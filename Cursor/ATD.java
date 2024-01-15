package Cursor;
import Item.Item;

public class ATD {

    private Element[] mass;  // массив
    private final int size = 10; // размер массива
    private int space;  // начало списка свободных
    private int start; // указатель на первый элемент

    // конструктор
    public ATD() {
        start = -1;
        space = 0;
        mass = new Element[size];
        createSpace();
    }

    private void createSpace() {

        for (int i=0; i<size-1; i++) {
            mass[i] = new Element(i+1);
        }
        mass[size-1] = new Element(-1);
    }

    // конец массива
    public Position end() {
        /*
        вернуть позицию последнего
         */
        return new Position(-1);
    }

    // вставка
    public void insert(Item x, Position p) {
        // начать с p.p == -1

        // вставка null
        if (p.p == -1) {
            // вставка в пустой
            if (start == -1) {
                //System.out.println(space + " " + start);
                mass[space].item = new Item(x);
                mass[space].next = -1;

                space++;
                start++;
                System.out.println("1");
                return;
            }

            // вставка в конец
            int last = findLast();
            mass[last].next = space;

            int next = mass[space].next;
            mass[space].next = -1;
            mass[space].item = new Item(x);

            space = next;
            System.out.println("3");
            return;
        }

        // вставка в голову
        //System.out.println(p.p + " " + start);
        if (p.p == start) {

            mass[space].item = new Item(x);
            mass[space].next = start;

            start = space;
            space = mass[space].next;
            System.out.println("2");
            return;
        }

        // общий случай
        int prev = findPrev(p.p);
        if (prev < 0) {
            System.out.println("5");
            return;
        }

        Element current = mass[p.p];
        int temp = current.next;
        current.next = space;
        space = mass[space].next;

        mass[p.p].item = x;

        current = mass[current.next];
        current.next = temp;

        System.out.println("4");
    }

    // найти последний в списке
    private int findLast() {

        int current = start;
        int prev;

        for (prev = -2; current != -1; current = mass[current].next) {
            prev = current;
        }

        return prev;
    }

    // найти предыдущий
    private int findPrev(int pos) {

        int next;
        int current = -1;

        for (next = start; next != -1; next = mass[next].next) {
            if (next == pos) { return current; }
            current = next;
        }

        return -1;
    }

    // вернуть
    public Position locate(Item x) {
        /*
         * идти по списку с start
         *      если элемент найден - вернуть его позицию
         * элемент не найден - вернуть свободную позицию
         */
        int cur = start;
        while (cur != -1) {
            if (mass[cur].item.equals(x)) { return new Position(cur); }
            cur = mass[cur].next;
        }
        return new Position(-1);
    }

    public Item retrieve(Position p) {
        /*
         * проверить позицию
         * вернуть объект в старте
         *      вернуть копию item
         * элемент не найден - выбросить исключение
         */

        if (p.p == start) { return new Item(mass[start].item); }
        if (findPrev(p.p) == -1 || p.p == -1) { throw new ArrayIndexOutOfBoundsException(); }

        int cur = start;
        while (cur != -1) {
            if (cur == p.p) { return mass[cur].item; }
            cur = mass[cur].next;
        }
        return new Item();
    }

    public void delete(Position p) {
        /*
        удаление головы
            в цепочку space добавить start
            start = el.next
        удаление середины
            проверить позицию
                есть - найти предыдущий к данной позиции
                       сделать его next равным next текущего элемента
                нет  - ничего не делать
        удаление конца
            найти элемент перед концом и его next = -1
         */

        if (p.p == -1) return;
        // удаление головы
        if (p.p == start) {
            start = mass[start].next;
            mass[p.p].next = space;
            space = p.p;
            return;
        }
        int prev = findPrev(p.p);
        // удаление конца
        if (mass[p.p].next == -1) {
            mass[prev].next = -1;
            return;
        }
        // общий случай
        if (prev != -1 && p.p != -1) {
            int cur = mass[prev].next;
            mass[prev].next = mass[cur].next;
            p.p = mass[prev].next;
            mass[cur].next = space;
            space = cur;
        }
    }

    public Position next(Position p) {
        /*
        проверить позицию и при false выбросить исключение
        вернуть голову если предыдущего нет
        вернуть next
         */
        //p.print();

        if (p.p == start) {
            return new Position(mass[start].next);
        }

        int prev = findPrev(p.p);
        if ((prev == -1 && start == -1) || p.p == -1) { throw new ArrayIndexOutOfBoundsException(); }

        return new Position(mass[p.p].next);
    }

    public Position previous(Position p) {
        /*
        проверить позицию и при false выбросить исключение
        вернуть голову если предыдущего нет
        вернуть next
         */
        if (p.p == start) { throw new ArrayIndexOutOfBoundsException(); }
        int prev = findPrev(p.p);
        return new Position(prev);
    }

    public void makenull() {
        /*
        сделать space = 0 и start = -1
         */
        // вернуть список пустых
        space = 0;
        start = -1;
        createSpace();
    }

    public Position first() {
        /*
        вернуть start
         */
        return new Position(start);
    }

    public void printlist() {
        /*
        идти по списку и вывести на печать каждый объект (имя + адрес)
         */

        if (start >= 0) {
            for (int cur = start; cur != -1; cur = mass[cur].next) {
                System.out.println(mass[cur].item.toString());
            }
        }
        else System.out.println("List is empty");
        System.out.println();
    }

    // класс для элемента массива, в котором содержится next и item
    private static class Element {

        private Item item;
        private int next;

        // конструктор по умолчанию
        private Element() {
            item = null;
            next = 0;
        }

        // копирующий конструктор
        private Element(Item item, int next) {
            this.item = new Item(item);
            this.next = next;
        }

        // иниц конструктор
        private Element(int next) {
            this.item = null;
            this.next = next;
        }
    }
}
