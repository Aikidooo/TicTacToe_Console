package com.company;




public class Main {

    public static void main(String[] args) {
        //Es gibt Spieler 0 und 1, -1 entspricht einem unbesetzten Feld. Turn legt den Spieler fest, der am Zug ist, winner den Gewinner, und das Board zeigt an welche Felder wie belegt sind.
        //Spiel wird vorbereitet
        //TODO Befehle <help> und <stop> einfügen, Begrüßung in Methode auslagern, anpassen des  graphischen Interface,
        System.out.println("Wilkommen zu TikTakToe.");
        System.out.println("Um ein Feld zu besetzen gebe die entsprechende Zahl ein.");
        System.out.println("1" + "   |   " + "2" + "   |   " + "3");
        System.out.println("____________");
        System.out.println("4" + "   |   " + "5" + "   |   " + "6");
        System.out.println("____________");
        System.out.println("7" + "   |   " + "8" + "   |   " + "9");
        System.out.println("");
        System.out.println("mit dem Befehl <help> kannst du dir die Steuerung von oben ansehen. ");
        System.out.println("Starte das Spiel mit einer Eingabe und beende es mit <stop>");
        System.out.println("Jetzt aber viel Spaß");
        int turn = 0;
        int winner = -1;
        char winnerAB;
        int[] board = new int[9];
        String[] symbolicBoard = new String[9];

        for (int i = 0; i < board.length; i++) { //erstellen der Werte des boards
            board[i] = -1;
        }




        //Erstellen von 2 Player Objekten
        Player PlayerA = new Player(0);
        Player PlayerB = new Player(1);




        //Spiel startet mit der Schleife
        while (winner == -1) {

            int turnField = PlayerA.getTurnField();
            if(PlayerA.validateTurnField(board, turnField)) { //checkt mit dem Input und dem Board, ob das Feld bereits besetzt ist.
                board[turnField] = turn;
                if(turn == 0){
                    turn = 1;
                }
                else{
                    turn = 0;
                }
                for(int i = 0; i <= 10; i++){ //schiebt die alten Felder nach oben
                    System.out.println("");
                }
            }

            winner = checkWinner(board);
            printBoard(board, symbolicBoard);
            System.out.println("Insert: ");
        }
        if(winner == 0){
            winnerAB = 'A';
        }
        else{
            winnerAB = 'B';
        }

        System.out.println("Spieler " + winnerAB + " hat gewonnen!");

    }

    public static int checkWinner(int[] board){
        int winner = -1;
        if(board[0] == board[1] &&  board[0] == board[2] && board[0] != -1){
            winner=board[0];
        }
        else if(board[3] == board[4] &&  board[3] == board[5] && board[3] != -1) {
            winner = board[0];
        }
        else if(board[6] == board[7] &&  board[6] == board[8] && board[6] != -1) {
            winner = board[6];
        }
        else if(board[0] == board[3] &&  board[0] == board[6] && board[0] != -1) {
            winner = board[0];
        }
        else if(board[1] == board[4] &&  board[1] == board[7] && board[1] != -1) {
            winner = board[1];
        }
        else if(board[2] == board[5] &&  board[2] == board[8] && board[2] != -1) {
            winner = board[2];
        }
        else if(board[0] == board[4] &&  board[0] == board[8] && board[0] != -1) {
            winner = board[0];
        }
        else if(board[2] == board[4] &&  board[2] == board[6] && board[2] != -1) {
            winner = board[2];
        }
        else {
            winner = -1;
        }


        return winner;


    }
    public static void printBoard(int[] board, String[] symbolicBoard){


        for(int i = 0; i < symbolicBoard.length; i++) { //erstellen der aliases für board
            if (board[i] == 0) {
                symbolicBoard[i] = " X ";
            } else if (board[i] == 1) {
                symbolicBoard[i] = " O ";
            } else {
                symbolicBoard[i] = "   ";
            }
        }


        System.out.println(symbolicBoard[0] + "  |  " + symbolicBoard[1] + "  |  " + symbolicBoard[2]);
        System.out.println("-----|-------|-------");
        System.out.println(symbolicBoard[3] + "  |  " + symbolicBoard[4] + "  |  " + symbolicBoard[5]);
        System.out.println("-----|-------|-------");
        System.out.println(symbolicBoard[6] + "  |  " + symbolicBoard[7] + "  |  " + symbolicBoard[8]);


        }
    }


