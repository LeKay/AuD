package Blatt1;

import java.util.Scanner;

public class SiebDesEratosthenes {

    public static void main( String[] args ) {
        Scanner s = new Scanner(System.in);
        System.out.println("Bitte Zahl eingeben: ");
        int n = s.nextInt();
        int[] prim = siebDesEratosthenes(n);
        for(int p : prim)
            System.out.print(p + " ");
    }

    private static int[] siebDesEratosthenes(int n) {
        // schreibe n Zahlen auf
        boolean[] arr = new boolean[n];
        // streiche die 1
        arr[0] = true;
        // start bei 2
        for(int i = 1; (i+1)*(i+1) <= n; i++) {
            // wenn die Zahl nicht gestrichen ist
            if(!arr[i]) {
                // streiche alle Vielfachen von i
                for(int v = (i+1)+(i+1); v <= n; v=v+(i+1)) {
                    arr[(v-1)] = true;
                }
            }
        }
        // zähle die Anzahl der Primzahlen
        int c = 0;
        for(boolean b : arr) {
            if(!b)
                c++;
        }
        int[] prim = new int[c];
        // index der Rückgabe
        int iPrim = 0;
        // schreibe die Primzahlen
        for(int i = 0; i < n; i++) {
            if(!arr[i]) {
                prim[iPrim] = i + 1;
                iPrim++;
            }
        }
        return prim;
    }
}
