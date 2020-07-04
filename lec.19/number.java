import java.util.*;
public class number{
    public static void main(String[] args){
      int [][] carr={
          {2,0,1,3,1},
          {1,4,6,2,5},
          {1,1,2,6,9},
          {4,5,3,8,2},
          {3,2,1,1,7},
          {5,4,9,2,3},
      };
      int m=path(carr);
      System.out.println(m);
    }

    public static int path(int[][] carr){
        int[][] storage=new int[carr.length][carr[0].length];
        for(int i=carr.lengt h-1;i>=0;i--){
            for(int j=carr[0].length-1;j>=0;j--){
                if(i==(carr.length-1) && j==(carr[0].length-1)){
                    storage[i][j]=carr[i][j];
                }
                else if(i==carr.length-1){
                    storage[i][j]=carr[i][j]+storage[i][j+1];}
                else if(j==carr[0].length-1){
                    storage[i][j]=carr[i][j]+storage[i+1][j];}
                else{
                    storage[i][j]=carr[i][j]+Math.min(storage[i+1][j],storage[i][j+1]);
                }
            }
        }
        String s="start";
        int pass=0;
        numberpath(storage,pass,pass,s);
        return storage[0][0];
    }
 
    public static void numberpath(int [][] dp,int sr,int sc,String s){
        if(sr==dp.length-1 && sc==dp[0].length-1){
            System.out.println(s);
            return;
        }

        if(sr==dp.length-1){
            numberpath(dp,sr,sc+1,s+"H");}
        else if(sc==dp[0].length-1){
        numberpath(dp,sr+1,sc,s+"V");
       }
       else{
           int max=Math.min(dp[sr+1][sc],dp[sr][sc+1]);
           if(max==dp[sr+1][sc]){
            numberpath(dp,sr+1,sc,s+"v");  
           }
           if(max==dp[sr][sc+1]){
            numberpath(dp,sr,sc+1,s+"h");   
           }
       }
    }
}
 