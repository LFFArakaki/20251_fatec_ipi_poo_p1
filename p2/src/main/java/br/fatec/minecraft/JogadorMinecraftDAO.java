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
    public static void atualizar(JogadorMinecraft jogador) throws Exception {
        var sql = "UPDATE tb_jogador_minecraft SET prob_madeira=?, prob_construir=?, prob_minerar=?, num_vitorias=?, num_derrotas=? WHERE cod_jogador=?";

        try(
            var c = ConnectionFactory.obterConexao();
            var ps = c.prepareStatement(sql)
            )
        {
            ps.setFloat(1, jogador.getProbMadeira());
            ps.setFloat(2, jogador.getProbConstruir());
            ps.setFloat(3, jogador.getProbMinerar());
            ps.setInt(4, jogador.getNumVitorias());
            ps.setInt(5, jogador.getNumDerrotas());
            ps.setInt(6, jogador.getCodigo());
            ps.execute();
        }
    }
}