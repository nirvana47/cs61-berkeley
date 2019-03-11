public class IntList {
	public int first;
	public IntList rest;

	/** Constructor which accepts node value
	  * and next node address. */
	public IntList(int f, IntList r) {
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
		IntList p = this;
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
	
	/** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
		int listSize = L.size();
		IntList M = new IntList(L.get(listSize)+x,null);
		
		for(int i=1; i<listSize; i+=1){
			// code here
			M = new IntList(L.get(listSize-i)+x,M);
		}

		return M;        
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
		int listSize = L.size();
		
		while(listSize > 0){
			L.first = L.first + x;
			L = L.rest;
			listSize -= 1;
		}

        return L;
    }

	/** Prints an IntList from start to finish */
	public void printList(){
		int listSize = this.size();
		
		for(int i=1; i<=listSize; i+=1){
			System.out.println(i + " --> " + this.get(i));
		}
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
        System.out.println(dincrList(L, 3));
	}
} 