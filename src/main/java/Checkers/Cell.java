package Checkers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Cell {

	private int x;
	private int y;
	private CheckersPiece piece;
	private Cell[][] board;

	private Move availableMove;
	
	public Cell(int x, int y, Cell[][] board) {
		this.x = x;
		this.y = y;

		this.board = board;

		// if (x > 0) {
		// 	if (y > 0) {
		// 		this.neibourCells.add(new Cell(x-1, y-1));
		// 		if (y > 1) {
		// 			this.neibourCells.add(new Cell(x-2, y-2));
		// 		}
		// 	}
		// 	if (y < 7) {
		// 		this.neibourCells.add(new Cell(x-1, y+1));
		// 		if (y < 6) {
		// 			this.neibourCells.add(new Cell(x-2, y+2));
		// 		}
		// 	}
		// }
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	public void setAvailableMove(Move v) {
		this.availableMove = v;
	}

	public Move getAvailableMove() {
		return this.availableMove;
	}
	
	public void setPiece(CheckersPiece p) {
		this.piece = p;
		if (p != null) {
			p.setPosition(this);
		}
	}

	public boolean isCurrentUserSelectable() {
		return this.availableMove != null;
	}

	public Set<NeibourCell> getNeibourCells() {


		Set<NeibourCell> neibourCells = new HashSet<NeibourCell>();

		// Normal moves

		// TOP,LEFT

		if (isValidCellPosition(this.x - 1, this.y - 1)) {
			Cell toCell = this.board[this.y - 1][this.x - 1];
			if (toCell.getPiece() == null) {
				neibourCells.add(new NeibourCell(this, toCell, null));
			}
		}

		// TOP,RIGHT
		if (isValidCellPosition(this.x + 1, this.y - 1)) {
			Cell toCell = this.board[this.y - 1][this.x + 1];
			if (toCell.getPiece() == null) {
				neibourCells.add(new NeibourCell(this, toCell, null));
			}
		}

		// BOTTOM,LEFT

		if (isValidCellPosition(this.x - 1, this.y + 1)) {
			Cell toCell = this.board[this.y + 1][this.x - 1];
			if (toCell.getPiece() == null) {
				neibourCells.add(new NeibourCell(this, toCell, null));
			}
		}

		// BOTTOM,RIGHT

		if (isValidCellPosition(this.x + 1, this.y + 1)) {
			Cell toCell = this.board[this.y + 1][this.x + 1];
			if (toCell.getPiece() == null) {
				neibourCells.add(new NeibourCell(this, toCell, null));
			}
		}

		// Jump over moves

		// TOP,LEFT
		if (isValidCellPosition(this.x-2, this.y-2)) {
			Cell toCell = this.board[this.y - 2][this.x - 2];


			if (toCell.getPiece() == null && this.getJumpOVerCell(toCell).getPiece() != null){
				Cell jumpOverCell = this.getJumpOVerCell(toCell);
				neibourCells.add(new NeibourCell(this, toCell, jumpOverCell));
			}
		}

		// TOP,RIGHT

		if (isValidCellPosition(this.x+2, this.y-2)) {
			Cell toCell = this.board[this.y - 2][this.x + 2];

			if (toCell.getPiece() == null  && this.getJumpOVerCell(toCell).getPiece() != null) {
				Cell jumpOverCell = this.getJumpOVerCell(toCell);
				neibourCells.add(new NeibourCell(this, toCell, jumpOverCell));
			}
		}

		// BOTTOM,LEFT

		if (isValidCellPosition(this.x-2, this.y+2)) {
			Cell toCell = this.board[this.y + 2][this.x - 2];

			if (toCell.getPiece() == null  && this.getJumpOVerCell(toCell).getPiece() != null) {
				Cell jumpOverCell = this.getJumpOVerCell(toCell);
				neibourCells.add(new NeibourCell(this, toCell, jumpOverCell));
			}
		}

		// BOTTOM,RIGHT

		if (isValidCellPosition(this.x+2, this.y+2)) {
			Cell toCell = this.board[this.y + 2][this.x + 2];

			if (toCell.getPiece() == null  && this.getJumpOVerCell(toCell).getPiece() != null) {
				Cell jumpOverCell = this.getJumpOVerCell(toCell);
				neibourCells.add(new NeibourCell(this, toCell, jumpOverCell));
			}
		}


		return neibourCells;
		

	}

	public Cell getJumpOVerCell(Cell destinationCell) {
		// Magic function for getting the cell that is jumped over
		int x = (this.getX() + destinationCell.getX()) / 2;
		int y = (this.getY() + destinationCell.getY()) / 2;
		return this.board[y][x];
	}
	
	public CheckersPiece getPiece() {
		return this.piece;
	}
	
	public void draw(App app) {
		if (this.piece != null) 
			this.piece.draw(app);
			
	}

	public static boolean isValidCellPosition(int x, int y) {
		return x >= 0 && x < 8 && y >= 0 && y < 8;
	}

	// public static Cell getJumpOverCell(Cell start, Cell end) {
	// 	// Magic function for getting the cell that is jumped over
	// 	int x = (start.getX() + end.getX()) / 2;
	// 	int y = (start.getY() + end.getY()) / 2;
	// 	return new Cell(x, y);
	// }
}