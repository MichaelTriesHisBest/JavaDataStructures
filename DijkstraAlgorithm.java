package edu.belmont.csc.src.graphs;

import java.util.*;

class DijkstraAlgorithmAttempt3 {

    private static WeightedGraphite.EdgyTeen[] Field = {

            new WeightedGraphite.EdgyTeen('a', 'b', 1),
            new WeightedGraphite.EdgyTeen('a', 'c', 2),
            new WeightedGraphite.EdgyTeen('a', 'f', 3),
            new WeightedGraphite.EdgyTeen('b', 'c', 9),
            new WeightedGraphite.EdgyTeen('b', 'd', 8),
            new WeightedGraphite.EdgyTeen('c', 'd', 7),
            new WeightedGraphite.EdgyTeen('c', 'f', 6),
            new WeightedGraphite.EdgyTeen('d', 'e', 5),
            new WeightedGraphite.EdgyTeen('e', 'f', 4),
    };


    public static void main(String[] args) {

        WeightedGraphite g = new WeightedGraphite(Field);
        g.dijkstra_String();
        g.printAllPaths();
//        g.topsort(g);

    }
}

class WeightedGraphite {

    private Map<Character, Node> graph;
    private static int a = Integer.MAX_VALUE;
    static class EdgyTeen {
        Character nodular, Node;
        int gap;

        EdgyTeen(char nodular, char Node, int gap) {
            this.nodular = nodular;
            this.Node = Node;
            this.gap = gap;
        }
    }

    static class Node implements Comparable<Node> {
        Character name;
        int gap = a;
        Node prior = null;
        Map<Node, Integer> neighneighs = new HashMap<>();

        Node(char name) {
            this.name = name;
        }

        private void printPathandgap() {
            //holy cow is printf bonkers
            if (this == prior) {
                System.out.printf("%s", this.name);
            } else if (prior == null) {
                System.out.printf("%s(CANNOT BE REACHED)", this.name);
            } else {
                prior.printPathandgap();
                System.out.printf(" -> %s(%d)", this.name, this.gap);
            }
        }

        public int compareTo(Node other) {
            if (gap == other.gap)
                return name.compareTo(other.name);

            return Integer.compare(gap, other.gap);
        }

        @Override
        public String toString() {
            return "(" + name + ", " + gap + ")";
        }
    }

    WeightedGraphite(EdgyTeen[] EdgyTeens) {
        graph = new HashMap<>(EdgyTeens.length);

        for (EdgyTeen e : EdgyTeens) {
            if (!graph.containsKey(e.nodular))
                graph.put(e.nodular, new Node(e.nodular));
            if (!graph.containsKey(e.Node))
                graph.put(e.Node, new Node(e.Node));
        }


        for (EdgyTeen e : EdgyTeens) {
            //I hate maps with such a passion
            graph.get(e.nodular).neighneighs.put(graph.get(e.Node), e.gap);

        }
    }

    void dijkstra_String() {
        if (!graph.containsKey('a')) {
            System.out.printf("Graph doesn't contain start Node \"%s\"\n", "a");
            return;
        }
        Node startingNode = graph.get('a');
        NavigableSet<Node> q = new TreeSet<>();
        for (Node v : graph.values()) {
            v.prior = v == startingNode ? startingNode : null;
            v.gap = v == startingNode ? 0 : a;
            q.add(v);
        }
        dijkstra_set(q);
    }

    private void dijkstra_set(NavigableSet<Node> clobber) {
        //FIRST TIME USING NAVIGABLSET
        Node first, second;

        while (!clobber.isEmpty()) {

            first = clobber.pollFirst();
            assert first != null;
            if (first.gap == a)
                break;


            for (Map.Entry<Node, Integer> randomName : first.neighneighs.entrySet()) {
                second = randomName.getKey();

                int alternategaptoDestination = first.gap + randomName.getValue();
                if (alternategaptoDestination < second.gap) {
                    clobber.remove(second);
                    second.gap = alternategaptoDestination;
                    second.prior = first;
                    clobber.add(second);
                }
            }
        }
    }

    void printAllPaths() {
        for (Node v : graph.values()) {
            v.printPathandgap();
            System.out.println();
        }

    }

    private void visit(char v) {
        System.out.println(v);
    }

    void dfs(char v, Set<Character> visited) {
        if (visited.contains(v)) return;

        visit(v);
        visited.add(v);

//        for (char n : graph.get(v)) {
        for (int n = 0; n < graph.size(); n++)
            if (!visited.contains(n)) {
                dfs((char) n, visited);
            }
    }

    public char[] topsort(WeightedGraphite g) {
        Set<Character> visited = new HashSet<>();
        char[] beepBoop = new char[graph.size()];
        Stack<Character> uncalledStack = new Stack<>();
        for (Character v : graph.keySet()) {
            uncalledStack.push(v);
            dfs(v, visited);
        }
        for (int i = beepBoop.length; i < uncalledStack.size() - 1; i--)
            beepBoop[i] = uncalledStack.pop();
        return beepBoop;
    }
}