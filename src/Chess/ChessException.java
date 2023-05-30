package Chess;

import BoardGame.BoardException;

public class ChessException extends BoardException {
    private static final long serialVersionID = 1L;

    public ChessException(String msg){
        super(msg);
    }
}
