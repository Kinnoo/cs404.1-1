package edu.berkeley.cs.graph;

import edu.berkeley.cs.util.Utilities;
import org.junit.Assert;
import org.junit.Test;

public class Cycle_T {
  private DirectedGraph graph;

  @Test
  public void testHasCycle() {
    graph = Utilities.smallCyclicGraph();
    Cycle finder = new Cycle(graph);
    Assert.assertTrue(finder.hasCycle());
  }

  @Test
  public void testHasNoCycle() {
    graph = Utilities.smallAcyclicGraph();
    Cycle finder = new Cycle(graph);
    Assert.assertFalse(finder.hasCycle());
  }
}
