import Item.Item;
import Mass.*;
public class Main {

    public static void deleteDuplicates(ATD L) {

        Position p, q;
        p = L.first();
        while(!p.equal(L.end())) {
            q = L.next(p);
            //p.print();
            //int i = 0;
            while(!q.equal(L.end())) {
                //if(i==6) break;
                //System.out.println(!q.equal(L.end()));
                //L.end().print();
                //q.print();
                if(L.retrieve(p).equals(L.retrieve(q))) {
                    L.delete(q);
                    q = L.previous(q);
                }
                q = L.next(q);
                //i++;
            }
            p = L.next(p);
        }
    }
    public static void main(String[] args) {

        ATD list = new ATD();

        char[] adr1 = {'S', 'a', 'i', 'n', 't', '-', 'P', 'e', 't', 'e', 'r', 's', 'b', 'u', 'r', 'g'};
        char[] nm1 = {'A', 'l', 'e', 'x', 'a', 'n', 'd', 'r'};
        Item post1 = new Item(adr1, nm1);

        char[] adr2 = {'M', 'o', 's', 'k', 'o', 'w'};
        char[] nm2 = {'M', 'a', 'r', 'i', 'n', 'a'};
        Item post2 = new Item(adr2, nm2);

        char[] adr3 = {'F', 'l', 'o', 'r', 'i', 'd', 'a'};
        char[] nm3 = {'J', 'a', 'n', 'e'};
        Item post3 = new Item(adr3, nm3);

        char[] adr4 = {'Y', 'a', 'l', 't', 'a'};
        char[] nm4 = {'V', 'l', 'a', 'd', 'i', 'm', 'i', 'r'};
        Item post4 = new Item(adr4, nm4);

        list.insert(post1, list.end());
        list.printlist();
        System.out.println();

        list.insert(post2, list.end());
        list.insert(post1, list.end());
        list.insert(post1, list.end());
        list.insert(post3, list.end());
        list.printlist();
        System.out.println();

        list.insert(post2, list.end());
        list.printlist();
        System.out.println();

        list.insert(post3, list.first());
        list.printlist();
        System.out.println();

        deleteDuplicates(list);
        list.printlist();
        System.out.println();

        Position pos1 = list.locate(post1);
        list.insert(post4, pos1);
        list.printlist();
        System.out.println();

        Position pos4 = list.locate(post4);
        System.out.println(list.retrieve(pos4).toString());
        //System.out.println(pos1.equals(pos4));
        System.out.println();

        pos1 = list.locate(post1);
        list.delete(list.next(pos1));
        list.printlist();
        System.out.println();

        Position pos3 = list.locate(post3);
        list.delete(pos3);
        list.printlist();
        System.out.println();

        pos1 = list.locate(post1);
        list.delete(list.previous(pos1));
        list.printlist();
        System.out.println();

        list.makenull();
        list.printlist();
        System.out.println();
    }
}
