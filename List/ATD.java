package List;

public class ATD<T> {

    private Node head;

    ATD(T param) {
        /*
        создать узел по введенным данным

         */
        this.head = new Node(param);
    }

    private Node end() {
        /*
        пока данный узел не null, переходить на следующий
        вернуть данный
         */

        Node current = head;
        while(current.next != null) {
            current = current.next();
        }
        return current.next;
    }

    private void insert(Node x, Node p) {
        /*
        если позиция есть:
            ищем элемент с позицией p
            вставляем элемент, остальные двигаем вправо
        если нет - ничего не делать
         */
    }

    private Node locate(Node x) {
        /*
        идем по списку с head
            если объект есть - вернуть позицию
        если объекта нет - вернуть end()
         */
    }

    private Node retrieve(Node p) throws Exception{
        /*
        идем по списку
            если находится элемент, то возвращаем его
        элемент не найден или p = end(), выбросить исключение
         */
    }

    private void delete(Node p) {
        /*
        идем по списку
            находим элемент, привязываем предыдущий к последующему от данного элемента
        в списке нет элемента - ничего не делать
         */
    }

    private Node next(Node p) {
        /*
        вернуть следующую позицию
         */
    }

    private Node previous(Node p) {
        /*
        вернуть предыдущую позицию
         */
    }

    private void makenull() {
        /*
        сделать head = null
         */
    }

    private Node first() {
        if(head != null)
            return head;
        else return end();
    }

    private void printlist() {
        /*
        идти по списку и вывести на печать каждый узел
         */
    }

    private class Node {

        T param;
        Node next;

        Node(T param) {
            this.param = param;
        }

        private Node next() {
            return this.next;
        }
    }
}
