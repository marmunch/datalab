package Tree.Cursor;

public class Item {

    public int leftChild;
    public int rightSibling;
    public String str;

    public Item(int rightSibling, int leftChild, String str) {

        this.leftChild = leftChild;
        this.rightSibling = rightSibling;
        this.str = str;
    }
}
