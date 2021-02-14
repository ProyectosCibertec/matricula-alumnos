package guis;

import excepciones.ExcepcionAdicionar;
import clases.Alumno;
import arreglos. * ;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgAlumno extends JDialog implements ActionListener,
WindowListener, KeyListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JLabel label_2;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel panel;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox<?> comboBox;
	private JButton btnBuscar;
	private JButton btnAceptar;
	ArregloAlumno aa;
    ArregloMatricula am;
    ArregloCurso ac;
    ArregloRetiro ar;
	int tipoOperacion;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;

	/**
     * Launch the application.
     */
	public static void main(String[] args) {
		try {
			DlgAlumno dialog = new DlgAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * CREANDO DI�LOGO
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DlgAlumno() {
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAlumno.class.getResource("/img/chico (1).png")));
		getContentPane().setBackground(new Color(0, 51, 102));
		getContentPane().setLayout(null);

		label = new JLabel("MANTENIMIENTO DE ALUMNOS");
		label.setForeground(new Color(235, 242, 248));
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(474, 11, 344, 34);
		getContentPane().add(label);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(this);
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBackground(UIManager.getColor("Button.background"));
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdicionar.setBounds(356, 58, 172, 25);
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(this);
		btnConsultar.addActionListener(this);
		btnConsultar.setBackground(UIManager.getColor("Button.background"));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultar.setBounds(356, 101, 172, 25);
		getContentPane().add(btnConsultar);

		label_2 = new JLabel("");
		label_2.setBounds(379, 139, 136, 113);
		getContentPane().add(label_2);

		btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(this);
		btnModificar.addActionListener(this);
		btnModificar.setBackground(UIManager.getColor("Button.background"));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModificar.setBounds(356, 273, 172, 25);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(this);
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(UIManager.getColor("Button.background"));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(356, 311, 172, 25);
		getContentPane().add(btnEliminar);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(235, 242, 248));
		panel.setBounds(10, 58, 334, 278);
		getContentPane().add(panel);

		label_3 = new JLabel("C\u00F3digo:");
		label_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_3.setBounds(12, 13, 56, 22);
		panel.add(label_3);

		label_4 = new JLabel("Nombres:");
		label_4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_4.setBounds(12, 48, 73, 28);
		panel.add(label_4);

		label_5 = new JLabel("Apellidos:");
		label_5.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_5.setBounds(12, 89, 73, 25);
		panel.add(label_5);

		label_6 = new JLabel("DNI:");
		label_6.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_6.setBounds(12, 127, 56, 27);
		panel.add(label_6);

		label_7 = new JLabel("Edad:");
		label_7.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_7.setBounds(12, 169, 56, 16);
		panel.add(label_7);

		label_8 = new JLabel("Celular:");
		label_8.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_8.setBounds(12, 209, 56, 16);
		panel.add(label_8);

		label_9 = new JLabel("Estado:");
		label_9.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_9.setBounds(12, 249, 56, 16);
		panel.add(label_9);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.addKeyListener(this);
		textField.setColumns(10);
		textField.setBounds(85, 13, 126, 25);
		panel.add(textField);

		textField_1 = new JTextField();
		textField_1.addKeyListener(this);
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(85, 52, 235, 25);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.addKeyListener(this);
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(85, 91, 235, 25);
		panel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.addKeyListener(this);
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(85, 130, 126, 25);
		panel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.addKeyListener(this);
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(85, 165, 126, 25);
		panel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.addKeyListener(this);
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(85, 207, 126, 25);
		panel.add(textField_5);

		comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setBackground(UIManager.getColor("Button.background"));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
			"Registrado",
			"Matriculado",
			"Retirado"
		}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBounds(85, 245, 126, 24);
		panel.add(comboBox);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(this);
		btnBuscar.setBackground(UIManager.getColor("Button.background"));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBuscar.setBounds(223, 13, 97, 25);
		panel.add(btnBuscar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		btnAceptar.setBackground(UIManager.getColor("Button.background"));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAceptar.setBounds(223, 246, 97, 25);
		panel.add(btnAceptar);
		setTitle("Mantenimiento | Alumno");
		setBounds(100, 100, 1311, 394);

		label = new JLabel("");
		label.setIcon(new ImageIcon(DlgAlumno.class.getResource("/img/logo-cibertec.png")));
		label.setBounds(381, 141, 136, 113);
		getContentPane().add(label);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(541, 56, 744, 288);
		getContentPane().add(scrollPane);

		tblTabla = new JTable();
		tblTabla.setModel(new DefaultTableModel(
		new Object[][] {},
		new String[] {
			"C\u00F3digo de Alumno",
			"Nombres",
			"Apellidos",
			"DNI",
			"Celular",
			"Edad",
			"Celular",
			"Estado"
		}) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		modelo.addColumn("C�digo");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("DNI");
		modelo.addColumn("Edad");
		modelo.addColumn("Celular");
		modelo.addColumn("Estado");
		tblTabla.setModel(modelo);
		modelo.setRowCount(0);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerfomedBtnAceptar(arg0);
		}
	}

	//BOT�N ADICIONAR
	
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = 0;
		activarCuadrosDeTexto(true);
		textField.setEnabled(false);
		textField.setText(String.valueOf(ArregloAlumno.numAlumnoCorrelativo()));
		btnBuscar.setEnabled(false);
	}
	
	//BOT�N MODIFICAR

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = 2;
		alistarCuadrosDeTextoParaConsultar();
	}
	
	//BOT�N CONSULTAR

	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = 1;
		alistarCuadrosDeTextoParaConsultar();
	}
	
	//BOT�N ELIMINAR
	
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = 3;
		alistarCuadrosDeTextoParaConsultar();
	}
	
	//BOT�N BUSCAR
	
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		try {
			int codigoAlumno = Integer.parseInt(textField.getText());
			if (ArregloAlumno.buscar(codigoAlumno) != null) {
				switch (tipoOperacion) {
				case 1:
					activarCuadrosDeTexto(false);
					buscarAlumnoPorCodigo(codigoAlumno);
					break;
				case 2:
					activarCuadrosDeTexto(true);
					buscarAlumnoPorCodigo(codigoAlumno);
					textField.setEnabled(false);
					textField_3.setEnabled(false);
					comboBox.setEnabled(true);
					btnAdicionar.setEnabled(true);
					break;
				case 3:
					activarCuadrosDeTexto(false);
					buscarAlumnoPorCodigo(codigoAlumno);
					btnAceptar.setEnabled(true);
					break;
				}
			} else {
				error("Este c�digo no existe.", textField);
			}
		} catch(NumberFormatException nfe) {
			error("Ingrese un c�digo v�lido.", textField);
		}
	}

	//BOT�N ACEPTAR
	
	protected void actionPerfomedBtnAceptar(ActionEvent arg0) {
		switch (tipoOperacion) {
		case 0:
			int contador = 0;
			for (int i = 0; i < ArregloAlumno.tama�o(); i++) {
				if (textField_3.getText().equals(ArregloAlumno.obtener(i).getDni())) {
					contador++;
				}
			}
			if (contador < 1) {
				try {
					try{
						int condicion = JOptionPane.showConfirmDialog(null, "�Est� seguro que desea registrar al alumno?", "Confirmaci�n", 0, 1, null);
						if(condicion == 0){
							ArregloAlumno.adicionar(new Alumno(ArregloAlumno.numAlumnoCorrelativo(), Integer.parseInt(textField_4.getText()), Integer.parseInt(textField_5.getText()), comboBox.getSelectedIndex(), textField_1.getText(), textField_2.getText(), textField_3.getText()));
							activarCuadrosDeTexto(false);
							listar();
						}
					} 
					catch(ExcepcionAdicionar ea) {
						JOptionPane.showMessageDialog(this, ea.getMessage());
					} 
				}
				catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(this, "Por favor, complete los datos.");
				}
			} 
			else {
				error( "Debe poner otro n�mero de DNI, este est� siendo usado por otro alumno.", textField_3);
			}
			break;
			
		case 2:
			int condicion = JOptionPane.showConfirmDialog(null, "�Est� seguro que desea modificar al alumno?", "Confirmaci�n", 0, 1, null);
			if(condicion == 0){
				Alumno alumnoAReemplazar = ArregloAlumno.buscar(Integer.parseInt(textField.getText()));
				alumnoAReemplazar.setNombres(textField_1.getText());
				alumnoAReemplazar.setApellidos(textField_2.getText());
				alumnoAReemplazar.setEdad(Integer.parseInt(textField_4.getText()));
				alumnoAReemplazar.setCelular(Integer.parseInt(textField_5.getText()));
				alumnoAReemplazar.setEstado(comboBox.getSelectedIndex());
				ArregloAlumno.actualizarArchivo();
				listar();
				reiniciarCuadrosDeTexto();
				activarCuadrosDeTexto(false);
				comboBox.setEnabled(false);
				btnBuscar.setEnabled(false);
			}
			break;
			
		case 3:
			int condicion1 = JOptionPane.showConfirmDialog(null, "�Est� seguro que desea eliminar al alumno?","Confirmaci�n",0,1,null);
			if (condicion1 == 0) {
				Alumno alumnoAEliminar = ArregloAlumno.buscar(Integer.parseInt(textField.getText()));
				if (alumnoAEliminar.getEstado() == 0) {
					ArregloAlumno.eliminar(alumnoAEliminar);
					ArregloAlumno.actualizarArchivo();
					btnBuscar.setEnabled(false);
					btnAceptar.setEnabled(false);
					listar();
					reiniciarCuadrosDeTexto();
				}
				else{
					error( "Este alumno se encuentra matriculado", null);
				}
			}
			break;
		}
	}
	
	//M�TODOS QUE RETORNAN VALORES
	Object enTexto(int i){
		return comboBox.getItemAt(i);
	}
	
	//M�TODOS VOID CON PAR�METROS
	 void error(String s, JTextField txt) {
	        mensaje(s);
	 }
	 
	 void mensaje(String s) {
	       JOptionPane.showMessageDialog(this, s, "Informaci�n", 0);
     }
	
	public void listar(Alumno alumno) {
		modelo.setRowCount(0);
		Object[] fila = {
			alumno.getCodAlumno(),
			alumno.getNombres(),
			alumno.getApellidos(),
			alumno.getDni(),
			alumno.getEdad(),
			alumno.getCelular(),
			alumno.getEstado()
		};
		modelo.addRow(fila);
	}

	public void activarCuadrosDeTexto(boolean bool) {
		reiniciarCuadrosDeTexto();
		textField.setEnabled(bool);
		textField_1.setEnabled(bool);
		textField_2.setEnabled(bool);
		textField_3.setEnabled(bool);
		textField_4.setEnabled(bool);
		textField_5.setEnabled(bool);
		btnAceptar.setEnabled(bool);
		btnAdicionar.setEnabled(!bool);
	}

	public void buscarAlumnoPorCodigo(int codigoAlumno) {
		textField.setText(String.valueOf(codigoAlumno));
		textField_1.setText(ArregloAlumno.buscar(codigoAlumno).getNombres());
		textField_2.setText(ArregloAlumno.buscar(codigoAlumno).getApellidos());
		textField_3.setText(ArregloAlumno.buscar(codigoAlumno).getDni());
		textField_4.setText(String.valueOf(ArregloAlumno.buscar(codigoAlumno).getEdad()));
		textField_5.setText(String.valueOf(ArregloAlumno.buscar(codigoAlumno).getCelular()));
		comboBox.setSelectedIndex(ArregloAlumno.buscar(codigoAlumno).getEstado());
	}
	
	//M�TODOS VOID SIN PAR�METROS
		public void listar() {
			modelo.setRowCount(0);

			for (int i = 0; i < ArregloAlumno.tama�o(); i++) {
				Object[] fila = {
					ArregloAlumno.obtener(i).getCodAlumno(),
					ArregloAlumno.obtener(i).getNombres(),
					ArregloAlumno.obtener(i).getApellidos(),
					ArregloAlumno.obtener(i).getDni(),
					ArregloAlumno.obtener(i).getEdad(),
					ArregloAlumno.obtener(i).getCelular(),
					enTexto(ArregloAlumno.obtener(i).getEstado())
				};
				modelo.addRow(fila);
			}
		}
		
		public void reiniciarCuadrosDeTexto() {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			comboBox.setSelectedIndex(0);
		}
		
		public void alistarCuadrosDeTextoParaConsultar() {
			activarCuadrosDeTexto(false);
			textField.setEnabled(true);
			btnBuscar.setEnabled(true);
			btnAceptar.setEnabled(false);
			listar();
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
		listar();
	}
	
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getSource()== textField_5){
			keyPressedTextField_5(arg0);
		}
		if (arg0.getSource() == textField_4) {
			keyPressedTextField_4(arg0);
		}
		if (arg0.getSource() == textField_3) {
			keyPressedTextField_3(arg0);
		}
		if (arg0.getSource() == textField_2) {
			keyPressedTextField_2(arg0);
		}
		if (arg0.getSource() == textField_1) {
			keyPressedTextField_1(arg0);
		}
		if (arg0.getSource() == textField) {
			keyPressedTextField(arg0);
		}
	}
	protected void keyPressedTextField(KeyEvent arg0) {
		if(btnModificar.isSelected() == false){
			if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
				btnBuscar.doClick();
				textField_1.requestFocus();
			}
		}
		
		else{
			if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
				btnBuscar.doClick();
			}
		}
	}
	protected void keyPressedTextField_1(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
			textField_2.requestFocus();
		}
	}
	protected void keyPressedTextField_2(KeyEvent arg0) {
		if(btnAdicionar.isEnabled() == false){
			if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
				textField_3.requestFocus();
			}
		}
		else{
			if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
				textField_4.requestFocus();
			}
		}
	}
	protected void keyPressedTextField_3(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
			textField_4.requestFocus();
		}

	}
	protected void keyPressedTextField_4(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
			textField_5.requestFocus();
		}
	}
	
	protected void keyPressedTextField_5(KeyEvent arg0){
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
			btnAceptar.doClick();
		}
	}
	
	
	public void keyReleased(KeyEvent arg0) {
	}
	
	//AGREGANDO EVENTO keyTyped
	
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == textField) {
			keyTypedTextField(arg0);
		}
		if (arg0.getSource() == textField_5) {
			keyTypedTextField_5(arg0);
		}
		if (arg0.getSource() == textField_4) {
			keyTypedTextField_4(arg0);
		}
		if (arg0.getSource() == textField_3) {
			keyTypedTextField_3(arg0);
		}
	}
	
	//M�TODO VOID KeyTyped, PERMITIR� INGRESAR UNA CIERTA CANTIDAD DE CARACTERES

	protected void keyTypedTextField_3(KeyEvent arg0) {
		if(textField_3.getText().length()>=8){
			arg0.consume();
		}
	}
	
	protected void keyTypedTextField_4(KeyEvent arg0) {
		if(textField_4.getText().length()>=2){
			arg0.consume();
		}
	}
	
	protected void keyTypedTextField_5(KeyEvent arg0) {
		if(textField_5.getText().length()>=9){
			arg0.consume();
		}
	}
	
	protected void keyTypedTextField(KeyEvent arg0) {
		if(textField.getText().length()>=9){
			arg0.consume();
			Toolkit.getDefaultToolkit().beep();
		}
	}
	
	
	
	//AGREGANDO EVENTO mouseClicked
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btnEliminar) {
			mouseClickedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			mouseClickedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			mouseClickedBtnConsultar(e);
		}
		if (e.getSource() == btnAdicionar) {
			mouseClickedBtnAdicionar(e);
		}
	}
	
	public void mouseEntered(MouseEvent e) {
	}
	
	public void mouseExited(MouseEvent e) {
	}
	
	public void mousePressed(MouseEvent e) {
	}
	
	public void mouseReleased(MouseEvent e) {
	}
	
	//M�TODO VOID mouseClicked, NOS PISICIONAR� EN EL JTEXTFIELD A LA HORA DE DAR CLICK EN EL BOT�N CORRESPONDIENTE

	protected void mouseClickedBtnAdicionar(MouseEvent e) {
		textField_1.requestFocus();
	}
	
	protected void mouseClickedBtnConsultar(MouseEvent e) {
		textField.requestFocus();
	}
	
	protected void mouseClickedBtnModificar(MouseEvent e) {
		textField.requestFocus();
	}
	
	protected void mouseClickedBtnEliminar(MouseEvent e) {
		textField.requestFocus();
	}
	
}