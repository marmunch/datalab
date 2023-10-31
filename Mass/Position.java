package Mass;

public class Position {

    protected int p;

    // конструктор
    Position(int p) {
        this.p = p;
    }

    // сравнение
    public boolean equal(Position q) {

        if(q.p == this.p) return true;
        else return false;
    }

    public void print() { System.out.println(p); }
}
