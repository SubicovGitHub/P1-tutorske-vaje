public class Islands {
    
    // samo za testiranje
    public static void main(String[] args) {
        // char[][] grid = {
        //     {'1','1','1','1','0'},
        //     {'1','1','0','1','0'},
        //     {'1','1','0','0','0'},
        //     {'0','0','0','0','0'}
        // };
        // char[][] grid = {
        //     {'1','1','0','0','0'},
        //     {'1','1','0','0','0'},
        //     {'0','0','1','0','0'},
        //     {'0','0','0','1','1'}
        // };
        char[][] grid = {
            {'0','1','1','0','1'},
            {'0','0','1','0','1'},
            {'1','1','1','0','0'},
            {'0','0','0','1','1'},
            {'0','1','1','1','1'},
            {'1','0','0','0','0'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int[][] grid2 = gridConvert(grid);
        
        int islandCounter = 0;

        for (int i=0; i<grid2.length; i++) {
            for (int j=0; j<grid2[0].length; j++) {
                if (grid2[i][j] == -1) {
                    colorIslandRecursive(i, j, ++islandCounter, grid2);
                }
            }
        }

        return islandCounter;
    }

    // rekurzivna funkcija za iskanje in označevanje otoka
    public static void colorIslandRecursive(int i, int j, int n, int[][] grid) {
        if (i >= 0 && j >= 0 && i<grid.length && j<grid[0].length && 
            grid[i][j] == -1) 
        {
            grid[i][j] = n;
            colorIslandRecursive(i, j-1, n, grid);
            colorIslandRecursive(i, j+1, n, grid);
            colorIslandRecursive(i-1, j, n, grid);
            colorIslandRecursive(i+1, j, n, grid);
        }
    }

    // pretvori grid v int, s čimer lažje delam
    public static int[][] gridConvert(char[][] grid) {
        int[][] grid2 = new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid2[i][j] = -1;
                }
            }
        }
        return grid2;
    }
}
