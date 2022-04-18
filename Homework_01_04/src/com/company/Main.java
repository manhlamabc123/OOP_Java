package com.company;

public class Main {

    public static void main(String[] args) {
        int space = 4;
        int star = 1;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < space; j++) System.out.print(" ");
            for(int k = 0; k < star; k++) System.out.print("*");
            space--;
            star+=2;
            System.out.print("\n");
        }
    }
}
