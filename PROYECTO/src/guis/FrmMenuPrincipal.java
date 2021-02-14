package guis;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import arreglos.ArregloMatricula;
import arreglos.ArregloRetiro;

public class FrmMenuPrincipal extends JFrame implements ActionListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JLabel label;
	private JMenuItem mntmAlumnos;
	private JMenuItem mntmCursos;
	private JMenuItem mntmMatrculas;
	private JMenuItem mntmRetiros;
	public ArregloAlumno arregloAlumno = new ArregloAlumno();
	public ArregloMatricula arregloMatricula = new ArregloMatricula();
	public ArregloCurso arregloCurso = new ArregloCurso();
	public ArregloRetiro arregloRetiro = new ArregloRetiro();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuPrincipal frame = new FrmMenuPrincipal();
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
	public FrmMenuPrincipal() {
		addWindowListener(this);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("REGISTRO Y MATR\u00CDCULA DE ALUMNOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMenuPrincipal.class.getResource("/img/icono-cibertec.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBounds(100, 100, 800, 600);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setIcon(null);
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/puerta-de-salida (2).png")));
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Mantenimiento");
		mnNewMenu_1.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/mantenimiento.png")));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Alumno");
		mntmNewMenuItem_1.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/chico (1).png")));
		mntmNewMenuItem_1.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Curso");
		mntmNewMenuItem_2.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/aprender-en-linea.png")));
		mntmNewMenuItem_2.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		mnNewMenu_2 = new JMenu("Registro");
		mnNewMenu_2.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/registro-en-linea.png")));
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Matr\u00EDcula");
		mntmNewMenuItem_3.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/lista.png")));
		mntmNewMenuItem_3.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Retiro");
		mntmNewMenuItem_4.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/contrato (2).png")));
		mntmNewMenuItem_4.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		mnNewMenu_3 = new JMenu("Consulta");
		mnNewMenu_3.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/consultar.png")));
		menuBar.add(mnNewMenu_3);
		
		mntmAlumnos = new JMenuItem("Alumnos");
		mntmAlumnos.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/chico (1).png")));
		mntmAlumnos.addActionListener(this);
		mnNewMenu_3.add(mntmAlumnos);
		
		mntmCursos = new JMenuItem("Cursos");
		mntmCursos.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/aprender-en-linea.png")));
		mntmCursos.addActionListener(this);
		mnNewMenu_3.add(mntmCursos);
		
		mntmMatrculas = new JMenuItem("Matr\u00EDculas");
		mntmMatrculas.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/lista.png")));
		mntmMatrculas.addActionListener(this);
		mnNewMenu_3.add(mntmMatrculas);
		
		mntmRetiros = new JMenuItem("Retiros");
		mntmRetiros.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/contrato (2).png")));
		mntmRetiros.addActionListener(this);
		mnNewMenu_3.add(mntmRetiros);
		
		mnNewMenu_4 = new JMenu("Reporte");
		mnNewMenu_4.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/inmigracion.png")));
		menuBar.add(mnNewMenu_4);
		
		mntmNewMenuItem_7 = new JMenuItem("Alumnos con matr\u00EDcula pendiente");
		mntmNewMenuItem_7.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/pendiente.png")));
		mntmNewMenuItem_7.addActionListener(this);
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		mntmNewMenuItem_8 = new JMenuItem("Alumnos con matr\u00EDcula vigente");
		mntmNewMenuItem_8.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/cheque.png")));
		mntmNewMenuItem_8.addActionListener(this);
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		mntmNewMenuItem_9 = new JMenuItem("Alumnos matr\u00EDculados por curso");
		mntmNewMenuItem_9.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/computadora.png")));
		mntmNewMenuItem_9.addActionListener(this);
		mnNewMenu_4.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Banner.jpg")));
		label.setBounds(0, -28, 1919, 1013);
		contentPane.add(label);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmRetiros) {
			actionPerformedMntmRetiros(arg0);
		}
		if (arg0.getSource() == mntmMatrculas) {
			actionPerformedMntmMatrculas(arg0);
		}
		if (arg0.getSource() == mntmCursos) {
			actionPerformedMntmCursos(arg0);
		}
		if (arg0.getSource() == mntmAlumnos) {
			actionPerformedMntmAlumnos(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem_9) {
			actionPerformedMntmNewMenuItem_9(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem_8) {
			actionPerformedMntmNewMenuItem_8(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem_7) {
			actionPerformedMntmNewMenuItem_7(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem_4) {
			actionPerformedMntmNewMenuItem_4(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem_3) {
			actionPerformedMntmNewMenuItem_3(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem_2) {
			actionPerformedMntmNewMenuItem_2(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem_1) {
			actionPerformedMntmNewMenuItem_1(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(arg0);
		}
	}
	
	protected void actionPerformedMntmNewMenuItem(ActionEvent arg0) {
		System.exit(0);
	}
	
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent arg0) {
		DlgAlumno da = new DlgAlumno();
		da.setLocationRelativeTo(this);
		da.setVisible(true);
	}
	
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent arg0) {
		DlgCurso dc = new DlgCurso();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);	
	}
	
	protected void actionPerformedMntmNewMenuItem_3(ActionEvent arg0) {
		DlgMatricula dm = new DlgMatricula();
		dm.setLocationRelativeTo(this);
		dm.setVisible(true);
	}
	
	protected void actionPerformedMntmNewMenuItem_4(ActionEvent arg0) {
		DlgRetiro dr = new DlgRetiro();
		dr.setLocationRelativeTo(this);
		dr.setVisible(true);
	}
	
	protected void actionPerformedMntmNewMenuItem_7(ActionEvent arg0) {
		DlgAlumnosMatriculaPendiente damp = new DlgAlumnosMatriculaPendiente();
		damp.setLocationRelativeTo(this);
		damp.setVisible(true);
	}
	
	protected void actionPerformedMntmNewMenuItem_8(ActionEvent arg0) {
		DlgAlumnosMatriculaVigente damv = new DlgAlumnosMatriculaVigente();
		damv.setLocationRelativeTo(this);
		damv.setVisible(true);
	}
	
	protected void actionPerformedMntmNewMenuItem_9(ActionEvent arg0) {
		DlgAlumnosMatriculadosCurso damc = new DlgAlumnosMatriculadosCurso();
		damc.setLocationRelativeTo(this);
		damc.setVisible(true);
	}
	
	protected void actionPerformedMntmAlumnos(ActionEvent arg0) {
		DlgConsultaAlumno dca = new DlgConsultaAlumno();
		dca.setLocationRelativeTo(this);
		dca.setVisible(true);
	}
	
	protected void actionPerformedMntmCursos(ActionEvent arg0) {
		DlgConsultaCurso dcc = new DlgConsultaCurso();
		dcc.setLocationRelativeTo(this);
		dcc.setVisible(true);
	}
	
	protected void actionPerformedMntmMatrculas(ActionEvent arg0) {
		DlgConsultaMatricula dcm = new DlgConsultaMatricula();
		dcm.setLocationRelativeTo(this);
		dcm.setVisible(true);
	}
	
	protected void actionPerformedMntmRetiros(ActionEvent arg0) {
		DlgConsultaRetiro dcr = new DlgConsultaRetiro();
		dcr.setLocationRelativeTo(this);
		dcr.setVisible(true);
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
	}
}
