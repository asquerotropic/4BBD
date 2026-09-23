package modelo;

public class Requisito {
    private String nombreDocumento;
    private boolean fueEntregado;

    public Requisito (String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
        this.fueEntregado = false;
    }

    public void marcarComoEntregado() {
        this.fueEntregado = true;
        System.out.println("\n	-> Los documentos [" + nombreDocumento + "] han sido cargados.");
    }

    public boolean getFueEntregado() { 
		return fueEntregado; 
	}

    public String getNombreDocumento() { 
		return nombreDocumento; 
	}
}