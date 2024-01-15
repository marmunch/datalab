package Tree.List;

public class Item {

    public Son son;
    public String str;
    public int next;

    // конструктор
    public Item(int next, String str) {

        this.str = str;
        this.next = next;
    }
}
