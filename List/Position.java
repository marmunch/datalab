package List;

// класс позиции
public class Position {

    private ATD.Node p;  // нод

    // конструктор
    Position(ATD.Node p) {
        this.p = p;
    }

    // сравнение
    private boolean equals(Position q) {
        if(this == q) return true;
        return q.p == this.p;
    }
}
