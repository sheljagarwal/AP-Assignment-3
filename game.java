package com.shelja;

public class game extends player{
    public void elevator_floor(int position,player make1){
        if (position==2){
            System.out.println(make1.name+" has reached an Elevator floor");
            make1.position = 10;
            make1.points = make1.points+4;
            System.out.println("Total points "+make1.points);
            System.out.println("Player position Floor-10");
        }
        else{
            System.out.println(make1.name+" has reached a ladder floor");
            make1.position = 12;
            make1.points = make1.points+2;
            System.out.println("Total points "+make1.points);
            System.out.println("Player position Floor-12");
        }
        System.out.println(make1.name+" has reached an Empty floor");
        make1.points = make1.points+1;
        System.out.println("Total points "+make1.points);
    }
}
class game1 extends game{
    public void empty_floor(player make1){
        System.out.println(make1.name+" has reached an Empty floor");
        make1.points = make1.points+1;
        System.out.println("Total points "+make1.points);

    }
}
class game2 extends game1{
    public void snake_floor(int position, player make1){
        if (position==5) {
            System.out.println(make1.name + " has reached a normal snake floor");
            make1.position = 1;
            make1.points = make1.points - 2;
            System.out.println("Total points " + make1.points);
            System.out.println("Player position Floor-1");
        }
        else{
            System.out.println(make1.name + " has reached king cobra");
            make1.position = 3;
            make1.points = make1.points - 4;
            System.out.println("Total points " + make1.points);
            System.out.println("Player position Floor-3");
        }
        System.out.println(make1.name+" has reached an Empty floor");
        make1.points = make1.points+1;
        System.out.println("Total points "+make1.points);
    }
}