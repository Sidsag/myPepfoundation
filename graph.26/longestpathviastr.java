
import java.util.*;

public class longestpathviastr {

	static class edge {
		int v1;
		int v2;
		int wt;

		edge(int a, int b, int wt) {
			this.v1 = a;
			this.v2 = b;
			this.wt = wt;
		}
	}

     public	static void addEdge(ArrayList<ArrayList<edge>> graph, int a, int b, int wt) {
		graph.get(a).add(new edge(a, b, wt));
		graph.get(b).add(new edge(b, a, wt));
	}
    static String path = "";
	public static void maxCostPath(ArrayList<ArrayList<edge>> graph, int s, int d,boolean[] visited,String str) {
	  if(s==d){
          str+=d;
		  if(str.length()>path.length()){
		      path=str;
		  }
		}
	visited[s]=true;
	for(int i=0;i<graph.get(s).size();i++){
		 edge cs=graph.get(s).get(i);
		 if(!visited[cs.v2]){
		 maxCostPath(graph,cs.v2,d,visited,str+s+"->");
		  }
		}
	visited[s]=false;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			graph.add(new ArrayList<edge>());
		}

		addEdge(graph, 0, 3, 40);
		addEdge(graph, 1, 0, 10);
		addEdge(graph, 2, 1, 10);
		addEdge(graph, 3, 2, 10);
		addEdge(graph, 4, 3, 2);
		addEdge(graph, 5, 4, 3);
		addEdge(graph, 6, 5, 3);
		addEdge(graph, 6, 4, 8);

		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
	    boolean[] visited=new boolean[7];
	    maxCostPath(graph, a, b,visited,"");
		System.out.println(path);
	}	
}