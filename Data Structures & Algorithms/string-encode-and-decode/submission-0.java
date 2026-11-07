class Solution {
    int[] arr;
    public String encode(List<String> strs) {
        arr = new int[strs.size()];
        String s = "";
        for(int i = 0; i < strs.size();i++){
            arr[i] = strs.get(i).length();
            s += strs.get(i);
        }
        return s;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < arr.length;i++){
            int x = arr[i];
            String s = "";
            while(x-- > 0) s += str.charAt(j++);
            list.add(s);
        }
        return list;
    }
}
