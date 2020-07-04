
import java.util.*;

public class hamlinton {
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


	public static boolean hamiltonian(int s, ArrayList<ArrayList<edge>> graph, boolean[] visited, ArrayList<Integer> psf, int os) {
		
		if(psf.size()==graph.size()-1){
		    psf.add(s);
		    for(int i=0;i<psf.size();i++){
		        System.out.print(psf.get(i)+" -> ");
		    }
		    System.out.println();
		    boolean iscycle=false;
		    psf.remove(psf.size()-1);
		    if(iscycle){
		        return true;
		    }
		    return false;
		}
		
		visited[s]=true;
	     for(int i=0;i<graph.get(s).size();i++){
		    edge cs=graph.get(s).get(i);
		    if(!visited[cs.v2]){
		        psf.add(s);
		        boolean ans=hamiltonian(cs.v2,graph,visited,psf,os);
		        psf.remove(psf.size()-1);
		        if(ans){return ans;}
		    }
		}
	    visited[s]=false;
		return false;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
		for(int i = 0; i < 7; i++) {
			graph.add(new ArrayList<edge>());
		}

		addEdge(graph, 0, 3, 40);
		addEdge(graph, 1, 0, 10);
		addEdge(graph, 2, 1, 10);
		addEdge(graph, 3, 2, 10);
		addEdge(graph, 0, 5, 15);
		addEdge(graph, 4, 3, 2);
		addEdge(graph, 5, 4, 3);
		addEdge(graph, 6, 5, 3);
		addEdge(graph, 6, 4, 8);

		boolean cycle = false;
	    for(int v=0;v<7;v++){
	        ArrayList<Integer> psf=new ArrayList<>();
		    boolean [] visited=new boolean[7];
		    boolean ans= hamiltonian(v,graph,visited, psf,v);
		    if(ans)
		    cycle=ans;
		}
		System.out.println(cycle);
	}
}