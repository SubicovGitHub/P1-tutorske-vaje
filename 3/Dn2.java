import java.util.Scanner;

public class Dn2 {
    
    // kvadrat je zaporedna št. koncentričnega kvadrata (0-...)
    public static int povrsinaKvadrata(int kvadrat) {
        int stranica = 2*kvadrat+1;
        return stranica*stranica;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();   // ne rabimo, samo za avtomatsko testiranje
        int d = sc.nextInt();
        int dolzinaTipkanja = sc.nextInt();

        int skupnaPot = 0;

        int prejsnjiX = d;
        int prejsnjiY = d;

        for (int i=0; i<dolzinaTipkanja; i++) {
            
            int tipka = sc.nextInt();

            int stKvadrata = 0; // a_n (indeks kvadrata)
            for (int j=0; j<d; j++) {
                int kvadrat = povrsinaKvadrata(j);
                if (tipka < kvadrat) {
                    stKvadrata = j;
                    break;
                }
            }

            int povrsinaKvadrata = povrsinaKvadrata(stKvadrata);
            int povrsinaNotranjegaKvadrata = povrsinaKvadrata(stKvadrata-1);
            // System.out.printf("kvadrat: (%d->%d)\n", stKvadrata, povrsinaKvadrata);
            // System.out.printf("notranji: (%d->%d)\n", stKvadrata-1, povrsinaNotranjegaKvadrata);

            int tipkaX = -1 * stKvadrata;
            int tipkaY = stKvadrata;

            // gremo po tipkah na tem kvadratu
            int indeksTipke = 0;
            int stranica = 1;
            for (int j=povrsinaNotranjegaKvadrata; j<povrsinaKvadrata; j++) {
                
                // takoj prva tipka v kvadratu
                if (j == tipka)
                    break;

                // zgornja stranica
                if (indeksTipke / (stKvadrata*2) == 0) {
                    tipkaX += 1;
                    stranica = 1;
                }
                // desna stranica
                else if (indeksTipke / (stKvadrata*2) == 1) {
                    tipkaY -= 1;
                    stranica = 2;
                }
                // spodnja stranica
                else if (indeksTipke / (stKvadrata*2) == 2) {
                    tipkaX -= 1;
                    stranica = 3;
                }
                // leva stranica
                else if (indeksTipke / (stKvadrata*2) == 3) {
                    tipkaY += 1;
                    stranica = 4;
                }

                indeksTipke++;
            }

            // System.out.printf("%2d -> (%d,%d) (%d. stranica)\n", tipka, tipkaX, tipkaY, stranica);

            // če ni začetna tipka
            if (prejsnjiX != d && prejsnjiY != d) {
                int potX = Math.abs(tipkaX - prejsnjiX);
                int potY = Math.abs(tipkaY - prejsnjiY);
                skupnaPot += potX + potY;
            }

            prejsnjiX = tipkaX;
            prejsnjiY = tipkaY;
        }

        sc.close();
        // System.out.println("-----------------");
        System.out.println(skupnaPot);

    }
}
