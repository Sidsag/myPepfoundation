import java.util.*;

public class disiktra {

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

   static class helper implements Comparable<helper>{
        int vtx;
        String path;
        int cost;
        helper(int v,String p,int c){
            this.vtx=v;
            this.path=p;
            this.cost=c;
        }
        public int compareTo(helper other){
            return this.cost - other.cost;
        }
    }

	static void Dijkstra(ArrayList<ArrayList<edge>>graph, int src) {
       PriorityQueue<helper> pq=new PriorityQueue<helper>();
       helper root=new helper(src,""+src,0);
       pq.add(root);
       boolean[] visited=new boolean[graph.size()];
       while(pq.size()>0){
           helper cp =pq.remove();
           if(visited[cp.vtx]){
               continue;
           }
           else
           visited[cp.vtx]=true;
           
           System.out.println(cp.vtx+" via "+cp.path+" @ "+cp.cost);
           for(int ce=0;ce<graph.get(cp.vtx).size();ce++){
                   edge e=graph.get(cp.vtx).get(ce);
                   if(visited[e.v2]==false){
                       helper cvtx=new helper(e.v2,cp.path+e.v2,cp.cost+e.wt);
                       pq.add(cvtx);
                   }
             }
       }
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
		Dijkstra(graph, a);
	}	
}