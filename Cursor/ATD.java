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
        /*
        вставка в пустой список
            space++
            start++
            создание объекта Element по item и p
            next = -1
        вставка в голову
            создание Element в ячейке с номером space
            next у этой ячейки сделать = start
            start = space
            space передается первому незанятому
        вставка в конец
            у конечного элемента поменять next = space
            создать элемент в space
            next у space = -1
            space передается первому незанятому
        общий случай
            поиск элемента у которого next = p.p
            сделать его next = space
            в space поместить item и сделать его next = p.p
            space передается первому незанятому
         */

        // вставка в голову
        //System.out.println(p.p + " " + start);
        if (p.p == start) {
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
            // вставка в голову, но список не пустой

            mass[space].item = new Item(x);
            mass[space].next = start;

            start = space;
            space = mass[space].next;
            System.out.println("2");
            return;
        }

        // вставка в конец
        if (p.p == -1) {

            int last = findLast();
            mass[last].next = space;

            int next = mass[space].next;
            mass[space].next = -1;
            mass[space].item = new Item(x);

            space = next;
            System.out.println("3");
            return;
        }

        // общий случай

        int prev = findPrev(p.p);
        if (prev < 0) {
            System.out.println("5");
            return;
        }

        Element current = mass[mass[prev].next];
        current.next = space;
        space = mass[space].next;

        mass[space].item = current.item;
        mass[space].next = current.next;
        System.out.println("4");
    }

    // найти последний в списке
    private int findLast() {

        int current = start;
        int prev = -1;

        while (current != -1) {
            prev = current;
            current = mass[current].next;
        }

        return prev;
    }

    // найти предыдущий
    private int findPrev(int pos) {

        int next = start;
        int current = -1;

        while (next != -1) {
            if (next == pos) { return current; }

            current = next;
            next = mass[next].next;
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
        // удаление головы
        if (p.p == start) {
            start = mass[start].next;
            return;
        }

        int prev = findPrev(p.p);
        if (prev == -1) { throw new ArrayIndexOutOfBoundsException(); }

        // удаление конца
        if (mass[p.p].next == -1) {
            mass[prev].next = -1;
            return;
        }
        // удаление середины
        int del = mass[prev].next;

        mass[prev].next = mass[mass[prev].next].next;
        p.p = mass[prev].next;

        mass[del].next = space;
        space = del;
    }

    public Position next(Position p) {
        /*
        проверить позицию и при false выбросить исключение
        вернуть голову если предыдущего нет
        вернуть next
         */
        //p.print();

        int prev = findPrev(p.p);
        if ((prev == -1 && start == -1) || p.p == -1) { throw new ArrayIndexOutOfBoundsException(); }

        if (prev == -1) {
            return new Position(mass[start].next);
        }

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
        space = 0;
        start = -1;
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
            int cur = start;
            int r = 0;
            while (cur != -1) {
                System.out.println(mass[cur].item.toString());
                cur = mass[cur].next;
                r++;
                if(r==5) break;
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
