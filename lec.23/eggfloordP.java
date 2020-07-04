class eggfloordp{
    public static void main(String[] args){
      System.out.println(egf(2,7));
    }

    public static int egf(int egg,int floor){
        int [][] dp=new int[egg+1][floor+1];

        for(int e=0;e<=egg;e++){
            for(int f=0;f<=floor;f++){
                if(e==0)
                dp[e][f]=0;
                else if(e==1 || f==0 || f==1)
                    dp[e][f]=f;
                else{
                    int bestofworst=Integer.MAX_VALUE;
                        for(int i=1;i<=f;i++){
                            int case1=dp[e][f-i];
                            int case2=dp[e-1][i-1];
                            int worst=Math.max(case1,case2);
                            bestofworst=Math.min(bestofworst,worst);
                        }
                    
                    dp[e][f]=bestofworst+1;
                }
                }
            }
            return dp[egg][floor];
        }
    }