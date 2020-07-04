public class unboundknapsack{
    public static void main(String [] args){
        int[] wt={3,4,1,2,5};
        int[] cost={45,20,15,25,30};
       System.out.println(knsp(wt,cost,7));
    }

    public static int coinchange(int [] wt,int cost,int target){
        int[] dp=new int[target+1];

        for(int i=0;i<=target;i++){
            for(int j=0;j<arr.length;j++){
                int k= i-arr[j];
                if(k == 0){
                    dp[i]+=1;
                }
                else if(k>0 && dp[k]!=0){
                    dp[i]+=dp[i - arr[j]];
                }
            }
        }

        return dp[target];
    }
}