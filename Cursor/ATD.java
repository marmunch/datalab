package Cursor;
import Item.Item;

public class ATD {

    private Element[] mass;  // массив
    private int size = 10; // размер массива
    private int space;  // элемент первый свободный
    private int start; // указатель на первй элемент

    // конструктор
    public ATD() {
        this.mass = new Element[size];
        space = 0;
        start = -1;
    }

    // конец массива
    public Position end() {
        /*
        вернуть позицию последнего
         */
        return new Position(space);
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
    }

    // вернуть
    public Position locate(Item x) {
        /*
         * идти по списку с start
         *      если элемент найден - вернуть его позицию
         * элемент не найден - вернуть свободную позицию
         */
        Element el = mass[start];
        int i = start;
        while (i >= 0) {
            if(x.equals(mass[i].item)) return new Position(i);
            i = el.next;
            el = mass[el.next];
        }
        return new Position(space);
    }

    private boolean checkPos(int i) {
        Element el = mass[start];
        int time = start;
        while (time >= 0) {
            if (i == time) return true;
            time = el.next;
            el = mass[el.next];
        }
        return false;
    }

    public Item retrieve(Position p) {
        /*
         * проверить позицию
         *      вернуть копию item
         * элемент не найден - выбросить исключение
         */
        //System.out.println(p.p);
        if(checkPos(p.p)) {
            return new Item(mass[p.p].item);
        }
        throw new IndexOutOfBoundsException();
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
    }

    public Position next(Position p) {
        /*
        проверить позицию checkPos(p)
            вернуть next
        иначе вернуть space
         */
        //p.print();
        if(checkPos(p.p)) return new Position(mass[p.p].next);
        else return new Position(space);
    }

    public Position previous(Position p) {
        /*
        проверить позицию checkPos(p)
            найти предыдущий и вернуть его позицию
        иначе вернуть space
         */
        if(checkPos(p.p)) return new Position(p.p-1);
        else return new Position(space);
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
        вернуть 0
         */
        return new Position(start);
    }

    public void printlist() {
        /*
        идти по списку и вывести на печать каждый объект (имя + адрес)
         */

        if(start >= 0) {
            int time = start;
            Element current = mass[start];
            while (time >= 0) {
                System.out.println(mass[time].item);
                time = current.next;
                current = mass[time];
            }
        }
        else System.out.println("List is empty");
        System.out.println();
    }

    // класс для элемента массива, в котором содержится next и item
    protected class Element {

        Item item;
        int next;

        // конструктор по умолчанию
        protected Element() {
            item = null;
            next = 0;
        }

        // конструктор
        protected Element(Item item, int next) {
            this.item = new Item(item);
            this.next = next;
        }
    }
}
