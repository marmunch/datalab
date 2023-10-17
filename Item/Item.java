package Item;
public class Item {
    	
    	private char[] address;
    	private char[] name;

    	Item() {
    		this.address = null;
    		this.name = null;
    	}
    	
    	Item(char[] address, char[] name) {
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
    	
    	public boolean equals(Item other) {
    		if(this.address.equals(other.address) && this.name.equals(other.name)) return true;
    		else return false;
    	}
    }
