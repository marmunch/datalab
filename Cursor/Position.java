package Cursor;

public class Position {

    protected int p; // позиция

    // конструктор
    Position(int p) {
        this.p = p;
    }

    // сравнение
    public boolean equal(Position q) {

        if(q.p == this.p) return true;
        else return false;
    }

    // вывести позицию
    public void print() { System.out.println(p); }
}
