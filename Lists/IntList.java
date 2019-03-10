public class IntList {
	public int first;
	public IntList rest;

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

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);
		L = new IntList(0, L);
		L = new IntList(-10, L);
		L = new IntList(-5, L);
		L = new IntList(-15, L);
		L = new IntList(35, L);
		int i = 8;

		System.out.println(L.size());
		System.out.println(L.iterativeSize());
		System.out.println("The " + i + "'th value in this list is: " + L.get(i));
	}
} 