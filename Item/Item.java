package Item;

public class Item {

    public char[] address;
    public char[] name;

    // конструктор
    public Item() {
        this.address = null;
        this.name = null;
    }

    // конструктор
    public Item(char[] adr, char[] nm) {

        this.address = new char[30];
        this.name = new char[50];

        int i;
        for(i = 0; i < nm.length; i++) {
            this.name[i] = nm[i];
        }
        for(i = 0; i < adr.length; i++) {
            this.address[i] = adr[i];
        }
    }

    // копирующий конструктор
    public Item(Item item) { // сделать item
        this.address = new char[30];
        this.name = new char[50];

        int i;
        for(i = 0; i < item.name.length; i++) {
            this.name[i] = item.name[i];
        }
        for(i = 0; i < item.address.length; i++) {
            this.address[i] = item.address[i];
        }
    }

    // сравнение объектов
    public boolean equals(Item other) {//написать самой
        int i;
        for(i = 0; i < name.length && i < other.name.length; i++) {
            if(this.name[i] != other.name[i]) return false;
        }
        for(i = 0; i < address.length && i < other.address.length; i++) {
            if(this.address[i] != other.address[i]) return false;
        }
        return true;
    }

    // скопировать массив в другой
    public static void copyArray(char[] from, char[] to) {

        if (to.length < from.length) { throw new ArrayIndexOutOfBoundsException(); }

        int i;
        for (i = 0; i < from.length && from[i] != 0; ++i) {
            to[i] = from[i];
        }

        to[i] = 0;
    }

    // сравнить 2 массива
    public static boolean equalsArray(char[] mas1, char[] mas2) {

        if (mas1.length != mas2.length) { return false; }

        for (int i = 0; i < mas1.length; ++i) {
            if (mas1[i] != mas2[i]) { return false; }

            if (mas1[i] == 0 && mas2[i] == 0) { return true; }
        }
        return true;
    }

    // превратить в строку
    public String toString() {
        return "___Name: " + new String(name) + "; ___Address: " + new String(address);
    }
}
