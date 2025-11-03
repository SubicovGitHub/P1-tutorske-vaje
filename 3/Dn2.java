import java.util.Scanner;

public class Dn2 {
    
    // kvadrat je zaporedna št. koncentričnega kvadrata (0-...)
    public static int povrsinaKvadrata(int kvadrat) {
        int stranica = 2*kvadrat+1;
        return stranica*stranica;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int d = sc.nextInt();
        int dolzinaTipkanja = sc.nextInt();

        int skupnaPot = 0;

        int prejsnjiX = d;
        int prejsnjiY = d;

        for (int i=0; i<dolzinaTipkanja; i++) {
            
            int tipka = sc.nextInt();

            int an = 0;
            for (int j=0; j<d; j++) {
                int kvadrat = (j+1)*(j+1);
                if (tipka < kvadrat*kvadrat) {
                    an = j;
                    break;
                }
            }

            int povrsinaKvadrata = povrsinaKvadrata(an);
            int povrsinaNotranjegaKvadrata = povrsinaKvadrata(an-1);

            int tipkaX = -1 * an;
            int tipkaY = an;

            // gremo po tipkah na tem kvadratu
            int indeksTipke = 0;
            for (int j=povrsinaNotranjegaKvadrata; j<povrsinaKvadrata; j++) {
                
                if (j == tipka)
                    break;
                
                // zgornja stranica
                if (indeksTipke / (an*an) == 0) {
                    tipkaX += 1;
                }
                // desna stranica
                else if (indeksTipke / (an*an) == 1) {
                    tipkaY -= 1;
                }
                // spodnja stranica
                else if (indeksTipke / (an*an) == 2) {
                    tipkaX -= 1;
                }
                // leva stranica
                else if (indeksTipke / (an*an) == 3) {
                    tipkaY += 1;
                }

                indeksTipke++;
            }

            System.out.printf("%2d -> (%d,%d), ", tipka, tipkaX, tipkaY);
            System.out.println("");

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
        System.out.println("-----------------");
        System.out.println(skupnaPot);

    }
}
