package application;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modelo.Due�o;

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
	private TextField cedulaDue�o;
	@FXML
	private TextField nombreDue�o;
	@FXML
	private TextField apellidoDue�o;
	@FXML
	private DatePicker fechaNDue�o;
	
	
	@FXML
	private DatePicker fecha;
	@FXML
	private TextArea infLista;
	
	private Main m;
	
	public void initialize(){
		m=new Main();
		m.iniciarClub();
	}
	
	public void registrarDue�os() {
		try {
			Due�o nuevo=new Due�o(cedulaDue�o.getText(), nombreDue�o.getText(), apellidoDue�o.getText(), fechaNDue�o.toString());
			m.darClub().agregarDue�oAlPrincipio(nuevo);
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void eliminarDue�os() {
		try {
			//m.darClub().eliminarDue�o(cedulaDue�o.getText());
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void buscarDue�o() {
		try {
			if(cedulaDue�o.getText()!=null) {
				//m.darClub().buscarDue�o(cedulaDue�o.getText());
			}
			else if(nombreDue�o.getText()!=null) {
				//m.darClub().buscarDue�o(cedulaDue�o.getText());
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
