
/*
Samodejno testiranje:

tj.exe Druga.java . .

Javni testni primeri:

01: primer iz besedila
02--06: k = 1
01, 07--10: splošni primeri
*/

import java.util.*;

public class Druga {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int casPrivijanja = sc.nextInt();
        int casHlajenja = sc.nextInt();
        
        int cas = 0;
        int [][] vijakiNaVoljo = new int[m][k];

        for (int i=0; i<n; i++) {
            int vijak = sc.nextInt();

            cas = privijVijak(cas, casPrivijanja, casHlajenja, vijak, vijakiNaVoljo);
        }
        sc.close();

        System.out.println(cas);
    }

    public static int privijVijak(int cas, int casPrivijanja, int casHlajenja, 
        int m, int[][] vijaki) 
    {
        int minCas = 1000000;
        int minVijacnikIndeks = -1;
        for (int j=0; j<vijaki[m].length; j++) {
            if (vijaki[m][j] < minCas) {
                minCas = vijaki[m][j];
                minVijacnikIndeks = j;
            }
        }

        int casCakanja = minCas > cas ? minCas - cas : 0;
        int noviCas = cas + casCakanja + casPrivijanja;
        
        vijaki[m][minVijacnikIndeks] = noviCas + casHlajenja;
        
        return noviCas;
    }
}
