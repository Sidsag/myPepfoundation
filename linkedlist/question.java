public class question{
    public static class linkedlist{
        public class Node{
            int data=0;
            Node next=null;
            public Node(int data){
             this.data=data;
            }
        }
        Node head=null;
        Node tail=null;
        int size=0;
       //gerenal util**==========
        public int size(){
            return size;
        }
   
        public boolean isEmpty(){
            return size==0?true:false;
        }
   
        public void display(){
            Node curr=head;
            while(curr!=null){
              System.out.print(curr.data+" -> ");
              curr=curr.next;
            }
            System.out.println("");
        }
   
        public Node getNodeat(int idx){
            if(idx<0 || idx>=size)return null;
            if(idx==0)return head;
            else{
                Node current=head;
                while(idx-->0){
                    current=current.next;
                }
                return current;
            }
        }
   
        //get.=======
        public int getFirst(){
            if(size==0){
                System.out.println("Nosuchelement");
                return -1;
            }
            return head.data;
        }
   
        public int getLast(){
           if(size==0){
               System.out.println("Nosuchelement");
               return -1;
           }
           return tail.data;
       }
       public static void main(String [] args){
           
       }
}

