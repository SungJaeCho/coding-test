package dfs;

import java.util.Stack;

public class Dfs_002 {

    static boolean[] visited = new boolean[9];

    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    public static void main(String[] args) {
//        dfs(1);
        dfsStack(1);
    }

    static void dfs(int nodeIndex) {
        //방문처리
        visited[nodeIndex] = true;

        //방문 노드 출력
        System.out.print(nodeIndex + " -> ");

        for(int node : graph[nodeIndex]) {
            if(!visited[node]) {
                dfs(node);
            }
        }
    }

    //stack사용
    static Stack<Integer> stack = new Stack<>();

    public static void dfsStack(int nodeIndex) {

        //시작 노드 스택삽입
        stack.push(nodeIndex);
        //시작노드 방문처리
        visited[nodeIndex] = true;

        //스택이 비어있지 않으면 계속 반복
        while (!stack.isEmpty()) {

            //스택에서 하나 꺼냄
            nodeIndex = stack.pop();

            System.out.println(nodeIndex + " -> ");

            for (int LinkedNode : graph[nodeIndex]) {
                if(!visited[LinkedNode]) {
                    stack.push(LinkedNode);
                    visited[LinkedNode] = true;
                }
            }
        }

    }

}
