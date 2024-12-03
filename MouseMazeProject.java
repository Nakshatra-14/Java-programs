import java.lang.reflect.Array;
import java.util.Arrays;

public class MouseMazeProject {

    public static int randInt(int lb, int ub) {
        return lb + (int) ((ub - lb + 1) * Math.random());
    }

    public static void main(String[] args) {
        
        int maze[][] = new int[10][12];

        for(int i = 0 ; i < maze.length ; i++)
            for(int j = 0 ; j < maze[0].length ; j++)
                maze[i][j] = randInt(0, 1);
         
        // System.out.println(Arrays.toString(maze));   
        
        for (int i = 0 ; i < maze.length ; i++) {
            for (int j = 0 ; j < maze[0].length ; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}
