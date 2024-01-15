package Stack;

import Item.Item;
import List.*;

public class ADT {

    private ATD S;  // стек

    // конструктор по умолчанию
    public ADT() {

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
        Item result = new Item(S.retrieve(S.first()));
        S.delete(S.first());

        return result;
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
