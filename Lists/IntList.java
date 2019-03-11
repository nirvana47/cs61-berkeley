public class IntList {
    /**
     * First element of list.
     */
    public int first;
    /**
     * Remaining elements of list.
     */
    public IntList rest;

    /**
     * A List with first FIRST0 and rest REST0.
     */
    public IntList(int first0, IntList rest0) {
        first = first0;
        rest = rest0;
    }

    /**
     * A List with null rest, and first = 0.
     */
    public IntList() {
        /* NOTE: public IntList () { } would also work. */
        this(0, null);
    }

    /** Return the size of the list using... recursion! */
    public int size() {
        if (this.rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int size = 0;
        while (p != null) {
            size += 1;
            p = p.rest;
        }
        return size;
    }

    /** Returns the ith value in this list. */
    public int get(int i) {
        if (i == 1) {
            return first;
        }
        return this.rest.get(i - 1);
    }

    /**
     * Returns an IntList identical to L, but with each element incremented by x. L
     * is not allowed to change.
     */
    public static IntList incrList(IntList L, int x) {
        int listSize = L.size();
        IntList M = new IntList(L.get(listSize) + x, null);

        for (int i = 1; i < listSize; i += 1) {
            // code here
            M = new IntList(L.get(listSize - i) + x, M);
        }

        return M;
    }

    /**
     * Returns an IntList identical to L, but with each element incremented by x.
     * Not allowed to use the 'new' keyword.
     */
    public static IntList dincrList(IntList L, int x) {
        int listSize = L.size();

        while (listSize > 0) {
            L.first = L.first + x;
            L = L.rest;
            listSize -= 1;
        }

        return L;
    }

    /** Prints an IntList from start to finish */
    public void printList() {
        int listSize = this.size();

        for (int i = 1; i <= listSize; i += 1) {
            System.out.println(i + " --> " + this.get(i));
        }
    }

    /**
     * Returns a list equal to L with all elements squared. Destructive.
     */
    public static void dSquareList(IntList L) {

        while (L != null) {
            L.first = L.first * L.first;
            L = L.rest;
        }
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     */
    public static IntList squareListIterative(IntList L) {
        if (L == null) {
            return null;
        }
        IntList res = new IntList(L.first * L.first, null);
        IntList ptr = res;
        L = L.rest;
        while (L != null) {
            ptr.rest = new IntList(L.first * L.first, null);
            L = L.rest;
            ptr = ptr.rest;
        }
        return res;
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     */
    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        return new IntList(L.first * L.first, squareListRecursive(L.rest));
    }

    /** DO NOT MODIFY ANYTHING ABOVE THIS LINE! */

    /**
     * Returns a list consisting of the elements of A followed by the * elements of
     * B. May modify items of A. Don't use 'new'.
     */

    public static IntList dcatenate(IntList A, IntList B) {
        // TODO: fill in method
        return null;
    }

    /**
     * Returns a list consisting of the elements of A followed by the * elements of
     * B. May NOT modify items of A. Use 'new'.
     */
    public static IntList catenate(IntList A, IntList B) {
        // TODO: fill in method
        return null;
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(0, L);
        L = new IntList(-10, L);
        L = new IntList(-5, L);
        L = new IntList(-15, L);
        L = new IntList(35, L);
        int i = 3;

        // L.printList();

        // dSquareList(L);
        IntList M = squareListRecursive(L);

        System.out.println("Squared M List:");
        M.printList();

        System.out.println("Original L List:");
        L.printList();

        // incrList(L,i);
        // System.out.println("Increment List method called");
        // L.printList();

        // System.out.println(L.size());
        // System.out.println(L.iterativeSize());
        // L.printList();
        // System.out.println("The " + i + "'th value in this list is: " + L.get(i));

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        // System.out.println(L.get(1));
        // System.out.println(incrList(L, 3));
        // System.out.println(dincrList(L, 3));
    }
}