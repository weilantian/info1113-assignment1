package Checkers;


class Move {
    private CheckersPiece piece;
    private CheckersPiece capturedPiece;
    private Cell destination;
    
    public Move(CheckersPiece currentP, Cell destination , CheckersPiece capturePiece) {
        this.piece = currentP;
        this.destination = destination;
        this.capturedPiece = capturePiece;

    }

    public Cell getDestination() {
        return this.destination;
    }
    
    // Return the piece that was captured if not captured, return null
    public CheckersPiece execute() {
        if (this.capturedPiece != null) {
            this.capturedPiece.capture();
        }

        this.piece.getPosition().setPiece(null);
        this.destination.setPiece(this.piece);
        // Check if a piece should be promoted to a king
        if (this.piece.getColour() == 'w' && this.destination.getY() == 7) {
            this.piece.promote();
        } else if (this.piece.getColour() == 'b' && this.destination.getY() == 0) {
            this.piece.promote();
        }

        return this.capturedPiece;
    }
    

}