import java.util.Scanner;

public class CuentaCorriente extends Cuenta {
    private int sobregiro;

    public CuentaCorriente(Persona dueño , int id ,  int saldo , int numeroRetiros , int comision , int procentaje , int sobregiro) {
        super(dueño , id , saldo , numeroRetiros , comision , procentaje);
        this.sobregiro = sobregiro; 
    }

    public int getSobregiro() {
        return sobregiro;
    }


    public boolean retirar() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el valor que desea retirar");
        int retiro = leer.nextInt();
        if (retiro <= saldo + sobregiro && numeroRetiros == 0) {
            saldo -= retiro;
            saldo -= comision;
            System.out.println("Se le cobro una comision de "+ comision);
            return true;
        } else if (retiro <= saldo + sobregiro) {
            saldo -= retiro; 
            numeroRetiros -= 1;
            return true;
        } else {
            return false;
        }
    }

}
