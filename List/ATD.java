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
        если позиция Null
            если список пустой
                в head создать новый нод
            иначе
                ищем последний
                присваиваем его next новый нод
        иначе ищем объект в середине списка
            находим предыдущий от Position
            находим сам нод объекта
            если их item равны c p.p - делаем вставку
        объект не найден - ничего не делаем
         */

        if (p == null || p.p == null) {
            if (head == null) {
                head = new Node(x);
                //System.out.println('1');
            }
            else {
                Node cur = findNodePrev(null);
                //cur.print();
                cur.next = new Node(x);
                //cur.next.print();
                //System.out.println('2');
            }
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
            Node prev = findNodePrev(p.p);
            //prev.print();
            Node cur = findNode(p.p);
            //p.p.print();
            //cur.print();
            if(cur.item.equals(p.p.item)) {
                prev.next = new Node(x);
                prev = prev.next;
                prev.next = cur;
                //System.out.println('4');
            }
            //System.out.println('3');
        }
    }

    // находить заданный узел
    private Node findNode(Node find) {

        Node current = head;
        while(current != find) { // проверка на узел
            current = current.next;
        }
        return current;
    }

    // метод поиска позиции возвращать предыдущую (проверять head перед методом)
    private Node findNodePrev(Node find) {

        Node curprev = head;
        Node current = head.next;
        //head.print();
        /*if (head.next == null) {
            System.out.println();
        } else {
            head.next.print();
        }*/
        while(current != null) { // проверка на узел
            curprev = curprev.next;
            current = current.next;
            if (current == find) return curprev;
        }
        return curprev;
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
         если (p != null) идем с head
            если находится элемент (сверяем позицию по equals), то возвращаем его копию
         иначе выбросить исключение
         IndexOutOfBoundsException
         */

        if (p != null) {
            Node current = head;
            while(current != null) {
                if (current.item.equals(p.p.item)) return new Item(current.item);
                current = current.next;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    // удалить объект в позиции
    public void delete(Position p) {
        /*
        если удаляем голову
            голове присвоить next
        если удаляем середину или конец
            во временную сохраняем ссылку на head
            в текущую - head.next
            пока не дойдем до конца списка
                если ссылка p.p == ссылка текущей
                    делаем next предыдущего = next текущего (т.е. нод между ними пропадает из цепи)
                переставляем указатели временного и текущего
         */

        if (p.p == head) {
            head = head.next;
            //System.out.println('1');
        }
        else {
            Node time = findNodePrev(p.p);
            Node nxt = findNode(p.p).next;
            time.next = nxt;
            //time.print();
            //p.p.print();
            //System.out.println('2');
        }
        //System.out.println('3');
    }

    // вернуть последующую позицию
    public Position next(Position p) {
        /*
         * если (p != null)
         * вернуть следующую позицию
         * иначе вернуть null
         */
        if(p.p != null) return new Position(p.p.next);
        else return new Position(null);
    }

    // вернуть предыдущую позицию
    public Position previous(Position p) {
        /*
        если позиция = head
            вернуть null
        иначе
            найти нод и его предыдущий
            если нод равен p вернуть предыдущий
            иначе вернуть null
         */

        if (p.p.item.equals(head.item)) {
            return new Position(null);
        }
        else {
            Node current = findNode(p.p);
            Node prev = findNodePrev(current);
            if (current.item.equals(p.p.item)) return new Position(prev);
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
        /*
        если список не пуст, вернуть head
        иначе - null
         */

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
        System.out.println();
    }

    // класс нода
    protected class Node {

        protected Item item; // объект
        private Node next; // ссылка на следующий

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

        // печать
        protected void print() {

            if (item != null) System.out.println(item);
            else System.out.println("Item is null");
        }

    }
}
