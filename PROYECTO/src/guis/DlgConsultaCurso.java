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

public class DlgConsultaCurso extends JDialog implements ActionListener, KeyListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblConsultaDeCursos;
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
			DlgConsultaCurso dialog = new DlgConsultaCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultaCurso() {
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConsultaCurso.class.getResource("/img/aprender-en-linea.png")));
		setTitle("Consulta l Cursos");
		setBounds(100, 100, 632, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 51, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblConsultaDeCursos = new JLabel("CONSULTA DE CURSOS");
		lblConsultaDeCursos.setForeground(new Color(235, 242, 248));
		lblConsultaDeCursos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsultaDeCursos.setBounds(178, 13, 301, 25);
		contentPanel.add(lblConsultaDeCursos);
		
		panel = new JPanel();
		panel.setBounds(10, 47, 596, 305);
		panel.setBackground(new Color(235, 242, 248));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblNmeroAlumno = new JLabel("C\u00F3digo del Curso:");
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
	protected void actionPerformedButton(ActionEvent e) {
		Curso curso = ArregloCurso.buscar(Integer.parseInt(textField.getText()));
		if(curso != null) {
			textArea.setText("");
			imprimir("******************************************************************");
			imprimir("C�digo del curso: 		" + curso.getCodCurso());
			imprimir("Nombres de la asignatura: 	" + curso.getAsignaturas());
			imprimir("Ciclo del curso: 		" + curso.getCiclo());
			imprimir("Cr�ditos del curso: 		" + curso.getCreditos());
			imprimir("Horas del curso: 		" + curso.getHoras());
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
		if(textField.getText().length()>=4){
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
