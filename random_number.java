package codsoft;

import java.util.Random;
import java.util.Scanner;

public class random_number {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Random random=new Random();
        boolean playagain=true;
        int total =0;
        while(playagain){
            int target= random.nextInt(100)+1;
            final int maxattempt=6;
            int  attempt=0;
            System.out.println("welcome to the number game");
            while(attempt<maxattempt){
                System.out.println("enter the guessing number with in 100: ");
                int usernum=input.nextInt();
                if(usernum==target){
                    System.out.println("congratulation your guess is correct\t"+target );
                    total++;
                    break;
                }
                else if(usernum<target){
                    System.out.println("too low from target\t" );
                }
                else {
                    System.out.println("too high from target\t" );
                }
                attempt++;

            }
            if(attempt==maxattempt){
                System.out.println("sorry you have reach the max attempt");
            }
            System.out.println("target element\t"+target);
            System.out.println("do you want playagain(yes/no)" );
            String inputplayagain=input.next().toLowerCase();
            playagain=inputplayagain.equals("yes");

        }
        System.out.println("TOTAL SCORE OF GAME \t"+total);
    }

}
