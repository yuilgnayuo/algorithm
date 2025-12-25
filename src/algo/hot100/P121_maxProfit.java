package algo.hot100;

public class P121_maxProfit {
    public static void main(String[] args) {
        System.out.println(new P121_maxProfit().maxProfit(new int[]{2,4,1}));
        System.out.println(new P121_maxProfit().maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)return 0;
        // 0 ~ i - 1 上的最小值
        int min = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if(min > prices[i]) {
                min = prices[i];
            }else {
                ans = Math.max(ans, prices[i] - min);
            }
        }
        return ans;
    }
}
