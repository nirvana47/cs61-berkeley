public class SLList{

    IntNode first;

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
        SLList L1 = new SLList(10);
        L1.addFirst(15);
        L1.addFirst(25);

        System.out.println(L1.getFirst());
    }
}