package nn.functional_interface;

import java.util.function.Function;

// class Graph
// {
    // private int x, y;

    // public GraphPoint(int x, int y) {
    //     this.x = x;
    //     this.y = y;
    // }

    // }
    
    public class FunctionInterface {

        static void plotGraph(Function <Integer, Integer> func)
        {
            for(int x = -50 ; x <= 50 ; x++)
                System.out.printf("X = %d, Y = %d%n", x, func.apply(x));
        }

        public static void main(String[] args) {

        // Graph g = new Graph();

        plotGraph(x -> x * x + 9 * x - 5);
    }
}
