package asyncListService;
/**
 * Just an interface to define the operations of a service.
 * @author iurymiguel
 *
 */
public interface IService {
	
	/**
	 * Sets a listener which will be listening to events which happens in the service class.
	 * @param listener the listener instance.
	 */
	void setListener(IServiceListener listener);
	
	/**
	 * Just an async operation, simulating a connection.
	 * @param the id of a item of the list.
	 */
	void connect(int itemId);
	
	/**
	 * Just an async operation, simulating a reading.
	 */
	void read();
	
	/**
	 * Just an async operation, simulating a disconnection.
	 */
	void disconnect();
}

