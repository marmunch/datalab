package Tree.Cursor;

import Tree.List.Son;

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
            mass[i] = new Item(-1,i + 1, "");
        }

        mass[mass.length - 1] = new Item(-1, -1, "");
        root = -1;
    }

    // найти родителя
    private int findPar(int start, int tofind) {

        for (int child = mass[start].leftChild; child != -1; child = mass[child].rightSibling) {
            if (child == tofind) return start;

            int res = findPar(child, tofind);
            if (res != -1) return res;
        }

        return -1;
    }

    // левый сын
    public int leftMostChild(int n) {

        // пустое дерево
        if (root == -1) return -1;

        // вернуть сына корня
        if (n == root) return mass[root].leftChild;

        // общий случай
        int item = findPar(root, n);
        if (item == -1) return -1;

        return mass[n].leftChild;
    }

    // вернуть метку
    public String label(int n) {

        if (n == root) return mass[n].str;

        int parent = findPar(n, root);
        if (parent != -1) return mass[n].str;

        throw new ArrayIndexOutOfBoundsException("Not Found");
    }

    // правый брат
    public int rightSibling(int n) {

        int item = findPar(root, n);

        // предыдущего нет
        if (item == -1) return -1;

        item = mass[item].leftChild;
        while (item != n) {
            item = mass[item].rightSibling;
        }

        return mass[item].rightSibling;
    }

    // создать дерево
    public Tree create(String str) {

        // нет места
        if (space == -1) return null;

        int newNode = space;
        space = mass[space].leftChild;
        mass[newNode].str = str;
        // дерево не пустое
        if (root != -1) mass[newNode].leftChild = root;
        else mass[newNode].leftChild = -1;

        root = newNode;
        return this;
    }

    // создать дерево
    public Tree create(String str, Tree tree) {

        // нет места
        if (space == -1) return null;

        // если какое-либо дерево пустое
        if (tree.root == -1) return create(str);
        if (this.root == -1) return tree.create(str);

        // создание
        int newNode = space;
        space = mass[space].leftChild;

        mass[newNode].str = str;
        mass[newNode].leftChild = root;
        mass[root].rightSibling = tree.root;

        root = newNode;
        tree.root = -1;

        return this;
    }

    // корень
    public int root()
    {
        return root;
    }

    // родитель
    public int parent(int n) {
        return findPar(root, n);
    }

    // обнулить
    public void makenull() {

        // очистить дерево, когда оно не пустое
        if (root == -1) return;

        clrBranch(root);
        root = -1;
    }

    // удалить ветвь
    private void clrBranch(int parent) {

        // циклично очистить каждого сына потомка
        for (int child = mass[parent].leftChild; child != -1; child = mass[child].rightSibling) {
            clrBranch(child);
        }

        mass[parent].leftChild = space;
        mass[parent].str = "";
        space = parent;
    }

    // печать
    public static void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " " + mass[i].leftChild + " " + mass[i].rightSibling + " " + mass[i].str);
        }
    }
}
