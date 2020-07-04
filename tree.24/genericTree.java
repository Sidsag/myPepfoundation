import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class genericTree{
    static node root=null;
    static class node{
        int data=0;
        ArrayList<node>child;
        node(int d){
            this.data=d;
            this.child=new ArrayList<>();
        }
    }
    public static void main(String[] args){
        int[] data={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100};
        construct(data);
         display(root);
        System.out.println("number of nodes= "+count(root));
        System.out.println(max(root));
        System.out.println(depth(root));
        System.out.println(n2rp(root,110));
        System.out.println(lcaccestor(root, 110,90));
        levelorder(root);
        levelorderZZ(root);
        levelorderLWnullmethod(root);
        levelordercountmethod(root);
        levelorderLW2queuemethod(root);
    }
    //to construct a binary tree
    public static void construct(int [] data){
       ArrayList<node> stack=new ArrayList<>();
       for(int i=0;i<data.length;i++){
           if(data[i]==-1){ 
               stack.remove(stack.size()-1);
           }
           else{
               if(root==null){
                   node n=new node(data[i]);
                   root =n;
                   stack.add(n);
               }
               else{
                   node cp=stack.get(stack.size()-1);
                   node n=new node(data[i]);
                   cp.child.add(n);
                   stack.add(n);
                }
           }
       }
    }
   //to display a generic tree
    public static void display(node croot){
        if(croot==null){
            return;}
        System.out.print(croot.data+"-> ");
        
        for(int i=0;i<croot.child.size();i++){
            System.out.print(croot.child.get(i).data+" ");
         }
         System.out.println(".");
        for(int i=0;i<croot.child.size();i++){
        display(croot.child.get(i));
       }
}
//to count number of nodes
public static int count(node croot){
    int myans=1;
    for(int i=0;i<croot.child.size();i++){
       myans+= count(croot.child.get(i));
       }
       return myans;
}
//to find maximum in tree
public static int max(node croot){
    if(croot==null){
        return Integer.MIN_VALUE;
    }
    int mymax=croot.data;
    for(int i=0;i<croot.child.size();i++){
        int recAns=max(croot.child.get(i));
        if(recAns>mymax)
        mymax=recAns;
       }
       return mymax;
}
//to find hieght of tree
public static int depth(node croot){
    if(croot==null){
    return 0;
    }
    int maxnode=0;
    for(int i=0;i<croot.child.size();i++){
       int crnode= depth(croot.child.get(i));
       if(crnode>maxnode){
           maxnode=crnode;
       }
    }
    return maxnode+1;
}
//to print all acesstor of given data 
public static ArrayList<Integer> n2rp(node root,int data){
    if(root==null){
        return null;
    }

    if(root.data==data){
        ArrayList<Integer> myans=new ArrayList<>();
        myans.add(data);
        return myans;
    }
    for(int i=0;i<root.child.size();i++){
     ArrayList<Integer> recans=n2rp(root.child.get(i),data);
     if(recans!=null){
         recans.add(root.data);
         return recans;
     }
    }
     return null;
     }
    //to print lowest common acesstor of 2 data
     public static int lcaccestor(node root,int d1,int d2){
         ArrayList<Integer> n2p1=n2rp(root, d1);
         ArrayList<Integer> n2p2=n2rp(root, d2);
         int i=n2p1.size()-1;
         int j=n2p2.size()-1;
         while(i>=0 && j>=0){
             if(n2p1.get(i)!=n2p2.get(j)){
                 break;}
             
             i--;
             j--;
         }
         return n2p1.get(i+1);
        }
    //print level order travelsal
    public static void levelorder (node root){
        Queue<node> qu=new LinkedList<>();
            qu.add(root);
           
        while(qu.size()!=0){
            node cp=qu.remove();
            System.out.print(cp.data+" ");                       
            for(int i=0;i<cp.child.size();i++){
                qu.add(cp.child.get(i));
            }
         }
         System.out.println();
        }
        //to print levelorder traversal but line wise
        //null method using  null in queue
        public static void levelorderLWnullmethod (node root){
            Queue<node> qu=new LinkedList<>();
                qu.add(root);
                qu.add(null);
               while(qu.size()!=0){
                node cp=qu.remove();
                if(cp!=null){
                    System.out.print(cp.data+" ");
                    for(int i=0;i<cp.child.size();i++){
                        qu.add(cp.child.get(i));
                    }
                }
                else{
                System.out.println(); 
                   if(qu.size()>0)                     
                    qu.add(null);
                }
                }
                System.out.println();
            }
    ////to print levelorder traversal but line wise
    //count method
    public static void levelordercountmethod(node root){
        Queue<node> qu=new LinkedList<>();
        qu.add(root);
        while(qu.size()>0){
            int size=qu.size();
            while(size>0){
            node cp=qu.remove();
            System.out.print(cp.data+" ");
             for(int i=0;i<cp.child.size();i++){
                 qu.add(cp.child.get(i));
             }
            size--;
            }
            System.out.println();
        }
    }

    ////to print levelorder traversal but line wise
    //usint 2 queuemethod
    public static void levelorderLW2queuemethod(node root){
    Queue<node> main=new LinkedList<>();
    Queue<node> helper=new LinkedList<>();
    main.add(root);
    while(main.size()>0){
        node cp=main.remove();
        System.out.print(cp.data+" ");
         for(int i=0;i<cp.child.size();i++){
            helper.add(cp.child.get(i));
         }
         if(main.size()==0){
            Queue<node> temp= main;
            main=helper;
            helper=temp;
            System.out.println();
         }
    }
    }
    //print element in waveform i.e in zigzag fashion
  

        public static void levelorderZZ(node root){
            Queue<node> qu=new LinkedList<>();
            ArrayList<node> stack=new ArrayList<>();
            boolean flag= true;
            qu.add(root);

            while(qu.size()!=0){
            node cp=qu.remove();
            System.out.print(cp.data+" ");
            if(flag){
                for(int j=0;j<cp.child.size();j++){
                    stack.add(cp.child.get(j));}
                }
            else{
                for(int k=cp.child.size()-1;k>=0;k--){
                    stack.add(cp.child.get(k));}
            }
            if(qu.size()==0){
                while(stack.size()>0){
                    qu.add(stack.remove(stack.size()-1));
                }
            flag=!flag;                      //toggle flag
            } 
            }
            System.out.println();
        }
    }