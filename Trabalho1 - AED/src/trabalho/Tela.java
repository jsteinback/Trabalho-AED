package trabalho;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Tela {

	private JFrame frame;
	private JTextField txtExpressao;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(168, 121, 131, 23);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Calculadora c = new Calculadora();

				Double resultado = (double) 0;
				try {
					resultado = c.Calcular(txtExpressao.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}

				txtResultado.setText(resultado.toString());
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnCalcular);

		txtExpressao = new JTextField();
		txtExpressao.setBounds(129, 56, 225, 20);
		frame.getContentPane().add(txtExpressao);
		txtExpressao.setColumns(10);

		JLabel lblExpresso = new JLabel("Express\u00E3o:");
		lblExpresso.setBounds(54, 59, 65, 14);
		frame.getContentPane().add(lblExpresso);

		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(54, 181, 65, 14);
		frame.getContentPane().add(lblResultado);

		txtResultado = new JTextField();
		txtResultado.setColumns(10);
		txtResultado.setBounds(129, 178, 113, 20);
		frame.getContentPane().add(txtResultado);
	}
}
