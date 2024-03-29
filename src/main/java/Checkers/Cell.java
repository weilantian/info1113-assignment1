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

}