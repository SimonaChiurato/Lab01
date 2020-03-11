package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Parole elenco;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnInserisci;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;
	@FXML
	private Button btnCancella;

	 @FXML
	    private TextArea txtTempi;
	@FXML
	void doInsert(ActionEvent event) {
		String parola = this.txtParola.getText();
		try {
			elenco.addParola(parola);
		} catch (Exception e) {

		}
		String risultato = "";
		for (String s : elenco.getElenco()) {
			if (risultato.equals(""))
				risultato += s;
			else
				risultato += "\n" + s;
		}
		this.txtResult.setText(risultato);
		this.txtParola.clear();
		String tempo= Long.toString(System.nanoTime());
		elenco.addTempo(tempo);
		txtTempi.setText(elenco.getTempi());
	}

	@FXML
	void doReset(ActionEvent event) {
		elenco.reset();
		this.txtResult.clear();
		String tempo= Long.toString(System.nanoTime());
		elenco.addTempo(tempo);
		txtTempi.setText(elenco.getTempi());
	}

	 @FXML
	    void doCancella(ActionEvent event) {
		 String parola = this.txtParola.getText();
		 if(elenco.getElenco().contains(parola)) {
			 elenco.remove(parola);
		 }
		 this.txtResult.clear();
		 String risultato = "";
			for (String s : elenco.getElenco()) {
				if (risultato.equals(""))
					risultato += s;
				else
					risultato += "\n" + s;
			}
			this.txtResult.setText(risultato);
			String tempo= Long.toString(System.nanoTime());
			elenco.addTempo(tempo);
			txtTempi.setText(elenco.getTempi());
	    }
	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

		elenco = new Parole();
	}
}
