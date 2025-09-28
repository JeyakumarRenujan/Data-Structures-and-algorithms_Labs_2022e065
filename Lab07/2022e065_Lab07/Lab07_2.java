// 2022/E/065
//Lab07 Part2

import java.util.*;

class Lab07_2 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] maze = new int[rows][cols];
        char[][] mazeChars = new char[rows][cols];

        System.out.println("Enter the maze grid (S for start, E for end, 0 for open cell, 1 for blocked cell):");
        int startX = -1, startY = -1, endX = -1, endY = -1;

        // Input the maze and locate start (S) and end (E)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char cell = scanner.next().charAt(0);
                mazeChars[i][j] = cell;
                if (cell == 'S') {
                    startX = i;
                    startY = j;
                    maze[i][j] = 0;  // Mark start as open cell
                } else if (cell == 'E') {
                    endX = i;
                    endY = j;
                    maze[i][j] = 0;  // Mark end as open cell
                } else {
                    maze[i][j] = (cell == '1') ? 1 : 0;  // 1 for blocked, 0 for open
                }
            }
        }

        System.out.println("Maze as inputted:");
        printMaze(mazeChars);  // Print original maze

        // Perform BFS to find the shortest path
        Graph graph = new Graph(rows * cols);
        int startVertex = startX * cols + startY;
        int endVertex = endX * cols + endY;

        // Add edges based on the open cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == 0) {
                    int vertex = i * cols + j;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if (isValid(nx, ny, maze)) {
                            int neighbor = nx * cols + ny;
                            graph.addEdge(vertex, neighbor);  // Add edge between adjacent open cells
                        }
                    }
                }
            }
        }

        LinkedList<Integer> path = graph.bfs(startVertex, endVertex);

        if (path != null) {
            System.out.println("Shortest path from start to end (marked with *):");
            markPathInMaze(mazeChars, path, cols);
            printMaze(mazeChars);  // Print maze with path marked
        } else {
            System.out.println("No path found.");
        }

        scanner.close();
    }

    // BFS to find the shortest path
    static class Graph {
        private List<List<Integer>> adjList;

        Graph(int size) {
            adjList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // BFS algorithm to find the shortest path
        public LinkedList<Integer> bfs(int start, int end) {
            int n = adjList.size();
            boolean[] visited = new boolean[n];
            int[] parent = new int[n];
            Arrays.fill(parent, -1);  // Initialize parent array
            LinkedList<Integer> queue = new LinkedList<>();
            visited[start] = true;
            queue.add(start);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                if (current == end) {
                    return reconstructPath(parent, start, end);
                }

                for (int neighbor : adjList.get(current)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        parent[neighbor] = current;
                        queue.add(neighbor);
                    }
                }
            }

            return null;  // No path found
        }

        // Reconstruct the path from parent array
        private LinkedList<Integer> reconstructPath(int[] parent, int start, int end) {
            LinkedList<Integer> path = new LinkedList<>();
            for (int at = end; at != start; at = parent[at]) {
                path.addFirst(at);
            }
            path.addFirst(start);
            return path;
        }
    }

    // Check if the current cell is valid (within bounds and open)
    public static boolean isValid(int x, int y, int[][] maze) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }

    // Mark the path with '*' in the maze
    public static void markPathInMaze(char[][] maze, LinkedList<Integer> path, int cols) {
        for (int vertex : path) {
            int x = vertex / cols;
            int y = vertex % cols;
            if (maze[x][y] != 'S' && maze[x][y] != 'E') {  // Don't overwrite start or end
                maze[x][y] = '*';
            }
        }
    }

    // Print the maze (including path marked with '*')
    public static void printMaze(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}
