package app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.TelaLogin;

public class Main {

    public static void main(String[] args) {

        // Define o tema visual Nimbus, caso esteja disponível
        configurarTema();

        // Inicia a interface gráfica na thread correta do Swing
        java.awt.EventQueue.invokeLater(() -> {

            TelaLogin telaLogin = new TelaLogin();

            // Centraliza a tela
            telaLogin.setLocationRelativeTo(null);

            // Exibe a tela de login
            telaLogin.setVisible(true);
        });
    }

    private static void configurarTema() {

        try {

            for (UIManager.LookAndFeelInfo info
                    : UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {

                    UIManager.setLookAndFeel(
                            info.getClassName()
                    );

                    break;
                }
            }

        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | UnsupportedLookAndFeelException e) {

            System.out.println(
                    "Não foi possível carregar o tema Nimbus: "
                    + e.getMessage()
            );
        }
    }
}