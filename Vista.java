import java.util.Scanner;

/**
 *
 * @author Sebastian Solorzano
 */
public class Vista {
    private Scanner scan;
    Scanner entrada = new Scanner(System.in);
	
    public Vista()
    {
        scan = new Scanner(System.in);
    }

    public void bienvenida()
    {
        System.out.println("\nBienvendi@ al programa para calcular la ruta mas corta");
    }

    public int MenuOpciones()
    {
        int op;
        String s = """
                   Que desea hacer?
                   1. Agregar ciudad
                   2. Matriz de Floyd
                   3. Rutas mas cortas
                   4. Salir
                   """;
        System.out.println(s);
        op = scan.nextInt();

        return op;
    }

    public void opcionInvalida()
    {
            System.out.println("\nHa elegido una opcin invalida.\n");
    }

   public void despedida()
    {
            System.out.println("\nAdios, que tenga feliz dia!\n");
    } 
}
