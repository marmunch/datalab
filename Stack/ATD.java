package Stack;
import Item.Item;

public class Mass {

    private Item[] S;  // стек
    private int last;  // последний занятый
    private final int size = 10;

    // конструктор по умолчанию
    public Mass() {

        S = new Item[size];
        last = -1;
    }

    // сделать пустым
    public void makenull() {

        last = -1;
    }

    // вернуть копию элемента
    public Item top() {

        if (last < size && last >= 0)
            return new Item(S[last]);
        return null;
    }

    // вернуть копию элемента и удалить его в стеке
    public Item pop() {

        last--;
        return new Item(S[last+1]);
    }

    // добавить в стек
    public void push(Item item) {

        if (last < size-1)
            S[++last] = new Item(item);
        else System.out.println("Stack is FULL!");
    }

    // проверка на пустоту
    public boolean empty() {

        return last < 0;
    }

    // проверка на заполненность
    public boolean full() {

        return last == size-1;
    }
}
