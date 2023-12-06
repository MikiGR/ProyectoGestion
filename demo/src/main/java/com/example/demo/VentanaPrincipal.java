package com.example.demo;
import Entity.TmuestraEntity;

import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;

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
    private JList list;
    private TmuestraEntity muestraSeleccionada;


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
            lblMuestras.setBounds(491, 20, 423, 95);
            panelMuestras.add(lblMuestras);



            JScrollPane scrollPane = new JScrollPane(getTable());
            scrollPane.setBounds(68, 144, 1268, 158); // Ajusta las coordenadas y el tamaño del JScrollPane
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
        if(table == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence.xml"); // Reemplaza con tu unidad de persistencia
            EntityManager em = emf.createEntityManager();
            // Consultar la base de datos para obtener los datos de Tmuestra
            List<TmuestraEntity> tmuestras = em.createQuery("SELECT t FROM TmuestraEntity t", TmuestraEntity.class).getResultList();

            // Crear un DefaultTableModel con los datos y encabezados de columna
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"ID", "NIF_Paciente", "Cultivo", "Solucion"});

            for (TmuestraEntity tmuestra : tmuestras) {
                // Agregar cada fila a la tabla
                model.addRow(new Object[]{tmuestra.getId(), tmuestra.getNifPaciente(), tmuestra.getCultivo(), tmuestra.getSolucion()});
            }

            // Crear la JTable con el modelo
            JTable table = new JTable(model);

            // Cerrar el EntityManager cuando hayas terminado
            em.close();
            emf.close();
            ListSelectionModel selectionModel = table.getSelectionModel();

            // Agregar un ListSelectionListener para manejar cambios de selección
            selectionModel.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        // Manejar el evento de cambio de selección aquí
                        int selectedRow = table.getSelectedRow();
                        int selectedColumn = table.getSelectedColumn();
                        // Verificar si la selección es válida
                        if (selectedRow != -1 && selectedColumn != -1) {
                            // Obtener el valor de la celda seleccionada
                            muestraSeleccionada = (TmuestraEntity)table.getValueAt(selectedRow, selectedColumn);
                            mostrarSeleccionada();
                        }


                    }
                }
            });
        }
        return table;
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
    public JList getList() {
        if(list == null) {
            list = new JList();
            list.setBounds(281, 602, 1055, 95);
        }
        return list;
    }

    public JButton getBotonInsertar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence.xml"); // Reemplaza con tu unidad de persistencia
        EntityManager em = emf.createEntityManager();
        if (btnInsertar == null) {
            btnInsertar = new JButton("Insertar");
            btnInsertar.setBackground(SystemColor.scrollbar);
            btnInsertar.setBounds(179, 716, 117, 29);
            btnInsertar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    em.getTransaction().begin();
                    TmuestraEntity nueva = new TmuestraEntity();
                    nueva.setId(Integer.parseInt(textFieldID.getText()));
                    nueva.setNifPaciente(textFieldNIF.getText());
                    nueva.setCultivo(textFieldCultivo.getText());
                    nueva.setSolucion((int)list.getSelectedValue());
                    em.persist(nueva);
                    em.getTransaction().commit();
                    em.close();
                    emf.close();
                    muestraSeleccionada = null;
                    mostrarSeleccionada();
                }
            });
        }
        return btnInsertar;
    }

    public JButton getBotonBorrar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence.xml"); // Reemplaza con tu unidad de persistencia
        EntityManager em = emf.createEntityManager();
        if (btnBorrar == null) {
            btnBorrar = new JButton("Borrar");
            btnBorrar.setBackground(SystemColor.scrollbar);
            btnBorrar.setBounds(399, 716, 117, 29);
            btnBorrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    em.getTransaction().begin();
                    em.remove(muestraSeleccionada);
                    em.getTransaction().commit();
                    em.close();
                    emf.close();
                    muestraSeleccionada = null;
                    mostrarSeleccionada();
                }
            });
        }
        return btnBorrar;
    }

    public JButton getBotonActualizar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence.xml"); // Reemplaza con tu unidad de persistencia
        EntityManager em = emf.createEntityManager();
        if (btnActualizar == null) {
            btnActualizar = new JButton("Actualizar");
            btnActualizar.setBackground(SystemColor.scrollbar);
            btnActualizar.setBounds(656, 716, 117, 29);
            btnActualizar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    em.getTransaction().begin();
                    if (muestraSeleccionada.getId() != Integer.parseInt(textFieldID.getText()))
                        muestraSeleccionada.setId(Integer.parseInt(textFieldID.getText()));
                    if (!muestraSeleccionada.getNifPaciente().equalsIgnoreCase(textFieldNIF.getText()))
                        muestraSeleccionada.setNifPaciente(textFieldNIF.getText());
                    if (!muestraSeleccionada.getCultivo().equalsIgnoreCase(textFieldCultivo.getText()))
                        muestraSeleccionada.setCultivo(textFieldCultivo.getText());
                    if (muestraSeleccionada.getSolucion() != (int) list.getSelectedValue())
                        muestraSeleccionada.setSolucion((int) list.getSelectedValue());
                    em.getTransaction().commit();
                    em.close();
                    emf.close();
                    muestraSeleccionada = null;
                    mostrarSeleccionada();
                }
            });
        }
        return btnActualizar;
    }

    public JButton getBotonLimpiar() {
        if (btnLimpiar == null) {
            btnLimpiar = new JButton("Limpiar");
            btnLimpiar.setBackground(SystemColor.windowBorder);
            btnLimpiar.setBounds(923, 716, 117, 29);
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
            btnSalir.setBounds(1187, 716, 117, 29);
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
            lblID.setBounds(68, 359, 61, 16);

        }
        return lblID;
    }
    private JTextField getTextFieldID() {
        if (textFieldID == null) {
            textFieldID = new JTextField();
            textFieldID.setBounds(281, 354, 1055, 32);
            textFieldID.setColumns(10);
        }
        return textFieldID;
    }
    private JLabel getLblNif() {
        if (lblNif == null) {
            lblNif = new JLabel("NIF");
            lblNif.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblNif.setBounds(68, 436, 61, 16);
        }
        return lblNif;
    }
    private JTextField getTextFieldNIF() {
        if (textFieldNIF == null) {
            textFieldNIF = new JTextField();
            textFieldNIF.setColumns(10);
            textFieldNIF.setBounds(281, 431, 1055, 32);
        }
        return textFieldNIF;
    }
    private JTextField getTextFieldCultivo() {
        if (textFieldCultivo == null) {
            textFieldCultivo = new JTextField();
            textFieldCultivo.setColumns(10);
            textFieldCultivo.setBounds(281, 513, 1055, 32);
        }
        return textFieldCultivo;
    }
    private JLabel getLblCultivo() {
        if (lblCultivo == null) {
            lblCultivo = new JLabel("Cultivo");
            lblCultivo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblCultivo.setBounds(68, 514, 102, 24);
        }
        return lblCultivo;
    }
    private JLabel getLblSolucin() {
        if (lblSolucin == null) {
            lblSolucin = new JLabel("Solución");
            lblSolucin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblSolucin.setBounds(68, 602, 102, 24);
        }
        return lblSolucin;
    }
}
