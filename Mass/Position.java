package Mass;

public class Position {

    int p;

    // конструктор
    Position(int p) {
        this.p = p;
    }

    // сравнение
    protected boolean equals(Position q) {

        if(q.p == this.p) return true;
        else return false;
    }
}
