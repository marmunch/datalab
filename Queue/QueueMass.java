package Queue;
import Item.Item;

public class QueueMass {

    Item[] Q;
    int tail; // конец очереди
    final int size = 10;

    public QueueMass() {

        tail = -1;
        Q = new Item[size];
    }

    // сделать пустым
    public void makenull() {

        tail = -1;
    }

    // вернуть первый в очереди
    public Item front() {

        return new Item(Q[0]);
    }

    // вернуть первый и удалить его из очереди
    public Item dequeue() {

        Item copy = new Item(Q[0]);
        moveLeft();
        return copy;
    }

    // сдвинуть влево
    private void moveLeft() {

        for (int i = 0; i < tail; i++) {
            Q[i] = Q[i+1];
        }
    }

    // вставить в конец очереди
    public void enqueue(Item x) {

        if (tail < size-1) {
            Q[++tail] = x;
        }
    }

    // проверка на пустоту
    public boolean empty() {

        return tail < 0;
    }

    // проверка на полноту
    public boolean full() {

        return tail == size-1;
    }
}
