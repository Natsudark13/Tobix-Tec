package Services;

public class SingletonTraductor {
	private static Traductor instance;
	
	private SingletonTraductor() {
		
	}
	
	public static synchronized Traductor getInstance() {
		if(instance == null) {
			instance = new Traductor();
		}
		return instance;
	}
}
