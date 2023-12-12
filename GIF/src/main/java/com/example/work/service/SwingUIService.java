package com.example.work.service;

import com.example.work.front.VentanaPrincipal;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class SwingUIService {

    private final UsuarioService usuarioService;
    private final MuestraService muestraService;

    public SwingUIService(UsuarioService usuarioService, MuestraService muestraService) {
        this.usuarioService = usuarioService;
        this.muestraService = muestraService;
    }

    public void startSwingUI() {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(usuarioService, muestraService);

        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventanaPrincipal.setVisible(true);
    }
}