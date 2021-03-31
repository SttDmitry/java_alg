package lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);



//        System.out.println(graph.getAdjList(4));

//        DepthFirstPath dfp = new DepthFirstPath(graph, 0);
//        System.out.println(dfp.hasPathTo(2));
//        System.out.println(dfp.pathTo(2));

        BreadthFirstPath bfp  = new BreadthFirstPath(graph, 0);



    }
}
