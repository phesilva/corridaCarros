package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CarroController;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField tfVencedor;
	private JTextField tfPerdedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfVencedor = new JTextField();
		tfVencedor.setEditable(false);
		tfVencedor.setBounds(496, 115, 86, 20);
		contentPane.add(tfVencedor);
		tfVencedor.setColumns(10);
		
		tfPerdedor = new JTextField();
		tfPerdedor.setEditable(false);
		tfPerdedor.setBounds(496, 140, 86, 20);
		contentPane.add(tfPerdedor);
		tfPerdedor.setColumns(10);
		
		JLabel lblVencedor = new JLabel("Vencedor");
		lblVencedor.setBounds(423, 118, 73, 14);
		contentPane.add(lblVencedor);
		
		JLabel lblPerdedor = new JLabel("Perdedor");
		lblPerdedor.setBounds(423, 143, 73, 14);
		contentPane.add(lblPerdedor);
		
		JLabel lblCarro1 = new JLabel("Carro 1");
		lblCarro1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCarro1.setForeground(Color.BLUE);
		lblCarro1.setBounds(38, 53, 62, 14);
		contentPane.add(lblCarro1);
		
		JLabel lblCarro2 = new JLabel("Carro 2");
		lblCarro2.setForeground(Color.RED);
		lblCarro2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCarro2.setBounds(38, 78, 46, 14);
		contentPane.add(lblCarro2);
		
		
		JButton btnCorrer = new JButton("Correr");
		CarroController carroController = new CarroController(lblCarro1, lblCarro2, tfVencedor, tfPerdedor, btnCorrer);
		
		btnCorrer.setBounds(493, 262, 89, 23);
		contentPane.add(btnCorrer);
		
		JLabel lblI = new JLabel("|");
		lblI.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblI.setBounds(314, 24, 46, 80);
		contentPane.add(lblI);
		btnCorrer.addActionListener(carroController);
	}
}