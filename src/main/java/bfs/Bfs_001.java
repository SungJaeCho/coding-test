package bfs;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_001 {

    static int vertex;
    static int edge;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        vertex = sc.nextInt();
        edge = sc.nextInt();
        map = new int[vertex + 1][vertex + 1];
        visited = new boolean[vertex + 1];

        for(int i = 1; i <= edge; i++) {
            System.out.println("시작입력");
            int start = sc.nextInt();
            System.out.println("종료입력");
            int end = sc.nextInt();

            map[start][end] = 1;
            map[end][start] = 1;
        }
        BFS(1, vertex);
    }

    static void BFS(int start, int end) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, end));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll(); //큐에서 뺌
            visited[node.x] = true;
            System.out.println("노트poll:" + node.x);
            for(int i=1; i<map.length; i++) {
                if(map[node.x][i] == 1 && !visited[i]) {
                    queue.add(new Node(i, end));
                    visited[i] = true;
                }
            }
        }

    }


    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
