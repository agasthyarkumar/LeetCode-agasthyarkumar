import java.util.PriorityQueue;

class Solution {
  public double maxAverageRatio(int[][] classes, int extraStudents) {
    // store {gain, pass, total}
    PriorityQueue<Node> maxHeap = new PriorityQueue<>(
        (a, b) -> Double.compare(b.gain, a.gain));

    for (int[] c : classes) {
      maxHeap.offer(new Node(c[0], c[1]));
    }

    while (extraStudents-- > 0) {
      Node top = maxHeap.poll();
      top.pass++;
      top.total++;
      top.gain = calcGain(top.pass, top.total);
      maxHeap.offer(top);
    }

    double sum = 0.0;
    while (!maxHeap.isEmpty()) {
      Node cur = maxHeap.poll();
      sum += (double) cur.pass / cur.total;
    }

    return sum / classes.length;
  }

  private double calcGain(int pass, int total) {
    return (pass + 1.0) / (total + 1.0) - (double) pass / total;
  }

  private static class Node {
    int pass, total;
    double gain;
    Node(int p, int t) {
      this.pass = p;
      this.total = t;
      this.gain = (p + 1.0) / (t + 1.0) - (double) p / t;
    }
  }
}

