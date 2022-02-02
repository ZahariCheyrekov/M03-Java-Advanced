package M03_JavaAdvanced.L11_Workshop_LinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addLast(9);
        System.out.println(linkedList.get(-9));
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());

        linkedList.forEach(System.out::println);

        int[] array = linkedList.toArray();

        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}