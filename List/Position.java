package List;
import List.ATD.Node;

// класс позиции
public class Position {

    protected Node p;  // нод

    // конструктор
    public Position(Node p) {
        this.p = p;
    }

    // сравнение
    public boolean equal(Position q) {
        //System.out.println('1');
        if(this == q) return true;
        //System.out.println('2');
        if(this.p != null) return this.p.equals(q.p);
        else if(q.p == null) return true;
        else return false;
    }

    public void print() {
        if (p != null) p.print();
        else System.out.println("Node is null");
    }
}
