package List;
import List.ATD.Node;

// класс позиции
public class Position {

    protected Node p;  // нод

    // конструктор
    Position(Node p) {
        this.p = p;
    }

    // сравнение
    protected boolean equals(Position q) {
        if(this == q) return true;
        return q.p == this.p;
    }
}
