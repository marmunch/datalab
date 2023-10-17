package Item;

public class Item {

    private char[] address;
    private char[] name;

    // конструктор
    public Item() {
        this.address = null;
        this.name = null;
    }

    // копирующий конструктор
    public Item(Item item) { // сделать item
        this.address = new char[50];
        this.name = new char[30];

        int i;
        for(i = 0; i < 30; i++) {
            this.address[i] = item.address[i];
            this.name[i] = item.name[i];
        }
        for(i = 30; i < 50; i++) {
            this.address[i] = item.address[i];
        }
    }

    // сравнение объектов
    public boolean equals(Item other) {//написать самой
        int i;
        for(i = 0; i < 30; i++) {
            if(this.address[i] != other.address[i] && this.name[i] != other.name[i]) return false;
        }
        for(i = 30; i < 50; i++) {
            if(this.address[i] != other.address[i]) return false;
        }
        return true;
    }

    public String toString() {
        return "___Name: " + new String(name) + "; ___Address: " + new String(address);
    }
}
