package y24.m3.d18.p4;

import java.util.*;

class Main {
    static Map<Integer, Integer> father;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        father = new HashMap<>();
        List<Node> all = new ArrayList<>();
        Set<Pair> q = new HashSet<>();
        Set<Pair> q_del = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            father.put(u, u);
            father.put(v, v);
            q.add(new Pair(u, v));
        }
        for (int i = 0; i < p; i++) {
            int op = scanner.nextInt();
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            all.add(new Node(op, u, v));
            father.put(u, u);
            father.put(v, v);
            if (op == 1) {
                q_del.add(new Pair(u, v));
            }
        }
        for (Pair e : q_del) {
            int u = e.first, v = e.second;
            if (q.contains(new Pair(u, v)) || q.contains(new Pair(v, u))) {
                q.remove(e);
            }
        }
        for (Pair e : q) {
            merge(e.first, e.second);
        }
        List<String> res = new ArrayList<>();
        for (int i = p - 1; i >= 0; i--) {
            if (all.get(i).op == 1) {
                merge(all.get(i).u, all.get(i).v);
            } else {
                if (find(all.get(i).u) == find(all.get(i).v)) {
                    res.add("Yes");
                } else {
                    res.add("No");
                }
            }
        }
        Collections.reverse(res);
        for (String s : res) {
            System.out.println(s);
        }
    }

    static int find(int x) {
        return father.get(x) == x ? x : find(father.get(x));
    }

    static void merge(int x, int y) {
        int i = find(x);
        int j = find(y);
        if (i != j) {
            father.put(i, j);
        }
    }

    static class Node {
        int op;
        int u;
        int v;

        Node(int op, int u, int v) {
            this.op = op;
            this.u = u;
            this.v = v;
        }
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Pair pair = (Pair) obj;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
