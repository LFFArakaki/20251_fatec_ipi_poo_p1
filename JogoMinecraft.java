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
            if (Modifier.isPublic(metodo.getModifiers()) && !metodo.getName().equals("toString") && !metodo.getName().equals("levarDano") && !metodo.getName().equals("estaVivo")) {
                numeroDeMetodos++;
            }
        }
        while(true)
        {
            var acao = rand.nextInt(numeroDeMetodos)+1;
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
            System.out.println(jogador);
            System.out.println("============");
            Thread.sleep(5000);
        }
    }
}