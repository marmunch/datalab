package List;
import Item.Item;

public class ATD {

    private Node head; // голова списка

    // конструктор
    public ATD() {
        this.head = null;
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
         * если позиция вставки head или список null (p == head || head == null):
         *  	создать нод head;
         *  	привязать к новой head старую (если head == null)
         * если вставка в середину (p != null):
         * 		в цикле дойти до позиции и проверить та ли это позиция (через equals)
         * 		если позиция та, то начать вставку
         * 			next у предыдущего на новый нод, next нового нода на текущий
         * 		позиция не та - ничего не делать
         * если вставка в конец:
         * 		присоединить новый нод в конец
         */

        if (head == null) {
            head = new Node(x);
            //System.out.println('1');
        }
        else if (p == null || p.p == null) {
            Node cur = findNodePrev(head, null);
            //cur.print();
            cur.next = new Node(x);
            //cur.next.print();
            //System.out.println('2');
        }
        else if (head.item.equals(p.p.item)) {
            Node node = new Node(x);
            Node prev = new Node(head);
            head = node;
            //head.print();
            head.next = prev;
            //head.next.print();
            //System.out.println('3');
        }
        else {
            Node prev = findNodePrev(head, p.p);
            //prev.print();
            Node cur = findNode(head, p.p);
            //p.p.print();
            //cur.print();
            if(cur.item.equals(p.p.item)) {
                prev.next = new Node(x);
                prev = prev.next;
                prev.next = cur;
                //System.out.println('5');
            }
            //System.out.println('4');
        }
    }

    // находить последний нод
    private Node findNode(Node current, Node tofind) {

        while(current != null && !current.equals(tofind)) {
            current = current.next;
        }
        return current;
    }

    // метод поиска позиции возвращать предыдущую (проверять head перед методом)
    private Node findNodePrev(Node current, Node end) {

        while(current.next != end) {
            current = current.next;
        }
        return current;
    }

    // вернуть позицию по объекту
    public Position locate(Item x) {
        /*
        идем по списку с head до null
            если объект равен х по equals - вернуть позицию
        если объекта нет(цикл завершил свою работу и объект не нашел) - вернуть null
         */

        Node current = head;
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
         * если (p != null) идем с head
         *		если находится элемент (сверяем позицию по equals), то возвращаем его копию
         * 		элемент не найден, выбросить исключение
         * иначе выбросить исключение
         IndexOutOfBoundsException
         */

        if (p != null) {
            Node current = head;
            while(current != null) {
                if (current.equals(p.p)) return new Item(current.item);
                current = current.next;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    // удалить объект в позиции
    public void delete(Position p) {
        /*
         * если удаляем head (p.equals(head)):
         * 		ставим this.head = head.next;
         * иначе если в середину (p != null) идем по списку
         *		если находится элемент (сверяем позицию по equals),
         *          привязываем предыдущий к последующему от данного элемента,
         *          меняем Position на последующий
         * 		элемент не найден - ничего не делать
         * иначе ничего не делать
         */

        if (p.p == head) {
            head = head.next;
            //System.out.println('1');
        }
        else if (p != null) {
            Node current = head.next;
            //current.print();
            Node time = head;
            //time.print();
            //p.p.print();
            while (current != null) {
                //System.out.println(p.p == current);
                //current.print();
                if (p.p == current) {
                    time.next = current.next;
                }
                time = time.next;
                current = current.next;
            }
            //System.out.println('2');
        }
        //System.out.println('3');
    }

    // вернуть последующую позицию
    public Position next(Position p) {
        /*
         * если (p != null)
         * вернуть следующую позицию
         */
        if(p.p != null) return new Position(p.p.next);
        else return new Position(null);
    }

    // вернуть предыдущую позицию
    public Position previous(Position p) {
        /*
         * если p == null - искать позицию перед последней (null) (пока current.next != null)
         * иначе time = null
         *      идем по списку от head
         *      если позиция временного совпадает с позицией текущего - вернуть копию time
         *      в time сохраняем позицию данного нода
         * позиции нет - вернуть null
         */

        if (p.p.equals(head)) {
            return new Position(null);
        }
        else {
            Node current = findNode(head, p.p);
            Node prev = findNodePrev(head, current);
            if (current.equals(p.p)) return new Position(prev);
            else return new Position(null);
        }
    }

    // обнулить список
    public void makenull() {
        /*
        сделать head = null
         */
        head = null;
    }

    // вернуть первую позицию
    public Position first() {

        if(head != null)
            return new Position(head);
        else return new Position(null);
    }

    // вывести на экран
    public void printlist() {
        /*
        идти по списку и вывести на печать каждый узел
         */
        if (head == null) System.out.println("List is empty");
        else {
            Node current = head;
            while (current != null) {
                System.out.println(current.item.toString());
                current = current.next;
            }
        }
    }

    // класс нода
    protected class Node {

        protected Item item;
        private Node next;

        // конструктор
        protected Node() {
            this.next = null;
        }

        // конструктор по Item
        protected Node(Item item) {
            this.item = new Item(item);
        }

        // копирующий конструктор
        protected Node(Node copy) {
            this.item = new Item(copy.item);
            this.next = copy.next;
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
