package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CarroController implements ActionListener {
	
	private JLabel lblCarro1;
	private JLabel lblCarro2;
	private JTextField tfVencedor;
	private JTextField tfPerdedor;
	
	private JButton btnCorrer;
	
	public CarroController(JLabel lblCarro1, JLabel lblCarro2, JTextField tfVencedor, JTextField tfPerdedor, JButton btnCorrer){
		this.lblCarro1 = lblCarro1;
		this.lblCarro2 = lblCarro2;
		
		this.tfVencedor = tfVencedor;
		this.tfPerdedor = tfPerdedor;
		
		this.btnCorrer = btnCorrer;
	}
	
	private void botaoCorrer(){
		
		int velocidadeMaxima = 120;
		int distanciaMaxima = 300;
		
		Thread carro1 = new ThreadCarro(velocidadeMaxima, distanciaMaxima, lblCarro1, tfVencedor, tfPerdedor, btnCorrer);
		Thread carro2 = new ThreadCarro(velocidadeMaxima, distanciaMaxima, lblCarro2, tfVencedor, tfPerdedor, btnCorrer);
		carro1.start();
		carro2.start();
	}
		

	@Override
	public void actionPerformed(ActionEvent arg0) {
		botaoCorrer();
	}

}