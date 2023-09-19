package List;

public class ATD {
	
	/*
	 * проверять существование позиции!
	 */

    private Node head; // голова списка

    // конструктор
    ATD(char[] param) {
        /*
        создать узел
         */
        this.head = new Node(param);
    }

    // конец списка
    private Position end() {
        /*
        пока данный узел не null, переходить на следующий
        вернуть позицию последнего
         */
    	
    	Node current = head;
    	while(current.next != null) {
    		
    	}
    	return new Position(current.next);
    }

    // вставить объект в позицию
    private void insert(char[] x, Position p) {
        /*
        если позиция есть (p < end()):
            ищем элемент с позицией p (цикл с 0 до p)
            вставляем копию элемента (next у вставляемого нода на элемент p, next у предыдущего на вставляемый)
        если нет - ничего не делать
         */
    }

    // вернуть позицию по объекту
    private Position locate(char[] x) {
        /*
        идем по списку с first() до end()
            если объект есть - вернуть позицию
        если объекта нет - вернуть end()
         */
    }

    // вернуть объект в позиции
    private char[] retrieve(Position p) throws MyException {
        /*
        идем по списку
            если находится элемент, то возвращаем его
        элемент не найден или p = end(), выбросить исключение
         */
         try {
         }
         catch (IndexOutOfBoundsException e) {
        	 System.out.println("Position Not Found");
         }
    }
    
    // удалить объект в позиции
    private void delete(Position p) {
        /*
        идем по списку
            находим элемент, привязываем предыдущий к последующему от данного элемента
        в списке нет элемента - ничего не делать
         */
    }

    // вернуть последующую позицию
    private Position next(Position p) {
        /*
        вернуть следующую позицию
         */
    	return new Position(p.p.next);
    }

    // вернуть предыдущую позицию
    private Position previous(Position p) {
        /*
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
    private void makenull() {
        /*
        сделать head = null
         */
    }

    // вернуть первую позицию
    private Position first() {
    	
        if(head != null)
            return new Position(head);
        else return null;
    }

    // вывести на экран
    private void printlist() {
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

        private char[] name;
        private char[] address;
        private Node next;

        // конструктор
        Node(char[] param) {
            this.param = param;
            this.next = null;
        }
        
        // копирующий конструктор
        Node(Node copy) {
            this.param = copy.param;
            this.next = copy.next;
        }
        
        // вернуть объект
        private char[] get() {
        	return this.param;
        }
    }

    // класс позиции
    private class Position {

    	private Node p;  // нод
    	
    	// конструктор
    	Position(Node p) {
    		this.p = p;
    	}
    	
    	// копирующий конструктор
    	Position(Position copy) {
    		this.p = copy.p;
    	}
    	
    	private boolean equals(Position q) {
    		if(this == q) return true;
    		return q.p == this.p;
    	}
    }
}
