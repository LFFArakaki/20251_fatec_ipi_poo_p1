package br.fatec.minecraft;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JogadorMinecraftDAO {
    public static ArrayList<JogadorMinecraft> listar() throws Exception {
        var jogadores = new ArrayList<JogadorMinecraft>();
        var sql = "SELECT * FROM tb_jogador_minecraft";

        try(
            var c = ConnectionFactory.obterConexao();
            var ps = c.prepareStatement(sql);
            var rs = ps.executeQuery();      
        )
        {
            while(rs.next())
            {
                var codigo = rs.getInt("cod_jogador");
                var nome = rs.getString("nome");
                var probMadeira = rs.getFloat("prob_madeira");
                var probConstruir = rs.getFloat("prob_construir");
                var probMinerar = rs.getFloat("prob_minerar");
                var numVitorias = rs.getInt("num_vitorias");
                var numDerrotas = rs.getInt("num_derrotas");
                var jogador = new JogadorMinecraft(codigo, nome, probMadeira, probConstruir, probMinerar, numVitorias, numDerrotas);
                jogadores.add(jogador);

            }
            return jogadores;
        }
    }
}