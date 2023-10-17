package DLL;
import DLL.ATD.Node;

// класс позиции
public class Position {

    protected Node p;  // нод

    // конструктор
    Position(Node p) {
        this.p = p;
    }

    // сравнение
    protected boolean equals(List.Position q) {
        if(this == q) return true;
        return q.p == this.p;
    }
}
