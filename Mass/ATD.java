package Mass;
import Item.Item;

public class ATD {

    private Item[] mass;  // массив
    private int size = 10; // размер массива
    private int last;  // элемент первый свободный

    // конструктор
    public ATD() {
        this.mass = new Item[size];
        last = 0;
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
         * вставка (Position < size и >= 0)
         *      двигаем массив с конца вправо до нужной позиции
         *      в освободившуюся ячейку вставляем item
         * позиция не найдена - ничего не делать
         */
        if(p.p >= 0 && p.p <= last) {
            for(int i=last; i > p.p; i--) {
                mass[i] = mass[i-1];
            }
            mass[p.p] = new Item(x);
            last++;
        }
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
            if(x.equals(mass[i])) return new Position(i);
        }
        return new Position(last);
    }

    public Item retrieve(Position p) {
        /*
         * проверить позицию check_pos(p)
         *      вернуть копию item
         * элемент не найден - выбросить исключение
         */
        //System.out.println(p.p);
        if(p.p >= 0 && p.p < last) {
            return new Item(mass[p.p]);
        }
        throw new IndexOutOfBoundsException();
    }

    public void delete(Position p) {
        /*
            проверка позиции
                переставить массив влево
                уменьшить last
            иначе ничего не делать
         */
        if(p.p >= 0 && p.p < last) {
            for(int i=p.p; i<last-1; i++) {
                //System.out.println(mass[i]);
                mass[i] = mass[i+1];
            }
            last--;
        }
    }

    public Position next(Position p) {
        /*
        проверить позицию check_pos(p)
            вернуть p+1
        иначе вернуть last
         */
        //p.print();
        if(p.p >= 0 && p.p < last) return new Position(p.p+1);
        else return new Position(last);
    }

    public Position previous(Position p) {
        /*
        проверить позицию p.p >= 0 && p.p <= last
            вернуть p-1
        иначе вернуть last
         */
        if(p.p >= 0 && p.p <= last) return new Position(p.p-1);
        else return new Position(last);
    }

    public void makenull() {
        /*
        сделать last = 0
         */
        last = 0;
    }

    public Position first() {
        /*
        вернуть 0
         */
        return new Position(0);
    }

    public void printlist() {
        /*
        идти по списку и вывести на печать каждый объект (имя + адрес)
         */

        if(last > 0) {
            for (int i = 0; i < last; i++) {
                System.out.println(mass[i]);
            }
        }
        else System.out.println("List is empty");
        System.out.println();
    }
}
