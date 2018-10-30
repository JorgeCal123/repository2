package modelo;

public class Mascota {
	
	private Mascota siguiente;
	private Mascota anterior;

	
	private String nombre;
	private String fechaNacimiento;
	private int genero;
	private String tipo;
	
	public final int MASCULINO = 1;
	public final int FEMENINO = 2;
	
	public final int PERRO = 1;
	public final int GATO = 2;
	
	public Mascota(String nombre, String fechaNacimiento, int genero, String tipo) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Mascota getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Mascota siguiente) {
		this.siguiente = siguiente;
	}
	
	
}