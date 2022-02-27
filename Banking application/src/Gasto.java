
public class Gasto extends Dinero {

        public Gasto(double gasto, String description) {
        	this.setDinero(gasto); //accedemos a los métodos setDinero y setDescription heredados de la clase Dinero
    		this.setDescription(description);
        }
         
        @Override //Indicamos que la sobreescritura del método toString de la clase Object es correcta
        public String toString() {
        	
          return "Gasto:" + this.description //retornamos un gasto y su descripción
                    + ", cantidad: " + this.dinero + "€" ;
         }
         
}
