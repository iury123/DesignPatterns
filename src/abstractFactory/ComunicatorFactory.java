package abstractFactory;

import factory.Emitter;

public interface ComunicatorFactory {
	Emitter createEmitter();
	Receptor createReceptor();
}

