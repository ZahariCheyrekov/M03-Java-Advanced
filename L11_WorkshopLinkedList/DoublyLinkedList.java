package M03_JavaAdvanced.L11_Workshop_LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;

        } else {
            newNode.next = head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int value) {
        if (isEmpty()) {
            addFirst(value);

        } else {
            Node newNode = new Node(value);
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
            this.size++;
        }
    }

    public int get(int index) {
        int result;
        checkValidIndex(index);
        Node currentNode;
        if (index <= this.size / 2) {
            currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }

        } else {
            currentNode = this.tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        result = currentNode.currentValue;
        return result;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Error while remove element from empty list!");

        } else if (this.size == 1) {
            int removedElement = this.head.currentValue;
            this.head = this.tail = null;
            this.size--;
            return removedElement;

        } else {
            int removedElement = this.head.currentValue;
            this.head = this.head.next;
            this.head.prev = null;
            this.size--;
            return removedElement;
        }
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Error while remove element from empty list!");

        } else if (this.size == 1) {
            int removedElement = this.head.currentValue;
            this.head = this.tail = null;
            this.size--;
            return removedElement;

        } else {
            int removedElement = this.tail.currentValue;
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.size--;
            return removedElement;
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.currentValue);
            currentNode = currentNode.next;
        }
    }

    private void checkValidIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("The index " + index + " is out of bounds!");
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int[] toArray() {
        List<Integer> resultList = new ArrayList<>();
        forEach(resultList::add);

        return resultList.stream().mapToInt(e -> e).toArray();
    }
}
