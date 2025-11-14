package nn.gui;

import java.util.Arrays;

public class Testing2 {
    public static int maxProfit(int[] prices) {
        
        int bP = prices[0];
        int maxP = 0;
        for(int i = 1 ; i < prices.length ; i++)
        {
            int currP = bP - prices[i];
            // int currP = prices[i] - bP;
            if(maxP < currP)
                maxP = currP;
            if(bP > prices[i])
                bP = prices[i];
        }
        System.out.println("BP:" + bP);
        return maxP;
    }

    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
