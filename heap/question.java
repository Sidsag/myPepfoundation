import java.util.PriorityQueue;
import java.util.Collections;

public class question{
    public static class pair implements Comparable<pair>{
        int val=0;
        int idx=0;
        pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }

        public int compareTo(pair o){
            return this.val-o.val;    //min pq
           // return o.val-this.val;  //max pq if collectionreverse not used
        }
    }

    public static pair kthlargest(int[] arr,int k){
        PriorityQueue<pair> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(new pair(arr[i],i));
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek(); //kth largest
    }

    public static pair kthsmallest(int[] arr,int k){
        PriorityQueue<pair> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            pq.add(new pair(arr[i],i));
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek(); //kth smallest
    }
    public static void main(String[] args){
    int[] dataset={2,4,7,3,-2,9,8,5};
    //pair p=kthlargest(dataset,3);
    //System.out.println(p.val+" at index "+p.idx);
    pair q=kthsmallest(dataset,3);
    System.out.println(q.val+" at index  "+q.idx);
    }
}