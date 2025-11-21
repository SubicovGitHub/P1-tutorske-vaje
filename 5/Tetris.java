import java.util.Scanner;

public class Tetris {
    
    public static void izpisiTetris(int[] polje) {
        int start = 0;
        int konec = 0;
        for(int i=0; i<polje.length; i++) {
            if (polje[i] >= 1) {
                start = i;
                break;
            }
        }
        for(int i=polje.length-1; i>=0; i--) {
            if (polje[i] >= 1) {
                konec = i;
                break;
            }
        }
        for (int i=start; i<=konec; i++) {
            System.out.println("todo");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] blok0 = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};
        int[][] blok1 = {{0, 3}};
        int[][] blok2 = {{0, 1}, {0, 1}};
        int[][] blok3 = {{0, 0}, {0, 1}, {0, 0}};
        int[][] blok4 = {{1, 1}, {0, 2}};
        int[][] blok5 = {{1, 1}, {0, 1}, {1, 1}};
        int[][] blok6 = {{0, 2}, {1, 1}};
        int[][] blok7 = {{0, 2}, {0, 0}};
        int[][] blok8 = {{0, 0}, {0, 0}, {0, 1}};
        int[][] blok9 = {{2, 2}, {0, 2}};
        int[][] blok10 = {{0, 1}, {1, 1}, {1, 1}};
        int[][] blok11 = {{0, 0}, {0, 2}};
        int[][] blok12 = {{1, 1}, {1, 1}, {0, 1}};
        int[][] blok13 = {{0, 2}, {2, 2}};
        int[][] blok14 = {{0, 1}, {0, 0}, {0, 0}};
        int[][] blok15 = {{1, 1}, {0, 1}, {0, 0}};
        int[][] blok16 = {{0, 1}, {1, 2}};
        int[][] blok17 = {{0, 0}, {0, 1}, {1, 1}};
        int[][] blok18 = {{1, 2}, {0, 1}};

        int[][][] bloki = {
            blok0, blok1, blok2, blok3, blok4, blok5, blok6, 
            blok7, blok8, blok9, blok10, blok11, blok12, 
            blok13, blok14, blok15, blok16, blok17, blok18
        };
        
        int[] polje = new int[2001];

        for (int i=0; i<n; i++) {
            int blok = sc.nextInt();
            int polozaj = sc.nextInt();

            int maxVisina = 0;
            int maxIndex = -1;

            // najdi visino postavitve
            for (int j=0; j<bloki[blok].length; j++) {
                int visinaElementa = bloki[blok][j][1];
                int offsetElementa = bloki[blok][j][0];
                int visinaPolja = polje[polozaj+j];

                int kandidatVisina = visinaPolja-offsetElementa;

                if (kandidatVisina > maxVisina && kandidatVisina > 0) {
                    maxVisina = kandidatVisina;
                    maxIndex = polozaj+j;
                }
            }

            // prištej višino na polje
            for (int j=0; j<bloki[blok].length; j++) {
                int visinaElementa = bloki[blok][j][1];
                int offsetElementa = bloki[blok][j][0];

                polje[polozaj+1000] += visinaElementa+1-offsetElementa; 
            }

        }

    }
}
