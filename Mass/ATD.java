package Mass;

public class ATD<T> {

    private T[] mass;

    ATD(T param) {
        /*
        создать массив
         */
        this.mass = (T[])new Object[10];
    }

    private int end() {
        /*
        пока данный object не null, переходить на следующий
        вернуть данный
         */
    }

    private void insert(T x, int p) {
        /*
        если позиция есть:
            ищем элемент с позицией p
            вставляем элемент, остальные двигаем вправо
        если нет - ничего не делать
         */
    }

    private int locate(T x) {
        /*
        идем по списку с first
            если объект есть - вернуть позицию
        если объекта нет - вернуть end()
         */
    }

    private T retrieve(int p) throws Exception{
        /*
        идем по списку
            если находится элемент, то возвращаем его
        элемент не найден или p = end(), выбросить исключение
         */
    }

    private void delete(int p) {
        /*
        идем по списку
            находим элемент, двигаем на него все элементы справа
        в списке нет элемента - ничего не делать
         */
    }

    private int next(int p) {
        /*
        вернуть следующую позицию
         */
    }

    private int previous(int p) {
        /*
        вернуть предыдущую позицию
         */
    }

    private void makenull() {
        /*
        сделать head = null
         */
    }

    private int first() {
        /*
        вернуть первый если массив не пуст
         */
    }

    private void printlist() {
        /*
        идти по списку и вывести на печать каждый узел
         */
    }
}
