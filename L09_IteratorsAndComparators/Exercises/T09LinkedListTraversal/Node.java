package M03_JavaAdvanced.L09_IteratorsAndComparators.Exercises.T09LinkedListTraversal;

public class Node {
    Node prev;
    Node next;
    Integer value;

    public Node(int value) {
        this.next = null;
        this.prev = null;
        this.value = value;
    }
}