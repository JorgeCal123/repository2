package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Club;
import modelo.Dueño;

class ClubTest {

	private Dueño a,b,c,d,e;
	private Club cm;
	
	@BeforeEach
	void setUp() {
		cm = new Club();
	}
	
	@BeforeEach
	void setUp2() {
		setUp();
		a = new Dueño("321", "Andres", "Gomez", "2014-06-20");
		b = new Dueño("5566", "Mateo", "Garcia", "2006-11-10");
		c = new Dueño("5451", "Adrian", "Sanchez", "2018-10-20");
		d = new Dueño("9845", "Carlos", "Bacca", "1997-09-17");
		cm.setPrimerDueño(a);
		b.setAnterior(a);
		a.setSiguiente(b);
		c.setAnterior(b);
		b.setSiguiente(c);
		d.setAnterior(c);
		c.setSiguiente(d);
		
	}

	@Test
	void testAgregarDuenio() {
		try {
			setUp();
			e = new Dueño("4515", "Mario", "Rendon", "2013-07-06");
			cm.agregarDuenio(e);
			assertTrue(cm.getPrimerDueño() == e);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testAgregarDuenioFallo() {
		try {
			setUp();
			e = null;
			cm.agregarDuenio(e);
			assertFalse(cm.getPrimerDueño() != null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testBuscarDuenio() {
		try {
			setUp2();
			assertTrue(cm.buscarDuenio("Mateo") == cm.getPrimerDueño().getSiguiente());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	@Test
	void eliminarDuenio() {
		try {
			setUp2();
			cm.eliminarDuenio("321");
			assertTrue(cm.getPrimerDueño() == b);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
