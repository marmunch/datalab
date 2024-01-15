package Queue;

import Item.Item;

public class List {

    private Node tail;

    // класс нода
    private class Node {

        protected Item item; // объект
        private Node next; // ссылка на следующий

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

    public List() {

        tail = null;
    }

    // сделать пустым
    public void makenull() {

        tail = null;
    }

    // вернуть первый в очереди
    public Item front() {

        // вернуть голову
        return new Item(tail.next.item);
    }

    // вернуть первый и удалить его из очереди
    public Item dequeue() {

        // один объект в списке
        if (tail == tail.next) {
            Item headItem = tail.item;
            tail = null;
            return new Item(headItem);
        }
        // общий случай
        Node head = tail.next;
        tail.next = head.next;

        return new Item(head.item);
    }

    // вставить в конец очереди
    public void enqueue(Item x) {

        // вставка в пустой список
        if (tail == null) {
            tail = new Node(x, null);
            tail.next = tail;
            return;
        }
        // общий случай
        Node head = tail.next;
        tail.next = new Node(x, head);
        tail = tail.next;
    }

    // проверка на пустоту
    public boolean empty() {

        return tail == null;
    }

    // проверка на полноту
    public boolean full() {

        return false;
    }
}
