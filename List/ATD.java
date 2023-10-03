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
        пока данный узел не null, переходить на следующий
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

    // вернуть позицию по объекту
    public Position locate(Item x) {
        /*
        идем по списку с first() до end()
            если объект есть - вернуть позицию
        если объекта нет - вернуть null
         */
    }

    // вернуть объект в позиции
    public Item retrieve(Position p) {
        /*
         * если (p != null) идем по списку
         *		если находится элемент (сверяем позицию по equals), то возвращаем его	
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
         * если в середину (p != null) идем по списку
         *		если находится элемент (сверяем позицию по equals), привязываем предыдущий к последующему от данного элемента	
         * 		элемент не найден - ничего не делать
         * если p = null ничего не делать
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
         * проверяем позицию на существование (p != null)
        вернуть предыдущую позицию
        пока позиция у след нода не p
        	сохраняем позицию в t
        вернуть позицию t
         */
    	/*
    	Node current = new Node(head);
    	Position t = new Position(current);
    	while(!next(t).equals(p)) {
    		current = current.next;
    		t = new Position(current);
    	}
    	return new Position(t);
    	*/
    }

    // обнулить список
    public void makenull() {
        /*
        сделать head = null
         */
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
    private class Node {

        Item item;
        private Node next;

        // конструктор
        Node() {
            this.next = null;
        }
        
        // копирующий конструктор
        Node(Node copy) {
        	// 
            this.next = copy.next;
        }
    }

    // класс позиции
    public class Position {

    	private Node p;  // нод
    	
    	// конструктор
    	Position(Node p) {
    		this.p = p;
    	}
    	
    	private boolean equals(Position q) {
    		if(this == q) return true;
    		return q.p == this.p;
    	}
    }
}
