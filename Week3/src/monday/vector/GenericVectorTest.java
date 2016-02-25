package monday.vector;

import java.util.List;
import java.util.ListIterator;


public class GenericVectorTest {

	public static void main(String[] args) {
		GenericVector<Integer> gv = new GenericVector<>(10);
		gv.add(1);
		gv.add(2);
		gv.add(5);
		gv.add(2);
		gv.add(2);
		System.out.println(gv);
		gv.add(2, 100);
		//System.out.println(gv.indexOf(5));
		//gv.remove(2);
//		System.out.println(gv.isEmpty());
//		System.out.println(gv.lastIndexOf(3));
		//gv.clear();
		System.out.println(gv);
		List<Integer> l = gv.subList(2, 4);
		System.out.println(l.toString());
//		Object[] arr =  gv.toArray();
//		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < 10; i++) {
			gv.add(i);
		}
		System.out.println("ListIterator");
		ListIterator<Integer> it = gv.listIterator();
		while (it.hasNext()) {
			int i = (Integer) it.next();
//			if (i == 100) {
//				it.remove();
//			}
			//it.remove();
			System.out.println(i);
			
		}
		while (it.previousIndex() > 1) {
			int i = (Integer) it.previous();
			if (i == 100) {
				it.set(200);
			}
			System.out.print(i+", ");
		}
		System.out.println(it.previous());
		while (it.hasNext()) {
			int i = (Integer) it.next();
			//it.remove();
			System.out.println(i);
			
		}
		System.out.println(gv.removeAll(gv));
	}
	
}
