package lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(3,1);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(5,7);
        graph.addEdge(4,6);
        graph.addEdge(6, 8);
        graph.addEdge(8,5);
        graph.addEdge(8,3);
        graph.addEdge(7,9);


//        System.out.println(graph.getAdjList(4));

//        DepthFirstPath dfp = new DepthFirstPath(graph, 0);
//        System.out.println(dfp.hasPathTo(2));
//        System.out.println(dfp.pathTo(2));

        BreadthFirstPath bfp  = new BreadthFirstPath(graph, 0);
        System.out.println(bfp.hasPathTo(9));
        System.out.println(bfp.pathTo(9));



    }
}
