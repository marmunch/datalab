import List.ATD;
import List.ATD.Position;
public class Main {

	public static void deleteDuplicates() {
		ATD L;
		Position p, q;
		p = L.first();
		while(p != L.end()) {
			q = L.next(p);
			while(q != L.end()) {
				if(/*сравнение*/)
					L.delete(q);
				else q = L.next(q);
			}
			p = L.next(p);
		}
	}
	
    public static void main(String[] args) {
    	
    	char[] name = new char[30];
    	char[] address = new char[50];
    }
}
