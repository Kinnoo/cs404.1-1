package edu.berkeley.cs.graph;

import edu.berkeley.cs.util.HashSet;
import edu.berkeley.cs.util.Utilities;
import org.junit.Assert;
import org.junit.Test;

public class MinimumSpanningTree_T {
  private static final double epsilon = 0.0001;

  @Test
  public void testSmallGraph() {
    MinimumSpanningTree mst = new MinimumSpanningTree(Utilities.smallGraph());
    Assert.assertEquals(100, mst.weight(), epsilon);

    HashSet<Edge> edges = new HashSet<>();
    for (Edge edge : mst.edges()) {
      edges.add(edge);
    }

    Assert.assertTrue(edges.contains(new Edge(2, 0, 12)));
    Assert.assertTrue(edges.contains(new Edge(0, 1, 14)));
    Assert.assertTrue(edges.contains(new Edge(9, 10, 19)));
    Assert.assertTrue(edges.contains(new Edge(4, 3, 4)));
    Assert.assertTrue(edges.contains(new Edge(5, 0, 8)));
    Assert.assertTrue(edges.contains(new Edge(5, 3, 2)));
    Assert.assertTrue(edges.contains(new Edge(4, 6, 13)));
    Assert.assertTrue(edges.contains(new Edge(7, 8, 17)));
    Assert.assertTrue(edges.contains(new Edge(11, 9, 11)));
  }

  @Test
  public void testLargeGraph() {
    MinimumSpanningTree mst = new MinimumSpanningTree(Utilities.largeGraph());
    Assert.assertEquals(2140, mst.weight());

    HashSet<Edge> edges = new HashSet<>();
    for (Edge edge : mst.edges()) {
      edges.add(edge);
    }

    Assert.assertTrue(edges.contains(new Edge(13, 10, 19)));
    Assert.assertTrue(edges.contains(new Edge(43, 11, 48)));
    Assert.assertTrue(edges.contains(new Edge(45, 11, 44)));
    Assert.assertTrue(edges.contains(new Edge(12, 15, 89)));
    Assert.assertTrue(edges.contains(new Edge(13, 15, 80)));
    Assert.assertTrue(edges.contains(new Edge(27, 16, 65)));
    Assert.assertTrue(edges.contains(new Edge(4, 16, 79)));
    Assert.assertTrue(edges.contains(new Edge(23, 17, 17)));
    Assert.assertTrue(edges.contains(new Edge(23, 18, 49)));
    Assert.assertTrue(edges.contains(new Edge(20, 19, 41)));
    Assert.assertTrue(edges.contains(new Edge(21, 19, 25)));
    Assert.assertTrue(edges.contains(new Edge(25, 19, 22)));
    Assert.assertTrue(edges.contains(new Edge(13, 20, 86)));
    Assert.assertTrue(edges.contains(new Edge(14, 20, 109)));
    Assert.assertTrue(edges.contains(new Edge(25, 24, 30)));
    Assert.assertTrue(edges.contains(new Edge(26, 25, 33)));
    Assert.assertTrue(edges.contains(new Edge(42, 27, 46)));
    Assert.assertTrue(edges.contains(new Edge(17, 28, 53)));
    Assert.assertTrue(edges.contains(new Edge(22, 28, 128)));
    Assert.assertTrue(edges.contains(new Edge(27, 28, 32)));
    Assert.assertTrue(edges.contains(new Edge(23, 29, 38)));
    Assert.assertTrue(edges.contains(new Edge(21, 3, 40)));
    Assert.assertTrue(edges.contains(new Edge(36, 30, 84)));
    Assert.assertTrue(edges.contains(new Edge(32, 18, 45)));
    Assert.assertTrue(edges.contains(new Edge(49, 33, 42)));
    Assert.assertTrue(edges.contains(new Edge(42, 34, 62)));
    Assert.assertTrue(edges.contains(new Edge(35, 34, 20)));
    Assert.assertTrue(edges.contains(new Edge(40, 35, 57)));
    Assert.assertTrue(edges.contains(new Edge(39, 37, 12)));
    Assert.assertTrue(edges.contains(new Edge(26, 38, 36)));
    Assert.assertTrue(edges.contains(new Edge(38, 31, 3)));
    Assert.assertTrue(edges.contains(new Edge(38, 37, 10)));
    Assert.assertTrue(edges.contains(new Edge(39, 36, 4)));
    Assert.assertTrue(edges.contains(new Edge(1, 4, 110)));
    Assert.assertTrue(edges.contains(new Edge(5, 4, 26)));
    Assert.assertTrue(edges.contains(new Edge(40, 39, 14)));
    Assert.assertTrue(edges.contains(new Edge(41, 40, 18)));
    Assert.assertTrue(edges.contains(new Edge(43, 41, 43)));
    Assert.assertTrue(edges.contains(new Edge(47, 43, 24)));
    Assert.assertTrue(edges.contains(new Edge(47, 44, 8)));
    Assert.assertTrue(edges.contains(new Edge(46, 45, 64)));
    Assert.assertTrue(edges.contains(new Edge(48, 46, 58)));
    Assert.assertTrue(edges.contains(new Edge(49, 48, 61)));
    Assert.assertTrue(edges.contains(new Edge(6, 1, 1)));
    Assert.assertTrue(edges.contains(new Edge(9, 6, 21)));
    Assert.assertTrue(edges.contains(new Edge(4, 7, 13)));
    Assert.assertTrue(edges.contains(new Edge(8, 3, 5)));
    Assert.assertTrue(edges.contains(new Edge(0, 9, 11)));
    Assert.assertTrue(edges.contains(new Edge(2, 9, 115)));
  }
}
