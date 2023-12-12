package Stack;
import Item.Item;
import List.*;

public class StackATD {

    private ATD S;  // стек

    // конструктор по умолчанию
    public StackATD() {

        S = new ATD();
    }

    // сделать пустым
    public void makenull() {

        S.makenull();
    }

    // вернуть копию элемента
    public Item top() {

        return new Item(S.retrieve(S.first()));
    }

    // вернуть копию элемента и удалить его в стеке
    public Item pop() {

        //S.first().print();
        if (!S.first().equal(S.end())) {
            Item copy = new Item(S.retrieve(S.first()));
            S.delete(S.first());
            return copy;
        }
        return null;
    }

    // добавить в стек
    public void push(Item item) {

        S.insert(item, S.first());
    }

    // проверка на пустоту
    public boolean empty() {

        return S.first().equal(S.end());
    }

    // проверка на заполненность
    public boolean full() {

        return false;
    }
}
