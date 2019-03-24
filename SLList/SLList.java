public class SLList{

    private IntNode first;

    private class IntNode{
        int item;
        IntNode next;
    
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    public SLList(int x){
        first = new IntNode(x, null);
    }

    public void addFirst(int x){
        first = new IntNode(x,first);
    }

    public int getFirst(){
        return first.item;
    }

    public static void main(String[] args) {
        SLList L1 = new SLList(25);
        L1.addFirst(15);
        L1.addFirst(5);

        System.out.println(L1.getFirst());
    }
}