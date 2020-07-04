import java.util.PriorityQueue;
import java.util.ArrayList;
public class disiktranew {
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

	static void addEdge(A rrayList<ArrayList<edge>>graph, int a, int b, int wt) {
		graph.get(a).add(new edge(a, b, wt));
		graph.get(b).add(new edge(b, a, wt));
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

    public static class dpair{
        int u=0;
        int par=0;
        int wt=0;
        int wsf=0;

        dpair(int a,int b,int wt,int wsf){
            this.u=a;
            this.par=b;
            this.wt=wt;
            this.wsf=wsf;
        }
    }

    public static void disiktraalgo(ArrayList<ArrayList<edge>> graph,int src){
        ArrayList<ArrayList<edge>> mygraph=new ArrayList<>();

        for(int i=0;i<graph.size();i++){
            PriorityQueue<dpair> que=new PriorityQueue<>((dpair a,dpair b) ->{return a.wsf-b.wsf;});
            boolean [] visited=new boolean[graph.size()];
            que.add(new dpair(src,-1,0,0));
            while(que.size()!=0){
                dpair pair=que.remove();
                if(visited[pair.u])continue;   //case of cycle

                visited[pair.u]=true; //marked

                if(pair.par!=-1)
                addEdge(mygraph,pair.u,pair.par,pair.wt); //add to ans

                for(edge e: graph.get(pair.u).size()){
                    if(!visited[e.v])
                    que.add(new dpair(e.v,pair.u,e.wt,pair.wsf+e.wt));
                }
            }
        }
        display(mygraph);
    }

    public static void solve(){
        ArrayList<ArrayList<edge>> mygraph=new ArrayList<>();
        
        for(int i=0;i<=7;i++){
            graph.add(new ArrayList<edge>());
        }
        addedge(graph,0,1,2); 
        addedge(graph,0,3,10); 
        addedge(graph,1,2,3); 
        addedge(graph,2,3,7); 
        addedge(graph,3,4,4); 
        addedge(graph,4,5,2); 
        addedge(graph,4,6,3); 
        addedge(graph,5,6,8);
         
        display(graph);

        System.out.println();

        disiktraalgo(graph,2);
    }

    public static void main(String [] args){
        solve();
    }
}