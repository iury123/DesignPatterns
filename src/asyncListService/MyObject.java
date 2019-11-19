package asyncListService;

/**
 * Class which represents each item of the list
 * @author iurymiguel
 *
 */
public class MyObject implements IServiceListener {

	public int id;
	public String name;
	public String status;
	public long time;
	public IService myService;
	public IMyObjectListener listener;

	/**
	 * Initializes its own instance of the service as this object is instantiated.
	 */
	public MyObject() {
		myService = new MyService();
		myService.setListener(this);
	}

	/**
	 * Just an async operation, simulating a connection.
	 */
	public void connect() {
		myService.connect();
	}

	/**
	 * When its status changes, its variable is updated and notifies the view.
	 */
	@Override
	public void onStatusChange(String status) {
		this.status = status;
		listener.onStatusChange(id, status);
	}

	/**
	 * Just a callback to return its time to be set as a delay. 
	 */
	@Override
	public long onRetreiveTime() {
		return time;
	}
	
	@Override
	public String toString() {
		return "------------------------\n" + "ID: " + id + "\nNome: " + name + "\nStatus: " + status
				+ "\n------------------------";
	}
}
