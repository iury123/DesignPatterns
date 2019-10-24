package factory;

public class Main {

	public static void main(String[] args) {
		
		EmitterCreator creator = new EmitterCreator();
		
		Emitter e1 = creator.create(EmitterCreator.SMS);
		e1.send("Olá 1");
		
		Emitter e2 = creator.create(EmitterCreator.EMAIL);
		e2.send("Olá 2");
		
		Emitter e3 =  creator.create(EmitterCreator.JMS);
		e3.send("Olá 3");
	}
}


class SMSEmitter implements Emitter {

	@Override
	public void send(String message) {
		System.out.println("Sending message through SMS");
		System.out.println(message);
	}
}


class EmailEmitter implements Emitter {
	@Override
	public void send(String message) {
		System.out.println("Sending message through Email");
		System.out.println(message);
	}
}

class JMSEmitter implements Emitter {
	@Override
	public void send(String message) {
		System.out.println("Sending message through JMS");
		System.out.println(message);
	}
}