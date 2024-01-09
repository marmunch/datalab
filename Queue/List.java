package Queue;

import Item.Item;

public class List {

    private Node tail;

    // класс нода
    private class Node {

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

    public List() {

        tail = null;
    }

    // сделать пустым
    public void makenull() {

        tail = null;
    }

    // вернуть первый в очереди
    public Item front() {

        return new Item(tail.item);
    }

    // вернуть первый и удалить его из очереди
    public Item dequeue() {

        Item copy = new Item(tail.item);
        tail = tail.next;
        return copy;
    }

    private Node findPrev(Node find) {

        Node current = tail.next;
        Node prev = tail;
        while (current != find) {
            current = current.next;
            prev = prev.next;
        }
        return prev;
    }

    private Node findLast() {

        Node curprev = tail;
        Node current = tail.next;
        while(current != null) {
            current = current.next;
            curprev = curprev.next;
        }
        return curprev;
    }

    // вставить в конец очереди
    public void enqueue(Item x) {

        if (tail == null) {
            tail = new Node(x);
            return;
        }
        Node last = findLast();
        last.next = new Node(x);
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
