
public class Ingreso extends Dinero{
	public Ingreso(double ingreso, String description) { //constructor de ingreso que recibir� un ingreso y una descripci�n
		
		this.setDinero(ingreso); //accedemos a los m�todos setDinero y setDescription heredados de la clase Dinero
		this.setDescription(description);
	}
    
	@Override //Indicamos que la sobreescritura del m�todo toString de la clase Object es correcta
    public String toString() { 
    	 
		return "Ingreso: " + this.description //retornamos un ingreso y su descripci�n
                + ", cantidad: " + this.dinero + "�" ;
     }
}
