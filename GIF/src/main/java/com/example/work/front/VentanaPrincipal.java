package com.example.work.front;

import com.example.work.entity.Muestra;
import com.example.work.entity.Solucion;
import com.example.work.service.MuestraService;
import com.example.work.service.SolucionService;
import com.example.work.service.UsuarioService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.Entity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaPrincipal extends JFrame {

	private UsuarioService usuarioService;
	private MuestraService muestraService;
	private SolucionService solucionService;

    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JPanel panelPrincipal;
    public JPanel panelInicio;
    public JPanel panelMuestras;
    private JTextField textFieldUsuario;
    private JTextField textFieldPassword;
	private JButton btnCancel;
	private JButton btnOk;
	private JTable table;
	private JLabel lblID;
	private JTextField textFieldID;
	private JLabel lblNif;
	private JTextField textFieldNIF;
	private JTextField textFieldCultivo;
	private JLabel lblCultivo;
	private JLabel lblSolucin;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnActualizar;
	private JButton btnLimpiar;
	private JButton btnSalir;
	private String rolname;
	private JList list;
	private Muestra muestraSeleccionada;

    public VentanaPrincipal(UsuarioService usuarioService, MuestraService muestraService) {
        //setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/Logo Seamos Triviales.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1500, 800);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.add(getPanelPrincipal(), BorderLayout.CENTER);
		this.usuarioService = usuarioService;
		this.muestraService = muestraService;
	}

    public JPanel getPanelPrincipal() {
        if (panelPrincipal == null) {
            panelPrincipal = new JPanel();
            panelPrincipal.setBackground(new Color(255, 255, 255));
            panelPrincipal.setLayout(new CardLayout(0, 0));
            panelPrincipal.add(getPanelInicio(), "panelInicio");
            panelPrincipal.add(getPanelMuestras(), "panelMuestras");


        }
        return panelPrincipal;
    }
    
    public JPanel getPanelInicio() {
    	if (panelInicio == null) {
    		panelInicio = new JPanel();
    		panelInicio.setBackground(SystemColor.window);
    		panelInicio.setLayout(null);
    		
    		JLabel lblBienvenido = new JLabel("Bienvenido");
    		lblBienvenido.setFont(new Font("Dialog", Font.BOLD, 50));
    		lblBienvenido.setBounds(479, 82, 354, 83);
    		panelInicio.add(lblBienvenido);
    		
    		JLabel lblUsuario = new JLabel("Usuario");
    		lblUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    		lblUsuario.setBounds(441, 239, 98, 34);
    		panelInicio.add(lblUsuario);
    		
    		textFieldUsuario = new JTextField();
    		textFieldUsuario.setBounds(593, 242, 252, 34);
    		panelInicio.add(textFieldUsuario);
    		textFieldUsuario.setColumns(10);
    		
    		textFieldPassword = new JTextField();
    		textFieldPassword.setColumns(10);
    		textFieldPassword.setBounds(593, 342, 252, 34);
    		panelInicio.add(textFieldPassword);
    		
    		JLabel lblPassword = new JLabel("Password");
    		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    		lblPassword.setBounds(441, 342, 98, 34);
    		panelInicio.add(lblPassword);
    		
    		
    		panelInicio.add(getBotonOk());		
    		
    		panelInicio.add(getBotonCancel());
    		
    	}
    	return panelInicio;
    }
    
    public JButton getBotonOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
    		btnOk.setBounds(460, 674, 144, 45);
    		btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String role = usuarioService.doLogin(textFieldUsuario.getText(), textFieldPassword.getText());

					if (role != null){
						rolname = role;
						System.out.println(rolname);
						mostrarPanelMuestras();
					}
				}
			});
		}
		return btnOk;
	}
    
    public JButton getBotonCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("CANCEL");
    		btnCancel.setBounds(689, 674, 144, 45);
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return btnCancel;
	}
    
    public JPanel getPanelMuestras() {
        if (panelMuestras == null) {
            panelMuestras = new JPanel();
            panelMuestras.setBackground(SystemColor.window);
            panelMuestras.setLayout(null);

            JLabel lblMuestras = new JLabel("MUESTRAS");
            lblMuestras.setFont(new Font("Dialog", Font.PLAIN, 80));
            lblMuestras.setBounds(426, 23, 423, 95);
            panelMuestras.add(lblMuestras);

            JScrollPane scrollPane = new JScrollPane(getTable());
            scrollPane.setBounds(43, 142, 1144, 158);
            panelMuestras.add(scrollPane);
            panelMuestras.add(getLblID());
            panelMuestras.add(getTextFieldID());
            panelMuestras.add(getLblNif());
            panelMuestras.add(getTextFieldNIF());
            panelMuestras.add(getTextFieldCultivo());
            panelMuestras.add(getLblCultivo());
            panelMuestras.add(getLblSolucin());
            

            panelMuestras.add(getList());
            
            
            panelMuestras.add(getBotonInsertar());
            
           
            panelMuestras.add(getBotonBorrar());
            
            
            panelMuestras.add(getBotonActualizar());
            
            
            panelMuestras.add(getBotonSalir());
            
           
            panelMuestras.add(getBotonLimpiar());
        }
        return panelMuestras;
    }
    public JTable getTable(){
		if (table == null){
			DefaultTableModel modeloTabla = new DefaultTableModel();
			modeloTabla.addColumn("ID");
			modeloTabla.addColumn("NIF Paciente");
			modeloTabla.addColumn("Cultivo");
			modeloTabla.addColumn("Solucion");
			List<Muestra> muestras = muestraService.getMuestras();
			for (Muestra muestra : muestras) {
				modeloTabla.addRow(new Object[]{muestra.getId(), muestra.getNifPaciente(), muestra.getCultivo(), muestra.getSolucion().getId()});
			}
			table = new JTable(modeloTabla);
			ListSelectionModel selectionModel = table.getSelectionModel();

			// Agregar un ListSelectionListener para manejar cambios de selección
			selectionModel.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						// Manejar el evento de cambio de selección aquí
						int selectedRow = table.getSelectedRow();
						// Verificar si la selección es válida
						if (selectedRow != -1) {
							muestraSeleccionada = muestraService.getMuestraById((int)table.getValueAt(selectedRow, 0));
							mostrarSeleccionada();
						}


					}
				}
			});

		}
		return table;
	}
    public JButton getBotonInsertar() {
		if (btnInsertar == null) {
			btnInsertar = new JButton("Insertar");
            btnInsertar.setBackground(SystemColor.scrollbar);
            btnInsertar.setBounds(179, 716, 117, 29);
            btnInsertar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					muestraService.create(Integer.parseInt(textFieldID.getText()),textFieldNIF.getText(),textFieldCultivo.getText(),(Solucion)list.getSelectedValue());
					muestraSeleccionada = null;
					mostrarSeleccionada();
				}
			});
		}
		return btnInsertar;
	}
    
    public JButton getBotonBorrar() {
		if (btnBorrar == null) {
			 btnBorrar = new JButton("Borrar");
	         btnBorrar.setBackground(SystemColor.scrollbar);
	         btnBorrar.setBounds(399, 716, 117, 29);
	         btnBorrar.addActionListener(new ActionListener() {
	        	 public void actionPerformed(ActionEvent e) {
					 try{
						muestraService.delete(muestraSeleccionada);
						muestraSeleccionada = null;
						mostrarSeleccionada();
					 }catch(Exception exc){
						 System.err.println("ERROR: "+exc);
					 }
				}
			});
		}
		return btnBorrar;
	}
    
    public JButton getBotonActualizar() {
		if (btnActualizar == null) {
			btnActualizar = new JButton("Actualizar");
            btnActualizar.setBackground(SystemColor.scrollbar);
            btnActualizar.setBounds(639, 716, 117, 29);
            btnActualizar.addActionListener(new ActionListener() {
	        	 public void actionPerformed(ActionEvent e) {
					if(muestraService.id_unico(Integer.parseInt(textFieldID.getText())) == 0){

					}else{
						muestraService.update(Integer.parseInt(textFieldID.getText()),textFieldNIF.getText(),textFieldCultivo.getText(),(Solucion)list.getSelectedValue());
						muestraSeleccionada = null;
						mostrarSeleccionada();
					}
				}
			});
		}
		return btnActualizar;
	}
    
    public JButton getBotonLimpiar() {
		if (btnLimpiar == null) {
			 btnLimpiar = new JButton("Limpiar");
	         btnLimpiar.setBackground(SystemColor.windowBorder);
	         btnLimpiar.setBounds(863, 716, 117, 29);
	         btnLimpiar.addActionListener(new ActionListener() {
	        	 public void actionPerformed(ActionEvent e) {
					muestraSeleccionada = null;
					mostrarSeleccionada();
				}
			});
		}
		return btnLimpiar;
	}
    
    public JButton getBotonSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
            btnSalir.setBackground(SystemColor.scrollbar);
            btnSalir.setBounds(1083, 716, 117, 29);
            btnSalir.addActionListener(new ActionListener() {
	        	 public void actionPerformed(ActionEvent e) {
	        		 System.exit(0);
				}
			});
		}
		return btnSalir;
	}

	
	public void mostrarPanelMuestras() {
		((CardLayout) getPanelPrincipal().getLayout()).show(panelPrincipal, "panelMuestras");
	}
	private JLabel getLblID() {
		if (lblID == null) {
			lblID = new JLabel("ID");
			lblID.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblID.setBounds(43, 359, 61, 16);
		}
		return lblID;
	}
	private JTextField getTextFieldID() {
		if (textFieldID == null) {
			textFieldID = new JTextField();
			textFieldID.setBounds(132, 354, 1055, 32);
			textFieldID.setColumns(10);
		}
		return textFieldID;
	}
	private JLabel getLblNif() {
		if (lblNif == null) {
			lblNif = new JLabel("NIF");
			lblNif.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNif.setBounds(43, 436, 61, 16);
		}
		return lblNif;
	}
	private JTextField getTextFieldNIF() {
		if (textFieldNIF == null) {
			textFieldNIF = new JTextField();
			textFieldNIF.setColumns(10);
			textFieldNIF.setBounds(132, 431, 1055, 32);
		}
		return textFieldNIF;
	}
	private JTextField getTextFieldCultivo() {
		if (textFieldCultivo == null) {
			textFieldCultivo = new JTextField();
			textFieldCultivo.setColumns(10);
			textFieldCultivo.setBounds(132, 513, 1055, 32);
		}
		return textFieldCultivo;
	}
	private JLabel getLblCultivo() {
		if (lblCultivo == null) {
			lblCultivo = new JLabel("Cultivo");
			lblCultivo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblCultivo.setBounds(43, 514, 102, 24);
		}
		return lblCultivo;
	}
	private JLabel getLblSolucin() {
		if (lblSolucin == null) {
			lblSolucin = new JLabel("Solución");
			lblSolucin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblSolucin.setBounds(43, 602, 102, 24);
		}
		return lblSolucin;
	}

	public JList getList() {
		if(list == null) {
			List<Solucion> soluciones = solucionService.getSoluciones();
			DefaultListModel<Solucion> listModel = new DefaultListModel<Solucion>();
			for (Solucion solucion : soluciones){
				listModel.addElement(solucion);
			}
			list = new JList(listModel);
			list.setBounds(281, 602, 1055, 95);
		}
		return list;
	}

	public void mostrarSeleccionada(){
		if(muestraSeleccionada != null) {
			textFieldID.setText(String.valueOf(muestraSeleccionada.getId()));
			textFieldNIF.setText(String.valueOf(muestraSeleccionada.getNifPaciente()));
			textFieldCultivo.setText(String.valueOf(muestraSeleccionada.getCultivo()));
			list.setSelectedValue(muestraSeleccionada.getSolucion(), true);
		}else{
			textFieldID.setText("");
			textFieldNIF.setText("");
			textFieldCultivo.setText("");
			list.clearSelection();
			table.clearSelection();
		}
	}
}