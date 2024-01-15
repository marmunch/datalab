import Item.Item;
import DLL.*;
import Map.*;

public class Main {

    public static void deleteDuplicates(ATD L) {

        Position p, q;
        p = L.first();
        while(!p.equal(L.end())) {
            q = L.next(p);
            //p.print();
            //System.out.println();
            //int i = 0;
            while(!q.equal(L.end())) {
                //if(i==5) break;
                //System.out.println(!q.equal(L.end()));
                //L.end().print();
                //q.print();
                if(L.retrieve(p).equals(L.retrieve(q))) {
                    Item x = L.retrieve(q);
                    L.delete(q);
                    //L.printlist();
                    q = L.locate(x);
                    //System.out.println("YES");
                    //q = L.previous(q);
                }
                q = L.next(q);
                //i++;
            }
            p = L.next(p);
            //break;
        }
    }
    public static void main(String[] args) {

        ATD list = new ATD();

        char[] adr1 = {'S', 'a', 'i', 'n', 't', '-', 'P', 'e', 't', 'e', 'r', 's', 'b', 'u', 'r', 'g'};
        char[] nm1 = {'A', 'l', 'e', 'x', 'a', 'n', 'd', 'e', 'r'};
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

        // вставка в пустой список
        System.out.println("вставка в пустой список");
        list.insert(post1, list.end());
        list.printlist();

        // заполнение дубликатами
        System.out.println("заполнение дубликатами");
        list.insert(post3, list.end());
        //list.printlist();
        list.insert(post2, list.end());
        list.insert(post2, list.end());
        //list.printlist();
        list.insert(post3, list.end());
        //list.printlist();
        list.insert(post1, list.end());
        list.printlist();
/*
        // вставка в конец
        System.out.println("вставка в конец");
        list.insert(post2, list.end());
        list.printlist();

        // вставка в начало
        System.out.println("вставка в начало");
        list.insert(post3, list.first());
        list.printlist();*/

        // удаление дупликатов
        System.out.println("удаление дупликатов");
        deleteDuplicates(list);
        System.out.println();
        list.printlist();
/*
        // вставка в позицию объекта
        System.out.println("вставка в позицию объекта");
        Position pos1 = list.locate(post1);
        list.insert(post4, pos1);
        list.printlist();
        //System.out.println(list.retrieve(list.next(list.first())));

        // вытащить элемент по позиции
        System.out.println("вытащить элемент по позиции");
        Position pos4 = list.locate(post4);
        System.out.println(list.retrieve(pos4));
        //System.out.println(pos1.equals(pos4));
        System.out.println();

        // удалить следующий от позиции
        System.out.println("удалить следующий от позиции");
        pos1 = list.locate(post1);
        //list.next(pos1).print();
        list.delete(list.next(pos1));
        list.printlist();

        // удалить в позиции
        System.out.println("удалить в позиции");
        Position pos3 = list.locate(post3);
        list.delete(pos3);
        list.printlist();

        // удаление предыдущего
        System.out.println("удаление предыдущего");
        pos1 = list.locate(post1);
        list.previous(pos1).print();
        list.delete(list.previous(pos1));
        list.printlist();

        // сделать список пустым
        System.out.println("сделать список пустым");
        list.makenull();
        list.printlist();*/

        //стек
/*        Mass S1 = new Mass();

        System.out.println("на массиве");
        S1.push(post1);
        S1.push(post2);
        System.out.println(S1.empty());
        System.out.println(S1.pop());
        System.out.println(S1.top());
        S1.makenull();
        System.out.println(S1.empty());
        System.out.println();

        List S2 = new List();

        System.out.println("на списке");
        S2.push(post1);
        S2.push(post2);
        System.out.println(S2.empty());
        System.out.println(S2.pop());
        System.out.println(S2.top());
        S2.makenull();
        System.out.println(S2.empty());
        System.out.println();

        ADT S3 = new ADT();

        System.out.println("на атд");
        System.out.println(S3.empty());
        S3.push(post1);
        S3.push(post2);
        System.out.println(S3.empty());
        System.out.println(S3.pop());
        System.out.println(S3.top());
        S3.makenull();
        System.out.println(S3.empty());
        System.out.println();*/
       /*
        //очередь
        Mass Q1 = new Mass();

        System.out.println("на массиве");
        Q1.enqueue(post1);
        Q1.enqueue(post2);
        System.out.println(Q1.empty());
        System.out.println(Q1.dequeue());
        System.out.println(Q1.front());
        Q1.makenull();
        System.out.println(Q1.empty());
        System.out.println();

        List Q2 = new List();

        System.out.println("на списке");
        Q2.enqueue(post1);
        Q2.enqueue(post2);
        System.out.println(Q2.empty());
        System.out.println(Q2.dequeue());
        System.out.println(Q2.front());
        Q2.makenull();
        System.out.println(Q2.empty());
        System.out.println();

        ADT Q3 = new ADT();

        System.out.println("на атд");
        Q3.enqueue(post1);
        Q3.enqueue(post2);
        System.out.println(Q3.empty());
        System.out.println(Q3.dequeue());
        System.out.println(Q3.front());
        Q3.makenull();
        System.out.println(Q3.empty());
        System.out.println();*/
/*
        // отображение
        List M1 = new List();

        System.out.println("на списке");
        M1.assign(post1.address, post1.name);
        M1.assign(post2.address, post2.name);
        System.out.println(M1.compute(post1.address, post1.name));
        System.out.println(M1.compute(post3.address, post1.name));

        ADT M2 = new ADT();

        System.out.println("на атд");
        M2.assign(post1.address, post1.name);
        M2.assign(post2.address, post2.name);
        System.out.println(M2.compute(post1.address, post1.name));
        System.out.println(M2.compute(post3.address, post1.name));*/
    }
}
