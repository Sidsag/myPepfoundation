import java.util.*;
public class consdis{
    static class node{
        int data;
        node left;
        node rigth;
        node(int d){
            this.data=d;
            left=rigth=null;
        }
    }
    static  node root=null;
    public static void construct(int[] data){
        ArrayList<node> stack=new ArrayList<>();
        for(int i=0;i<data.length;i++){
            if(data[i]==-1){
                stack.remove(stack.size()-1);
            }else{
                node nm=new node(data[i]);
                if(root==null){
                    root=nm;
                }else{
                    node cp=stack.get(stack.size()-1);
                    if(cp.left==null){
                        cp.left=nm;
                    }else{
                        cp.rigth=nm;
                    }
                }
                stack.add(nm);
            }
        }
    }
    public static void display(node Node){
        if(Node==null){
            return;
        }
        String str="";
        str+=Node.left!=null?Node.left.data:".";
        str+="->"+Node.data+"->";
        str+=Node.left!=null?Node.left.data:".";
        System.out.println(str);
        display(Node.left);
        display(Node.rigth);
    }

    static node construct1(int[] pre,int ps,int pe,int[] in,int is,int ie){
        if(is==ie || ps==pe){
            return new node(pre[ps]);
        }
        node croot=new node(pre[ps]);
        int i=is;
        while(pre[ps]!=in[i]){
            i++;
        }
        int count=i-is;
        croot.left=construct1(pre,ps+1,ps+count,in,is,i-1);
        croot.rigth=construct1(pre,ps+count+1,pe,in,i+1,ie);
        return croot;
    }
    public static int findmax(node croot){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        else if(croot.left==null & croot.rigth==null){
            return croot.data;
        }
        else{
         int max_c;
            if(croot.left==null){
                max_c=croot.rigth.data;
            }else if(croot.rigth==null){
                max_c=croot.left.data;
            }else{
           max_c=Math.max(findmax(croot.left),findmax(croot.rigth));}
         return Math.max(max_c,croot.data);
    }
   }
    
    public static int findsize(node croot){
        if(croot==null){
            return 0;
        }
        int size=findsize(croot.left)+findsize(croot.rigth)+1;
        return size;
    }

    public static int findhieght(node croot){
        if(croot==null){
            return 0;
        }
        int max_h=Math.max(findhieght(croot.left),findhieght(croot.rigth));
        return max_h+1;
    }
    public static void preorder(node croot){
        if(croot==null){
            return;
        }
        System.out.print(croot.data+" ");
        if(croot.left!=null){
            preorder(croot.left);}
        if(croot.rigth!=null){
            preorder(croot.rigth); }
        }

    public static void Inorder(node croot){
        if(croot==null){
            return;
        }
       
        if(croot.left!=null){
            Inorder(croot.left);}
        System.out.print(croot.data+" ");
        if(croot.rigth!=null){
            Inorder(croot.rigth); }
        }

    public static void postorder(node croot){
        if(croot==null){
            return;
        }
       
        if(croot.left!=null){
            postorder(croot.left);}
        if(croot.rigth!=null){
            postorder(croot.rigth); }
     System.out.print(croot.data+" ");
        }
    public static boolean ifbalanced(node croot){
        if(root==null){
            return true;
        }
        if(croot.left!=null && croot.rigth!=null){
        boolean check=ifbalanced(croot.left) && ifbalanced(croot.rigth);
        if(check){
        int diff=findhieght(croot.left)-findhieght(croot.rigth);
        if(diff==-1|| diff==0|| diff==1){
            return true;
        }else
          return false;
         }else
         return false;}
         else
         return true;
        }
        public static boolean findelement(node croot,int element){
            if(root==null){
                return false;
            }
            if(croot.data==element){
               return true;
            }
            boolean find=findelement(croot.left,element)||findelement(croot.rigth,element);
            return find;
         }
     public static void main(String[] args){
       int [] data={10,20,40,-1,50,80,-1,90,-1,-1,-1,30,60,100,-1,110,-1,-1,70};
       construct(data);
       display(root);
       System.out.println("maximum element is "+findmax(root));
       System.out.println("size of tree is "+findsize(root));
       System.out.println("hieght is "+findhieght(root));
        preorder(root);
        System.out.println(":preorder");
        Inorder(root);
        System.out.println(":inorder");
        postorder(root);
        System.out.println(":postorder");
        int[] pre={10, 20, 40, 50 ,80 ,90, 30, 60, 100, 110, 70};
        int[] in={40 ,20 ,80 ,50 ,90 ,10 ,100 ,60 ,110 ,30, 70};
        node newroot=construct1(pre, 0, pre.length-1, in, 0, in.length-1);
        display(newroot);
        boolean isbalanced=ifbalanced(root);
        System.out.println(isbalanced);
        boolean found= findelement(root,111);
        System.out.println(found);
    }
}