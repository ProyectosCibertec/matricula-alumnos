package guis;

import arreglos.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Toolkit;
import clases.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class DlgConsultaMatricula extends JDialog implements ActionListener, KeyListener, WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton button;
	ArregloAlumno aa;
    ArregloMatricula am;
    ArregloCurso ac;
    ArregloRetiro ar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultaMatricula dialog = new DlgConsultaMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultaMatricula() {
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConsultaMatricula.class.getResource("/img/lista.png")));
		setTitle("Consulta | Matr\u00EDculas");
		getContentPane().setBackground(new Color(0, 51, 102));
		setBounds(100, 100, 634, 392);
		getContentPane().setLayout(null);
		{
			JLabel label = new JLabel("CONSULTA DE MATR\u00CDCULAS");
			label.setForeground(new Color(235, 242, 248));
			label.setFont(new Font("Tahoma", Font.BOLD, 20));
			label.setBounds(163, 9, 301, 25);
			getContentPane().add(label);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(10, 47, 596, 285);
			panel.setBackground(new Color(235, 242, 248));
			getContentPane().add(panel);
			{
				JLabel label = new JLabel("N\u00FAmero Matr\u00EDcula:");
				label.setFont(new Font("Tahoma", Font.ITALIC, 13));
				label.setBounds(10, 11, 116, 14);
				panel.add(label);
			}
			{
				textField = new JTextField();
				textField.addKeyListener(this);
				textField.setColumns(10);
				textField.setBounds(138, 8, 107, 20);
				panel.add(textField);
			}
			{
				button = new JButton("Consultar");
				button.addActionListener(this);
				button.setFont(new Font("Tahoma", Font.BOLD, 13));
				button.setBackground(UIManager.getColor("Button.background"));
				button.setBounds(470, 7, 116, 23);
				panel.add(button);
			}
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 40, 574, 232);
			panel.add(scrollPane);
			
			textArea = new JTextArea();
			textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
			scrollPane.setViewportView(textArea);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			actionPerformedButton(e);
		}
	}
	
	//BOT�N CONSULTAR

	protected void actionPerformedButton(ActionEvent e) {
		Matricula matricula = ArregloMatricula.buscar(Integer.parseInt(textField.getText()));
		if(matricula != null) {
			textArea.setText("");
			imprimir("******************************************************************");
			imprimir("C�digo del alumno es: 		" + ArregloAlumno.buscar(matricula.getCodAlumno()).getCodAlumno());
			imprimir("Nombres del alumno son: 	" + ArregloAlumno.buscar(matricula.getCodAlumno()).getNombres());
			imprimir("Apellidos del alumno son: 	" + ArregloAlumno.buscar(matricula.getCodAlumno()).getApellidos());
			imprimir("DNI del alumno es: 		" + ArregloAlumno.buscar(matricula.getCodAlumno()).getDni());
			imprimir("Celular del alumno es: 		" + ArregloAlumno.buscar(matricula.getCodAlumno()).getCelular());
			imprimir("Edad del alumno es: 		" + ArregloAlumno.buscar(matricula.getCodAlumno()).getEdad());
			imprimir("Estado del alumno es: 		" + ArregloAlumno.buscar(matricula.getCodAlumno()).getEstado());
			imprimir("------------------------------------------------------------------");
			imprimir("C�digo del curso es: 		" + ArregloCurso.buscar(matricula.getCodCurso()).getCodCurso());
			imprimir("Asignatura del curso es: 	" + ArregloCurso.buscar(matricula.getCodCurso()).getAsignaturas());
			imprimir("Ciclo del curso es: 		" + ArregloCurso.buscar(matricula.getCodCurso()).getCiclo());
			imprimir("Cr�ditos del curso son: 	" + ArregloCurso.buscar(matricula.getCodCurso()).getCreditos());
			imprimir("Horas del curso son: 		" + ArregloCurso.buscar(matricula.getCodCurso()).getHoras());
			imprimir("******************************************************************");
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
		if(textField.getText().length()>=6){
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
