package Queue;

import Item.Item;

public class Mass {

    Item[] Q;
    int tail; // конец очереди
    int head; // начало очереди
    final int size = 10;

    public Mass() {

        tail = 0;
        head = 1;
        Q = new Item[size];
    }

    // следующая позиция
    private int getNext(int p) { return (p+1) % size; }

    // сделать пустым
    public void makenull() {

        tail = 0;
        head = 1;
    }

    // вернуть первый в очереди
    public Item front() {

        return new Item(Q[head]);
    }

    // вернуть первый и удалить его из очереди
    public Item dequeue() {
        //System.out.println(tail + " " + head);
        int newHead = head;

        if (getNext(head) == tail) {
            tail = 0;
            head = 1;
        }
        else head = getNext(head);

        return new Item(Q[newHead]);
    }

    // вставить в конец очереди
    public void enqueue(Item x) {

        if (getNext(tail + 1) == head) {
            return;
        }
        tail = getNext(tail);
        //System.out.println(tail);
        Q[tail] = new Item(x);
    }

    // проверка на пустоту
    public boolean empty() {

        return getNext(tail) == head;
    }

    // проверка на полноту
    public boolean full() {

        return getNext(tail + 1) == head;
    }
}
