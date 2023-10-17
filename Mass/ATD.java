package Mass;
import Item.Item;

public class ATD {

    private Item[] mass;
    private int size = 10;
    private int last;

    // конструктор
    ATD() {
        /*
        создать массив
         */
        this.mass = null;
        last = 0;
    }

    // конструктор
    ATD(char[] adr, char[] name) {
        /*
        создать массив
         */
        this.mass = new Item[size];
        mass[0] = new Item(adr, name);
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
    }

    // двинуть массив вправо
    private void move_right(int start, int end, Item time1) {
        /*
         * цикл с start до last-1 (переставляю элементы вправо по парам)
         *      time2 = mas[i+1];
         *      mas[i+1] = mas[i];
         *      mas[i] = time1;
         *      time1 = time2;
         */
    }

    // вернуть
    public Position locate(char[] x) {
        /*
         * идти с 0 до last
         *      проверка элемента массива через equals
         *          true - вернуть позицию
         * элемент не найден - вернуть null
         */
    }

    public Item retrieve(Position p) {
        /*
         * проверить позицию check_pos(p)
         *      c 0 до last
         *          проверка позиции через equals
         *              true - вернуть копию объекта
         * элемент не найден либо check_pos вернуло false - выбросить исключение
         */
    }

    public void delete(Position p) {
        /*
         * проверить позицию check_pos(p)
         * если удаление первого или середины метод move_left(), переставить позицию
         * если конец то last-- и переставить позицию;
         */
    }

    // двинуть массив влево
    private void move_left(int start, int end) {
        /*
         * цикл с start до last-1 (переставляю элементы влево по парам)
         *      mas[i] = mas[i+1];
         * last--;
         */
    }

    public Position next(Position p) {
        /*
         * проверить позицию check_pos(p)
         * вернуть позицию p+1
         */
    }

    public Position previous(Position p) {
        /*
         * проверить позицию check_pos(p)
         * вернуть позицию p-1
         */
    }

    public void makenull() {
        /*
        сделать last = 0
         */
        last = 0;
    }

    private boolean check_pos(Position p) {
        /*
         * если позиция > 0 и < last вернуть true
         * иначе false
         */
    }

    public Position first() {
        /*
        вернуть 0 если массив не пуст
         */
    }

    public void printlist() {
        /*
        идти по списку и вывести на печать каждый объект (имя + адрес)
         */
    }
}
