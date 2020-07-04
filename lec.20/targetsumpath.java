public class targetsumpath{
    public static void main(String[] args){
        int [] arr={2,1,9,4,5};
        String s="";
        System.out.println(targetpath(arr,7,s));
        }

        public static String targetpath(int [] arr,int target,String s){
            boolean[][] dp=new boolean[arr.length+1][target+1];
            dp[0][0]=true;
    
            for(int i=1;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    dp[i][j]=dp[i-1][j];
    
                    if(dp[i][j]==false){
                        if(j-arr[i-1]>=0 && dp[i-1][j-arr[i-1]])
                            dp[i][j]=true;
                    }
                }
            }
            
            
        }
}

