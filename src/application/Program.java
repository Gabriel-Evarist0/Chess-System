package application;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch match = new ChessMatch();

        while(true){
            try {
                UI.clearScreen();
                UI.printBoard(match.getPieces());
                System.out.println();
                System.out.println("Print Source");
                ChessPosition source = UI.readChessPosition(sc);

                System.out.println();
                System.out.println("Print target");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturePiece = match.performChessMove(source, target);
            }
            catch (ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }

        }


    }
}