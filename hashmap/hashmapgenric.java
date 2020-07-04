import java.util.LinkedList;
import java.util.ArrayList;
public class hashmapgenric<K,V> {
      public class Node{
            K key=null;
            V value=null;
            Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }
    
        LinkedList<Node>[] groupArray=new LinkedList[10];
        int nodecount=0;
       
        public hashmapgenric(){
            reassign(10);
        }
    
        public void reassign(int size){
            groupArray=new LinkedList[size];
            nodecount=0;
            for(int i=0;i<size;i++){
                groupArray[i]=new LinkedList<>();
            }
        }
    
        public int size(){
            return nodecount;
        }
    
        public boolean isEmpty(){
            return nodecount==0;
        }
    
        public int getHashCode(K key){
            int hc=key.hashCode();
            return Math.abs(hc)%groupArray.length;
        }
       
        public Node foundNodeInGroup(K key){
            int my_groupidx=getHashCode(key);
            LinkedList<Node> group=groupArray[my_groupidx];
            Node rn=null;
            if(group==null)return null;
    
            int size=group.size();
            while(size-->0){
                Node node=group.getFirst();
                if(node.key==key){
                    rn=node;
                    break;
                }
                group.addLast(group.removeFirst());
            }
            return rn;
        }
    
        public boolean containskey(K key){
            Node node=foundNodeInGroup(key);
            return node!=null?true:false;
        }
    
        public V get(K key){
            Node node=foundNodeInGroup(key);
            return node!=null?node.value:null;
        }

        public V getbydefault(K key,V n){
            Node node=foundNodeInGroup(key);
            return node!=null?node.value:n;
        }
    
        public V remove(K key){
            Node node=foundNodeInGroup(key);
            if(node!=null){
                int mygrpidx=getHashCode(key);
                LinkedList<Node> group=groupArray[mygrpidx];
                group.removeFirst();
                nodecount--;
            }
            return node!=null?node.value:null;
        }
    
     public ArrayList<K> keyset(){
         ArrayList<K> ans=new ArrayList<>();
         for(int i=0;i<groupArray.length;i++){
             LinkedList<Node> group=groupArray[i];
             int size=group.size();
             while(size-->0){
                 Node node=group.getFirst();
                 ans.add(node.key);
                 group.addFirst(group.removeFirst());
             }
         }
         return ans;
     }
    
     public void display(){
         String ans="[";
         for(int i=0;i<groupArray.length;i++){
            LinkedList<Node> group=groupArray[i];
            int size=group.size();
            while(size-- > 0){
                Node node=group.getFirst();
                ans+=node.key+":"+node.value+", ";
                group.addLast(group.removeFirst());
            }
         }
         ans+="]";
         System.out.println(ans);
        }
         public void put(K key,V value){
             Node node=foundNodeInGroup(key);
             if(node!=null){
                 node.value=value;  //update
             }
    
             else{
                 int mygrpIdxi=getHashCode(key);
    
                 LinkedList<Node> group=groupArray[mygrpIdxi];
                 Node  nnode=new Node(key,value);
                 group.addLast(nnode);
                 nodecount++;
                 
                 //rehashing
                 double lambda=(group.size()*1.0)/nodecount;
                 if(lambda>0.6){
                     rehash();
                 }
             }
             }

             public void putifabsent(K key,V value){
                Node node=foundNodeInGroup(key);
                   if(node==null){
                    int mygrpIdxi=getHashCode(key);
       
                    LinkedList<Node> group=groupArray[mygrpIdxi];
                    Node  nnode=new Node(key,value);
                    group.addLast(nnode);
                    nodecount++;
                    
                    //rehashing
                    double lambda=(group.size()*1.0)/nodecount;
                    if(lambda>0.6){
                        rehash();
                    }
                }
                }
        public void rehash(){
            LinkedList<Node>[] olddata=groupArray;
            reassign(olddata.length*2);
            for(int i=0;i<olddata.length;i++){
                LinkedList<Node> group=olddata[i];
                int size =group.size();
                while(size-->0){
                    Node node=group.removeFirst();
                    put(node.key,node.value);
                }
            }
        }
    
     }
    
