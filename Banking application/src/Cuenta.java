import java.util.ArrayList;//importamos la libreria para las arrayList
import java.util.List; //importamos la libreria para añadir listas

public class Cuenta {  //comienzo de la clase con lo que nos pide el enunciado
private double saldo;
private Usuario usuario;
private List<Gasto>gastos;
private List<Ingreso>ingresos;

public Cuenta(Usuario usuario) { //constructor de la clase que tomará como argumento una variable del tipo Usuario
	this.usuario = usuario; 
	this.saldo = 0.0; //El usuario comienza con 0 euros de saldo en la cuenta
	this.gastos=new ArrayList <Gasto>(); //inicializamos las listas para poder usarlas
    this.ingresos=new ArrayList<Ingreso>();
}

public double getSaldo() { //Método que devuelve el saldo en la cuenta
	
	return this.saldo;
}

public void setSaldo(double saldo) {  //Método para añadir saldo a la cuenta
	this.saldo = saldo;
}

public Usuario getUsuario() {  //Método que retorna el usuario que estamos manejando
	return usuario;
}


public void setUsuario(Usuario usuario) { //Método que recibe un usuario como parámetro y lo inserta en el atributo usuario
	this.usuario = usuario;
}

public double addIngresos(String descripcion, double cantidad) { //método para añadir ingresos a las listas con su cantidad y descripción
			ingresos.add(new Ingreso(cantidad, descripcion)); //añadimos a la lista la instancia de Ingreso y le pasamos la descripción y cantidad
			
			this.saldo = this.saldo + cantidad; //Sumamos el saldo
			
			return this.getSaldo(); //retornamos el saldo de la cuenta
			
}

public double addGastos(String descripcion, double cantidad) throws GastoException  { //método que añadirá los gastos tomando como parámetro la descripción y la cantidad, si hay un error lanzará la excepción
	 
	
	if(this.getSaldo()<cantidad) { 
		throw new GastoException(); //lanzamos la excepción en caso de que no haya saldo suficiente para el gasto
	}
	
	gastos.add(new Gasto (cantidad, descripcion)); //Si no saltó la excepción significa que hay saldo así que añadimos el gasto
	
	this.saldo = this.saldo - cantidad; 
	return this.getSaldo(); 
	
}

public List<Ingreso> getIngresos() { //Métodos que devuelven los ingresos y gastos de las listas
	return ingresos;
}

public List<Gasto> getGastos() {
	return gastos;
}

@Override //Indicamos que la sobreescritura del método toString de la clase Object es correcta
public String toString() {
	
	return "el saldo de: " + this.getUsuario() + " es de: " +  this.getSaldo(); // retornamos el nombre del usuario de la cuenta y su saldo
}
}

