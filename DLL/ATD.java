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
        /*
        если в list 1 элемент
            в start.next привязать новый нод
            end = start.next
            end.prev = start
        если позиция null
            если вставка в пустой list
                создать нод в start
                start = end
            вставка в конец
                привязать к end нод, переопределить end
                переопределить prev
        если вставка в start
            создать нод и вставить его в start
            в start.next = старый start
        вставка в середину
            найти нод по позиции
            привязать нод между предыдущим у current и current
         */

        // вставка в голову либо вставка в конец
        if (end == start) { // в list 1 элемент
            if (p == null || p.p == null) {
                end = new Node(x);
                start.next = end;
                end.prev = start;
                //System.out.println('1');
            }
            else { // поменять тут на вставку в голову
                end = new Node(x);
                start.next = end;
                end.prev = start;
                //System.out.println('2');
            }
        }
        else if (p == null || p.p == null) {  // вставка в end
            if (start == null || end == null) { // list пуст
                start = new Node(x);
                end = start;
                //System.out.println('3');
            }
            else {
                Node node = new Node(x);
                end.next = node;
                node.prev = end;
                end = end.next;
                //System.out.println('4');
            }
        }
        else if (start == p.p) { //start = p.p
            Node node = new Node(x);
            start.prev = node;
            node.next = start;
            start = start.prev;
            //start.print();
            //start.next.print();
            //System.out.println('5');
        }
        else {// вставка в голову и это - общий случай
            Node cur = findNode(start, p.p);
            Node prev = cur.prev;
            //p.p.print();
            //prev.print();
            //cur.print();
            if(cur.item.equals(p.p.item)) {
                prev.next = new Node(x);
                //prev.print();
                prev = prev.next;
                //prev.print();
                prev.next = cur;
                //prev.next.print();
                prev.prev = cur.prev;
                cur.prev = prev;
                //prev.prev.print();
                //System.out.println('6');
            }
            //System.out.println('7');
        }
    }

    // находить последний нод
    private Node findNode(Node current, Node tofind) {

        while(current != null && !current.equals(tofind)) {
            current = current.next;
        }
        return current;
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

        if (p != null) {
            Node current = start;
            while(current != null) {
                if (current.equals(p.p)) return new Item(current.item);
                current = current.next;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    // проверка существования позиции

    // удалить объект в позиции
    public void delete(Position p) {
        /*
         * если удаляем start (p.equals(start)):
         * 		ставим this.start = start.next;
         * если удаляем end (p.equals(end)):
         * 		ставим this.end = end.prev;
         * иначе если середину или конец (p != null) идем по списку
         *		если находится элемент (сверяем позицию по equals),
         *          привязываем предыдущий к последующему от данного элемента,
         *          меняем Position на последующий
         * 		элемент не найден - ничего не делать
         * иначе ничего не делать
         */

        if (p.p == start) {
            start = start.next;
            start.prev = null;
            //System.out.println('1');
        }
        else if (p.p == end) {
            end = end.prev;
            end.next = null;
            //System.out.println('2');
        }
        else {
            Node current = start.next;
            //current.print();
            Node time = start;
            //time.print();
            //p.p.print();
            while (current != null) {
                //System.out.println(p.p == current);
                //current.print();
                if (p.p == current) {
                    time.next = current.next;
                    current = current.next;
                    if(current != null) current.prev = time;
                    break;
                }
                time = time.next;
                current = current.next;
            }
            //System.out.println('3');
        }
        //System.out.println('4');
    }

    // вернуть последующую позицию
    public Position next(Position p) {
        /*
         * если (p != null)
         * вернуть следующую позицию
         */
        if(p != null) return new Position(p.p.next);
        else return new Position(null);
    }

    // вернуть предыдущую позицию
    public Position previous(Position p) {
        /*
         * если (p != null)
         * вернуть предыдущую позицию
         */
        if(p != null) return new Position(p.p.prev);
        else return new Position(null);
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

        if(start != null)
            return new Position(start);
        else return new Position(null);
    }

    // вывести на экран
    public void printlist() {
        /*
        идти по списку и вывести на печать каждый узел
         */
        if (start == null && end == null) System.out.println("List is empty");
        else {
            Node current = start;
            while (current != null) {
                System.out.println(current.item.toString());
                current = current.next;
            }
        }
        /*else {
            Node current = end;
            while (current != null) {
                System.out.println(current.item.toString());
                current = current.prev;
            }
        }*/
        System.out.println();
    }

    // класс нода
    protected class Node {

        protected Item item;
        private Node next;
        private Node prev;

        // конструктор
        protected Node() {
            this.next = null;
            this.prev = null;
        }

        // конструктор по Item
        protected Node(Item item) {
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
