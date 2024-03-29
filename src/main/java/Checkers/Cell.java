package Checkers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Cell {

	private int x;
	private int y;
	private CheckersPiece piece;
	private Cell[][] board;
	
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
	
	public void setPiece(CheckersPiece p) {
		this.piece = p;
		if (p != null) {
			p.setPosition(this);
		}
	}

	public Set<Cell> getNeibourCells() {
		Set<Cell> neibourCells = new HashSet<>();
		if (this.x > 0) {
			if (this.y > 0) {
				neibourCells.add(this.board[this.x-1][this.y-1]);
				if (this.y > 1) {
					neibourCells.add(this.board[this.x-2][this.y-2]);
				}
			}
			if (this.y < 7) {
				neibourCells.add(this.board[this.x-1][this.y+1]);
				if (this.y < 6) {
					neibourCells.add(this.board[this.x-2][this.y+2]);
				}
			}
		}
		if (this.x < 7) {
			if (this.y > 0) {
				neibourCells.add(this.board[this.x+1][this.y-1]);
				if (this.y > 1) {
					neibourCells.add(this.board[this.x+2][this.y-2]);
				}
			}
			if (this.y < 7) {
				neibourCells.add(this.board[this.x+1][this.y+1]);
				if (this.y < 6) {
					neibourCells.add(this.board[this.x+2][this.y+2]);
				}
			}
		}
		return neibourCells;
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