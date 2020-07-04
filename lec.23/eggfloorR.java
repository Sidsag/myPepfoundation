class eggfloorR{
    public static void main( String [] args){
     System.out.println(trial(2,7));
    }

    public static int trial(int e,int f){
        if(e==1 || f==0 || f==1){
            return f;
        }
       int bestofworst=Integer.MAX_VALUE;
        for(int i=1;i<=f;i++){
             int case1= trial(e,f-i);   //survive
             int case2= trial(e-1,i-1); //break
             int worst=Math.max(case1,case2);
             bestofworst=Math.min(bestofworst,worst);
        }
        return bestofworst+1;
    }
}