package dfs;

import java.util.Arrays;
import java.util.Scanner;

public class Dfs_001 { // 인접행렬
    static int edge; //간선의 수
    static int vertex; //정점의 수
    static int[][] map; //정점간의 연결의 정보를 담는 객체
    static boolean[] visit; //정점을 방문했는지 체크하기 위한 객체

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vertex = sc.nextInt();
        edge = sc.nextInt();
        map = new int[vertex + 1][vertex + 1];
        visit = new boolean[vertex + 1];

        for(int i=0; i<edge; i++) {
            int start = sc.nextInt();
            int next = sc.nextInt();
            map[start][next] = 1;
            map[next][start] = 1;
        }
        dfs(1);
        System.out.println(Arrays.toString(visit));
    }

    public static void dfs(int start) {
        visit[start] = true;
        System.out.println(start + " ");
        for(int i=1; i<vertex; i++) {
            if(map[start][i] == 1 && visit[i] == false) {
                dfs(i);
            }
        }
    }
}
