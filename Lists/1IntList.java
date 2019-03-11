public class IntList1 {
	public int first;
	public IntList1 rest;

	/** Constructor which accepts node value
	  * and next node address. */
	public IntList1(int f, IntList1 r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if(this.rest == null){
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList1 p = this;
		int size = 0;
		while(p!= null){
			size += 1;
			p = p.rest;
		}
		return size;
	}

	/** Returns the ith value in this list.*/
	public int get(int i) {
		if(i==1){
			return first;
		}
		return this.rest.get(i-1);
	}
	
	/** Returns an IntList1 identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList1 incrList(IntList1 L, int x) {
		int listSize = L.size();
		IntList1 M = new IntList1(L.get(listSize)+x,null);
		
		for(int i=1; i<listSize; i+=1){
			// code here
			M = new IntList1(L.get(listSize-i)+x,M);
		}

		return M;        
    }

    /** Returns an IntList1 identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList1 dincrList(IntList1 L, int x) {
		int listSize = L.size();
		
		while(listSize > 0){
			L.first = L.first + x;
			L = L.rest;
			listSize -= 1;
		}

        return L;
    }

	/** Prints an IntList1 from start to finish */
	public void printList(){
		int listSize = this.size();
		
		for(int i=1; i<=listSize; i+=1){
			System.out.println(i + " --> " + this.get(i));
		}
	}

	public static void main(String[] args) {
		IntList1 L = new IntList1(15, null);
		L = new IntList1(10, L);
		L = new IntList1(5, L);
		L = new IntList1(0, L);
		L = new IntList1(-10, L);
		L = new IntList1(-5, L);
		L = new IntList1(-15, L);
		L = new IntList1(35, L);
		int i = 3;

		// incrList(L,i);
		// System.out.println("Increment List method called");
		// L.printList();

		// System.out.println(L.size());
		// System.out.println(L.iterativeSize());
		// L.printList();
		// System.out.println("The " + i + "'th value in this list is: " + L.get(i));
		
        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList1.java and
        // run it in the visualizer.
        // System.out.println(L.get(1));
        // System.out.println(incrList(L, 3));
        System.out.println(dincrList(L, 3));
	}
} 