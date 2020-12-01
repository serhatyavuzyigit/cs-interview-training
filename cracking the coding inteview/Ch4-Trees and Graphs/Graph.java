
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph<E> {

    // undirected graph
    private static class Vertex<E> {

        private E data;     // data stored in vertex


        private List<Vertex<E>> adjacencyList;           // the list of adjecent vertices

        public Vertex(E data) {  // constructor of class
            this.data = data;
            this.adjacencyLinkedList = new ArrayList<>();
            this.adjacencyList = new ArrayList<>();
            adjacencyLinkedList.add(this);
            adjacencyList.add(this);
        }

        public void addToAdjacencyLinkedList(Vertex<E> v) {
            adjacencyLinkedList.add(v);
            adjacencyList.add(v);
        }

        public void printAdjacencyLinkedList() {
            adjacencyLinkedList.printList();
        }

        public boolean findDataInList(E data) {
            for (Vertex<E> v : adjacencyList) {
                if (v.getData().equals(data)) {
                    return true;
                }
            }
            return false;
        }

        public E getData() {
            return data;
        }

        public SinglyLinkedList<Vertex<E>> getAdjacencyLinkedList() {
            return adjacencyLinkedList;
        }

        public List<Vertex<E>> getAdjacencyList() {
            return adjacencyList;
        }

        public String toString() {
            return data.toString();
        }
    }

    private static class Edge<E> {

        private Vertex<E> firstVertex;      // first vertex of edge

        private Vertex<E> secondVertex;     // second vertex of edge

        public Edge(Vertex<E> firstVertex, Vertex<E> secondVertex) {
            this.firstVertex = firstVertex;
            this.secondVertex = secondVertex;
        }

        public String toString() {
            return "- - - ( " + firstVertex.getData() + " ) - - - - - - ( " + secondVertex.getData() + " ) - - -";
        }
    }

    private List<Vertex<E>> vertexList;

    private List<Edge<E>> edgeList;

    public Graph() {
        vertexList = new ArrayList<>();
        edgeList = new ArrayList<>();
    }

    public void addVertex(E data1, E data2) {
        Vertex<E> v1 = getVertexFromList(data1);
        Vertex<E> v2 = getVertexFromList(data2);
        Edge<E> edge = new Edge<E>(v1, v2);
        v1.addToAdjacencyLinkedList(v2);
        v2.addToAdjacencyLinkedList(v1);
        if (!isVertexInList(v1)) {
            vertexList.add(v1);
        }
        if (!isVertexInList(v2)) {
            vertexList.add(v2);
        }

        edgeList.add(edge);
    }

    public void printVertexList() {
        String content = "Vertex List:\n";
        for (int i = 0; i < vertexList.size(); i++) {
            content += vertexList.get(i).getData() + " ";
        }
        System.out.println(content + "\n");
    }

    public void printEdgeList() {
        String content = "Edge List:\n";
        for (int i = 0; i < edgeList.size(); i++) {
            content += "( " + edgeList.get(i).firstVertex.getData() + " ) - - - ( " + edgeList.get(i).secondVertex.getData() + " )\n";
        }
        System.out.println(content);
    }

    private boolean isVertexInList(Vertex<E> v) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (v.getData().equals(vertexList.get(i).getData())) {
                return true;
            }
        }
        return false;
    }

    private Vertex<E> getVertexFromList(E data) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getData().equals(data)) {
                return vertexList.get(i);
            }
        }
        Vertex<E> newVertex = new Vertex<E>(data);
        return newVertex;
    }

    // adjacency matrix , adjacency list, comments
    public void printAdjacencyList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < vertexList.size(); i++) {
            vertexList.get(i).printAdjacencyLinkedList();
        }
        System.out.println();
    }

    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertexList.size(); i++) {
            for (int j = 0; j < vertexList.size(); j++) {
                if (vertexList.get(i).getData().equals(vertexList.get(j).getData())) {
                    System.out.print("0 ");
                } else if (vertexList.get(i).findDataInList(vertexList.get(j).getData())) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }


}
