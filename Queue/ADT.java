package Queue;

import List.*;
import Item.Item;

public class ADT {

    ATD Q;

    public ADT() {

        Q = new ATD();
    }

    // сделать пустым
    public void makenull() {

        Q.makenull();
    }

    // вернуть первый в очереди
    public Item front() {

        return new Item(Q.retrieve(Q.first()));
    }

    // вернуть первый и удалить его из очереди
    public Item dequeue() {

        Item copy = new Item(Q.retrieve(Q.first()));
        Q.delete(Q.first());
        return copy;
    }

    // вставить в конец очереди
    public void enqueue(Item x) {

        Q.insert(x, Q.end());
    }

    // проверка на пустоту
    public boolean empty() {

        return Q.first().equal(Q.end());
    }

    // проверка на полноту
    public boolean full() {

        return false;
    }
}
