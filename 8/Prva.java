
/*
Samodejno testiranje:

tj.exe Prva.java . .

Javni testni primeri:

01: primer iz besedila
02--06: k = n
01, 07--10: splo"sni primeri
*/

import java.util.*;

public class Prva {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int skupnaCena = 0;
        int najcenejsiZaK = 1000000000;
        
        for (int i=1; sc.hasNext(); i++) {
            int cena = sc.nextInt();
            skupnaCena += cena;

            if (cena < najcenejsiZaK) {
                najcenejsiZaK = cena;
            }

            if (i % k == 0) {
                skupnaCena -= najcenejsiZaK;
                najcenejsiZaK = 1000000000;
            }
        }
        sc.close();

        System.out.println(skupnaCena);
    }
}
