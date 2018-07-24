package Blatt5;

import Blatt2.StopUhr;

import java.math.BigInteger;

public class Fibonacci {

    public static void main( String[] args ) {
        System.out.println("Fibonacci Rekursiv:");
        StopUhr uhr = new StopUhr();
        uhr.start();
        for(int i = 1; i <= 40; i++) {
            System.out.print(fiboRek(i) + " ");
        }
        uhr.stop();
        System.out.println("\nDauer: " + uhr.getDuration() + " ns.");
        System.out.println("\n\nFibonacci Iterativ:");
        uhr.start();
        for(int i = 1; i <= 40; i++) {
            System.out.print(fiboIt(i) + " ");
        }
        uhr.stop();
        System.out.println("\nDauer: " + uhr.getDuration()/1000 + " ns.");
    }

    public static int fiboRek(int n ) {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        else
            return fiboRek(n-1) + fiboRek(n-2);
    }

    public static int fiboIt( int n ) {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        int erg = 0;
        int prepre = 0;
        int pre = 1;
        for(int i = 2; i <= n; i++) {
            erg = pre + prepre;
            prepre = pre;
            pre = erg;
        }
        return erg;
    }

}
