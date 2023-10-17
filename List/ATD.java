package List;
import Item.Item;

public class ATD {

    private Node head; // голова списка

    // конструктор
    ATD() {
        /*
        создать узел
         */
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
         * если позиция вставки head или список null (p == head || head == null):
         *  	создать нод head;
         *  	привязать к новой head старую (если head == null)
         * если вставка в середину (p != null):
         * 		в цикле дойти до позиции и проверить та ли это позиция (через equals)
         * 		если позиция та, то начать вставку
         * 			next у предыдущего на новый нод, next нового нода на текущий
         * 		позиция не та - ничего не делать
         * если вставка в конец:
         * 		присоединить новый нод в конец
         */
    }

    // находить последний нод

    // метод поиска позиции возвращать предыдущую (проверять head перед методом)

    // вернуть позицию по объекту
    public Position locate(Item x) {
        /*
        идем по списку с head до null
            если объект равен х по equals - вернуть позицию
        если объекта нет(цикл завершил свою работу и объект не нашел) - вернуть null
         */
    }

    // вернуть объект в позиции
    public Item retrieve(Position p) {
        /*
         * если (p != null) идем с head
         *		если находится элемент (сверяем позицию по equals), то возвращаем его копию
         * 		элемент не найден, выбросить исключение
         * иначе выбросить исключение
         IndexOutOfBoundsException
         */
    }

    // удалить объект в позиции
    public void delete(Position p) {
        /*
         * если удаляем head (p.equals(head)):
         * 		ставим this.head = head.next;
         * иначе если в середину (p != null) идем по списку
         *		если находится элемент (сверяем позицию по equals),
         *          привязываем предыдущий к последующему от данного элемента,
         *          меняем Position на последующий
         * 		элемент не найден - ничего не делать
         * иначе ничего не делать
         */
    }

    // вернуть последующую позицию
    public Position next(Position p) {
        /*
         * если (p != null)
         * вернуть следующую позицию
         */
        if(p != null) return new Position(p.p.next);
        else return null;
    }

    // вернуть предыдущую позицию
    public Position previous(Position p) {
        /*
         * если p == null - искать позицию перед последней (null) (пока current.next != null)
         * иначе time = null
         *      идем по списку от head
         *      если позиция временного совпадает с позицией текущего - вернуть копию time
         *      в time сохраняем позицию данного нода
         * позиции нет - вернуть null
         */
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

        if(head != null)
            return new Position(head);
        else return null;
    }

    // вывести на экран
    public void printlist() {
        /*
        идти по списку и вывести на печать каждый узел
         */
        Node current = head;
        while(current != null) {

            current = current.next;
        }
    }

    // класс нода
    protected class Node {

        Item item;
        private Node next;

        // конструктор
        Node() {
            this.next = null;
        }

        // копирующий конструктор
        Node(Node copy) {
            this.item = new Item(copy.item);
            this.next = copy.next;
        }
    }
}
