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
import javax.swing.SwingConstants;
public class GuiAda extends JFrame {
	public Libro Libro1[]= new Libro[5];
	//public Alumnos arralumno[]=new Alumnos[6];
	 int i =0;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textAutor;
	private JTextField textEditorial;
	JButton btnObjeto = new JButton("objeto");
	

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
		lblNewLabel.setBounds(39, 52, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autor:");
		lblNewLabel_1.setBounds(39, 110, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Editorial:");
		lblNewLabel_2.setBounds(39, 173, 60, 14);
		contentPane.add(lblNewLabel_2);
		JButton btnLeer = new JButton("Leer");
		JButton btnEscribir = new JButton("Escribir");
		btnEscribir.setEnabled(false);
		btnEscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cadena = textNombre.getText();
				String cadena2 = textAutor.getText();
				String cadena3 = textEditorial.getText();
				try {
					btnEscribir.setEnabled(false);
					btnLeer.setEnabled(true);
					File file = new File("Biblioteca.txt");
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(cadena);
					bw.close();
					BufferedWriter out = new BufferedWriter(new FileWriter("Archivos/Biblioteca.txt"));
					String cadena1 = textNombre.getText()+"\t"+textAutor.getText()+"\t"+textEditorial.getText()+"\n";
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
				textNombre.setText("");
				textAutor.setText("");
				textEditorial.setText("");
				//Mensaje
				JOptionPane.showMessageDialog(btnEscribir,"Se ha guardado con exito");
				
			}
		});
		btnEscribir.setBounds(241, 52, 89, 23);
		contentPane.add(btnEscribir);

		JLabel lblNewLabel_3 = new JLabel("Biblioteca");
		lblNewLabel_3.setFont(new Font("Stencil", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(163, 11, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		
		btnLeer.setEnabled(false);
		btnLeer.addActionListener(new ActionListener() {
			
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
		                JOptionPane.showMessageDialog(null, "Autor:"+ palabra1);
		                JOptionPane.showMessageDialog(null, "Editorial:"+ palabra2);
		           //yajaira guadalupe pech cupul
					}
		            scanner.close();
				}catch(IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		btnLeer.setBounds(241, 106, 89, 23);
		contentPane.add(btnLeer);
		
		textNombre = new JTextField();
		textNombre.setBounds(121, 49, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setBounds(121, 107, 86, 20);
		contentPane.add(textAutor);
		textAutor.setColumns(10);
		
		textEditorial = new JTextField();
		textEditorial.setBounds(121, 170, 86, 20);
		contentPane.add(textEditorial);
		textEditorial.setColumns(10);
		
		
		btnObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((i<6)&&(i>=0)) {
					Libro1[i]= new Libro(textNombre.getText(),textAutor.getText(),textEditorial.getText());
					i++;
					btnEscribir.setEnabled(true);
				}
				else {
					btnEscribir.setEnabled(false);
					JOptionPane.showMessageDialog(null, "No se pueden agregar mas objetos ");
				}
			}
		});
		btnObjeto.setBounds(241, 169, 89, 23);
		contentPane.add(btnObjeto);
		
		JLabel lblNewLabel_4 = new JLabel("Primero guardar en objeto para poder escribir en el documento");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 201, 429, 14);
		contentPane.add(lblNewLabel_4);
	
	} 
}
