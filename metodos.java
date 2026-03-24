import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class metodos {

    Scanner sc = new Scanner(System.in);

    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor digite un numero");
            sc.nextLine();
        }
        return sc.nextInt();
    }

    public Double ValidarDecimal(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Por favor digite un numero");
            sc.nextLine();
        }
        return sc.nextDouble();
    }

    public int ValidarRango(int n1, int n2, int numero) {
        metodos m = new metodos();
        while (numero < n1 || numero > n2) {
            System.out.println("Por favor ingrese un rango de :" + n1 + " hasta " + n2);
            numero = m.ValidarEntero(sc);
        }
        return numero;
    }

    public Queue<Integer> llenarCola(Queue<Integer> p) {
        metodos m = new metodos();
        boolean bandera = true;
        int opt = 0;
        while (bandera) {
            System.out.println("Ingrese el numero");
            p.offer(m.ValidarEntero(sc));
            System.out.println("Desea ingresar mas registros 1) si , 2) no");
            opt = m.ValidarEntero(sc);
            opt = m.ValidarRango(1, 2, opt);
            if (opt == 2) {
                bandera = false;
            }
        }
        return p;
    }

    public void Mostrar(Queue<Integer> p) {
        System.out.println(p);
    }

    public int Pedirdato(int opt) {
        metodos m = new metodos();
        switch (opt) {
            case 1:
                System.out.println("Ingrese El numero a Modificar");
                opt = m.ValidarEntero(sc);
                break;
            case 2:
                System.out.println("Ingrese El nuevo numero Modificado");
                opt = m.ValidarEntero(sc);
                break;
            case 3:
                System.out.println("Eliminar todos repetidos 1, eliminar solo el primero 2");
                opt = m.ValidarEntero(sc);
                break;

            default:
                System.out.println("Ingrese el numero a eliminar");
                opt = m.ValidarEntero(sc);
                break;
        }
        return opt;

    }

    public Queue<Integer> ModificarPila(Queue<Integer> cola, int numero) {
        Queue<Integer> Auxp = new LinkedList<>();
        metodos m = new metodos();
        int n = cola.size();
        for (int i = 0; i < n; i++) {
            if (cola.peek().equals(numero)) {
                cola.remove();
                Auxp.offer(m.Pedirdato(2));
            } else {
                Auxp.offer(cola.remove());
            }
        }
        for (int i = 0; i < n; i++) {
            cola.offer(Auxp.remove());
        }
        return cola;
    }

    public Queue<Integer> Eliminar(Queue<Integer> p, int numero) {
        Queue<Integer> Auxp = new LinkedList<>();
        metodos m = new metodos();
        int opt = m.Pedirdato(3);
        boolean encontrado = true;
        if (opt == 1) {
            while (!p.isEmpty()) {
                if (p.peek().equals(numero)) {
                    p.remove();
                } else {
                    Auxp.offer(p.remove());
                }
            }
        } else {

            while (!p.isEmpty()) {
                if (p.peek().equals(numero) && encontrado) {
                    p.remove();
                    encontrado = false;
                } else {
                    Auxp.offer(p.remove());
                }

            }

        }

        while (!Auxp.isEmpty()) {
            p.offer(Auxp.remove());
        }

        return p;
    }

}
