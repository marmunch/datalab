package Mass;
import Item.Item;

public class ATD {

	private Item[] mass;
	
	ATD() {
        /*
        создать массив
         */
    	this.mass = new Item[10];
    }
	
    ATD(char[] adr, char[] name) {
        /*
        создать массив
         */
    	this.mass = new Item[10];
    	mass[0] = new Item(adr, name);
    }

    private int end() {
        /*
        пока данный object не null(элемент массива), переходить на следующий
        вернуть позицию
         */
    }

    private void insert(char[] x, int p) {
        /*
         * p > 0 and p < 10
        если позиция есть:
            ищем элемент с позицией p (цикл с 0 до p)
            вставляем элемент, элемент с номером p запомнить в временную переменную t
            в цикле остальные двигаем вправо (с p+1 до end())
        если нет - ничего не делать
         */
    }

    private int locate(char[] x) {
        /*
        идем по списку с first
            если объект есть - вернуть позицию
        если объекта нет - вернуть end()
         */
    }

    private char[] retrieve(int p) throws Exception{
        /*
         * p > 0 and p < 10
        идем по списку
            если находится элемент, то возвращаем его
        элемент не найден или p = end(), выбросить исключение
         */
    }

    private void delete(int p) {
        /*
         * p > 0 and p < 10
        идем по списку
            находим элемент, двигаем на него все элементы справа
        в списке нет элемента - ничего не делать
         */
    }

    private int next(int p) {
        /*
         * p > 0 and p < 10
        вернуть следующую позицию
         */
    }

    private int previous(int p) {
        /*
         * p > 0 and p < 10
        вернуть предыдущую позицию
         */
    }

    private void makenull() {
        /*
        сделать null
         */
    	this.mass = new Item[10];
    }

    private int first() {
        /*
        вернуть первый если массив не пуст
         */
    }

    private void printlist() {
        /*
        идти по списку и вывести на печать каждый объект имя + адрес
         */
    }
    
    private class Position {

    	int p;
    	
    	Position(int p) {
    		this.p = p;
    	}
    	
    	private boolean equals(int q) {
    		
    		if(q.p == this.p) return true;
    		else return false;
    	}
    }
}
