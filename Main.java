package com.shelja;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        player make1 = new player();
        game2 make2 = new game2();
        dice roll = new dice(2);
        System.out.println("Enter the player name and hit enter");
        make1.name = sc.nextLine();
        make1.name+= sc.nextLine();
        System.out.println("The game setup is ready");
        int n = 0;
        int s = 0;
        make1.points = 0;
        make1.position = -1;
        while (n!=-1){
            while (s!=-1) {
                System.out.print("Hit enter to roll the dice");
                String enter=sc.nextLine();
                roll.roll();
                int r = roll.getFaceValue();
                System.out.println("Dice gave " + r);
                if (r!=1)
                    System.out.println("Game cannot start until you get 1");
                else{
                    System.out.println("Player position Floor-0");
                    System.out.println(make1.name+" has reached an empty floor");
                    System.out.println("Total points 1");
                    make1.position++;
                    make1.points++;
                    s = -1;
                }
            }
            System.out.println();
            System.out.println("--------------------------------");
            System.out.print("Hit enter to roll the dice");
            String enter=sc.nextLine();
            roll.roll();
            int r = roll.getFaceValue();
            System.out.println("Dice gave " + r);
            make1.position = make1.position + r;

            if (make1.position==2||make1.position==8) {
                System.out.println("Player position Floor-" + make1.position);
                make2.elevator_floor(make1.position, make1);
            }
            else if(make1.position==5||make1.position==11) {
                System.out.println("Player position Floor-" + make1.position);
                make2.snake_floor(make1.position, make1);
            }
            else if(make1.position>13) {
                System.out.println("Player cannot move");
                make1.position = make1.position - r;
            }
            else if(make1.position==13){
                make1.points++;
                System.out.println("Player position Floor-13");
                System.out.println(make1.name+" has reached an empty floor");
                System.out.println("Total points " + make1.points);
                System.out.println("Game Over");
                System.out.println(make1.name+" accumulated "+make1.points+" points");
                System.out.println("---------------------------------------------------------------");
                n = -1;
            }
            else{
                System.out.println("Player position Floor-" + make1.position);
                make2.empty_floor(make1);
            }
        }
    }
}
