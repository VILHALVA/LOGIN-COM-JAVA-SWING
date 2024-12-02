package com.exemplo.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("LOGIN COM JAVA SWING");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel usuarioLabel = new JLabel("USUÁRIO:");
        usuarioLabel.setBounds(50, 50, 80, 25);
        panel.add(usuarioLabel);

        JTextField usuarioField = new JTextField(20);
        usuarioField.setBounds(150, 50, 165, 25);
        panel.add(usuarioField);

        JLabel senhaLabel = new JLabel("SENHA:");
        senhaLabel.setBounds(50, 100, 80, 25);
        panel.add(senhaLabel);

        JPasswordField senhaField = new JPasswordField(20);
        senhaField.setBounds(150, 100, 165, 25);
        panel.add(senhaField);

        JButton cadastroButton = new JButton("CADASTRAR");
        cadastroButton.setBounds(50, 150, 120, 25);
        panel.add(cadastroButton);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(200, 150, 120, 25);
        panel.add(loginButton);

        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());

                if (usuario.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Por favor, preencha ambos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                boolean sucesso = Database.cadastrarUsuario(usuario, senha);
                if (sucesso) {
                    JOptionPane.showMessageDialog(panel, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } 
                else {
                    JOptionPane.showMessageDialog(panel, "Usuário já cadastrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());

                if (usuario.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Por favor, preencha ambos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                boolean validado = Database.validarLogin(usuario, senha);
                if (validado) {
                    JOptionPane.showMessageDialog(panel, "Bem-vindo, " + usuario + "!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } 
                else {
                    JOptionPane.showMessageDialog(panel, "Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
