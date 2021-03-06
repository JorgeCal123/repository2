package modelo;

import Excepsiones.Due�oExistente;
import Excepsiones.Due�oNoEncontrado;
import Excepsiones.MascotaNoEncontrado;

public class Club {

	private Due�o primerDue�o;

	public Club() {

	}

	public void agregarDuenio(Due�o nuevo) throws Due�oExistente {
		Due�o actual = primerDue�o;
		boolean condicion = false;
		if (nuevo != null) {
			if (primerDue�o != null) {
				while (actual.getSiguiente() != null) {

					if (!actual.getCedula().equalsIgnoreCase(nuevo.getCedula())) {
						actual = actual.getSiguiente();
					} else {
						condicion = true;
						throw new Due�oExistente();
					}
				}
				if (!condicion) {
					actual.setSiguiente(nuevo);
				}
			} else {
				primerDue�o = nuevo;
			}
		}
	}

	public Due�o buscarDuenio(String b) throws Due�oNoEncontrado {
		Due�o actual = primerDue�o;
		Due�o esta = null;
		boolean encontrada = false;
		while (!encontrada && actual != null) {
			if (actual.getNombre().equalsIgnoreCase(b) || actual.getCedula().equalsIgnoreCase(b)) {
				encontrada = true;
				esta = actual;
			}
			actual = actual.getSiguiente();
		}
		if (esta == null) {
			throw new Due�oNoEncontrado();
		}

		return esta;
	}

	public void eliminarDuenio(String cedula) {
		Due�o actual = primerDue�o;
		boolean encontrada = false;
		if (actual != null) {
			while (!encontrada && actual.getSiguiente() != null) {
				if (actual.getCedula().equalsIgnoreCase(cedula)) {
					encontrada = true;
					actual.getAnterior().setSiguiente(actual.getSiguiente().getSiguiente());
				}
				actual.setAnterior(actual);
				actual = actual.getSiguiente();
			}
		}
	}

	public Due�o getPrimerDue�o() {
		return primerDue�o;
	}

	public void setPrimerDue�o(Due�o primerDue�o) {
		this.primerDue�o = primerDue�o;
	}

	public String imprimirDuenio() {
		Due�o actual = primerDue�o;
		boolean terminar = false;
		String mensaje = "";
		while (!terminar) {
			if (actual != null) {
				mensaje += "*El due�o " + actual.getNombre() + " nacio el " + actual.getFechaNacimiento()
						+ " con cedula " + actual.getCedula() + "\n";
				actual = actual.getSiguiente();
			} else {
				terminar = true;
			}

		}
		return mensaje;
	}

	public String imprimirDuenio(String f) {
		Due�o actual = primerDue�o;
		boolean terminar = false;
		String mensaje = "";

		while (!terminar) {

			if (actual.getSiguiente() == null) {
				terminar = true;
			}
			if (actual.getFechaNacimiento().equals(f)) {
				mensaje += "*El due�o " + actual.getNombre() + " nacio el " + f + "\n";
			}
			actual = actual.getSiguiente();
		}
		return mensaje;
	}

	public String imprimirTodasMascota() {
		String mensaje = "";
		Due�o actual = primerDue�o;
		boolean terminar = false;
		while (!terminar) {
			if (actual != null) {
				mensaje += "*El due�o " + actual.getNombre() + " tiene a " + actual.imprimirMascotas() + "\n";
				actual = actual.getSiguiente();
			} else {
				terminar = true;
			}
		}
		return mensaje;

	}

	public String imprimirTodasMascota(String f) {
		Due�o actual = primerDue�o;
		boolean terminar = false;
		String mensaje = "";

		while (!terminar) {

			if (actual.getSiguiente() == null) {
				terminar = true;
			} else {
				if (actual.getPrimeraMascota().getFechaNacimiento().equals(f)) {
					mensaje += "*El due�o " + actual.getNombre() + " tiene a " + actual.imprimirMascotas(f) + "\n";
				}
			}

			actual = actual.getSiguiente();
		}
		return mensaje;
	}

	public String imprimirMascotaMismoGenero(String f) {

		Due�o actual = primerDue�o;
		boolean terminar = false;
		String mensaje = "";

		while (!terminar) {

			if (actual.getSiguiente() == null) {
				terminar = true;
			} else {
				if (actual.getPrimeraMascota().getFechaNacimiento().equals(f)) {
					mensaje += "*El due�o " + actual.getNombre() + " tiene a " + actual.imprimirMascotasmismoGenero(f)
							+ "\n";
				}
			}

			actual = actual.getSiguiente();
		}
		return mensaje;
	}

	public void imprimir() {
		Due�o sig = primerDue�o;
		System.out.println(
				sig.getNombre() + " " + sig.getApellido() + " " + sig.getCedula() + " " + sig.getFechaNacimiento());
		while (sig.getSiguiente() != null) {
			sig = sig.getSiguiente();

			System.out.println(
					sig.getNombre() + " " + sig.getApellido() + " " + sig.getCedula() + " " + sig.getFechaNacimiento());
		}
	}

	public void imprimir2() {
		Due�o d1 = new Due�o("1", "j", "c", "12-1");
		Due�o d2 = new Due�o("2", "a", "b", "12-1");

		// agregarDuenio(d1);
		// agregarDuenio(d2);
	}

	public void imprimir3() throws Due�oExistente, MascotaNoEncontrado {
		Due�o d1 = new Due�o("1", "jorge", "c", "12-1");
		Due�o d2 = new Due�o("2", "ana", "b", "12-4");
		Due�o d3 = new Due�o("3", "pedro", "b", "12-1");
		Due�o d4 = new Due�o("4", "juan", "b", "12-1");

		agregarDuenio(d1);
		agregarDuenio(d2);
		agregarDuenio(d3);
		agregarDuenio(d4);

		Mascota m1 = new Mascota("lulu", "22_jul", 1, 1);
		Mascota m2 = new Mascota("jerry", "20_jul", 1, 2);
		Mascota m3 = new Mascota("matias", "26_jul", 2, 2);
		Mascota m4 = new Mascota("kar", "22_jul", 1, 2);
		Mascota m5 = new Mascota("kar 1", "25_jul", 1, 2);
		Mascota m6 = new Mascota("kar 2", "26_jul", 2, 2);
		Mascota m7 = new Mascota("kar 4", "22_jul", 1, 2);

		d1.agregarMascotaAlFinal(m1);
		d1.agregarMascotaAlFinal(m2);
		d1.agregarMascotaAlFinal(m3);
		d1.agregarMascotaAlFinal(m4);
		d2.agregarMascotaAlFinal(m5);
		d2.agregarMascotaAlFinal(m6);
		d3.agregarMascotaAlFinal(m7);

		// System.out.println(imprimirDuenio());

		System.out.println(imprimirMascotaMismoGenero("22_jul"));

	}

}