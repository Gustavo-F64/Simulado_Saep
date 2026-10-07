package util;

import model.Usuario;

public class Sessao {

    private static Usuario usuarioLogado;
    private static long inicioSessao;

    // 30 minutos em milissegundos
    private static final long TEMPO_LIMITE = 30 * 60 * 1000;

    private Sessao() {
    }

    public static void iniciar(Usuario usuario) {
        usuarioLogado = usuario;
        inicioSessao = System.currentTimeMillis();
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static String getNomeUsuario() {
        if (usuarioLogado != null) {
            return usuarioLogado.getNome();
        }

        return "";
    }

    public static boolean estaAtiva() {

        if (usuarioLogado == null) {
            return false;
        }

        long tempoAtual = System.currentTimeMillis();
        long tempoDecorrido = tempoAtual - inicioSessao;

        if (tempoDecorrido >= TEMPO_LIMITE) {
            encerrar();
            return false;
        }

        return true;
    }

    public static void encerrar() {
        usuarioLogado = null;
        inicioSessao = 0;
    }
}