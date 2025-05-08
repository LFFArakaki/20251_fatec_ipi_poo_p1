import java.util.Random;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class JogoMinecraft{
    public static void main(String [] args) throws Exception {
        var jogador = new JogadorMinecraft("Alex");
        var jogador2 = new JogadorMinecraft("Steve Construtor");
        var rand = new Random();
        Class<?> classe = JogadorMinecraft.class;
        Method [] metodos = classe.getDeclaredMethods();
        int numeroDeMetodos = 0;

        for (Method metodo : metodos) {
            if (Modifier.isPublic(metodo.getModifiers()) && !metodo.getName().equals("toString") && !metodo.getName().equals("levarDano") && !metodo.getName().equals("estaVivo") && !metodo.getName().equals("getNome") && !metodo.getName().equals("atacar")) {
                numeroDeMetodos++;
            }
        }
        while(true)
        {
            var acaoAlex = rand.nextInt(numeroDeMetodos)+1;
            var chanceDanoAlex = rand.nextDouble();
            var chanceDanoSteve = rand.nextDouble();
            var acaoSteve = rand.nextDouble();
            var chanceAtaque = rand.nextDouble();

            if(jogador.estaVivo() && jogador2.estaVivo())
            {
                if(chanceAtaque <= 0.5) jogador.atacar(jogador2);
                else jogador2.atacar(jogador);
            }

            if(jogador.estaVivo())
            {
                switch(acaoAlex)
                {
                    case 1:
                    jogador.minerar();
                    break;
                    case 2:
                    jogador.coletarMadeira();
                    break;
                    case 3:
                    jogador.construir();
                    break;
                    default:
                    System.out.println("Acao invalida!");
                }
                if(chanceDanoAlex <= 0.25) jogador.levarDano();
            }
            if(jogador2.estaVivo())
            {
                if(acaoSteve <= 0.6) jogador2.construir();
                if(acaoSteve > 0.6 && acaoSteve <= 0.9) jogador2.coletarMadeira();
                if(acaoSteve > 0.9 && acaoSteve <= 1) jogador2.minerar();
                if(chanceDanoSteve <= 0.25) jogador2.levarDano();
            }    

            System.out.println(jogador);
            System.out.println(jogador2);
            if(!jogador.estaVivo() && !jogador2.estaVivo())
            {
                System.out.println("-------------");
                System.out.println("| GAME OVER |");
                System.out.println("-------------");
                break;
            } 
            System.out.println("============");
            Thread.sleep(5000);
        }
    }
}