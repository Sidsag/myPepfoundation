import java.util.*;

public class floorceil {

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

	static void addEdge(ArrayList<ArrayList<edge>> graph, int a, int b, int wt) {
		graph.get(a).add(new edge(a, b, wt));
		graph.get(b).add(new edge(b, a, wt));
	}

	static String cp; // ceilpath
	static String fp; // floorpath
	static int cpc = Integer.MAX_VALUE; // cp cost
	static int fpc = Integer.MIN_VALUE; // fp coct
	static void CeilfloorPath(ArrayList<ArrayList<edge>> graph, int src, int dest, int factor,String str,int ccost,boolean[] visited) {
		 
		 if(src==dest){
		     str+=dest;
		     if(factor<ccost && ccost<cpc){
		         cp=str;
		         cpc=ccost;
		        
		     }
		     if(ccost<factor && ccost>fpc){
		         fp=str;
		         fpc=ccost;
		        
		     }
		     return;
		 }
		 
		 
		 visited[src]=true;
		for(int e=0;e<graph.get(src).size();e++){
		    edge cs=graph.get(src).get(e);
		    if(!visited[cs.v2]){
		      //   ccost+=cs.wt;
		         CeilfloorPath(graph,cs.v2,dest,factor,str+src+"-",ccost+cs.wt,visited);
		    }
		}
		visited[src]=false;
			
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
		int factor=scn.nextInt();
		int cost=0;
	    boolean [] visited=new boolean[7];
		CeilfloorPath(graph, a, b,factor,"",cost,visited);
		System.out.println(cp + "@" + cpc);
		System.out.println(fp + "@" + fpc);
	}	
}