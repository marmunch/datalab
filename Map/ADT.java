package Map;

import Item.Item;
import List.*;

public class ADT {

    ATD M;

    // конструктор
    public ADT() {
        M = new ATD();
    }

    // сделать пустым
    public void makenull() {
        M.makenull();
    }

    // сделать ключ d равным r
    public void assign(char[] d, char[] r) {

        //System.out.println(M.first().equal(M.end()));
        if (M.first().equal(M.end())) {
            M.insert(new Item(d, r), M.first());
            return;
        }

        Item t = findByKey(d);
        if (t != null) {
            Item.copyArray(r, t.name);
            return;
        }

        M.insert(new Item(d, r), M.end());
    }

    // найти значение по ключу
    private Item findByKey(char[] key) {
        // с первой позиции до последней, переход через next
        for (Position cur = M.first(); !cur.equal(M.end()); cur = M.next(cur)) {
            if (Item.equalsArray(M.retrieve(cur).address, key)) {

                return cur.p.item;
            }
        }

        return null;
    }

    // вернуть true и присвоить r d если оно определено, иначе false
    public boolean compute(char[] d, char[] r) {

        Item cur = this.findByKey(d);
        if (cur == null) {
            return false;
        }

        Item.copyArray(cur.name, r);
        return true;
    }
}
