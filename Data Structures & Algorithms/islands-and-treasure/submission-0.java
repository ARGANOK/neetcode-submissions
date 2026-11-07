class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue =new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < m;j++){
                if(grid[i][j] == 0) queue.add(new int[]{i , j,0 , -1});
            }
        }
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            int time = curr[2];
            if (curr[3] != -1 && grid[i][j] != time) {
                continue;
            }
            grid[i][j] = time;
            if (i - 1 >= 0 && grid[i - 1][j] == Integer.MAX_VALUE) {
                grid[i - 1][j] = time + 1;
                queue.add(new int[]{i - 1, j, time + 1, 0});
            }
            if (i + 1 < n && grid[i + 1][j] == Integer.MAX_VALUE) {
                grid[i + 1][j] = time + 1;
                queue.add(new int[]{i + 1, j, time + 1, 0});
            }
            if (j - 1 >= 0 && grid[i][j - 1] == Integer.MAX_VALUE) {
                grid[i][j - 1] = time + 1;
                queue.add(new int[]{i, j - 1, time + 1, 0});
            }
            if (j + 1 < m && grid[i][j + 1] == Integer.MAX_VALUE) {
                grid[i][j + 1] = time + 1;
                queue.add(new int[]{i, j + 1, time + 1, 0});
            }
        }
    }
}
