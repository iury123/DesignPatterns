package asyncListService;

public interface IServiceListener {
	void onStatusChange(String status);
	long onRetreiveTime();
}
