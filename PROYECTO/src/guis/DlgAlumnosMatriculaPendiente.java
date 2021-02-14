package guis;


import arreglos.*;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;

public class DlgAlumnosMatriculaPendiente extends JDialog implements ActionListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblAlumnosConMatrcula;
	private JButton btnProcesar;
	ArregloAlumno aa;
    ArregloMatricula am;
    ArregloCurso ac;
    ArregloRetiro ar;
    private JScrollPane scrollPane;
    private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAlumnosMatriculaPendiente dialog = new DlgAlumnosMatriculaPendiente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAlumnosMatriculaPendiente() {
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAlumnosMatriculaPendiente.class.getResource("/img/pendiente.png")));
		setTitle("Reporte | Alumnos con matr\u00EDcula pendiente");
		setBounds(100, 100, 710, 545);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 51, 102));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblAlumnosConMatrcula = new JLabel("ALUMNOS CON MATR\u00CDCULA PENDIENTE");
		lblAlumnosConMatrcula.setForeground(new Color(235, 242, 248));
		lblAlumnosConMatrcula.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAlumnosConMatrcula.setBounds(139, 11, 417, 33);
		contentPanel.add(lblAlumnosConMatrcula);
		
		btnProcesar = new JButton("PROCESAR");
		btnProcesar.addActionListener(this);
		btnProcesar.setBackground(UIManager.getColor("Button.background"));
		btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProcesar.setBounds(292, 55, 110, 25);
		contentPanel.add(btnProcesar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 674, 391);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(textArea);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	
	//BOTÓN PROCESAR

	protected void actionPerformedBtnProcesar(ActionEvent e) {
		textArea.setText("");
		
		for(int i = 0; i < ArregloAlumno.tamaño(); i++) {
			if(ArregloAlumno.obtener(i).getEstado() == 0) {
				imprimir("******************************************************************");
				imprimir("Código del alumno: 		" + ArregloAlumno.obtener(i).getCodAlumno());
				imprimir("Nombres del alumno: 		" + ArregloAlumno.obtener(i).getNombres());
				imprimir("Apellidos del alumno: 		" + ArregloAlumno.obtener(i).getApellidos());
				imprimir("DNI del alumno: 		" + ArregloAlumno.obtener(i).getDni());
				imprimir("Edad del alumno: 		" + ArregloAlumno.obtener(i).getEdad());
				imprimir("Celular del alumno: 		" + ArregloAlumno.obtener(i).getCelular());
				imprimir("******************************************************************");
				imprimir("");
			}
		}
	}
	
	//MÉTODO VOID IMPRIMIR

	public void imprimir(String texto) {
		textArea.append(texto + "\n");
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
