package Checkers;

import java.util.HashSet;
import java.util.Set;

public class CheckersPiece {
	private boolean isKing = false;
	private boolean isCaptured = false;
	private char colour;
	private Cell position;
	
	public CheckersPiece(char c) {
		this.colour = c;
	}
	
	public char getColour() {
		return this.colour;
	}
	
	public void setPosition(Cell p) {
		this.position = p;
	}
	
	public Cell getPosition() {
		return this.position;
	}

	public boolean isKing() {
		return this.isKing;
	}
	
	public Set<Move> getAvailableMoves(Cell[][] board) {
		//get all available moves for this piece
		// We have to store the 2stops, and 1 stop moves in the Cell class so it understands the moves, or maybe it is a bad idea becuase the piece is the one that knows how to move
	
		Set<Move> moves = new HashSet<>();

	
		Set<Cell> possibleMoves = new HashSet<>();

		if (this.colour == 'w' || this.isKing) {
			if (Cell.isValidCellPosition(this.position.getX() + 1, this.position.getY() + 1)) {
				possibleMoves.add(board[this.position.getX() + 1][this.position.getY() + 1]);
			}


			if (Cell.isValidCellPosition(this.position.getX() - 1, this.position.getY() + 1 )) {
				possibleMoves.add(board[this.position.getX() - 1][this.position.getY() + 1]);
			}

			//Check if there is any jump over move
			if (Cell.isValidCellPosition(this.position.getX() + 2, this.position.getY() + 2)) {
				Cell jumpOverDestination = board[this.position.getX() + 2][this.position.getY() + 2];
				Cell jumpOverCell = Cell.getJumpOverCell(this.position, jumpOverDestination);
				if (jumpOverCell != null && jumpOverDestination.getPiece()==null) {
					moves.add(new Move(this,jumpOverDestination,jumpOverCell.getPiece()));
				}
			}

		}

		if (this.colour == 'b' || this.isKing) {
			if (Cell.isValidCellPosition(this.position.getX() + 1, this.position.getY() - 1)) {
				possibleMoves.add(board[this.position.getX() + 1][this.position.getY() - 1]);
			}

			if (Cell.isValidCellPosition(this.position.getX() - 1, this.position.getY() - 1)) {
				possibleMoves.add(board[this.position.getX() - 1][this.position.getY() - 1]);
			}
		}

		// Add jump over moves if the piece can jump over another piece

		


		
		

		return null;
	}

	private Cell getJumpOverCell(Cell destination) {
		// Magic function for getting the cell that is jumped over
		int x = (this.position.getX() + destination.getX())/2;
		int y = (this.position.getY() + destination.getY())/2;


	}
	
	public void capture() {
		//capture this piece
		this.isCaptured = true;
		this.position.setPiece(null);
	}
	
	public void promote() {
		//promote this piece
		this.isKing = true;
	}
	
	//draw the piece
	public void draw(App app) {
		app.strokeWeight(5.0f);
		if (colour == 'w') {
			app.fill(255);
			app.stroke(0);
		} else if (colour == 'b') {
			app.fill(0);
			app.stroke(255);
		}
		app.ellipse(position.getX()*App.CELLSIZE + App.CELLSIZE/2, position.getY()*App.CELLSIZE + App.CELLSIZE/2, App.CELLSIZE*0.8f, App.CELLSIZE*0.8f);
		app.noStroke();
	}
}