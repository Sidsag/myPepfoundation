public class conspi{
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
    public static  node construct(int[] pre,int[] in,int l,int h,int p){
        if(l==h){
        node bnm=new node(in[l]);
        return bnm; 
        }
        for(int i=l;i<=h;i++){
            if(pre[p]==in[i]){
            node nm=new node(in[i]);
            
            nm.left=construct(pre,in,l,i-1,p+1);
            nm.rigth= construct(pre,in,i+1,h,p+i+1);
            root=nm;
            }
        }
        return root;
    }

  
    public static void display(node Node){
        if(Node==null){
            return;
        }
        String str="";
        str+=Node.left!=null?Node.left.data:".";
        str+="<-"+Node.data+"->";
        str+=Node.left!=null?Node.left.data:".";
        System.out.println(str);
        display(Node.left);
        display(Node.rigth);
    }
    public static void main(String[] args){
        int[] pre={10, 20, 40, 50 ,80 ,90, 30, 60, 100, 110, 70};
        int[] in={40 ,20 ,80 ,50 ,90 ,10 ,100 ,60 ,110 ,30, 70};
        root= construct(pre,in,0,pre.length-1,0);
        display(root);
    }
}