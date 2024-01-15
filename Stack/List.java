package Stack;
import Item.Item;
import List.ATD;

public class List {

    private Node S;  // стек (голова списка)

    // конструктор по умолчанию
    public List() {

        S = null;
    }

    // сделать пустым
    public void makenull() {

        S = null;
    }

    private Node findPrev(Node find) {

        Node current = S.next;
        Node prev = S;
        while (current != null && current != find) {
            current = current.next;
            prev = prev.next;
        }
        return prev;
    }

    // вернуть копию элемента
    public Item top() {

        return new Item(findPrev(null).item);
    }

    // вернуть копию элемента и удалить его в стеке
    public Item pop() {
        // вставлять в голову, снимать с головы

        Item result = new Item(S.item);
        S = S.next;
        return result;
    }

    // добавить в стек
    public void push(Item item) {

        Node next = S;
        S = new Node(new Item(item), next);
    }

    // проверка на пустоту
    public boolean empty() {

        return S == null;
    }

    // проверка на заполненность
    public boolean full() {

        return false;
    }

    // класс нода
    protected class Node {

        protected Item item; // объект
        private Node next; // ссылка на следующий

        // конструктор
        protected Node() {
            this.next = null;
        }

        // конструктор по Item
        protected Node(Item item, Node next) {

            this.item = new Item(item);
            this.next = next;
        }

        // печать
        protected void print() {

            if (item != null) System.out.println(item);
            else System.out.println("Item is null");
        }

    }
}
