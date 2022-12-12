package com.company;

import java.util.Scanner;

public class Player {
    int number;
    Scanner scanner = new Scanner(System.in);
    public Player(int number){
        this.number = number;
    }
    public int getTurnField(){
        int input = scanner.nextInt();

        if(input <= 9 && input > 0){
            return input -1;
        }

            System.out.println("Ungültige Eingabe");

        return getTurnField();
    }
    public boolean validateTurnField(int[] board, int turn){
        if(board[turn] == -1){
            return true;
        }

        return false;

    }
}
