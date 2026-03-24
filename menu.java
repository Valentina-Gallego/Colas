import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*  public static void main(String[] args) {
     Scanner teclado = new Scanner(System.in);
     Queue<Integer> c = new LinkedList<>();
     boolean continuar = true;
     while (continuar) {
        // c.offer((int)(Math.random() * 200 + 1)); //llenar cola
        c.offer(teclado.nextInt());
         System.out.println("DESEA CONTINUAR 1. SI . 2. NO");
         int opt = teclado.nextInt();

         if (opt == 2) {
             System.out.println("HASTA LUEGO");
             continuar = false;
         }
     }

     System.out.println(c);


 }*/

public class menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        metodos m = new metodos();
        Queue<Integer> cola = new LinkedList<>();
        boolean seguir = true;
        int opt = 0, numero = 0;
        while (seguir) {
            System.out.println("Que desea realizar");
            System.out.println("1) llenar Cola");
            System.out.println("2) mostrar Cola");
            System.out.println("3) Modificar Cola");
            System.out.println("4) eliminar");
            System.out.println("5) Salir");
            opt = m.ValidarEntero(sc);
            switch (opt) {
                case 1:
                    cola = m.llenarCola(cola);
                    break;
                case 2:
                    m.Mostrar(cola);
                    break;
                case 3:
                    numero = m.Pedirdato(1);
                    cola = m.ModificarPila(cola, numero);
                    break;
                case 4:
                    int choise = 0;
                    numero = m.Pedirdato(4);
                    System.out.println("que metodo desea implementar 1) el depilas");
                    choise = sc.nextInt();
                    switch (choise) {
                        case 1:
                            cola = m.Eliminar(cola, numero);
                            break;

                    }

                    break;
                case 5:
                    System.out.println("Gracias por venir ");
                    seguir = false;
                    break;

                default:
                    System.out.println("home de 1 a 5 no joda");
                    break;
            }

        }
    }
}
