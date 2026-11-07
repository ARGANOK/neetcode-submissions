class Solution {
    public String foreignDictionary(String[] words) {
        int n = words.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        } 
        int[] indegree = new int[26];
        boolean[] exists = new boolean[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                exists[ch - 'a'] = true;
            }
        }
        for (int i = 0; i < words.length - 1; i++) {

            String s1 = words[i];
            String s2 = words[i + 1];

            int len = Math.min(s1.length(), s2.length());

            int j = 0;

            while (j < len && s1.charAt(j) == s2.charAt(j)) {
                j++;
            }
                if (j == len) {
                    if (s1.length() > s2.length()) return "";
                    continue;
                }

                int u = s1.charAt(j) - 'a';
                int v = s2.charAt(j) - 'a';

                if (!adj.get(u).contains(v)) {
                    adj.get(u).add(v);
                    indegree[v]++;
                }
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (exists[i] && indegree[i] == 0) {
                q.offer(i);
            }
        }
        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {

            int curr = q.poll();
            ans.append((char)(curr + 'a'));

            for (int adjNode : adj.get(curr)) {

                indegree[adjNode]--;

                if (indegree[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }
        int totalCharacters = 0;
        for(boolean val : exists) if(val) totalCharacters++;
        if (ans.length() == totalCharacters) {
            return ans.toString();
        }

        return "";
    }
}
