package Tree.List;

public class Tree {

    private int root;
    private static int space;           // список свободных
    private static final int size = 10; // размер массива
    private static Item[] mass;

    // конструктор
    public Tree() {

        // инициализация курсоров
        space = 0;
        mass = new Item[size];

        for (int i = 0; i < mass.length - 1; i++) {
            mass[i] = new Item(i + 1, "");
        }

        mass[mass.length - 1] = new Item(-1, "");
        root = -1;
    }

    // найти родителя
    private int findPar(int start, int tofind) {

        for (Son cur = mass[start].son; cur != null; cur = cur.next) {

            if (cur.label == tofind) return start;

            int res = findPar(cur.label, start);
            if (res != -1) return res;
        }

        return -1;
    }

    // вернуть левого сына
    public int leftMostChild(int n) {

        // пустое дерево
        if (root == -1) return -1;

        // вернуть сына корня
        if (root == n) return mass[root].son.label;

        // общий случай
        int item = findPar(root, n);
        if (item == -1) return -1;

        return mass[n].son.label;
    }

    // вернуть метку
    public String label(int n) {

        if (n == root) return mass[n].str;

        int parent = findPar(root, n);
        if (parent != -1) return mass[n].str;

        throw new ArrayIndexOutOfBoundsException("Not Found");
    }

    // вернуть правого брата
    public int rightSibling(int n) {

        int parent = findPar(root, n);

        if (mass[parent].son.next != null && parent != -1) {
            return mass[parent].son.next.label;
        }

        return -1;
    }

    // создать дерево
    public Tree create(String label) {

        // нет места
        if (space == -1) return null;

        // дерево не пустое
        if (root != -1) mass[space].son = new Son(root, null);

        mass[space].str = label;
        root = space;
        space = mass[space].next;
        return this;
    }

    // создать дерево
    public Tree create(String label, Tree tree) {

        // нет места
        if (space == -1) return null;

        // если какое-либо дерево пустое
        if (tree.root == -1) { return create(label); }
        if (this.root == -1) { return tree.create(label); }

        // создание
        mass[space].str = label;
        mass[space].son = new Son(root, new Son(tree.root, null));

        root = space;
        space = mass[space].next;
        return this;
    }

    // вернуть корень дерева
    public int root()
    {
        return root;
    }

    // родитель
    public int parent(int n) {

        return findPar(root, n);
    }

    // очистить дерево
    public void makenull()
    {
        // очистить дерево, когда оно не пустое
        if (root == -1) return;

        clrBranch(root);
        root = -1;
    }

    // очистить ветку
    private void clrBranch(int parent) {

        // циклично очистить каждого сына потомка
        for (Son child = mass[parent].son; child != null; child = child.next) {
            clrBranch(child.label);
        }

        mass[parent].next = space;
        mass[parent].str = "";
        space = parent;
    }

    // вывод на экран
    public static void print()
    {
        for (int i = 0; i < size; i++) {
            // номер в массиве, следующий объект, хранимые данные
            System.out.print(i + " " +  mass[i].next + " " + mass[i].str + " | Сыновья: ");

            Son son = mass[i].son;
            while (son != null) {
                System.out.print(son.label + " ");
                son = son.next;
            }

            System.out.println();
        }
    }
}
