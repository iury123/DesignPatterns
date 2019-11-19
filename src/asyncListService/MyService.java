package asyncListService;

interface IStartAsyncCallback {
	void onStartAsync() throws Exception;
}

public class MyService implements IService {

	private IServiceListener listener;
	private long time;

	/**
	 * Sets the service event listener.
	 * @param the listener.
	 */
	@Override
	public void setListener(IServiceListener listener) {
		this.listener = listener;
	}

	@Override
	public void connect() {
		startAsync(() -> {
			time = listener.onRetreiveTime();
			Thread.sleep(time);
			listener.onStatusChange("Conectando...");
			Thread.sleep(time * 2);
			listener.onStatusChange("Conectado.");
			Thread.sleep(7000);
			read();
		});
	}

	@Override
	public void read() {
		startAsync(() -> {
			listener.onStatusChange("Lendo...");
			Thread.sleep(time);
			listener.onStatusChange("Leitura Finalizada.");
			Thread.sleep(7000);
			disconnect();
		});
	}

	@Override
	public void disconnect() {
		startAsync(() -> {
			listener.onStatusChange("Desconectando...");
			Thread.sleep(3000);
			listener.onStatusChange("Desconectado.");
		});
	}

	/**
	 * Starts an async operation.
	 * @param callback the callback to be called in another thread.
	 * Its contains some operation to be executed.
	 */
	private void startAsync(IStartAsyncCallback callback) {
		new Thread(() -> {
			try {
				callback.onStartAsync();
			} catch (Exception e) {
				System.err.println(e);
			}
		}).start();
	}

}
