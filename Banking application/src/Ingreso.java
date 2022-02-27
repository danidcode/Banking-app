
public class Ingreso extends Dinero{
	public Ingreso(double ingreso, String description) { //constructor de ingreso que recibirá un ingreso y una descripción
		
		this.setDinero(ingreso); //accedemos a los métodos setDinero y setDescription heredados de la clase Dinero
		this.setDescription(description);
	}
    
	@Override //Indicamos que la sobreescritura del método toString de la clase Object es correcta
    public String toString() { 
    	 
		return "Ingreso: " + this.description //retornamos un ingreso y su descripción
                + ", cantidad: " + this.dinero + "€" ;
     }
}
