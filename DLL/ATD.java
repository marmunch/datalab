package DLL;
import Item.Item;

public class ATD {

    private Node start; // начало списка
    private Node end; // конец списка

    // конструктор
    public ATD() {
        this.end = null;
        this.start = null;
    }

    // конец списка
    public Position end() {
        /*
        вернуть позицию последнего
         */

        return new Position(null);
    }

    // вставить объект в позицию
    public void insert(Item x, Position p) {

        // позиция нулевая
        if (p.p == null) {
            // список пуст
            if (start == null) {
                start = new Node(x, null, null);
                end = start;
                return;
            }
            // список не пустой - вставка после последнего
            end.next = new Node(x,null, end);
            end = end.next;
            return;
        }

        // вставка в end
        if (p.p == end) {
            end.next = new Node(end.item, null, end);
            end.item = x;
            end = end.next;
            return;
        }

        // вставка в середину - проверка на наличие позиции
        if (!checkPos(p.p)) { return; }

        p.p.next = new Node(p.p.item, p.p.next, p.p.next.next);
        p.p.item = x;
    }

    // проверка на наличие позиции
    private boolean checkPos (Node node) {

        for (Node cur = start; cur != null; cur = cur.next) {
            if (cur == node) { return true; }
        }

        return false;
    }

    // вернуть позицию по объекту
    public Position locate(Item x) {
        /*
        идем по списку с start до null
            если объект равен х по equals - вернуть позицию
        если объекта нет(цикл завершил свою работу и объект не нашел) - вернуть null
         */

        Node current = start;
        while (current != null) {
            //current.print();
            if (x.equals(current.item)) return new Position(current);
            current = current.next;
        }
        return new Position(null);
    }

    // вернуть объект в позиции
    public Item retrieve(Position p) {
        /*
         * если (p != null) идем с start
         *		если находится элемент (сверяем позицию по equals), то возвращаем его копию
         * 		элемент не найден, выбросить исключение
         * иначе выбросить исключение
         IndexOutOfBoundsException
         */

        if (checkPos(p.p) && p.p != null) {
            return new Item(p.p.item);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    // проверка существования позиции

    // удалить объект в позиции
    public void delete(Position p) {

        // позиции нет - ничего не делать
        if (p.p == null || !checkPos(p.p)) {
            //System.out.println("1");
            return;
        }

        // один элемент
        if (start == end) {
            start = null;
            end = null;
            //System.out.println("2");
            return;
        }

        // удаление головы
        if (p.p == start) {
            start = start.next;
            start.prev = null;
            //System.out.println("3");
            return;
        }

        // удаление хвоста
        if (p.p == end) {
            end = end.prev;
            end.next = null;
            //System.out.println("4");
            return;
        }

        // общий случай
        //p.p.prev.print();
        p.p.prev.next = p.p.next;
        p.p = p.p.next;
        //System.out.println("5");
    }

    // вернуть последующую позицию
    public Position next(Position p) {
        /*
         * если (p != null)
         * вернуть следующую позицию
         */
        if (!checkPos(p.p) || p.p == null) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return new Position(p.p.next);
    }

    // вернуть предыдущую позицию
    public Position previous(Position p) {
        /*
         * если (p != null)
         * вернуть предыдущую позицию
         */
        if (!checkPos(p.p) || p.p == null || p.p == start) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return new Position(p.p.prev);
    }

    // обнулить список
    public void makenull() {
        /*
        сделать start и end = null
         */
        start = null;
        end = null;
    }

    // вернуть первую позицию
    public Position first() {
        /*
        вернуть start
         */

        return new Position(start);
    }

    // вывести на экран
    public void printlist() {
        /*
        идти по списку и вывести на печать каждый узел
         */
        if (start == null && end == null) System.out.println("List is empty");
        else {
            for (Node cur = this.start; cur != null; cur = cur.next) {
                System.out.println(cur.item.toString());
            }
        }
        System.out.println();
    }

    // класс нода
    protected class Node {

        protected Item item;
        private Node next;
        private Node prev;

        // конструктор
        protected Node() {
            this.item = null;
            this.next = null;
            this.prev = null;
        }

        // конструктор по Item
        protected Node(Item item, Node next, Node prev) {
            this.next = next;
            this.prev = prev;
            this.item = new Item(item);
        }

        // копирующий конструктор
        protected Node(Node copy) {
            this.item = new Item(copy.item);
            this.next = copy.next;
            this.prev = copy.prev;
        }

        protected void print() {

            if (item != null) System.out.println(item);
            else System.out.println("Item is null");
        }

        protected boolean equals(Node node) {
            if(node != null) return this.item.equals(node.item);
            return false;
        }
    }
}
