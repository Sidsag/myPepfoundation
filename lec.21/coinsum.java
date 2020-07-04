import java.util.Scanner;
public class coinsum{
    public static void main(String [] args){
        int[] arr={2,3,5};
       System.out.println(coinchange(arr,7));
    }

    public static int coinchange(int [] arr,int target){
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
