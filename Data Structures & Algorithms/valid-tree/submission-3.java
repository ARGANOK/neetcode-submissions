class Solution {
    boolean[] flag;
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length) return false;
        List<List<Integer>> list = new ArrayList<>();
        flag = new boolean[n];
        for(int i = 0; i < n;i++)list.add(new ArrayList<>());
        for(int[] arr : edges) {
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }
        if(get(0 , n , list , flag, -1)) return false;
        for(boolean f : flag){
            if(!f) return false;
        }
        return true;
    }
    private boolean get(int node , int n , List<List<Integer>> list, boolean[] flag, int parent){
        flag[node] = true;
        for(int val : list.get(node)){
            if(val == parent) continue;
            if(flag[val]) return true;
            if(get(val , n , list , flag , node)) return true;
        }
        return false;
    }
}
