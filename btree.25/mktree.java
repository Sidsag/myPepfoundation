import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class mktree{
    static node root=null;
    static class node{
        int data=0;
        node left=null;
        node right=null;
        node(int d){
            this.data=d;
        }
    }

    
    public static void display(node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" -> ");
        if(root.left!=null)
        System.out.print(root.left.data+" -> ");
        if(root.right!=null)
        System.out.print(root.right.data+" -> ");
        
        System.out.println(".");
        
        // if(root.left!=null) 
        display(root.left);
        // if(root.right!=null) 
        display(root.right);
    }

    // public static check(node root){
    //     if(root==null){
    //         helper base=
    //     }
    // }

    public static node constructviaip(int [] pre,int [] in,int plo,int phi,int inlo,int inhi){
        if(inlo==inhi){
            node basenode=new node(in[inlo]);
            return basenode;
        }
        node croot=new node(pre[plo]);
        int count=0;
        int i=inlo;
        while(pre[plo] !=in[i]){
            count++;
            i++;
        }
        
        croot.left=constructviaip(pre,in,plo+1,plo+count,inlo,inlo+count-1);
        croot.right=constructviaip(pre,in,plo+count+1,phi,i+1,inhi);
        return croot;
    }
    publi c static void main(String[] args){
    int[] pre={10,20,40,50,80,90,30,60,70};
    int[] in={40,20,80,50,90,10,60,30,70};
    root=constructviaip(pre,in,0,pre.length-1,0,in.length-1);
    // System.out.print(root);
    display(root);
    // diameterdp(root);
    }
}