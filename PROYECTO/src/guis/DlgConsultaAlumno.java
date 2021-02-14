package guis;

import clases.*;
import arreglos.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class DlgConsultaAlumno extends JDialog implements ActionListener, KeyListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblConsultaDeAlumnos;
	private JPanel panel;
	private JLabel lblNmeroAlumno;
	private JTextField textField;
	private JButton btnConsultar_1;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	ArregloAlumno aa;
    ArregloMatricula am;
    ArregloCurso ac;
    ArregloRetiro ar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultaAlumno dialog = new DlgConsultaAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultaAlumno() {
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConsultaAlumno.class.getResource("/img/chico (1).png")));
		setTitle("Consulta l Alumnos");
		setBounds(100, 100, 632, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 51, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblConsultaDeAlumnos = new JLabel("CONSULTA DE ALUMNOS");
		lblConsultaDeAlumnos.setForeground(new Color(235, 242, 248));
		lblConsultaDeAlumnos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsultaDeAlumnos.setBounds(178, 13, 301, 25);
		contentPanel.add(lblConsultaDeAlumnos);
		
		panel = new JPanel();
		panel.setBounds(10, 47, 596, 305);
		panel.setBackground(new Color(235, 242, 248));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblNmeroAlumno = new JLabel("N\u00FAmero del Alumno:");
		lblNmeroAlumno.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNmeroAlumno.setBounds(10, 11, 126, 14);
		panel.add(lblNmeroAlumno);
		
		textField = new JTextField();
		textField.addKeyListener(this);
		textField.setBounds(148, 8, 105, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		btnConsultar_1 = new JButton("Consultar");
		btnConsultar_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultar_1.addActionListener(this);
		btnConsultar_1.setBackground(UIManager.getColor("Button.background"));
		btnConsultar_1.setBounds(481, 7, 105, 23);
		panel.add(btnConsultar_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 574, 254);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(textArea);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar_1) {
			actionPerformedButton(e);
		}
	}
	
	//BOT�N CONSULTAR
	
	protected void actionPerformedButton(ActionEvent e) {
		Alumno alumno = ArregloAlumno.buscar(Integer.parseInt(textField.getText()));
		if(alumno != null) {
			textArea.setText("");
			imprimir("******************************************************************");
			imprimir("C�digo del alumno:		" + alumno.getCodAlumno());
			imprimir("Nombres del alumno:		" + alumno.getNombres());
			imprimir("Apellidos del alumno:		" + alumno.getApellidos());
			imprimir("DNI del alumno:			" + alumno.getDni());
			imprimir("Edad del alumno:		" + alumno.getEdad());
			imprimir("Celular del alumno:		" + alumno.getCelular());
			imprimir("Estado del alumno:		" + alumno.getEstado());
			imprimir("******************************************************************");
			
			if(alumno.getEstado() == 1) {
				bucle1:
				for(int i = 0; i < ArregloCurso.tama�o(); i++) {
					for(int j = 0; j < ArregloMatricula.tama�o(); j++){
						if(ArregloCurso.obtener(i).getCodCurso() == ArregloMatricula.obtener(j).getCodCurso()) {
							imprimir("C�digo del curso es: 		" + ArregloCurso.obtener(i).getCodCurso());
							imprimir("Asignatura del curso es: 	" + ArregloCurso.obtener(i).getAsignaturas());
							imprimir("Ciclo del curso es: 		" + ArregloCurso.obtener(i).getCiclo());
							imprimir("Cr�ditos del curso son: 	" + ArregloCurso.obtener(i).getCreditos());
							imprimir("Horas del curso son: 		" + ArregloCurso.obtener(i).getHoras());
							imprimir("******************************************************************");
							break bucle1;
						}
					}
				}
			}
		}
	}
	
	//M�TODO VOID IMPRIMIR

	public void imprimir(String texto) {
		textArea.append(texto + "\n");
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == textField) {
			keyTypedTextField(arg0);
		}
	}
	protected void keyTypedTextField(KeyEvent arg0) {
		if(textField.getText().length()>=9){
			arg0.consume();
			Toolkit.getDefaultToolkit().beep();
		}
	}
	public void windowActivated(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowClosing(WindowEvent e) {
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}
	protected void windowOpenedThis(WindowEvent e) {
		aa = new ArregloAlumno();
		am = new ArregloMatricula();
		ar = new ArregloRetiro();
		ac = new ArregloCurso();
	}
}
