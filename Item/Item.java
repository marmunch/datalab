package Item;

public class Item {

    private char[] address;
    private char[] name;

    // конструктор
    public Item() {
        this.address = null;
        this.name = null;
    }

    // конструктор
    public Item(char[] adr, char[] nm) {

        this.address = new char[adr.length];
        this.name = new char[nm.length];

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
        this.address = new char[item.address.length];
        this.name = new char[item.name.length];

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

    // превратить в строку
    public String toString() {
        return "___Name: " + new String(name) + "; ___Address: " + new String(address);
    }
}
