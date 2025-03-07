import java.util.ArrayList;

public class Maze {

    private static boolean isValidCoords(Point p, int maze[][])
    {
        return p.x >= 0 && p.x < maze[0].length && p.y >= 0 && p.y < maze.length && maze[p.y][p.x] == 0;
    }

    public static int[][] createMaze(String mazeLines[])
    {
        int rows = mazeLines.length;
        int cols = mazeLines[0].length();
        int maze[][] = new int[rows][cols];
        
        for(int i = 0 ; i < rows ; i++)
            for(int j = 0 ; j < cols ; j++)
            {
                char n = mazeLines[i].charAt(j);
                if(n == '1')
                    maze[i][j] = 1;
                else
                    maze[i][j] = 0;    
            }
            return maze;
    }

    public static ArrayList<Point> trackRoute(int maze[][], int irow, int icol, int orow, int ocol)
    {
        int rows = maze.length;
        int cols = maze[0].length;
        Point entry = new Point(icol, irow);
        Point exit = new Point(ocol, orow);
    
        Point cur = entry;
        Point next;

        Point inc[] = new Point[4];

        ArrayList<Point> tracks = new ArrayList<>();
        
        inc[0] = new Point(0, -1); //North
        inc[1] = new Point(1, 0); //East
        inc[2] = new Point(0, 1); //South
        inc[3] = new Point(-1, 0); //West


        // while(!cur.equals(exit))
        while(!cur.equals(exit))
        {
            // System.out.println(cur);
            tracks.add(cur);
            maze[cur.y][cur.x] = 2;

            for (Point dir : inc) {
                next = new Point(cur.x + dir.x, cur.y + dir.y);
                if(isValidCoords(next, maze))
                {
                    cur = next;
                    break;
                }
            }

            // //check whether next coordinate is valid
            // if(next.x >= 0 && next.x < cols && next.y >= 0 && next.y < rows && maze[next.y][next.x] == 0)
            // {
            //     cur = next;
            //     continue;
            // }

            // //Go East
            // next = new Point(cur.x+1, cur.y);

            // //check whether next coordinate is valid
            // if(next.x >= 0 && next.x < cols && next.y >= 0 && next.y < rows && maze[next.y][next.x] == 0)
            // {
            //     cur = next;
            //     continue;
            // }

            // //Go South
            // next = new Point(cur.x, cur.y+1);

            // //check whether next coordinate is valid
            // if(next.x >= 0 && next.x < cols && next.y >= 0 && next.y < rows && maze[next.y][next.x] == 0)
            // {
            //     cur = next;
            //     continue;
            // }

            // //Go West
            // next = new Point(cur.x-1, cur.y);

            // //check whether next coordinate is valid
            // if(next.x >= 0 && next.x < cols && next.y >= 0 && next.y < rows && maze[next.y][next.x] == 0)
            // {
            //     cur = next;
            //     continue;
            // }

            
        }

        maze[cur.y][cur.x] = 2;
        // System.out.println(exit);
        tracks.add(exit);
        return tracks;
    }



    public static void main(String[] args) {
        String strMaze[] =
        {
            "11 111111111111",
            "11 1111111 1 11",
            "11 11  1      1",
            "11 111   1111 1",
            "11   1111111111",
            "1111 1111111111",
            "11 1   111     ",
            "11 111 111 1111",
            "11 111     1111",
            "111111111111111"
        };

        int maze[][] = createMaze(strMaze);

        for(int i = 0 ; i < maze.length ; i++)
        {
            for(int j = 0 ; j < maze[i].length ; j++)
                System.out.print(maze[i][j]);
            System.out.println();
        }

        System.out.println(trackRoute(maze, 0, 2, 6, 14));

        for(int i = 0 ; i < maze.length ; i++)
        {
            for(int j = 0 ; j < maze[i].length ; j++)
                System.out.print(maze[i][j]);
            System.out.println();
        }
    }
}

