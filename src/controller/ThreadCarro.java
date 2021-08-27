package controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ThreadCarro extends Thread {
	
	private JLabel lblCarro;
	
	private JTextField tfVencedor;
	private JTextField tfPerdedor;
	
	private JButton btnCorrer;

	private int velocidade;
	private int distanciaMaxima;
	private int distanciaPercorrida;
	private int velocidadeMaxima;
	private int arrancada;
	String placarPosicao = "";
	
	static int numeroPosicao = 0;
	
	public ThreadCarro(int velocidadeMaxima, int distanciaMaxima, JLabel lblCarro, JTextField tfVencedor, JTextField tfPerdedor,JButton btnCorrer){
		this.velocidadeMaxima = velocidadeMaxima;
		this.distanciaMaxima = distanciaMaxima;
		this.lblCarro = lblCarro;
		this.tfVencedor = tfVencedor;
		this.tfPerdedor = tfPerdedor;
		
		this.btnCorrer = btnCorrer;
	}
	
	@Override
	public void run() {
		avancar();
	}
	
	private void avancar(){
		btnCorrer.setEnabled(false);
		Rectangle posicao;
		posicao = lblCarro.getBounds();
		lblCarro.setBounds(posicao);
		
		distanciaPercorrida = 0;
		
		Random random = new Random();
		
		while(distanciaPercorrida < distanciaMaxima){
			
			velocidade = random.nextInt(velocidadeMaxima - 0 + 1) + 0;
			
			if(velocidade >= 100){
				darArrancada();
			}
			
			posicao.x += velocidade;
			distanciaPercorrida += velocidade;
			
			lblCarro.setBounds(posicao);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		
		setPlacar();
		numeroPosicao += 1;
		
		System.out.println(this.getId() + " -> " + numeroPosicao + "o lugar.\n");
		
	}
	
	public void darArrancada(){
		Random random = new Random();
		arrancada = random.nextInt(velocidadeMaxima - 0 + 1) + 0;
		velocidade += arrancada;
	}
	
	public void setPlacar(){
		if(numeroPosicao == 0){
			tfVencedor.setText(this.lblCarro.getText());
		}else{
			tfPerdedor.setText(this.lblCarro.getText());
		}
	}

}