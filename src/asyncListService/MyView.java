package asyncListService;

import java.util.ArrayList;

/**
 * Just an interface for Main class not having visiblity of other methods.
 * @author iurymiguel
 */
interface EntryView {
	void start();
}

/**
 * Simulates a view, show the list of objects on console.
 * @author iurymiguel
 *
 */
public class MyView implements IMyObjectListener, EntryView {

	private ArrayList<MyObject> myObjects;
	
	/**
	 * Populates the list.
	 */
	private void initList() {
		MyObject obj1 = new MyObject();
		obj1.id = 1;
		obj1.time = 10000;
		obj1.listener = this;
		obj1.name = "Objeto 1";
		obj1.status = "Ready!";
		
		MyObject obj2 = new MyObject();
		obj2.id = 2;
		obj2.time = 10000;
		obj2.listener = this;
		obj2.name = "Objeto 2";
		obj2.status = "Ready!";
		
		MyObject obj3 = new MyObject();
		obj3.id = 3;
		obj3.time = 5000;
		obj3.listener = this;
		obj3.name = "Objeto 3";
		obj3.status = "Ready!";
		
		MyObject obj4 = new MyObject();
		obj4.id = 4;
		obj4.time = 20000;
		obj4.listener = this;
		obj4.name = "Objeto 4";
		obj4.status = "Ready!";
		
		MyObject obj5 = new MyObject();
		obj5.id = 5;
		obj5.time = 1000;
		obj5.listener = this;
		obj5.name = "Objeto 5";
		obj5.status = "Ready!";
		
		myObjects.add(obj1);
		myObjects.add(obj2);
		myObjects.add(obj3);
		myObjects.add(obj4);
		myObjects.add(obj5);
	}
	
	/**
	 * Prints all objects of the list.
	 */
	private void printAllObjects() {
		myObjects.forEach((obj) -> System.out.println(obj));
	}
	
	/**
	 * Clears the console.
	 */
	private void clear() {
		for (int i = 0; i < 20; ++i) {
			System.out.println();  
		}
	}

	/**
	 * Starts the system the system.
	 */
	@Override
	public void start() {
		myObjects = new ArrayList<MyObject>();
		initList();
		printAllObjects();
		myObjects.forEach((obj) -> obj.connect());
	}

	/**
	 * This callback must be synchronized for being a resource used by several threads.
	 * Here, the values are updated and the list is shown.
	 */
	@Override
	synchronized public void onStatusChange(int id, String status) {
		myObjects.forEach((obj) -> {
			if(obj.id == id) {
				obj.status = status;
			}
		});
		clear();
		printAllObjects();
	}
}