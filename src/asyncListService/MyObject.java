package asyncListService;

public class MyObject implements IServiceListener {

	public int id;
	public String name;
	public String status;
	public long time;
	public IService myService;
	public IMyObjectListener listener;

	public MyObject() {
		myService = new MyService();
		myService.setListener(this);
	}

	public void connect() {
		myService.connect();
	}

	@Override
	public String toString() {
		return "------------------------\n" + "ID: " + id + "\nNome: " + name + "\nStatus: " + status
				+ "\n------------------------";
	}

	@Override
	public void onStatusChange(String status) {
		listener.onStatusChange(id, status);
	}

	@Override
	public long onRetreiveTime() {
		return time;
	}
}
