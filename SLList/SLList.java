public class SLList {

    private IntNode first;

    private static class IntNode {
        int item;
        IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public int getFirst() {
        return first.item;
    }

    public void addLast(int x) {
        IntNode temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new IntNode(x, null);
    }

    private static int size(IntNode n) {
        if (n.next == null) {
            return 1;
        }
        return 1 + size(n.next);
    }

    public int size() {
        return size(first);
    }

    public static void main(String[] args) {
        SLList L1 = new SLList(25);
        L1.addFirst(15);
        L1.addFirst(5);
        L1.addLast(10);

        System.out.println(L1.getFirst());
        System.out.println(L1.size());
    }
}