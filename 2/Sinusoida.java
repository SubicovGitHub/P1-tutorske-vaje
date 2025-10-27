import java.util.Scanner;

public class Sinusoida {
    public static void main(String[] args) {
        
        int h = 16;
        int halfPeriod = 12;

        for (int x=0; x<50; x++) {

            double sinValue = Math.sin(x*Math.PI/halfPeriod) + 0.01;
            // System.out.println(sinValue);
            
            int y = (int) (sinValue * h);
            // System.out.println(y);

            int stars = Math.abs(y);

            // int spaces = (y >= 0 ? 10 : h-y);
            int spaces;
            if (y >= 0) {
                spaces = h;
            } else {
                spaces = h-stars;
            }

            for (int i=0; i < spaces; i++) {
                System.out.print(" ");
            }

            for (int i=0; i < stars; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
