import java.util.Scanner;
public class coinsumsirway{
    public static void main(String [] args){
        int[] arr={2,3,5};
       System.out.println(coinchange(arr,7));
    }

    public static int coinchange(int [] arr,int target){
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=0;i<=target;i++){
            for(int j=0;j<arr.length;j++){
               if(i-arr[j]>=0){
                   dp[i]+=dp[i-arr[j]];
               } 
            }
        }
      
        return dp[target];
    }

    public static void coinpath(int [][] dp,int [] wt,int sr,int sc,String s){
       if(sr==0 && sc==0){
           System.out.println(s);
       }
       if(dp[i-1][j]==dp[i][j])
       coinpath(dp,wt,sr-1,sc,s);
       else
       coinpath(dp,wt,sr,sc-wt[sr-1],s+wt[sr-1]);
    }
}
