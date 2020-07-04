import java.util.ArrayList;
public class basicheap{
    public static ArrayList<Integer> arr=new ArrayList<>();
    public static boolean isMax=false;

    public static void createheap(int[] dataset,boolean ismax){
        for(int ele:dataset)arr.add(ele);
        isMax=ismax;
        int ei=arr.size()-1;
        for(int i=ei;i>=0;i--){
            downheapify(i,ei);
        }
    }

    public static int remove(){
        int rv=arr.get(0);
        swap(0, arr.size() - 1);
        arr.remove(arr.size()-1);
        downheapify(0,arr.size()-1);
        return rv;
    }

    public static int get(){
        return arr.get(0);
    }

    public static void downheapify(int parIdx,int ei){
        int maxidx=parIdx;
        int lci=2*parIdx+1;
        int rci=2*parIdx+2;

        if(lci<=ei && arr.get(lci)>arr.get(maxidx))maxidx=lci;
        if(rci<=ei && arr.get(rci)>arr.get(maxidx))maxidx=rci;

        if(parIdx!=maxidx){
            swap(parIdx,maxidx);
            downheapify(maxidx,ei);
        }

    }

    public static void swap(int a,int b){
        int val1=arr.get(a);
        int val2=arr.get(b);

        arr.set(a,val2);
        arr.set(b,val1);
    }
  public static void main(String[] args){
      int[] dataSet={6,8,2,-4,18,4,10,9,8,9,16,15,13,11};
      createheap(dataSet,true);
      
      //while(arr.size()!=0){
         // System.out.print(remove()+" ");
      //}
      int ei=dataSet.length-1;
      while(ei>=0){
          int a=remove();
          dataSet[ei]=a;
          ei--;
      }
      System.out.println("Sorted array:");
      for(int ele:dataSet)System.out.print(ele+" ");

  }

}