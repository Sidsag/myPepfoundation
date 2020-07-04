public class stoz{
    public static void main(String[] args){
        System.out.println(way(7));
    }

    public static int way(int n){
        int[] dp= new int[n+1];
       dp[0]=1;
       for(int i=1;i<dp.length;i++){
           int myans=0;
           if((i-3)>=0)
               myans+=dp[i-3];
           if((i-2)>=0)
               myans+=dp[i-2];
           if((i-1)>=0)
               myans+=dp[i-1];
            dp[i]=myans;
       }

       return dp[n];
    }
}
