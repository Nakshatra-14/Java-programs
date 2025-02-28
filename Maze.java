public class Maze {

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

        public static char checker(int row, int col, int maze[][])
        {
            Point n = new Point(row, col);
                if(n.x - 1 == 0)
                {
                    maze[n.x - 1][n.y] = 2;
                    return 'A'; 
                }
                if(n.y + 1 == 0)
                {
                    maze[n.x][n.y + 1] = 2;
                    return 'B';
                }
                if(n.x + 1 == 0)
                {
                    maze[n.x + 1][n.y] = 2;
                    return 'C';
                }
                if(n.y - 1 == 0)
                {
                    maze[n.x][n.y - 1] = 2;
                    return 'D';            
                }
            return 'F';         
        }

    public static void printRoute(int maze[][], int irow, int icol, int orow, int ocol)
    {
        Point arr[] = new Point[50];

        Point n = new Point(irow, icol);
        int i = 0;

        while(n.x != orow && n.y != ocol)
        {
            if(checker(n.x, n.y, maze) == 'A')
            {
                n.x--;
                arr[i] = new Point(n.x, n.y);
            }

            else if(checker(n.x, n.y, maze) == 'B')
            {
                n.y++;
                arr[i] = new Point(n.x, n.y);
            }

            else if(checker(n.x, n.y, maze) == 'C')
            {
                n.x++;
                arr[i] = new Point(n.x, n.y);
            }

            else if(checker(n.x, n.y, maze) == 'D')
            {
                n.y--;
                arr[i] = new Point(n.x, n.y);
            }

            i++;
            // int t = i;
            // for(i = 0 ; i < t ; i++)
            //     System.out.println("(" + arr[i] +")");
        }
        System.out.println(i);

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

        printRoute(maze, 0, 2, 6, 13);

    }
}

