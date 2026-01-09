public class CountAndSay {
    
    public static void main(String[] args) {
        int n = 10;
        for (int i=1; i<= n; i++) {
            System.out.println(countAndSay(i));
        }

        // String test = "3322251";
        // System.out.println(rle(test));
    }

    public static String countAndSay(int n) {
        String lastRle = "1";
        for (int i=2; i<= n; i++) {
            lastRle = rle(lastRle);
        }
        return lastRle;
    }

    public static String rle(String s) {
        char currentChar = s.charAt(0);
        int counter = 0;
        String rleString = "";
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                counter++;
            } else {
                rleString = appendRle(rleString, counter, currentChar);
                currentChar = s.charAt(i);
                counter = 1;
            }
        }
        rleString = appendRle(rleString, counter, currentChar);
        return rleString;
    }

    public static String appendRle(String s, int counter, char c) {
        s += counter;
        s += c;
        return s;
    }
}
