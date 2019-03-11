public class Lists1Exercises {

    /**
     * Returns an IntList identical to L, but with each element incremented by x. L
     * is not allowed to change.
     */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        // System.out.println(L.first + " " + x);
        // IntList Q = new IntList(L.first+x, null);
        int size = L.size();

        return L;
    }

    /**
     * Returns an IntList identical to L, but with each element incremented by x.
     * Not allowed to use the 'new' keyword.
     */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        return L;
    }

    public void printList() {
        // Your code here
        if (this.rest == null) {
            System.out.println(this.first);
            return;
        }
        this.rest.printList();
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);
        // L = new IntList(11,L);

        // System.out.println(L.size());

        // L.printList();

        // System.out.println(L.iterativeSize());
        System.out.println(L);

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        // System.out.println(L.get(1));
        // System.out.println(incrList(L, 3));
        // System.out.println(dincrList(L, 3));
    }
}