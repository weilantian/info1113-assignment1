package Checkers;

public class NeibourCell {
    // Which cell does the piece come from?
    private Cell fromCell;
    // Which cell does the piece go to?
    private Cell toCell;
    private Cell cellToBeJumpOver;
    

    public NeibourCell(Cell fromCell, Cell toCell, Cell cellToBeJumpOver) {
        this.fromCell = fromCell;
        this.toCell = toCell;

        this.cellToBeJumpOver = cellToBeJumpOver;

  
    }
    
    public Cell getToCell() {
        return this.toCell;
    }

    public Cell getFromCell() {
        return this.fromCell;
    }

    public boolean isJumpOver() {
        return this.cellToBeJumpOver != null;
    }

    public Cell getCellToBeJumpOver() {
        return this.cellToBeJumpOver;
    }

    public boolean isAvailableMove(char pieceType,boolean isKing) {
        if (isKing) return true;
        if (pieceType == 'w') {
            return this.toCell.getY() > this.fromCell.getY();
        } else {
            return this.fromCell.getY() < this.toCell.getY();
        }
    }
}
