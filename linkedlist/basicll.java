public class basicll{

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

     //Add.=========

     public void addFirst(int data){
         Node node=new Node(data);
         if(size==0){
             head=node;
             tail=node;
         }else{
             node.next=head;
             head=node;
         }
         size++;
     }

     public void addLast(int data){
         Node node=new Node(data);
         if(size==0){
             head=node;
             tail=node;
         }else{
            tail.next=node;
            tail=node; 
         }
         size++;
     }

     public void addAt(int data,int idx){
         if(idx<0 || idx>size)return;
         if(idx==0)addFirst(data);
         if(idx==size)addLast(data);
         else{
             Node previous=getNodeat(idx-1);
             Node forward=previous.next;
             Node node=new Node(data);
             previous.next=node;
             node.next=forward;
         }
         size++;
     }
     //remove===
     public int removeFirst(){
         if(size==0){
             System.out.println("Nullpointexeption");
         }
         int rv=head.data;
         if(size==1){
           return rv;
         }else{
             Node temp=head;
             head=head.next;
             temp.next=null;
         }
         size--;
         return rv;
     }

    public int removeLast(){
        if(size==0){
            System.out.println("Nullpointexeption");
        }
        int rv=tail.data;
        if(size==1){
          return rv;
        }else{
        Node secondlast=getNodeat(size-2);
        secondlast.next=null;
        tail=secondlast;
        }
        size--;
        return rv;
    }

    public int removeAt(int idx){
        if(idx<0 || idx>size){
            System.out.println("Nosuchelementexception");
            return -1;
        }
        if(idx==0)return removeFirst();
        if(idx==size)return removeLast();
        else{
            Node prevnode=getNodeat(idx-1);
            Node currnode=getNodeat(idx);
            Node forward=currnode.next;
            prevnode.next=forward;
            currnode.next=null;
            size--;
           return currnode.data;
        }
    }

    //QUESTION SET

    //reverse linked list
  //reverse pointer approch
  public void reverseList() {
    Node curr=head;
    Node prev=null;
    Node forw=null;
     
     while(curr!=null){
         forw=curr.next;
         curr.next=prev;
         prev=curr;
         curr=forw;
         
     }
     tail=head;
     head=prev;
    }

    //iterative approach

    public void reverseListiterative(){
        int i=0;
        int j=size-1;
        while(i<j){
            Node a=getNodeat(i);
            Node b=getNodeat(j);

            int temp=a.data;
            a.data=b.data;
            b.data=temp;
            i++;
            j--;
        }
    }

    //find middleelement
    public int middleNode() {
        Node slow=head;
        Node fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
       return slow.data; 
    }
    //pallindrome check
    private Node PmiddleNode(Node chead) {
        Node slow=chead;
        Node fast=chead;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
       return slow; 
    }

    private Node PreverseList(Node chead) {
        Node curr=chead;
        Node prev=null;
        Node forw=null;
         
         while(curr!=null){
             forw=curr.next;
             curr.next=prev;
             prev=curr;
             curr=forw;
             
         }
         return prev;
        }
        public boolean isPalindrome(Node chead) {
            if(chead==null|| chead.next==null)return true;
            Node midnode= PmiddleNode(chead);
            Node nhead= midnode.next;
            midnode.next=null;
              
            nhead=PreverseList(nhead);
              
            Node curr1=chead;
            Node curr2=nhead;
              
           while(curr1.next!=null && curr2!=null){
            if(curr1.data!=curr2.data) return false;
               curr1=curr1.next;
               curr2=curr2.next;}

             nhead =PreverseList(nhead);
             midnode.next=nhead;
              return true;
            }


          ///reorde/foldlist
              public void reorderList(Node chead) {
                if(chead==null|| chead.next==null)return;
                Node midnode= PmiddleNode(chead);
                Node nhead= midnode.next;
                midnode.next=null;
                  
                 nhead=PreverseList(nhead);
                  
                Node curr1=chead;
                Node curr2=nhead;
                  
               while(curr1!=null && curr2!=null){
                   //backup
                   Node forw1=curr1.next;
                   Node forw2=curr2.next;
                   //reorder
                   curr1.next=curr2;
                   curr2.next=forw1;
                   //move
                   curr1=forw1;
                   curr2=forw2;
                   }
              }  
          }
    public static void main(String[] args){
      linkedlist ll=new linkedlist();
      for(int i=1;i<=10;i++){
          ll.addFirst(10*i);
      }
      ll.display();
      for(int i=10;i>=1;i--){
        ll.addLast(2*i);
      }
       ll.display();
       System.out.println(ll.removeLast());
       System.out.println(ll.removeLast());
       System.out.println(ll.removeFirst());
       System.out.println(ll.removeFirst());
       ll.display();
       ll.addAt(110, 6);
       System.out.println(ll.removeAt(9));
       ll.display();
       ll.reverseList();
       ll.display();
       System.out.println(ll.middleNode());
       ll.reverseListiterative();
       ll.display();
       System.out.println(ll.isPalindrome(ll.head));
       ll.display();
       ll.reorderList(ll.head);
       ll.display();
    }
}