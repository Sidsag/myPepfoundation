import java.util.*;

public class maxtower {

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
         while(t>0){
            int n=scn.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
            }
            System.out.println(max_tower(arr));
            t--;
        }
    }
    
    public static int max_tower(int [] arr){
        int[] dp=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j] && dp[i]<dp[j])
                    dp[i]=dp[j];
            }
            dp[i]++;
        }
        int max=1;
        for(int k=0;k<arr.length;k++){
            if(max<dp[k])
                max=dp[k];
        }
        return max;
    }
}