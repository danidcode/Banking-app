import java.util.Scanner; //importamos la librer�a necesaria para recoger datos por consola


public class Main {
	static Usuario nuevoUsuario = new Usuario(); //instanciamos la clase usuario para a�adir un nuevo usuario
	static Cuenta nuevaCuenta = new Cuenta(nuevoUsuario); //instanciamos la clase cuenta con una nueva cuenta para el nuevo usuario que creamos
	private static String nombre_usuario=""; //en estas variables almacenar� los datos del usuario para luego pasarlo a las clases
	private static int edad_usuario;
	private static String dni_usuario;
	private static Scanner entrada_escaner = new Scanner (System.in); 
    static int continua = 1; //esta variable valdr� 1 siempre que el programa continue, si el usuario decide pulsar 0 para salir, esta variable valdr� 0 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		
	solicitarUsuario(); //llamamos al metodo que creara el usuario
	
	do { //ejecutar� el menu opciones para ingresar movimientos siempre y cuando continua valga 1, si el usuario elige la opci�n de salir continua valdr� 0 y no ejecutar� m�s menuOpciones,finalizando el programa
	menuOpciones();
	} while(continua==1);
	
	}

	
	private static void solicitarUsuario(){ //m�todo que se ejecuta nada m�s comenzar el programa para a�adir un usuario
		
		do {
		System.out.println("Introduce el nombre de usuario:");
		nombre_usuario = entrada_escaner.next();
	
		}
		while(nombre_usuario.isEmpty()); //Se repetir� el bucle hasta que el usuario no deje el input en blanco
	nuevoUsuario.setNombre(nombre_usuario); //A�adimos el nombre al atributo del objeto 
	
	do {
		System.out.println("Introduce la edad del usuario:");
		edad_usuario = entrada_escaner.nextInt();
		if(edad_usuario<=0) {
			System.out.println("La edad debe ser mayor de 0 \n");
		}
	}
	
	

	while(edad_usuario<=0);
	
	nuevoUsuario.setEdad(edad_usuario); //a�adimos la edad al atributo del objeto
	
	do { 
	System.out.println("Introduce el DNI del usuario:");
	dni_usuario = entrada_escaner.next().toUpperCase(); //pasamos la letra del dni a may�sculas por si era m�nuscula con toUpperCase
	
	if(nuevoUsuario.setDNI(dni_usuario)) { //se a�ade el dni si cumple con los requisitos
		nuevoUsuario.setDNI(dni_usuario);
	}
	
	else {
		do{
		System.out.println("DNI introducido incorrecto");
		System.out.println("Introduce el DNI del usuario v�lido");
		dni_usuario = entrada_escaner.next();
		}
		while(dni_usuario.isEmpty() ||  nuevoUsuario.setDNI(dni_usuario) == false);
		
		nuevoUsuario.setDNI(dni_usuario); //Se a�ade el dni si luego de introducir una o varias veces uno inv�lido se pone uno correcto
		
		
	}

	}
	
	while(dni_usuario.isEmpty() ||  nuevoUsuario.setDNI(dni_usuario) == false);
	
	System.out.println(nuevoUsuario.toString()); //devuelvo al usuario con el m�todo toString como indica el enunciado
	System.out.println("Usuario creado correctamente");
	
	
	}
	
	 private static void menuOpciones()  { //M�todo que despliega el men� de opciones y realiza la elegida
		
		 
		System.out.println("Realiza una nueva acci�n");
		System.out.println("1 Introduce un nuevo gasto");
		System.out.println("2 Introduce un nuevo ingreso");
		System.out.println("3 Mostrar gastos");
		System.out.println("4 Mostrar ingresos");
		System.out.println("5 Mostrar saldo");
		System.out.println("0 salir");
		
		int opcionElegida = entrada_escaner.nextInt(); //almaceno en una variable la opci�n del usuario
		
		switch(opcionElegida) {
		
		case 0: //en este caso se acabar� el programa
			System.out.println("Fin del programa.");
			System.out.println("Gracias por usar la aplicaci�n");
			continua = 0;
			entrada_escaner.close();
			break;
		
		case 1: 
			String gasto_descripcion_escaner="";
			double gasto_escaner = 0;
			
			do {//bucle para que pida una descripcion si el usuario la deja vac�a
			System.out.println("Introduce la descripci�n");
		    gasto_descripcion_escaner = entrada_escaner.next();
			}while(gasto_descripcion_escaner.isEmpty());
			
			System.out.println("Introduce la cantidad");
			gasto_escaner = entrada_escaner.nextDouble();
			
		
			try { //Probar� esto para a�adir el gasto
				nuevaCuenta.addGastos(gasto_descripcion_escaner, gasto_escaner);
				System.out.println("Saldo restante: " + nuevaCuenta.getSaldo());
			}
			
			catch (GastoException error) { //si el gasto es mayor que el saldo se capturar� el error aqui y se mostrar� la excepci�n por consola
				System.out.println(error.getMessage());
			}
			break;
			
		case 2: 
			String ingreso_descripcion_escaner="";
			double ingreso_escaner=0;
			
			
			do { //bucle para que pida una descripcion si el usuario la deja vac�a
			System.out.println("Introduce la descripci�n");
		    ingreso_descripcion_escaner = entrada_escaner.next();
			}while(ingreso_descripcion_escaner.isEmpty());
			
		
			System.out.println("Introduce la cantidad");
		    ingreso_escaner = entrada_escaner.nextDouble();
		    
			
		    System.out.println("Saldo restante: " + nuevaCuenta.addIngresos(ingreso_descripcion_escaner, ingreso_escaner));
			//System.out.println(nuevaCuenta.toString());
			
		case 3:
			
			 if (nuevaCuenta.getGastos()!=null){ //si hay gastos recorrer� la lista mostrando todos los gastos con un bucle
		           
		          for(int i=0; i<nuevaCuenta.getGastos().size(); i++){
		             System.out.println(nuevaCuenta.getGastos().get(i).toString()); //usamos get para obtener los elementos de la lista y toString para devolver el contenido
		           }
		       }
		       else{ // si no hay gastos imprimiremos esto
		           System.out.println("No se han realizado gastos en la cuenta");
		       }
		    break;
		    
		case 4:
			if(nuevaCuenta.getIngresos()!=null){  //Al igual que con los gastos, si hay ingresos y no devuelve null entrar� al if y se recorrer�n todos los ingresos con el bucle
	           for(int i=0; i<nuevaCuenta.getIngresos().size();i++){
	               System.out.println (nuevaCuenta.getIngresos().get(i).toString());
	           }
	       }
	       else{ // En caso de que no haya ingresos mostramos esto por consola
	           System.out.println("No se han realizado ingresos en la cuenta");
	       }
			break;
	    
			 
		case 5:
			
			System.out.println("el saldo actual de la cuenta es: " + nuevaCuenta.getSaldo());
			
			break;
			
			default:
				System.out.println("La opci�n elegida no es correcta");
	 }
	 
	
		}
		
		
	} 

