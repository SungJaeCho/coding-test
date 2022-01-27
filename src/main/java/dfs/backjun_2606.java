package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjun_2606 {

    static int N, M, result;
    static boolean[][] conn; //컴퓨터간의 연결
    static boolean[] visited; //방문을 체크하기 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        conn = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 1; M >= i; ++i) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            conn[first][second] = true;
            conn[second][first] = true;
        }
        dfs(1);
        System.out.println(Arrays.toString(conn));
    }

    static void dfs(int start) {
        visited[start] = true; //방문 처리
        for(int i = 1; N >= i; ++i) { //모든 컴퓨터를 돌면서
            //연결된 컴퓨터이면서 방문하지 않은 컴퓨터를 확인
            if(conn[start][i] == true && visited[i] == false) {
                result++;
                dfs(i);
            }
        }
    }
}
