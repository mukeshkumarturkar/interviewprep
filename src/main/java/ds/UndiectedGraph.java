package ds;

import java.util.ArrayList;
import java.util.List;

public class UndiectedGraph {

    int vertices ;
    List<List<Integer>> adjcl;

    //constructor
    public UndiectedGraph(int v){
        this.vertices =v;
        adjcl = new ArrayList<>();
        for(int i=0;i<v;i++) adjcl.add(new ArrayList<>());
    }

    //Add Edge
    private void addEdge(int i, int j){
        adjcl.get(i).add(j);
        adjcl.get(j).add(i);
    }

    public static void main(String[] args) {

        UndiectedGraph graph = new UndiectedGraph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,1);
       System.out.println(graph.hasCycle());


    }

    // Main method to check for cycle in the graph
    private boolean hasCycle(){
        boolean[] isVisited = new boolean[vertices];
        for(int k=0;k<vertices;k++){
            if(!isVisited[k]){
                if(isCyclicDFS(k,isVisited,-1))
                    return true;
            }
        }
        return false;
    }
    // DFS method to detect cycle
    private boolean isCyclicDFS(int current ,boolean[] visited,int parrent){
        visited[current] =true;
        for(int neibhour:adjcl.get(current)){

            if(!visited[neibhour])
            {
                if(isCyclicDFS(neibhour,visited,current)) return true;
                    // Found a back edge (cycle)
                else if (neibhour!=parrent) return true;
            }
            
        }

        return false;
    }
}
