package Matrix;

public class IslandPerimeter463 {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        System.out.println(solution(grid));
    }

    public static int solution (int[][] grid) {
        int island = 0;
        int neighbors = 0;

        for(int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    island++;
                    if(i -1 >=0 && grid[i-1][j] == 1) { //위를 바라봄
                        neighbors++;
                    }
                    if(j -1 >= 0 && grid[i][j-1] == 1) { //좌측을 바라봄
                        neighbors++;
                    }
                }
            }
        }
        return island * 4 - neighbors * 2;

    }
}
