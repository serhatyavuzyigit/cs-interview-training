package Graph;

public class GraphDemo {

    public static void main(String[] args) {

        Graph<Integer> g = new Graph<Integer>();
        g.addVertex(5, 6);
        g.addVertex(5, 7);
        g.addVertex(6, 7);
        g.addVertex(6, 8);
        g.addVertex(8, 9);
        g.addVertex(8, 10);
        g.addVertex(9, 10);

        g.printVertexList();
        g.printEdgeList();
        g.printAdjacencyList();
        g.printAdjacencyMatrix();
    }
}
