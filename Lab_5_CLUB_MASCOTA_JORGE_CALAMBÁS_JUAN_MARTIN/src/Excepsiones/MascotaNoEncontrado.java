package Excepsiones;

public class MascotaNoEncontrado extends Exception {

	public MascotaNoEncontrado() {
		super("La mascota no se encuentra");
	}
}
