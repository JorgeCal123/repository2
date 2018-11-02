package modelo;

import Excepsiones.MascotaNoEncontrado;

public class Due�o {

	private Due�o siguiente;
	private Due�o anterior;
	
	private Mascota primerMascota;
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private Mascota primeraMascota;
	
	
	
	public Due�o(String cedula, String nombre, String apellido, String fechaNacimiento) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Due�o getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Due�o siguiente) {
		this.siguiente = siguiente;
	}

	public Due�o getAnterior() {
		return anterior;
	}

	public void setAnterior(Due�o anterior) {
		this.anterior = anterior;
	}

	public Mascota getPrimeraMascota() {
		return primeraMascota;
	}

	public void setPrimeraMascota(Mascota primeraMascota) {
		this.primeraMascota = primeraMascota;
	}
	
	public void agregarMascotaAlFinal(Mascota nueva) {
		Mascota actual = primeraMascota;
		boolean condicion = false;
		if(actual != null) {
			while(actual.getSiguiente() != null) {
				if(!actual.getNombre().equalsIgnoreCase(nueva.getNombre())) {
					actual = actual.getSiguiente();
				} else {
					condicion = true;
				}
				
			}
			if(!condicion) {
				actual.setSiguiente(nueva);
			} 
			
		} else {
			primeraMascota = nueva;
		}
	}
	
	public Mascota buscarMascota(String b) throws MascotaNoEncontrado{
		Mascota actual = primeraMascota;
		Mascota esta = null;
		boolean encontrada = false;
			while(!encontrada &&actual!=null) {
				if(actual.getNombre().equalsIgnoreCase(b) || actual.getFechaNacimiento().equalsIgnoreCase(b)) {
					encontrada = true;
					esta = actual;
				}
				else {
				actual = actual.getSiguiente();
				}
			}
		
		if(esta==null) {
			throw new MascotaNoEncontrado();
		}
		return esta;
	}
	
	public void eliminarMascota(String nombre) {
		Mascota actual = primeraMascota;
		Mascota anterior = null;
		boolean encontrada = false;
		if(actual != null) {
			while(!encontrada && actual.getSiguiente() != null) {
				if(actual.getNombre().equalsIgnoreCase(nombre)) {
					encontrada = true;
					anterior.setSiguiente(anterior.getSiguiente().getSiguiente());
				}
				anterior = actual;
				actual = actual.getSiguiente();
			}
		}
	}
	
	
}



