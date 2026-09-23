package modelo;

public class Ciudadano {
    // CREACIÓN DE ATRIBUTOS DE LA CLASE
    private String nombre;
    private String curp;
    private String telefono;

    // CREACIÓN DEL CONSTRUCTOS DE LA CLASE
    public Ciudadano (String nombre, String curp, String telefono) {
        this.nombre = nombre;
        this.curp = curp;
        this.telefono = telefono;
    }

    // MÉTODO PARA MOSTRAR LA INFORMACIÓN DEL CIUDADANO
    public void mostrarInfo() {
        System.out.println("\n	-> Ciudadano: " + nombre + "\n	-> CURP: " + curp + "\n	-> Teléfono: " + telefono);
    }

    // CREACIÓN DE LOS METODOS GETTERS DE LOS ATRIBUTOS
    public String getNombre() { 
		return nombre; 
	}

    public String getCurp() { 
		return curp; 
	}

	public String getTelefono() { 
		return telefono; 
	}
}