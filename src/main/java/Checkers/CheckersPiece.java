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

	private Move getNormalMoveIfValid(Cell[][] board,int xOffset,int yOffset) {


		// Print current position
		if (Cell.isValidCellPosition(this.position.getX()+xOffset, this.position.getY()+yOffset)) {
			Cell toCell = board[this.position.getY()+yOffset][this.position.getX()+xOffset];
			if (toCell.getPiece() == null) {
				//Print the cell axis
				
				return new Move(this, toCell, null);
			}
		}
		return null;
	}

	private Move getJumpOverMoveIfValid(Cell[][] board, int xOffset, int yOffset) {
		if (!Cell.isValidCellPosition(this.position.getX()+xOffset, this.position.getY()+yOffset)) return null;
		Cell toCell = board[this.position.getY()+yOffset][this.position.getX()+xOffset];
		if (toCell.getPiece() != null) return null;


		int jumpOverX = this.position.getX() + xOffset/2;
		int jumpOverY = this.position.getY() + yOffset/2;
		if (!Cell.isValidCellPosition(jumpOverX, jumpOverY)) return null;
		Cell cellToBeJumpOver = board[jumpOverY][jumpOverX];
		if (cellToBeJumpOver.getPiece() == null) return null;



		// Cell cellToBeJumpOver = board[this.position.getY()+yOffset/2][this.position.getX()+xOffset/2];
		// if (cellToBeJumpOver!=null) System.out.println("Cell to be jumped over: " + cellToBeJumpOver.getX() + " " + cellToBeJumpOver.getY());
		// if (cellToBeJumpOver == null) return null;
		//if (cellToBeJumpOver.getPiece() == null) return null;
		return new Move(this, toCell, cellToBeJumpOver.getPiece());

	}
	
	public Set<Move> getAvailableMoves(Cell[][] board) {

		Set<Move> availableMoves = new HashSet<Move>();

		// CHECK all the moves

		// Check the normal moves

		for (int i = -1; i <= 1; i+=2) {
			for (int j = -1; j <= 1; j+=2) {
				Move move = getNormalMoveIfValid(board,i,j);
				if (move != null) {
							availableMoves.add(move);
							}		

			}
		}

		// Check the jump over moves
		for (int i = -2; i <= 2; i+=4) {
			for (int j = -2; j <= 2; j+=4) {
				Move move = getJumpOverMoveIfValid(board,i,j);
				if (move != null) {
					availableMoves.add(move);
				}
			}
		}

		return availableMoves;
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