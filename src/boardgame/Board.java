package boardgame;

public class Board {
    private int rows;
    private int columns;

    private Piece[][] pieces;

    public Board(int columns, int rows) {
        if(columns<1 || rows<1){
            throw new BoardException("Error instantiating board: must have at least 1 row and 1 column");
        }
            
        this.columns = columns;
        this.rows = rows;
        pieces = new Piece[rows][columns];
        
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
         if(!positionExists(row,column)){
            throw new BoardException("Position is not on the board");
        }
        return pieces [row][column];
    }
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position is not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }
    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    private boolean positionExists(int row, int column){
        return row>=0 && row < rows && column >=0 && column <columns;
    }
    public boolean positionExists(Position position){
        return position.getRow() >= 0 && position.getRow() < rows && position.getColumn() >= 0 && position.getColumn() < columns;
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position is not on the board");
        }
        return piece(position) != null;
    }


}
