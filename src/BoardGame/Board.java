package BoardGame;

public class Board {
    private int rows;
    private int column;
    private Piece[][] pieces;

    public Board(int rows, int column) {
        if(rows < 1 || column < 1){
            throw new BoardException("Erro ao criar o tabuleiro: É necessário pelo menos 1 linha e 1 coluna para cria-lo");
        }
        this.rows = rows;
        this.column = column;
        pieces = new Piece[rows][column];

    }
    public int getRows() {return rows;}

    public int getColumn() {return column;}
    public Piece piece(int row, int column){
        if(!positionExists(row,column)){
            throw new BoardException("Posição não existe no tabuleiro");
        }return pieces[row][column];
    }
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição não existe no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("Já tem uma peça na posição " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posicao nao existe no tabuleiro");
        }if(piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >=0 && column < this.column;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(),position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição não existe no tabuleiro");
        }
        return piece(position) != null;
    }


}
