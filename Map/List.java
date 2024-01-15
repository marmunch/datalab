package Map;

import Item.Item;

public class List {

    private class Node {

        private Node next;
        private char[] key = new char[50];
        private char[] value = new char[30];

        public Node(char[] key, char[] value, Node next) {
            this.next = next;
            Item.copyArray(key, this.key);
            Item.copyArray(value, this.value);
        }
    }

    Node M;

    // конструктор
    public List() {
        M = null;
    }

    // сделать пустым
    public void makenull() {
        M = null;
    }

    // сделать ключ d равным r
    public void assign(char[] d, char[] r) {
        //System.out.println(d);
        // список пуст
        if (M == null) {
            M = new Node(d, r, null);
            return;
        }

        // изменение существующего значения ключа
        Node t = findByKey(d);
        if (t != null) {
            Item.copyArray(r, t.value);
            return;
        }

        // если ключ не найден, добавить в конец
        Node prev = findLast();
        prev.next = new Node(d, r, null);
        //System.out.println(prev.next.key);
    }

    private Node findLast() {

        Node prev = M;
        for (Node cur = M.next; cur != null; cur = cur.next) {
            prev = prev.next;
        }

        return prev;
    }

    // метод поиска
    // найти значение по ключу
    private Node findByKey(char[] key) {

        for (Node cur = M; cur != null; cur = cur.next) {
            if (Item.equalsArray(cur.key, key)) {
                return cur;
            }
        }

        return null;
    }

    // вернуть true и присвоить r d если оно определено, иначе false
    public boolean compute(char[] d, char[] r) {

        Node current = findByKey(d);

        if (current != null) {
            Item.copyArray(current.value, r);
            return true;
        }

        return false;
    }
}
