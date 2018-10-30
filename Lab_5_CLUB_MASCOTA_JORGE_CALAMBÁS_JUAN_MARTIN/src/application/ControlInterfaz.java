package application;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modelo.Dueño;

public class ControlInterfaz {
	
	@FXML
	private TextField nombreMascota;
	@FXML
	private DatePicker fechaNMascota;
	@FXML
	private MenuButton generoMascota;
	@FXML
	private MenuButton tipoMascota;
	
	@FXML
	private TextField cedulaDueño;
	@FXML
	private TextField nombreDueño;
	@FXML
	private TextField apellidoDueño;
	@FXML
	private DatePicker fechaNDueño;
	
	
	@FXML
	private DatePicker fecha;
	@FXML
	private TextArea infLista;
	
	private Main m;
	
	public void initialize(){
		m=new Main();
		m.iniciarClub();
	}
	
	public void registrarDueños() {
		try {
			Dueño nuevo=new Dueño(cedulaDueño.getText(), nombreDueño.getText(), apellidoDueño.getText(), fechaNDueño.toString());
			m.darClub().agregarDueñoAlPrincipio(nuevo);
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void eliminarDueños() {
		try {
			//m.darClub().eliminarDueño(cedulaDueño.getText());
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void buscarDueño() {
		try {
			if(cedulaDueño.getText()!=null) {
				//m.darClub().buscarDueño(cedulaDueño.getText());
			}
			else if(nombreDueño.getText()!=null) {
				//m.darClub().buscarDueño(cedulaDueño.getText());
			}
			else {
				throw new  NullPointerException();
			}
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
