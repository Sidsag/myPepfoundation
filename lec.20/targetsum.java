import java.util.*;
public class targetsum {
    public static void main(String[] args){
    int [] arr={2,1,9,4,5};
    System.out.println(target(arr,7));
    }

    public static boolean target(int[] arr,int target){
        boolean[][] dp=new boolean[arr.length+1][target+1];
        dp[0][0]=true;

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=dp[i-1][j];

                if(dp[i][j]==false){
                    if(j-arr[i-1]>=0 && dp[i-1][j-arr[i-1]]){
                        dp[i][j]=true;
                    }
                }
            }
        }
        targetpath(arr, dp, dp.length - 1, dp[0].length - 1, "");
        return dp[arr.length][target];
    }


   public static void targetpath(int []arr,boolean [][] storage,int sr,int sc,String s){
    if(sr==0){
        System.out.println(s);
        return;
    }    
    
    if(storage[sr - 1][sc] == true) {
        targetpath(arr, storage, sr - 1, sc, s);
    }

    if((sc - arr[sr - 1] >= 0) && (storage[sr - 1][sc - arr[sr -1]] == true)){
        targetpath(arr, storage, sr, sc - arr[sr - 1], s +" " +arr[sr - 1]);
    }
   }
}