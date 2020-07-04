import java.util.*;
public class goldcoin{
    public static void main(String[] args){
      int[][] carr={
          {4,8,2,7,9,4},
          {3,7,6,4,3,1},
          {5,1,2,3,5,6},
          {4,3,6,8,4,2},
          {1,2,6,4,2,6},
          {2,8,1,9,3,7},
      };
      System.out.println(gld(carr));
    }

    public static int gld(int[][] carr){
        int [][] strg=new int[carr.length][carr[0].length];
        for(int j=carr.length-1;j>=0;j--){
            for(int i=carr.length-1;i>=0;i--){
                if(j==carr.length-1){
                    strg[i][j]=carr[i][j];
                }
                else if(i==0){
                    strg[i][j] = carr[i][j] + max(strg[i][j+1], strg[i+1][j+1]);
                }
                else if(i == carr.length -1) {
                    strg[i][j] = carr[i][j] + max(strg[i-1][j+1], strg[i][j+1]);
                }
                else{
                    strg[i][j] = carr[i][j] + max(strg[i-1][j+1], strg[i][j+1], strg[i+1][j+1]);
                }
                
            }
        }
            int myans = -1;
            for(int k=0;k<strg.length;k++){
                if(strg[k][0] > myans)
                    myans=strg[k][0];
            } 
            for(int i=0;i<strg.length-1;i++){
                if(myans==strg[i][0]){
                int q=1;
                String s="";
                path(strg,i,q,s+i);
                }
            }
            return myans;  
        }

         public static int max(int... vals){
             int ans=vals[0];
            for(int i=1;i<vals.length;i++){
                if(vals[i]>ans){
                    ans=vals[i];
                }
            }
            return ans;
         }
public static void path(int [][] dp,int sr,int sc,String s){
    if(sc==dp.length-1){
        System.out.println(s);
        return;
    }
    if(sr==0){
        int max=max(dp[sr][sc+1],dp[sr+1][sc+1]);
        if(max==dp[sr][sc+1])
        path(dp,sr,sc+1,s+"d2");
        if(max==dp[sr+1][sc+1])
        path(dp,sr+1,sc+1,s+"d3");}
    else if(sr==dp.length-1){
        int max=max(dp[sr-1][sc+1],dp[sr][sc+1]);
        if(max==dp[sr-1][sc+1])
        path(dp,sr-1,sc+1,s+"d1");
        if(max==dp[sr][sc+1])
        path(dp,sr,sc+1,s+"d2");} 
    else{
        int max=max(dp[sr-1][ sc+1],dp[sr][sc+1],dp[sr+1][sc+1]);
        if(max==dp[sr-1][sc+1])
        path(dp,sr-1,sc+1,s+"d1");
        if(max==dp[sr][sc+1]) 
        path(dp,sr,sc+1,s+"d2");
        if(max==dp[sr+1][sc+1])
        path(dp,sr+1,sc+1,s+"d3");}
}
   
    }
