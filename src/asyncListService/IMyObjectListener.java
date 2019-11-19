package asyncListService;

/**
 * Interface which must be implemented by the view in order to receive the updates.
 * @author iurymiguel
 *
 */
public interface IMyObjectListener {
	/**
	 * When the status of some item of the list changes, this callback is triggered.
	 * @param id the id of the item of the list.
	 * @param status the current status of this item.
	 */
	void onStatusChange(int id, String status);
}
