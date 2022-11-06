package com.company;

import apple.awt.CInputMethod;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        Random generator = new Random();
        Scanner input = new Scanner(System.in);
        int correct = 0;
        int half_correct = 0;
        Vector<Integer> already_found_i = new Vector<Integer>();
        Vector<Integer> already_found_k = new Vector<Integer>();
        String guess_string = "";


        String answer = "";

        for (int i = 0; i <4; i++){

            int number = generator.nextInt(10);
            answer += number;
        }

        for (int j = 0; j < 10; j++) {

            do {
                System.out.println("Input your 4 digit guess:");
                int guess = input.nextInt();

                guess_string = "";
                guess_string += guess;

                if (guess_string.length() != 4) {
                    System.out.println("Are you crazy, are you out of your mind? (WRONG NUMBER OF CHARACTERS)");
                }
            } while (guess_string.length() != 4);
            correct = 0;
            half_correct = 0;


            if (guess_string.equals(answer)){
                System.out.println("Congratulations! You won!");
                break;
            }

            for (int k = 0; k < 4; k++) {
                for (int i = 0; i < 4; i++) {

                    if (guess_string.charAt(k) == answer.charAt(i)) {
                        if (i == k) {
                            correct++;
                            already_found_i.addElement(i);
                            already_found_k.addElement(k);
                        }
                        else if (!already_found_i.contains(i) || !already_found_k.contains(k)){
                            half_correct++;
                        }
                    }
                }
            }

            System.out.println("Correct:" + correct);
            System.out.println("Half Correct:" + half_correct);

            if (j == 9){
                System.out.println("You Lost");
            }

        }




    }
}
