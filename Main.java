package com.shelja;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of times you want to play.");
        int players = sc.nextInt();
        for (int i=1; i<=players; i++) {
            game2 make2 = new game2();

            dice roll = new dice(2);
            System.out.println("Enter the player "+ i+" name and hit enter");
            String name = sc.nextLine();
            name +=sc.nextLine();
            make2.setName(name);

            System.out.println("The game setup is ready");
            int n = 0;
            int s = 0;
            make2.setPoints(0);
            make2.setPosition(-1);
            while (n != -1) {
                while (s != -1) {
                    System.out.println("Hit enter to roll the dice");
                    String enter = sc.nextLine();
                    roll.roll();
                    int r = roll.getFaceValue();
                    System.out.println("Dice gave " + r);
                    if (r != 1)
                        System.out.println("Game cannot start until you get 1");
                    else {
                        System.out.println("Player position Floor-0");
                        System.out.println(make2.getName() + " has reached an empty floor");
                        System.out.println("Total points 1");
                        make2.setPosition(make2.getPosition() + 1);
                        make2.setPoints(make2.getPoints() + 1);
                        s = -1;
                    }
                }
                System.out.println();
                System.out.println("************************************");
                System.out.println();
                System.out.print("Hit enter to roll the dice");
                String enter = sc.nextLine();
                roll.roll();
                int r = roll.getFaceValue();
                System.out.println("Dice gave " + r);

                make2.setPosition(make2.getPosition() + r);

                if (make2.getPosition() == 2 || make2.getPosition() == 8) {
                    System.out.println("Player position Floor-" + make2.getPosition());
                    make2.elevator_floor(make2.getPosition(), make2);
                } else if (make2.getPosition() == 5 || make2.getPosition() == 11) {
                    System.out.println("Player position Floor-" + make2.getPosition());
                    make2.snake_floor(make2.getPosition(), make2);
                } else if (make2.getPosition() > 13) {
                    System.out.println("Player cannot move");
                    make2.setPosition(make2.getPosition() - r);
                } else if (make2.getPosition() == 13) {
                    make2.setPoints(make2.getPoints() + 1);
                    System.out.println("Player position Floor-13");
                    System.out.println(make2.getName() + " has reached an empty floor");
                    System.out.println("Total points " + make2.getPoints());
                    System.out.println("Game Over");
                    System.out.println(make2.getName() + " accumulated " + make2.getPoints() + " points");
                    System.out.println("---------------------------------------------------------------");
                    n = -1;
                } else {
                    System.out.println("Player position Floor-" + make2.getPosition());
                    make2.empty_floor(make2);
                }
            }
        }
    }
}
