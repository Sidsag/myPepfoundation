import java.util.*;
class graphbasic{
    static class edge{
        int v1;
        int v2;
        int wt;
        edge(int a,int b,int cost){
            this.v1=a;
            this.v2=b;
            this.wt=cost;
        }
    }
     public static void addedge(ArrayList<ArrayList<edge>>graph,int v1,int v2,int wt){
         graph.get(v1).add(new edge(v1,v2,wt));
         graph.get(v2).add(new edge(v2,v1,wt));
     }


   public static void display(ArrayList<ArrayList<edge>>graph){
       for(int i=0;i<graph.size();i++){
           System.out.print(i+" -> ");
          for(int j=0;j<graph.get(i).size();j++){
             edge cedge=graph.get(i).get(j);
              System.out.print("("+cedge.v2+","+cedge.wt+")");
          }
          System.out.println("");
       }
   }

   public static boolean haspath(int s,int d,boolean [] visited,ArrayList<ArrayList<edge>>graph){
       if(s==d){
           return true;
       }
       visited[s]=true;
       for(int i=0;i<graph.get(s).size();i++){
           edge cs=graph.get(s).get(i);
           if(!visited[cs.v2]){
           boolean ans=haspath(cs.v2, d, visited, graph);
           if(ans){return true;}
           }
       }
       return false;
   }

   public static boolean printpath(int s,int d,boolean[] visited,String str, ArrayList<ArrayList<edge>>graph){
    if(s==d){
        System.out.println(str+" "+d);
        return true;
    }
    visited[s]=true;
    for(int i=0;i<graph.get(s).size();i++){
        edge cs=graph.get(s).get(i);
        if(!visited[cs.v2]){
        boolean ans=printpath(cs.v2, d,visited,str+" "+s, graph);
        if(ans){return true;}
        }
    }
    return false;
   }

 //public static String printshortestpath( ArrayList<ArrayList<edge>>graph,)

public static void main(String[] args){
    ArrayList<ArrayList<edge>>graph= new ArrayList<>();
    for(int i=0;i<=7;i++){
        graph.add(new ArrayList<edge>());
    }
    addedge(graph,1,4,10); 
    addedge(graph,1,2,10); 
    addedge(graph,2,3,10); 
    addedge(graph,3,4,10); 
    addedge(graph,4,5,2); 
    addedge(graph,5,6,3); 
    addedge(graph,5,7,8); 
    addedge(graph,6,7,3);
    display(graph);
    boolean [] visited=new boolean[graph.size()];
    // System.out.println(haspath(1,7,visited,graph));
    System.out.println(printpath(1,7,visited,"",graph));
}
}