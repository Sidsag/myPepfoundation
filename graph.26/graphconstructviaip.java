
import java.util.*;

public class graphconstructviaip {


	static class edge{
		int v1;
		int v2;
		int wt;
		edge(int a,int b,int wt){
			this.v1 = a;
			this.v2 = b;
			this.wt = wt;
		}
	}
	
	static void addEdge(ArrayList<ArrayList<edge>> graph, int a, int b , int wt){
		// write your code here
	   graph.get(a).add(new edge(a,b,wt));
       graph.get(b).add(new edge(b,a,wt));  //two times as bidiraectional graph
	}
	
	static void display(ArrayList<ArrayList<edge>> graph){
		for(int i=0;i<graph.size();i++){
           System.out.print(i+" -> ");
          for(int j=0;j<graph.get(i).size();j++){
             edge cedge=graph.get(i).get(j);
              System.out.print("("+cedge.v2+","+cedge.wt+"), ");
          }
          System.out.println("");
       }
		
	}
	
	public static void main(String[] args) {
        ArrayList<ArrayList<edge>>graph= new ArrayList<>();
	    Scanner scn=new Scanner(System.in);
	    int nov=scn.nextInt();
        for(int i=0;i<nov;i++){
         graph.add(new ArrayList<edge>());
        }
        int edge=scn.nextInt();
	    for(int i=0;i<edge;i++){
	        int a=scn.nextInt();
	        int b=scn.nextInt();
	        int wt=scn.nextInt();
	        addEdge(graph,a,b,wt);
	    }
		display(graph);
	}
}