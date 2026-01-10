import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
    
    public static void main(String[] args) {
        
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3,4));
        input.add(Arrays.asList(6,5,7));
        input.add(Arrays.asList(4,1,8,3));

        // List<List<Integer>> input = new ArrayList<>();
        // input.add(Arrays.asList(1));
        // input.add(Arrays.asList(5,2));
        // input.add(Arrays.asList(6,3,4));
        // input.add(Arrays.asList(4,5,6,7));

        System.out.println(minimumTotal(input));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] sumMatrix = new int[n][n];
        sumMatrix[0][0] = triangle.get(0).get(0);
        for (int i=1; i<n; i++) {
            for (int j=0; j<triangle.get(i).size(); j++) {
                sumMatrix[i][j] += triangle.get(i).get(j);
                if (j == 0) {
                    sumMatrix[i][0] += sumMatrix[i-1][0];
                } else if (j == triangle.get(i).size()-1) {
                    sumMatrix[i][j] += sumMatrix[i-1][j-1];
                } else {
                    sumMatrix[i][j] += Math.min(
                        sumMatrix[i-1][j-1], 
                        sumMatrix[i-1][j]);
                }
            }
        }
        
        int minPath = sumMatrix[n-1][0];
        for (int j=1; j<n; j++) {
            if (sumMatrix[n-1][j] < minPath) {
                minPath = sumMatrix[n-1][j];
            }
        }
        return minPath;
    }
}
