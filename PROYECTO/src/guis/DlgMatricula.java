package guis;

import clases.*;

import excepciones.ExcepcionAdicionar;
import libreria.Fecha;
import arreglos.*;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgMatricula extends JDialog implements ActionListener,
WindowListener, KeyListener, MouseListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JLabel label;
    private JButton btnAdicionar;
    int tipoOperacion;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter dhf = DateTimeFormatter.ofPattern("hh:mm");
    LocalDate now
        /* = LocalDate.now()*/
    ;
    LocalTime nowTime
        /* = LocalTime.now()*/
    ;
    private JTable tblTabla;
    private DefaultTableModel modelo;
    private JButton btnConsultar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnAceptar;
    ArregloAlumno aa;
    ArregloMatricula am;
    ArregloCurso ac;
    ArregloRetiro ar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            DlgMatricula dialog = new DlgMatricula();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public DlgMatricula() {
        addWindowListener(this);
        setIconImage(Toolkit.getDefaultToolkit().getImage(DlgMatricula.class.getResource("/img/lista.png")));
        setTitle("Registro | Matr\u00EDcula");
        setBounds(100, 100, 1167, 331);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setMaximumSize(new Dimension(2147483647, 32767));
        contentPanel.setBackground(new Color(0, 51, 102));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblMatrcular = new JLabel("REGISTRO DE MATR\u00CDCULAS");
        lblMatrcular.setForeground(new Color(235, 242, 248));
        lblMatrcular.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblMatrcular.setBounds(384, 13, 294, 25);
        contentPanel.add(lblMatrcular);

        Panel panel = new Panel();
        panel.setLayout(null);
        panel.setBackground(new Color(235, 242, 248));
        panel.setBounds(10, 42, 368, 232);
        contentPanel.add(panel);

        JLabel lblNroMatrcula = new JLabel("Nro. Matr\u00EDcula:");
        lblNroMatrcula.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblNroMatrcula.setBounds(10, 11, 105, 14);
        panel.add(lblNroMatrcula);

        JLabel lblCdigoAlumno = new JLabel("C\u00F3digo Alumno:");
        lblCdigoAlumno.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblCdigoAlumno.setBounds(10, 62, 105, 17);
        panel.add(lblCdigoAlumno);

        JLabel lblCdigoCurso = new JLabel("C\u00F3digo Curso:");
        lblCdigoCurso.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblCdigoCurso.setBounds(10, 110, 105, 18);
        panel.add(lblCdigoCurso);

        JLabel lblAlumno = new JLabel("Alumno:");
        lblAlumno.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblAlumno.setBounds(10, 155, 86, 14);
        panel.add(lblAlumno);

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblCurso.setBounds(10, 202, 86, 17);
        panel.add(lblCurso);

        textField = new JTextField();
        textField.addKeyListener(this);
        textField.setEnabled(false);
        textField.setColumns(10);
        textField.setBounds(121, 9, 142, 20);
        panel.add(textField);

        textField_1 = new JTextField();
        textField_1.addKeyListener(this);
        textField_1.setEnabled(false);
        textField_1.setColumns(10);
        textField_1.setBounds(121, 61, 105, 20);
        panel.add(textField_1);

        textField_2 = new JTextField();
        textField_2.addKeyListener(this);
        textField_2.setEnabled(false);
        textField_2.setColumns(10);
        textField_2.setBounds(121, 108, 105, 20);
        panel.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setEnabled(false);
        textField_3.setColumns(10);
        textField_3.setBounds(121, 153, 204, 20);
        panel.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setEnabled(false);
        textField_4.setColumns(10);
        textField_4.setBounds(121, 201, 142, 20);
        panel.add(textField_4);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setEnabled(false);
        btnBuscar.addActionListener(this);
        btnBuscar.setBackground(UIManager.getColor("Button.background"));
        btnBuscar.setBounds(267, 7, 89, 23);
        panel.add(btnBuscar);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(this);
        btnAceptar.setBackground(UIManager.getColor("Button.background"));
        btnAceptar.setBounds(267, 199, 89, 23);
        panel.add(btnAceptar);

        btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addMouseListener(this);
        btnAdicionar.addActionListener(this);
        btnAdicionar.setBounds(384, 42, 130, 23);
        contentPanel.add(btnAdicionar);
        btnAdicionar.setBackground(UIManager.getColor("Button.background"));

        btnModificar = new JButton("Modificar");
        btnModificar.addMouseListener(this);
        btnModificar.addActionListener(this);
        btnModificar.setBounds(384, 215, 130, 23);
        contentPanel.add(btnModificar);
        btnModificar.setBackground(UIManager.getColor("Button.background"));

        btnConsultar = new JButton("Consultar");
        btnConsultar.addMouseListener(this);
        btnConsultar.addActionListener(this);
        btnConsultar.setBounds(383, 78, 131, 23);
        contentPanel.add(btnConsultar);
        btnConsultar.setBackground(UIManager.getColor("Button.background"));

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addMouseListener(this);
        btnEliminar.addActionListener(this);
        btnEliminar.setBounds(384, 251, 130, 23);
        contentPanel.add(btnEliminar);
        btnEliminar.setBackground(UIManager.getColor("Button.background"));

        label = new JLabel("");
        label.setIcon(new ImageIcon(DlgMatricula.class.getResource("/img/logo-cibertec.png")));
        label.setBounds(384, 113, 130, 89);
        contentPanel.add(label);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(524, 42, 613, 232);
        contentPanel.add(scrollPane);

        tblTabla = new JTable();
        tblTabla.setFillsViewportHeight(true);
        scrollPane.setViewportView(tblTabla);

        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo Matr�cula");
        modelo.addColumn("Alumno");
        modelo.addColumn("Curso");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        tblTabla.setModel(modelo);
        modelo.setRowCount(0);
    }
    
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == btnAceptar) {
            actionPerformedButton_1(arg0);
        }
        if (arg0.getSource() == btnBuscar) {
            actionPerformedButton(arg0);
        }
        if (arg0.getSource() == btnEliminar) {
            actionPerformedButton_5(arg0);
        }
        if (arg0.getSource() == btnModificar) {
            actionPerformedButton_3(arg0);
        }
        if (arg0.getSource() == btnConsultar) {
            actionPerformedButton_4(arg0);
        }
        if (arg0.getSource() == btnAdicionar) {
            actionPerformedButton_2(arg0);
        }
    }

    /*
     * 
     * Se definen los �ndices de cada acci�n:
     * 0: Agregar.
     * 1: Consultar.
     * 2: Modificar.
     * 3: Eliminar.
     * 
     * Tambi�n existen botones:
     * Bot�n: Buscar
     * Bot�n 1: Aceptar
     * Bot�n 2: Adicionar
     * Bot�n 3: Modificar
     * Bot�n 4: Consultar
     * Bot�n 5: Eliminar
     * 
     * */

    protected void actionPerformedButton_2(ActionEvent arg0) {
    	reiniciarCuadrosDeTexto();
        tipoOperacion = 0;
        activarCuadrosDeTexto(true);
        textField.setEnabled(false);
        textField.setText(String.valueOf(ArregloMatricula.numMatriculaCorrelativo()));
        btnBuscar.setEnabled(false);
        textField_3.setEnabled(false);
        textField_4.setEnabled(false);
    }

    protected void actionPerformedButton_4(ActionEvent arg0) {
        tipoOperacion = 1;
        alistarCuadrosDeTextoParaConsultar();
    }

    protected void actionPerformedButton_3(ActionEvent arg0) {
        tipoOperacion = 2;
        alistarCuadrosDeTextoParaConsultar();
    }

    protected void actionPerformedButton_5(ActionEvent arg0) {
        tipoOperacion = 3;
        alistarCuadrosDeTextoParaConsultar();
    }

    /* Desde aqu� se van a programar los m�todos que se van a usar */

    protected void actionPerformedButton(ActionEvent arg0) {

        /*
         * 
         * Primero se crea una variable codigoMatricula que contenga el c�digo de la matr�cula y que pueda ser
         * usada para buscar la matr�cula y poner sus datos en los jTextField mediante el m�todo buscarMatriculaPorCodigo.
         * 
         * */

        try {
            int codigoMatricula = Integer.parseInt(textField.getText());
            if (ArregloMatricula.buscar(codigoMatricula) != null) {
                switch (tipoOperacion) {
                    case 1:
                        activarCuadrosDeTexto(false);
                        textField.setEnabled(true);
                        buscarMatriculaPorCodigo(codigoMatricula);
                        break;
                    case 2:
                        activarCuadrosDeTexto(true);
                        buscarMatriculaPorCodigo(codigoMatricula);
                        textField_1.setEnabled(false);
                        textField_3.setEnabled(false);
                        textField_4.setEnabled(false);
                        textField.setEnabled(false);
                        btnAdicionar.setEnabled(true);
                        break;
                    case 3:
                        activarCuadrosDeTexto(false);
                        buscarMatriculaPorCodigo(codigoMatricula);
                        btnAceptar.setEnabled(true);
                        break;
                }
            } else {
                error("Este c�digo no existe.");
            }
        } catch (NumberFormatException nfe) {
            error("Ingrese c�digo valido.");
        }
    }

    protected void actionPerformedButton_1(ActionEvent arg0) {
        switch (tipoOperacion) {
            case 0:
            	try{
            		// Primero detecta si el c�digo existe en el arreglo alumno y curso
	                if (ArregloAlumno.buscar(Integer.parseInt(textField_1.getText())) != null) {
	                	// Segundo debe detectar si el c�digo del curso existe
	                    if (ArregloCurso.buscar(Integer.parseInt(textField_2.getText())) != null) {
	                        // Si el alumno est� matriculado, osea, si su estado es 1 (matriculado), no se agrega otra matr�cula
	                        if (ArregloAlumno.buscar(Integer.parseInt(textField_1.getText())).getEstado() != 1) {
	                        	try{
		                            try {
		                            	int condicion = JOptionPane.showConfirmDialog(this, "Desea matricular a este alumno?", "Confirmaci�n", 0,1,null);
		                            	if(condicion == 0){
			                                ArregloMatricula.adicionar(new Matricula(ArregloMatricula.numMatriculaCorrelativo(),
			                                    Integer.parseInt(textField_1.getText()),
			                                    Integer.parseInt(textField_2.getText()),
			                                    Fecha.fechaActual(), Fecha.horaActual()));
			                                ArregloAlumno.buscar(Integer.parseInt(textField_1.getText())).setEstado(1);
			                                ArregloAlumno.actualizarArchivo();
			                                activarCuadrosDeTexto(false);
			                                listar();
		                            	}
		                            } 
		                            catch (ExcepcionAdicionar ea) {
		                            	JOptionPane.showMessageDialog(this,ea.getMessage());
		                            }
	                        	}	
	                        	catch (NumberFormatException nfe) {
	                                JOptionPane.showMessageDialog(this,"Por favor, ingrese n�meros v�lidos.");
	                            }
	                        } else {
	                             error("Este alumno se encuentra matriculado.");
	                        }
	                    } else {
	                        error( "Este curso no se encuentra registrado en la base de datos.");
	                    }
	                } else {
	                    error("Este alumno no se encuentra registrado en la base de datos.");
	                    textField_1.requestFocus();
	                }
            	}
            	catch(Exception e){
            		JOptionPane.showMessageDialog(this,"Ingrese datos en los campos");
            	}
                break;
            case 2:
                if (ArregloCurso.buscar(Integer.parseInt(textField_2.getText())) != null) {
                	int condicion = validar("Desea modificar esta matr�cula?", "Confirmaci�n");
                	if(condicion == 0){
	                    Matricula matriculaAReemplazar = ArregloMatricula.buscar(Integer.parseInt(textField.getText()));
	                    matriculaAReemplazar.setCodCurso(Integer.parseInt(textField_2.getText()));
	                    btnBuscar.setEnabled(false);
	                    ArregloMatricula.actualizarArchivo();
	                    reiniciarCuadrosDeTexto();
	                    textField_2.setEnabled(false);
	                    btnAceptar.setEnabled(false);
	                    listar();
                	}
                } else {
                   error("El curso no existe.");
                }
                break;
            case 3:
                if (ArregloAlumno.buscar(Integer.parseInt(textField_1.getText())).getEstado() != 2) {
                    int condicion = validar("�Desea eliminar a esta matricula?", "Confirmaci�n");
                    if (condicion == 0) {
                        Matricula matriculaAEliminar = ArregloMatricula.buscar(Integer.parseInt(textField.getText()));
                        ArregloAlumno.buscar(Integer.parseInt(textField_1.getText())).setEstado(0);
                        ArregloMatricula.eliminar(matriculaAEliminar);
                        ArregloAlumno.actualizarArchivo();
                        btnBuscar.setEnabled(false);
                        btnAceptar.setEnabled(false);
                        reiniciarCuadrosDeTexto();
                        listar();
                    }
                } 
                else {
                    error("El alumno se encuentra actualmente retirado de la instituci�n.");
                }
                break;
        }
    }
    //M�TODOS QUE RETORNAN VALORES
    int validar(String s1, String s2) {
        return JOptionPane.showConfirmDialog(this, s1, s2, 0, 1, null);
    }
    
    void error(String s){
        mensaje(s);
    }
    void mensaje(String s) {
        JOptionPane.showMessageDialog(this, s, "Informaci�n", 0);
    }
    //M�TODOS VOID SIN PAR�METROS

    public void listar() {
        modelo.setRowCount(0);
        for (int i = 0; i < ArregloMatricula.tama�o(); i++) {
        	Alumno a = ArregloAlumno.buscar(ArregloMatricula.obtener(i).getCodAlumno());
        	Curso c = ArregloCurso.buscar(ArregloMatricula.obtener(i).getCodCurso());
            Object[] fila = {
                ArregloMatricula.obtener(i).getNumMatricula(),
                a.getNombres() + " " + a.getApellidos(),
                c.getAsignaturas(),
                ArregloMatricula.obtener(i).getFecha(),
                ArregloMatricula.obtener(i).getHora()
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
    }
    
    public void alistarCuadrosDeTextoParaConsultar() {
        activarCuadrosDeTexto(false);
        reiniciarCuadrosDeTexto();
        textField.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnAceptar.setEnabled(false);
        listar();
    }
    
    //M�TODOS VOID CON PAR�METROS

    public void activarCuadrosDeTexto(boolean bool) {
        textField.setEnabled(bool);
        textField_1.setEnabled(bool);
        textField_2.setEnabled(bool);
        textField_3.setEnabled(bool);
        textField_4.setEnabled(bool);
        btnAceptar.setEnabled(bool);
        btnAdicionar.setEnabled(!bool);
    }

    public void buscarMatriculaPorCodigo(int codigoMatricula) {
        textField.setText(String.valueOf(codigoMatricula));
        textField_1.setText(String.valueOf(ArregloMatricula.buscar(codigoMatricula).getCodAlumno()));
        textField_2.setText(String.valueOf(ArregloMatricula.buscar(codigoMatricula).getCodCurso()));
        Matricula m = ArregloMatricula.buscar(codigoMatricula);
        Alumno a = ArregloAlumno.buscar(m.getCodAlumno());
        textField_3.setText(a.getNombres() + "" + a.getApellidos());
        Curso c = ArregloCurso.buscar(m.getCodCurso());
        textField_4.setText(c.getAsignaturas());
    }

    public void windowActivated(WindowEvent arg0) {	
    }
    
    public void windowClosed(WindowEvent arg0) {
    }
    
    public void windowClosing(WindowEvent arg0) {
    }
    
    public void windowDeactivated(WindowEvent arg0) {
    }
    
    public void windowDeiconified(WindowEvent arg0) {    	
    }
    
    public void windowIconified(WindowEvent arg0) {    	
    }
    
    public void windowOpened(WindowEvent arg0) {
        if (arg0.getSource() == this) {
            windowOpenedThis(arg0);
        }
    }
    
    protected void windowOpenedThis(WindowEvent arg0) {
    	aa = new ArregloAlumno();
		am = new ArregloMatricula();
		ar = new ArregloRetiro();
		ac = new ArregloCurso();
        listar();
    }
    
	public void keyPressed(KeyEvent arg0) {	
		if(arg0.getSource() == textField_1){
			keyPressedTxtCodigoAlumno(arg0);
		}
		if(arg0.getSource()== textField_2){
			keyPressedTxtCodigoCurso(arg0);
		}
		if(arg0.getSource()== textField){
			keyPressedTxtCodigoMatricula(arg0);
		}
	}
	protected void keyPressedTxtCodigoMatricula(KeyEvent arg0){
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
			btnBuscar.doClick();
		}
	}
	protected void keyPressedTxtCodigoAlumno(KeyEvent arg0){
		try{
			if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
				try{
					Alumno a = ArregloAlumno.buscar(Integer.parseInt(textField_1.getText().trim()));
					textField_3.setText("" + a.getNombres() + " " + a.getApellidos());
					textField_2.requestFocus();
				}
				catch(Exception e){
					error("Este c�digo de alumno no existe");
				}
			}
		}
		catch(Exception e){
			error("Ingrese un c�digo de alumno v�lido");

		}
	}
	
	protected void keyPressedTxtCodigoCurso(KeyEvent arg0){
		try{
			if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
				try{
					Curso c = ArregloCurso.buscar(Integer.parseInt(textField_2.getText().trim()));
					textField_4.setText("" + c.getAsignaturas());
					btnAceptar.doClick();
				}
				catch(Exception e){
					error("Este c�digo de curso no existe");
				}
			}
		}
		catch(Exception e){
			error("Ingrese un c�digo de curso v�lido");
		}
	}
	
	public void keyReleased(KeyEvent arg0) {
	}
	
	//AGREGANDO EVENTO keyTyped
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == textField_2) {
			keyTypedTextField_2(arg0);
		}
		
		if (arg0.getSource() == textField_1) {
			keyTypedTextField_1(arg0);
		}
		
		if (arg0.getSource() == textField) {
			keyTypedTextField(arg0);
		}
	}
	
	//M�TODO VOID KeyTyped, PERMITIR� INGRESAR UNA CIERTA CANTIDAD DE CARACTERES

	protected void keyTypedTextField(KeyEvent arg0) {
		if(textField.getText().length()>=6){
			arg0.consume();
		}
	}
	
	protected void keyTypedTextField_1(KeyEvent arg0) {
		if(textField_1.getText().length()>=9){
			arg0.consume();
		}
	}
	
	protected void keyTypedTextField_2(KeyEvent arg0) {
		if(textField_2.getText().length()>=4){
			arg0.consume();
		}
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			mouseClickedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			mouseClickedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			mouseClickedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			mouseClickedBtnAdicionar(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedBtnAdicionar(MouseEvent arg0) {
		if (arg0.getSource() == btnAdicionar) {
			textField_1.requestFocus();
		}
	}
	protected void mouseClickedBtnConsultar(MouseEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			textField.requestFocus();
		}
	}
	protected void mouseClickedBtnModificar(MouseEvent arg0) {
		if (arg0.getSource() == btnModificar) {
			textField.requestFocus();
		}
	}
	protected void mouseClickedBtnEliminar(MouseEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			textField.requestFocus();
		}
	}
}