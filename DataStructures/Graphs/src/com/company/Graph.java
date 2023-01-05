package com.company;

import java.util.*;

public class Graph {
    private class Node {
        String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    Map<String, Node> nodes = new HashMap<>();
    Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.put(node, new ArrayList<>());
    }

    public void removeNode(String label) {
        var removedNode = nodes.get(label);
        nodes.remove("label");
        adjacencyList.remove(removedNode);
        for (Node i : adjacencyList.keySet())
            adjacencyList.get(i).remove(removedNode);
    }

    public void addEdge(String from, String to) {
        adjacencyList.get(nodes.get(from)).add(nodes.get(to));
    }

    public void removeEdge(String from, String to) {
        adjacencyList.get(nodes.get(from)).remove(nodes.get(to));
    }

    public void print() {
        for (Node i : adjacencyList.keySet())
            if (!adjacencyList.get(i).isEmpty())
                System.out.println(i + " is connected with " + adjacencyList.get(i));
    }

    public void DFS(String starting) {
        Node x = nodes.get(starting);
        Set<Node> visited = new HashSet<>();
        DFSs(x, visited);

        // delete the following if you dont want all the graph to be traversed
        for (Node i : nodes.values())
            if (!visited.contains(i))
                DFSs(i, visited);

    }

    private void DFSs(Node x, Set<Node> visited) {
        System.out.println(x);
        visited.add(x);
        for (Node i : adjacencyList.get(x))
            if (!visited.contains(i))
                DFSs(i, visited);
    }

    public void BFS(String starting) {
        var node = nodes.get(starting);
        LinkedList<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        System.out.println(node);
        visited.add(node);
        do {
            for (Node i : adjacencyList.get(node)) {
                if (!visited.contains(i)) {
                    q.addFirst(i);
                    visited.add(i);
                    System.out.println(i);
                }
            }
            node = q.removeLast();
        } while (!q.isEmpty());
    }

    public String[] topologicalDFS() {
        Stack<Node> s = new Stack<>();
        for (Node i : nodes.values())
            if (!s.contains(i))
                tDFS(i, s);
        String[] x = new String[nodes.values().size()];
        int i = 0;
        while (!s.isEmpty())
            x[i++] = s.pop().label;
        return x;
    }

    public void tDFS(Node node, Stack<Node> s) {
        for (Node i : adjacencyList.get(node))
            if (!s.contains(i)) {
                tDFS(i, s);
            }
        s.push(node);
    }

    public String[] topologicalSR() {
        List<Node> notSource = new ArrayList<>();
        List<Node> allNodes = new ArrayList<>(adjacencyList.keySet());
        String[] x = new String[allNodes.size()];
        int index = 0;

        for (List<Node> i : adjacencyList.values())
            notSource.addAll(i);

        while (!allNodes.isEmpty()) {
            ArrayList<Node> toBeDeleted = new ArrayList<>();
            for (Node i : allNodes)
                if (!notSource.contains(i)) {
                    toBeDeleted.add(i);
                    x[index++] = i.label;
                    for (Node j : adjacencyList.get(i))
                        notSource.remove(j);
                }
            for (Node i : toBeDeleted)
                allNodes.remove(i);
        }
        return x;

    }

    public boolean isAcyclic() {
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        boolean x = true;
        for (Node i : nodes.values()) {
            if (visited.contains(i) || visiting.contains(i))
                continue;
            if (!isAcyclic(i, visiting, visited))
                return false;
        }
        return true;
    }

    private boolean isAcyclic(Node p, Set<Node> visiting, Set<Node> visited) {
        visiting.add(p);
        for (Node i : adjacencyList.get(p)) {
            if (visited.contains(i))
                continue;

            if (visiting.contains(i))
                return false;

            if (!isAcyclic(i, visiting, visited))
                return false;
        }
        visiting.remove(p);
        visited.add(p);
        return true;
    }

}
