package Mass;
import Item.Item;

public class ATD {

    private Item[] mass;  // массив
    private int size = 10; // размер массива
    private int last;  // элемент после последнего занятого

    // конструктор
    ATD() {
        this.mass = null;
        last = 0;
    }

    // конструктор
    ATD(Item item) {
        /*
        создать массив
         */
        this.mass = new Item[size];
        mass[0] = new Item(item);
    }

    // конец массива
    public Position end() {
        /*
        вернуть позицию последнего
         */
        return new Position(last);
    }

    // вставка
    public void insert(Item x, Position p) {
        /*
         * вставка в начало или середину (Position < size и > 0)
         *      ищем позицию (equals)
         *      позиция найдена - метод move_right() с Position до end
         * вставка в конец
         *      mass[last] = new Item(x);
         *      last++;
         */
        int pos = 0;
        if(p.p > 0 && p.p < last) {
            for(int i=0; i<last; i++) {
                if(p.p == i) {
                    pos = i;
                    break;
                }
            }
            for(int i=last; i>pos; i--) {
                mass[i] = mass[i-1];
            }
            mass[pos] = new Item(x);
        }
        if(p.p == last) {
            mass[last] = new Item(x);
        }
        last++;
    }

    // вернуть
    public Position locate(Item x) {
        /*
         * идти с 0 до last
         *      проверка элемента массива через equals
         *          true - вернуть позицию
         * элемент не найден - вернуть null
         */
        for(int i=0; i<last; i++) {
            if(x.equals(mass[i])) return new Position(mass[i]);
        }
        return null;
    }

    public Item retrieve(Position p) {
        /*
         * проверить позицию check_pos(p)
         *      c 0 до last
         *          проверка позиции через equals
         *              true - вернуть копию объекта
         * элемент не найден либо check_pos вернуло false - выбросить исключение
         */
        if(p.p >= 0 && p.p < last) {
            for(int i=0; i< last; i++) {
                if(p.p == i) return new Item(mass[i]);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public void delete(Position p) {
        /*
         * проверить позицию check_pos(p)
         * если удаление первого или середины метод move_left(), переставить позицию
         * если конец то last-- и переставить позицию;
         */
        if(p.p >= 0 && p.p < last) {
            for(int i=p.p; i<last-1; i++) {
                mass[i] = mass[i+1];
            }
        }
        last--;
    }

    public Position next(Position p) {
        /*
         * проверить позицию check_pos(p)
         * вернуть позицию p+1
         */
        if(p.p >= 0 && p.p <= last) return new Position(p.p+1);
        else return null;
    }

    public Position previous(Position p) {
        /*
         * проверить позицию check_pos(p)
         * вернуть позицию p-1
         */
        if(p.p >= 0 && p.p <= last) return new Position(p.p-1);
        else return null;
    }

    public void makenull() {
        /*
        сделать last = 0
         */
        last = 0;
    }

    public Position first() {
        /*
        вернуть 0 если массив не пуст
         */
        if(mass != null) return new Position(0);
        else return null;
    }

    public void printlist() {
        /*
        идти по списку и вывести на печать каждый объект (имя + адрес)
         */

        for(int i = 0; i < last; i++) {
            System.out.println(mass[i].toString());
        }
    }
}
