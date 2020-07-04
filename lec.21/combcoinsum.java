import java.util.Scanner;
public class combcoinsum{
    public static void main(String [] args){
        int[] arr={2,3,5};
       System.out.println(coinchangecomb(arr,7));
    }

    public static int coinchangecomb(int [] arr,int target){
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int j=0;j<arr.length;j++){
            for(int i=0;i<=target;i++){
               if(i-arr[j]>=0){
                   dp[i]+=dp[i-arr[j]];
               }
            }
        }
        return dp[target];
    }
}