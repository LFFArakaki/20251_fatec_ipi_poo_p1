package br.fatec.minecraft;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JogadorMinecraft {
    private int codigo;
    private String nome;
    private int vida;
    private int blocosColetados;
    private float probMadeira;
    private float probConstruir;
    private float probMinerar;
    private int numVitorias;
    private int numDerrotas;
    private List<String> inventario;

    public JogadorMinecraft(int codigo, String nome, float probMadeira, float probConstruir, float probMinerar, int numVitorias, int numDerrotas) {
        this.codigo = codigo;
        this.nome = nome;
        this.vida = 10;
        this.blocosColetados = 0;
        this.inventario = new ArrayList<>();
        this.probMadeira = probMadeira;
        this.probConstruir = probConstruir;
        this.probMinerar = probMinerar;
        this.numVitorias = numVitorias;
        this.numDerrotas = numDerrotas;
    }

    public JogadorMinecraft(String nome) {
        this.nome = nome;
        this.vida = 10;
        this.blocosColetados = 0;
        this.inventario = new ArrayList<>();
    }

    public void minerar() {
        System.out.println(nome + " esta minerando...");
        blocosColetados++;
        inventario.add("Pedra");
    }

    public void coletarMadeira() {
        System.out.println(nome + " coletou madeira.");
        inventario.add("Madeira");
    }

    public void construir() {
        if (inventario.size() >= 2) {
            System.out.println(nome + " construiu algo com seus recursos!");
            inventario.remove(0);
            inventario.remove(0);
        } else {
            System.out.println(nome + " nao tem blocos suficientes para construir.");
        }
    }

    public void atacar(JogadorMinecraft inimigo){
        System.out.println(this.nome + " atacou " + inimigo.getNome());
        inimigo.levarDano();
    }

    public void levarDano() {
        vida--;
        System.out.println(nome + " levou dano! Vida atual: " + vida);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    @Override
    public String toString() {
        return String.format(
            "%s - Vida: %d, Blocos: %d, Inventario: %s",
            nome, vida, blocosColetados, inventario
        );
    }
}
