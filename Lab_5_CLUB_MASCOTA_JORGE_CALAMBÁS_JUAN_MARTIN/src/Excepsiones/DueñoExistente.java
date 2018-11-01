package Excepsiones;

public class DueñoExistente extends Exception {

	
	public DueñoExistente() {
		super("Ya existe alguien con esa misma cedula");
	}
}
