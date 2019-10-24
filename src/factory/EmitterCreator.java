package factory;

public class EmitterCreator {
	public static final int SMS = 0;
	public static final int EMAIL = 1;
	public static final int JMS = 2;
	
	public Emitter create(int type) {
		switch(type) {
		case SMS:
			return new SMSEmitter();
		case EMAIL: 
			return new EmailEmitter();
		case JMS:
			return new JMSEmitter();
		default:
			return null;
		}
	}
}
