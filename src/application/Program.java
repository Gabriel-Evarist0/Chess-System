package application;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch match = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while(true){
            try {
                UI.clearScreen();
                UI.printMatch(match, captured);
                System.out.println();
                System.out.print("Print Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                boolean[][] possibleMoves = match.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(match.getPieces(),possibleMoves);


                System.out.println();
                System.out.print("Print target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturePiece = match.performChessMove(source, target);
                if(capturePiece != null){
                    captured.add(capturePiece);
                }
            }
            catch (ChessException | InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }

        }


    }
}