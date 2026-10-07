package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Usuario;
import util.Seguranca;

public class UsuarioDAO {

    public Usuario autenticar(String login, String senha) {

        String sql =
                "SELECT id, nome, login " +
                "FROM usuario " +
                "WHERE login = ? AND senha = ?";

        try (
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql)
        ) {

            stmt.setString(1, login);
            stmt.setString(2, Seguranca.gerarHash(senha));

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));

                return usuario;
            }

        } catch (Exception e) {

            System.out.println(
                    "Erro ao autenticar usuário: "
                    + e.getMessage()
            );
        }

        return null;
    }
}