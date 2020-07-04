
public class  arr{
    public static void main( String[] args){
    int[] arr={9,3,8,7,6,5,2,13,20,4};
    int[] array={3,5,2,8,3,5,7,6,4,7};
    System.out.println(findmax(arr,0));
    System.out.println(findmin(arr,0));
    System.out.println(firstocc(array,0,5));
    System.out.println(lastocc(array,0,5));
    int ans=allindexocc(array,0,3,0);
    for(int i=0;i<ans.length;i++)
    System.out.println(ans[i]);
    }
    
    public static int findmax(int[] arr,int idx){
        if(idx==arr.length-1)
        return idx;

        int recAns= findmax(arr,idx+1);

        if(arr[idx]>arr[recAns])
        return idx;
        else 
        return recAns;   
    }

    public static int findmin(int[] arr,int idx){
        if(idx==arr.length-1)
        return idx;

        int recAns= findmin(arr,idx+1);

        if(arr[idx]<arr[recAns])
        return idx;
        else 
        return recAns;   
    }
//public static int sortarr(int[] arr,int idx){
//if(idx==arr.length-1)
  //      return idx;

    //    int recsort= sortarr(arr,idx+1);

        
      //  int st=findmin(arr,idx-1)
        //i
        //swap(recsort,)
        //else 
        //return recAns;   
    //}
public static int firstocc(int[] arr,int idx,int data){
    if(idx==arr.length-1)
    return -1;

    int res= firstocc(arr,idx+1,data);

    if(arr[idx]==data){
        return idx;
    }
    return res;
    
}
public static int lastocc(int[] arr,int idx,int data){
    if(idx==arr.length-1)
    return -1;

    int res= lastocc(arr,idx+1,data);

    if(arr[idx]==data){
        if(res==-1)
        return idx;
        else
        return res;
    }
    return res;
}

public static int[] allindexocc(int[] arr,int idx,int data){
    if(idx==arr.length-1){
        int baseres=new int[count];
        return baseres;
    }
    if(arr[idx]==data)
    cout++;

    int[] resAns=allinde

     if(arr[idx]==data){
     resAns(count-1)=idx;
     }
 return resAns;
}
}

