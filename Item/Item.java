package Item;

public class Item {

    private char[] address;
    private char[] name;

    // конструктор
    Item() {
        this.address = null;
        this.name = null;
    }

    // копирующий конструктор
    public Item(char[] address, char[] name) {
        this.address = new char[50];
        this.name = new char[30];

        int i;
        for(i = 0; i < 30; i++) {
            this.address[i] = address[i];
            this.name[i] = name[i];
        }
        for(i = 30; i < 50; i++) {
            this.address[i] = address[i];
        }
    }

    // сравнение объектов
    public boolean equals(Item other) {
        if(this.address.equals(other.address) && this.name.equals(other.name)) return true;
        else return false;
    }
}
