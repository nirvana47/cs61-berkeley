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
        if (B == null || A == null) {
            throw new IllegalArgumentException("One or both the IntLists are NULL");
        }
        IntList temp = new IntList(A.first, null);
        IntList ptr = temp;
        A = A.rest;
        while (A != null) {
            ptr.rest = new IntList(A.first, null);
            ptr = ptr.rest;
            A = A.rest;
        }
        while (B != null) {
            ptr.rest = new IntList(B.first, null);
            ptr = ptr.rest;
            B = B.rest;
        }

        return temp;
    }

    /**
     * Write the public static method named merge, which takes two parameters: each
     * is a reference to a sorted (in increasing order) list. This method returns a
     * reference to a new sorted list, which copies all the values from its two
     * parameter lists (which remain unchanged). Hint: use a recursive structures
     * limilar to the equalLength method described above
     */
    public static IntList recursiveCatenate(IntList A, IntList B) {
        if (A == null && B != null) {
            System.out.println("A null, B not null, calling recursiveCatenate(A, B.rest)");
            return new IntList(B.first, recursiveCatenate(A, B.rest));
        } else if (A != null && B == null) {
            System.out.println("A not null, B null, calling recursiveCatenate(A.rest, B)");
            return new IntList(A.first, recursiveCatenate(A.rest, B));
        } else if (A == null && B == null) {
            System.out.println("A null, B null, calling new IntList()");
            return null;
        } else {
            System.out.println("A not null, B not null, calling recursiveCatenate(A.rest, B)");
            return new IntList(A.first,recursiveCatenate(A.rest, B));
        }
    }

    /**
     * Examine the method below
     * 
     * public static boolean equalLength(LN l1, LN l2) {return length(l1) ==
     * length(l2);}
     * 
     * Although this method is trivial to write, it takes a long time to execute
     * when passed a very large linked list (a million node list) and a very short
     * one (a 5 node list), because it computes the length of each separately, and
     * computing the length of the large list takes much more time than computing
     * the length of the small list. Rewrite this method directly using recursion so
     * that it only traverses as much of each list as necessary to compute a result
     * (when it tries to reach the 6th node of each list -and fails for the smaller
     * list- it knows the answer. Hint: deal with the following four cases: both l1
     * and l2 are empty, l1 is empty and l2 is not empty, l1 is not empty and l2 is
     * empty, and finally both l1 and l2 are not empty; in three of four cases, an
     * answer can be returned immediately (the other requires recursion).
     */
    public static boolean equalLength(IntList A, IntList B) {
        if (A == null && B != null) {
            return false;
        } else if (A != null && B == null) {
            return false;
        } else if (A == null && B == null) {
            return true;
        } else {
            return equalLength(A.rest, B.rest);
        }
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        // L = new IntList(0, L);
        // L = new IntList(-10, L);
        // L = new IntList(-5, L);
        // L = new IntList(-15, L);
        L = new IntList(35, L);

        IntList A = new IntList(10, null);
        A = new IntList(13, A);
        A = new IntList(14, A);
        IntList B = new IntList(-10, null);
        // IntList B = null;
        B = new IntList(11, B);
        B = new IntList(-11, B);

        IntList C = recursiveCatenate(A, B);

        dSquareList(A);
        System.out.println("The C List:");
        C.printList();
        System.out.println("The A List:");
        A.printList();
        System.out.println("The B List:");
        B.printList();

        // IntList D = catenate(A, C);
        // System.out.println("The D List :");
        // D.printList();

    }
}