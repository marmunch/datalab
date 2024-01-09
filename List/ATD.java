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

        if (p.p == null) {  // если позиция null
            if (head == null) {  // список пустой
                head = new Node(x);
                //System.out.println('1');
                return;
            }
            // вставка в последний
            Node cur = findNodeLast(); //cur.print();
            cur.next = new Node(x); //cur.next.print();
            //System.out.println('2');
            return;
        }
        if (head == p.p) {  // вставка в голову
            Node node = new Node(x);
            Node prev = new Node(head);
            head = node; //head.print();
            head.next = prev; //head.next.print();
            //System.out.println('3');
            return;
        }
        // вставка в середину
        Node cur = findNodePrev(p.p).next; //cur.print(); //p.p.print();
        Node copy = new Node(cur);
        cur.next = copy;
        cur.item = new Item(x);

    }

    // !!!метод ищет последний элемент в списке, второй возвращает предыдущий
    // находить последний узел
    private Node findNodeLast() {

        Node curprev = head;
        Node current = head.next;
        while(current != null) {
            current = current.next;
            curprev = curprev.next;
        }
        return curprev;
    }

    // метод поиска позиции возвращать предыдущую (проверять head перед методом)
    private Node findNodePrev(Node find) {

        Node curprev = head;
        Node current = head.next;
        while(current != find) { // проверка на узел
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
        while (current != null) { //current.print();
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

        if (p.p == null || head == null) return;
        if (p.p == head) {
            head = head.next;
            //System.out.println('1');
            return;
        }
        Node time = findNodePrev(p.p);
        Node nxt = time.next.next;
        time.next = nxt; //time.print(); //p.p.print();
        //System.out.println('2');
        return;
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
        Node prev = findNodePrev(p.p);
        Node current = prev.next;
        if (current.item.equals(p.p.item)) return new Position(prev);
        else return new Position(null);
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
    public class Node {

        public Item item; // объект
        private Node next; // ссылка на следующий

        // конструктор
        private Node() {
            this.next = null;
        }

        // конструктор по Item
        private Node(Item item) {
            this.item = new Item(item);
        }

        // копирующий конструктор
        public Node(Node copy) {
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
