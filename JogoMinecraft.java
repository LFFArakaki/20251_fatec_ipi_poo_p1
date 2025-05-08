import java.util.Random;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class JogoMinecraft{
    public static void main(String [] args) throws Exception {
        var jogador = new JogadorMinecraft("Alex");
        var rand = new Random();
        Class<?> classe = JogadorMinecraft.class;
        Method [] metodos = classe.getDeclaredMethods();
        int numeroDeMetodos = 0;

        for (Method metodo : metodos) {
            if (Modifier.isPublic(metodo.getModifiers()) && !metodo.getName().equals("toString") && !metodo.getName().equals("levarDano") && !metodo.getName().equals("estaVivo") && !metodo.getName().equals("getVida")) {
                numeroDeMetodos++;
            }
        }
        while(true)
        {
            var acao = rand.nextInt(numeroDeMetodos)+1;
            var chanceDano = rand.nextDouble();
            switch(acao)
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
            if(chanceDano <= 0.25) jogador.levarDano();
            System.out.println(jogador);
            if(jogador.getVida() <= 0)
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