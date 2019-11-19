package asyncListService;
/**
 * Just an interface to define the operations of a service.
 * @author iurymiguel
 *
 */
public interface IService {
	
	/**
	 * Sets a listener which will be listening to events in the service class.
	 * @param listener the listener object.
	 */
	void setListener(IServiceListener listener);
	
	/**
	 * Just an async operation, simulating a connection.
	 */
	void connect();
	
	/**
	 * Just an async operation, simulating a reading.
	 */
	void read();
	
	/**
	 * Just an async operation, simulating a disconnection.
	 */
	void disconnect();
}

