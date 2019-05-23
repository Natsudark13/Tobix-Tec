package beans;



public class SingletonAnalizadorSentimientos {
private static AnalizadorSentimientos instance;
	
	private SingletonAnalizadorSentimientos() {
		
	}
	
	public static synchronized AnalizadorSentimientos getInstance() {
		if(instance == null) {
			instance = new AnalizadorSentimientos();
		}
		return instance;
	}
}
