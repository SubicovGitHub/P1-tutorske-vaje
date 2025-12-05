public class Stock {
    
    // samo za testiranje
    public static void main(String[] args) {
        
        // int[] prices = {7,1,5,3,6,4};
        // int[] prices = {7,6,4,3,1};
        int[] prices = {10,12,14,8,7,10,5,8,3,2,10};

        System.out.println(maxProfit(prices));
    }

    // izračuna v linearnem času (O(n)), ampak še zmerom bolje le od 57%
    public static int maxProfit(int[] prices) {
        int bestProfit = 0;
        int currentProfit = 0;
        int yesterdaysPrice = prices[0];
        
        for (int i=1; i<prices.length; i++) {
            int todaysPrice = prices[i];
            
            // koliko se cena spremeni z včeraj na danes
            currentProfit += todaysPrice - yesterdaysPrice;
            
            if (currentProfit > bestProfit) {
                bestProfit = currentProfit;
            }

            // če prideš v minus, potem se "resetira" - tretiraš tisti dan kot dan za nakup delnice
            else if (currentProfit < 0) {
                currentProfit = 0;
            }
            
            yesterdaysPrice = todaysPrice;
        }

        return bestProfit;
    }
}
