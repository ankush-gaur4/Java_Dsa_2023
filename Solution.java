<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Adjacency list
        List<List<Pair<Integer, Double>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Pair<>(v, p));
            adj.get(v).add(new Pair<>(u, p));
        }

        // Distances array
        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);
        dist[start] = 1.0;

        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Pair<Integer, Double> pair : adj.get(curr)) {
                int node = pair.getKey();
                double prob = pair.getValue();
                double newProb = dist[curr] * prob;

                if (newProb > dist[node]) {
                    dist[node] = newProb;
                    queue.offer(node);
                }
            }
        }

        return dist[end];
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
=======

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n  = s2.length(), l = s3.length();
        if (m + n !=l) return false;

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int j = 1; j <=n; ++j) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; ++i) {
            dp[0] = dp[0] && s1.charAt(i- 1) == s3.charAt(i- 1);
            for (int  j = 1; j <= n; ++j) {
                dp[j] = (dp[j] && s1.charAt(i- 1 )== s3.charAt( i + j -1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[n];
    }
}
>>>>>>> repo1/master
