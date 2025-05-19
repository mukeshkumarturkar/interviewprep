package ds;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjacencyList {
    public  static void addEdge(List<List<Integer>> adja , int i, int j){
        adja.get(i).add(j);
        adja.get(j).add(i);
    }
    public static void displayAdjList(List<List<Integer>> adjc){
        for(int i=0;i< adjc.size();i++){
            System.out.print(i + ":");
            for(int j:adjc.get(i))
            {
               System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int v=4;
        List<List<Integer>> adj = new ArrayList<>(v);
       /* for(List<Integer> ver:adj){
            adj.add(new ArrayList<>());
        }*/
        for(int j=0;j<v;j++){
            adj.add(new ArrayList<>());

        }
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,1);
        addEdge(adj,1,3);
        displayAdjList(adj);
    }
}
