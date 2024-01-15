package Tree;

import Tree.Cursor.*;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Tree tree2 = new Tree();
        tree = tree.create("label");
        tree2 = tree2.create("label2");

        tree = tree.create("label3", tree2);
        tree = tree.create("label4");

        //System.out.println(tree);
        Tree.print();
        SymmetricBypass(tree, tree.root());
    }

    public static void SymmetricBypass(Tree tree, int root) {

        if (root < 0) {
            return;
        }

        int child = tree.leftMostChild(root);
        SymmetricBypass(tree, child);
        System.out.println(tree.label(root));

        while (child >= 0) {
            child = tree.rightSibling(child);
            SymmetricBypass(tree, child);
        }
    }
}
