package asyncListService;

/**
 * Interface which behaves as a listener for each element of the list.
 * Its the way of communication between the item and its service instance.
 * @author iurymiguel
 *
 */
public interface IServiceListener {
	/**
	 * When the service instance notifies a change of status in the process,
	 * this callback is triggered.
	 * @param status the current status of the process.
	 */
	void onStatusChange(String status);
	
	/**
	 * Just returns a time to be a delay (Thread.sleep) in the service class.
	 * @return the time as a long.
	 */
	long onRetreiveTime();
}
