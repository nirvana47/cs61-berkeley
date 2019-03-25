public class SLList {

    private IntNode sentinel;
    private int size;

    private static class IntNode {
        int item;
        IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    public SLList(int x) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, sentinel.next);
        size = 1;
    }

    public SLList() {
        sentinel = new IntNode(0, null);
        size = 0;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        // first = new IntNode(x, first);
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        IntNode temp = sentinel;
        size += 1;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new IntNode(x, null);
    }

    public int size() {
        return size;
    }

    public void deleteFirst() {
        if (size == 0) {
            System.out.println("No items in the list to delete");
        } else if (size == 1) {
            sentinel.next = null;
            size -= 1;
        } else {
            sentinel.next = sentinel.next.next;
            size -= 1;
        }

    }

    public static void main(String[] args) {
        SLList L1 = new SLList();
        L1.addFirst(15);
        // L1.addFirst(5);
        L1.addLast(10);

        L1.deleteFirst();

        System.out.println(L1.getFirst());
        System.out.println(L1.size());
    }
}