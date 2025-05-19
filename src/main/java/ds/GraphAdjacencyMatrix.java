package ds;

public class GraphAdjacencyMatrix {
    public static void addEdge(int [][] matrix,int i,int j){
        matrix[i][j] =1;
        matrix[i][j]=1;
    }
    public static void displayMatrix(int[][] matrix)
    {
        for(int[] row:matrix){
         for(int val:row){
             System.out.print(val+" ");
         }
         System.out.println();
        }
    }
    public static void main(String[] args) {
        int v=4;
        int[][] matrix = new int[v][v];
        addEdge(matrix,0,1);
        addEdge(matrix,0,2);
        addEdge(matrix,1,3);
        addEdge(matrix,3,2);

        displayMatrix(matrix);
    }
}
