public class knapsack01{
    public static void main(String [] args){
        int[] wt={3,4,1,2,5};
        int[] cost={45,20,15,25,30};
       System.out.println(knsp(wt,cost,7));
    }

    public static int knsp(int[] wt,int[] cost,int capacity){
        int[][] dp=new int[wt.length+1][capacity+1];
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=dp[i-1][j];
                if(j-wt[i-1]>=0 && dp[i][j]<cost[i-1]+dp[i-1][j-wt[i-1]])
                dp[i][j]=cost[i-1]+dp[i-1][j-wt[i-1]];
            }
        }
        String spath="";
        coinpath(dp,wt,wt.length,capacity,spath);
        return dp[wt.length][capacity];
    }
    public static void coinpath(int [][] dp,int [] wt,int sr,int sc,String s){
        if(sr==0 && sc==0){
            System.out.println(s);
        }
        if(sr-1>=0 && dp[sr-1][sc]==dp[sr][sc])
        coinpath(dp,wt,sr-1,sc,s);
        else if(sc-wt[sr-1]>=0)
        coinpath(dp,wt,sr,sc-wt[sr-1],s+wt[sr-1]);
     }
    } 
