class Solution {
    boolean[] flag;
    public int countComponents(int n, int[][] edges) {
        flag = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n;i++) list.add(new ArrayList<>());
        for(int[] arr : edges){
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }
        int count = 0;
        for(int i = 0; i < n;i++){
            if(!flag[i]){
                get(list , i, n);
                count++;
            }
        }
        return count;
    }
    private void get(List<List<Integer>> list , int i, int n){
        flag[i] = true;
        int count = 0;
        for(int val : list.get(i)){
            if(flag[val]) continue;
            get(list , val , n);
        }
    }
}
