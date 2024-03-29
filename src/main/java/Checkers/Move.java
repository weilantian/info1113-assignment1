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
    
    public void execute() {
        if (this.capturedPiece != null) {
            this.capturedPiece.capture();
        }

        this.piece.getPosition().setPiece(null);
        this.destination.setPiece(this.piece);
    }
    

}