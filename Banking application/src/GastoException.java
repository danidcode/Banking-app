
public class GastoException extends Exception {

	public GastoException() { 
		//con super hago que al lanzar esta excepción se ejecute el constructor de su clase padre (Exception) con el valor del mensaje que le puse
		super("El saldo de la cuenta es insuficiente para realizar el gasto");
	}
		
		
	
		
		
	
}
