public class  a{
    public static void main( String[] args){
   
    int[] array={3,5,2,8,3,5,7,6,4,7};
    
    System.out.println(findfirstindex(array,0,5));
    }
    


public static int findfirstindex(int[] arr,int idx,int data){
        
         if(idx==arr.length-1)
         return -1;
         else if(arr[idx]==data)
         return idx ;
         
        
        else
        int firsto = findfirstindex(arr,idx+1,data);
    }
}