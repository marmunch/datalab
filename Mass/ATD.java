package Mass;

public class ATD {

	private char[][] mass;
    private char[] name;
    private char[] address;

    ATD(char[] param) {
        /*
        создать массив
         */
        this.mass = new char[10][];
    }

    private Position end() {
        /*
        пока данный object не null, переходить на следующий
        вернуть позицию
         */
    }

    private void insert(char[] x, Position p) {
        /*
        если позиция есть:
            ищем элемент с позицией p (цикл с 0 до p)
            вставляем элемент, элемент с номером p запомнить в временную переменную t
            в цикле остальные двигаем вправо (с p+1 до end())
        если нет - ничего не делать
         */
    }

    private Position locate(char[] x) {
        /*
        идем по списку с first
            если объект есть - вернуть позицию
        если объекта нет - вернуть end()
         */
    }

    private char[] retrieve(Position p) throws Exception{
        /*
        идем по списку
            если находится элемент, то возвращаем его
        элемент не найден или p = end(), выбросить исключение
         */
    }

    private void delete(Position p) {
        /*
        идем по списку
            находим элемент, двигаем на него все элементы справа
        в списке нет элемента - ничего не делать
         */
    }

    private Position next(Position p) {
        /*
        вернуть следующую позицию
         */
    }

    private Position previous(Position p) {
        /*
        вернуть предыдущую позицию
         */
    }

    private void makenull() {
        /*
        сделать head = null
         */
    }

    private Position first() {
        /*
        вернуть первый если массив не пуст
         */
    }

    private void printlist() {
        /*
        идти по списку и вывести на печать каждый узел
         */
    }
    
    private class Position {

    	int p;
    	
    	Position(int p) {
    		this.p = p;
    	}
    	
    	private boolean equals(Position q) {
    		
    		if(q.p == this.p) return true;
    		else return false;
    	}
    }
}
