import java.util.ArrayList;//importamos la libreria para las arrayList
import java.util.List; //importamos la libreria para a�adir listas

public class Cuenta {  //comienzo de la clase con lo que nos pide el enunciado
private double saldo;
private Usuario usuario;
private List<Gasto>gastos;
private List<Ingreso>ingresos;

public Cuenta(Usuario usuario) { //constructor de la clase que tomar� como argumento una variable del tipo Usuario
	this.usuario = usuario; 
	this.saldo = 0.0; //El usuario comienza con 0 euros de saldo en la cuenta
	this.gastos=new ArrayList <Gasto>(); //inicializamos las listas para poder usarlas
    this.ingresos=new ArrayList<Ingreso>();
}

public double getSaldo() { //M�todo que devuelve el saldo en la cuenta
	
	return this.saldo;
}

public void setSaldo(double saldo) {  //M�todo para a�adir saldo a la cuenta
	this.saldo = saldo;
}

public Usuario getUsuario() {  //M�todo que retorna el usuario que estamos manejando
	return usuario;
}


public void setUsuario(Usuario usuario) { //M�todo que recibe un usuario como par�metro y lo inserta en el atributo usuario
	this.usuario = usuario;
}

public double addIngresos(String descripcion, double cantidad) { //m�todo para a�adir ingresos a las listas con su cantidad y descripci�n
			ingresos.add(new Ingreso(cantidad, descripcion)); //a�adimos a la lista la instancia de Ingreso y le pasamos la descripci�n y cantidad
			
			this.saldo = this.saldo + cantidad; //Sumamos el saldo
			
			return this.getSaldo(); //retornamos el saldo de la cuenta
			
}

public double addGastos(String descripcion, double cantidad) throws GastoException  { //m�todo que a�adir� los gastos tomando como par�metro la descripci�n y la cantidad, si hay un error lanzar� la excepci�n
	 
	
	if(this.getSaldo()<cantidad) { 
		throw new GastoException(); //lanzamos la excepci�n en caso de que no haya saldo suficiente para el gasto
	}
	
	gastos.add(new Gasto (cantidad, descripcion)); //Si no salt� la excepci�n significa que hay saldo as� que a�adimos el gasto
	
	this.saldo = this.saldo - cantidad; 
	return this.getSaldo(); 
	
}

public List<Ingreso> getIngresos() { //M�todos que devuelven los ingresos y gastos de las listas
	return ingresos;
}

public List<Gasto> getGastos() {
	return gastos;
}

@Override //Indicamos que la sobreescritura del m�todo toString de la clase Object es correcta
public String toString() {
	
	return "el saldo de: " + this.getUsuario() + " es de: " +  this.getSaldo(); // retornamos el nombre del usuario de la cuenta y su saldo
}
}

