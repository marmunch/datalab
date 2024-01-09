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

        Node end = findPrev(null);
        Item copy = new Item(end.item);
        Node preend = findPrev(end);
        preend.next = null;
        return copy;
    }

    // добавить в стек
    public void push(Item item) {

        if (S == null) {
            S = new Node(item);
        }
        else {
            Node end = findPrev(null);
            end.next = new Node(item);
        }
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
        protected Node(Item item) {
            this.item = new Item(item);
        }

        // печать
        protected void print() {

            if (item != null) System.out.println(item);
            else System.out.println("Item is null");
        }

    }
}
