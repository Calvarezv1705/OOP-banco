import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

    public int menu() {
        boolean correcto = false;
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese que acciones desea realizar");
        System.out.println("1: Retirar");
        System.out.println("2: Depositar");
        System.out.println("3: Consultar datos");
        int opcion = leer.nextInt();

        while (correcto == false) {
            if (opcion < 1 || opcion > 3) {
                System.out.println("opcion incorrecta");
                opcion = leer.nextInt();
            } else {
                correcto = true;
            }
        }
        return opcion; 
    }

    public int menuCuenta(ArrayList<Cuenta> cuentas) {
        boolean correcto = false;
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el id de su cuenta");
        int id = leer.nextInt();
        int pos = -1;

        while (correcto == false) {
            for (int i = 0 ; i < cuentas.size() ; i++ ) {
                if (id == cuentas.get(i).getId()) {
                    pos = i;
                    correcto = true;
                    break;
                } 
            }

            if (pos == -1) {
                System.out.println("No hay id");
                id = leer.nextInt();
            }
        }

        return pos; 
        
    }
    public static void main(String[] args) {

        Banco banco = new Banco();

        ArrayList<Cuenta>cuentas = new ArrayList<>(); 

        Persona julian = new Persona(12, "Julian", "Villada", "Hoy");

        CuentaAhorro nuevaCuentaAhorro = new CuentaAhorro(julian, 1 , 0, 3, 10, 5);

        CuentaCorriente nuevCuentaCorriente = new CuentaCorriente(julian, 2 , 0, 3, 10, 5 , 10);

        cuentas.add(nuevaCuentaAhorro);
        cuentas.add(nuevCuentaCorriente);

        
        int opcion = banco.menu();

        while (opcion != 0) {
            int cuentaElegida = banco.menuCuenta(cuentas);
            if (opcion == 1) {
                boolean retiroEfectivo = cuentas.get(cuentaElegida).retirar();

                if (retiroEfectivo == true) {
                    System.out.println("retiro realizado");
                } else {
                    System.out.println("retiro fallido");
                }

            } else if (opcion == 2) {
                boolean depositoEfectivo = cuentas.get(cuentaElegida).depositar();

                if (depositoEfectivo == true) {
                    System.out.println("Deposito realizado");
                } else {
                    System.out.println("Deposito fallido");
                }

            } else {
                cuentas.get(cuentaElegida).consultar();
            }
            opcion = banco.menu();
        }
   

   
    }

  
}
