
public class Gasto extends Dinero {

        public Gasto(double gasto, String description) {
        	this.setDinero(gasto); //accedemos a los m�todos setDinero y setDescription heredados de la clase Dinero
    		this.setDescription(description);
        }
         
        @Override //Indicamos que la sobreescritura del m�todo toString de la clase Object es correcta
        public String toString() {
        	
          return "Gasto:" + this.description //retornamos un gasto y su descripci�n
                    + ", cantidad: " + this.dinero + "�" ;
         }
         
}
