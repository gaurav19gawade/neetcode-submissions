class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 0;
        int maxP = 0;

        while(right < prices.length){
            int profit = prices[right] - prices[left];
            if(prices[right] > prices[left]){
                maxP = Math.max(profit, maxP);
            } else{
                left = right;
            }
            right++;
        }
        return maxP;
    }
}
