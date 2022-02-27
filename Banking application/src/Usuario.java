import java.util.regex.Pattern; //importamos la librería para poder validar el dni

public class Usuario {
	
private String nombre; //atributos de la clase que se irán rellenando cuando se cree la cuenta
private int edad;
private String DNI;

public Usuario() {}


public String getNombre() { //método para obtener el nombre del usuario
	
	return this.nombre;
}

public void setNombre(String nombre) { //método para añadir nombre al usuario
	
	this.nombre = nombre;
	
}

public int getEdad() { //método para obtener la edad del usuario
	return this.edad;
}

public void setEdad(int edad) { //método para añadir la edad del usuario
	
	this.edad= edad;
}

public String getDNI() { //método para obtener el DNI
	return this.DNI;
}

public boolean setDNI(String DNI) { //método que devuelve true si el dni introducido es correcto y false si no lo es
	String regex = "^[0-9]{8}-?[a-zA-Z]{1}$"; //El patrón de caracteres que debe cumplir para que el dni sea correcto
    Pattern pattern = Pattern.compile(regex); 
    if(pattern.matcher(DNI).matches()) {
    	this.DNI = DNI;	//añadimos el DNI en caso de que sea correcto, esto lo hace un método setter y getter al mismo tiempo
    }
    return pattern.matcher(DNI).matches();
}

@Override //Indicamos que la sobreescritura del método toString de la clase Object es correcta

public String toString() { //método que devuelve el usuario creado con sus datos
	return "Nombre: " + getNombre() + ",\n " + 
           "DNI: " + getDNI() + ",\n " +
           "Edad: " + getEdad() ;
}
}

