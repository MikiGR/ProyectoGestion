package igu;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.io.*;

public class VentanaPrincipal extends JFrame {
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JPanel panelPrincipal;
    public JPanel panelInicio;
    public JPanel panelMuestras;
    private JTextField textFieldUsuario;
    private JTextField textFieldPassword;
	private JButton btnCancel;
	private JButton btnOk;
	private JLabel lblMuestras;
	private JTable table;
	private JLabel lblID;
	private JTextField textField;
	private JLabel lblNif;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblCultivo;
	private JLabel lblSolucin;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnActualizar;
	private JButton btnLimpiar;
	private JButton btnSalir;


    public VentanaPrincipal() {
        //setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/Logo Seamos Triviales.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1500, 800);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.add(getPanelPrincipal(), BorderLayout.CENTER);
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
					mostrarPanelMuestras();
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
            lblMuestras.setBounds(231, 24, 423, 95);
            panelMuestras.add(lblMuestras);

            String[] columnNames = {"Nombre", "Edad", "Correo Electrónico"};
            Object[][] data = {
                {"Juan", 25, "juan@example.com"},
                {"María", 30, "maria@example.com"},
                {"Carlos", 22, "carlos@example.com"}
            };
            table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(43, 142, 1144, 158); // Ajusta las coordenadas y el tamaño del JScrollPane
            panelMuestras.add(scrollPane);
            panelMuestras.add(getLblID());
            panelMuestras.add(getTextField());
            panelMuestras.add(getLblNif());
            panelMuestras.add(getTextField_1());
            panelMuestras.add(getTextField_2());
            panelMuestras.add(getLblCultivo());
            panelMuestras.add(getLblSolucin());
            
            JList list = new JList();
            list.setBounds(132, 602, 1055, 95);
            panelMuestras.add(list);
            
            
            panelMuestras.add(getBotonInsertar());
            
           
            panelMuestras.add(getBotonBorrar());
            
            
            panelMuestras.add(getBotonActualizar());
            
            
            panelMuestras.add(getBotonSalir());
            
           
            panelMuestras.add(getBotonLimpiar());
        }
        return panelMuestras;
    }
    
    public JButton getBotonInsertar() {
		if (btnInsertar == null) {
			btnInsertar = new JButton("Insertar");
            btnInsertar.setBackground(SystemColor.scrollbar);
            btnInsertar.setBounds(179, 716, 117, 29);
            btnInsertar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
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
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(132, 354, 1055, 32);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNif() {
		if (lblNif == null) {
			lblNif = new JLabel("NIF");
			lblNif.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNif.setBounds(43, 436, 61, 16);
		}
		return lblNif;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(132, 431, 1055, 32);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(132, 513, 1055, 32);
		}
		return textField_2;
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
}