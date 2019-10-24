package asyncListService;

public interface IService {
	void setListener(IServiceListener listener);
	void connect();
	void read();
	void disconnect();
}

