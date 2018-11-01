package Excepsiones;

public class DueñoNoEncontrado extends Exception {
	public DueñoNoEncontrado() {
		super("No existe ese dueño con esa cedula");
	}
}
