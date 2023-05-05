import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
public class GuiAda extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiAda frame = new GuiAda();
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
	public GuiAda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(53, 52, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autor:");
		lblNewLabel_1.setBounds(53, 110, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Editorial:");
		lblNewLabel_2.setBounds(53, 173, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Escribir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cadena = textField.getText();
				String cadena2 = textField_1.getText();
				String cadena3 = textField_2.getText();
				try {
					File file = new File("Biblioteca.txt");
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(cadena);
					bw.close();
					BufferedWriter out = new BufferedWriter(new FileWriter("Archivos/Biblioteca.txt"));
					String cadena1 = textField.getText()+"\t"+textField_1.getText()+"\t"+textField_2.getText()+"\n";
					//Escribimos una linea caracter por caracter
					for(int i=0;i<cadena1.length();i++) {
						out.write(cadena1.charAt(i));
					}
					
					//out.newLine();
					//out.write(cadena);
					
					out.close();
					
				} catch(IOException excepcion) {
					System.out.println(excepcion.getMessage());
					excepcion.printStackTrace();
				}
				//Borrado
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				//Mensaje
				JOptionPane.showMessageDialog(btnNewButton,"Se ha guardado con exito");
				
			}
		});
		btnNewButton.setBounds(241, 52, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Biblioteca");
		lblNewLabel_3.setFont(new Font("Stencil", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(163, 11, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Leer");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader in = new BufferedReader(new FileReader("Archivos/Biblioteca.txt"));
					String linea = in.readLine();
					//JOptionPane.showMessageDialog(null, linea);
					Scanner scanner = new Scanner(linea);
					scanner.useDelimiter("[,\\s]+"); // delimitador de coma y espacios en blanco
		            while (scanner.hasNext()) {
		                String palabra = scanner.next();
		                String palabra1 = scanner.next();
		                String palabra2 = scanner.next();
		                JOptionPane.showMessageDialog(null, "Nombre del libro:" + palabra );
		                JOptionPane.showMessageDialog(null,  "Autor:"+ palabra1);
		                JOptionPane.showMessageDialog(null,  "Editorial:"+ palabra2);
		           
					}
		            scanner.close();
				}catch(IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		btnNewButton_1.setBounds(241, 106, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(121, 49, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 107, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(121, 170, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("obj");
		btnNewButton_2.setBounds(241, 169, 89, 23);
		contentPane.add(btnNewButton_2);
	
	} 
}
