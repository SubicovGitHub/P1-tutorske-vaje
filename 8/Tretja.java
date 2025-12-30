
/*
Samodejno testiranje:

tj.exe

Javni testni primeri:

01--05: klici metode <monokultura>
06--10: klici metode <meraSosednosti>
01, 06: ro"cno izdelana
02--05, 07--10: samodejno izdelani

Primera 01 in 06 vsebujeta iste grede, razlikujeta se le po klicih metod.
*/

import java.util.*;

public class Tretja {

    // Dopolnite lahko katerikoli razred, lahko pa dodate tudi lastne notranje
    // razrede.

    private static final int[][] SOSEDNOST = {
        //                 C,  F,  G,  K,  P,  Z
        /* Cebula */    {  0, -1, -1,  1,  1,  0 },
        /* Fizol */     { -1,  0, -1,  0,  0,  1 },
        /* Grah */      { -1, -1,  0,  1,  0,  1 },
        /* Korenje */   {  1,  0,  1,  0, -1, -1 },
        /* Petersilj */ {  1,  0,  0, -1,  0, -1 },
        /* Zelena */    {  0,  1,  1, -1, -1,  0 },
    };

    private static final String[] RAZREDI = {
        "Cebula", "Fizol", "Grah", "Korenje", "Petersilj", "Zelena"
    };

    //=========================================================================

    public static class Vrt {
        private Vrtnina[][] grede;

        public Vrt(Vrtnina[][] grede) {
            this.grede = grede;
        }

        public boolean monokultura(int ixGrede) {
            Vrtnina v1 = null;
            for (Vrtnina v : this.grede[ixGrede]) {
                if (v1 == null && v != null) {
                    v1 = v;
                } else if (v1 != null && v != null) {
                    if (!v1.getClass().equals(v.getClass())) {
                        return false;
                    }
                }
            }
            return true;
        }

        public int meraSosednosti() {
            int vsota = 0;
            for (Vrtnina[] g: this.grede) {
                if (g.length <= 1) {
                    continue;
                }
                for (int j=1; j< g.length; j++) {
                    int indeksVrtnine0 = indeksVrtnine(g[j-1].imeRazreda());
                    int indeksVrtnine1 = indeksVrtnine(g[j].imeRazreda());
                    int sosednost = SOSEDNOST[indeksVrtnine0][indeksVrtnine1];
                    vsota += sosednost;
                }
            }
            return vsota;
        }

        private int indeksVrtnine(String vrtnina) {
            for (int i=0; i<RAZREDI.length; i++) {
                if (RAZREDI[i].equals(vrtnina)) {
                    return i;
                }
            }
            return -1;
        }
    }

    //=========================================================================

    public static abstract class Vrtnina {

        public String imeRazreda() {
            return this.getClass().getSimpleName();
        }
    }

    //=========================================================================

    public static class Cebula extends Vrtnina {
    }

    //=========================================================================

    public static class Fizol extends Vrtnina {
    }

    //=========================================================================

    public static class Grah extends Vrtnina {
    }

    //=========================================================================

    public static class Korenje extends Vrtnina {
    }

    //=========================================================================

    public static class Petersilj extends Vrtnina {
    }

    //=========================================================================

    public static class Zelena extends Vrtnina {
    }
}
