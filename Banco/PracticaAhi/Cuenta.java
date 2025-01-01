import java.util.Scanner;

abstract class Cuenta implements ICuenta {
    private Persona dueño;
    private int id; 
    protected int saldo;
    protected int numeroRetiros;
    protected int comision;
    private int porcentaje;

    public Cuenta (Persona dueño , int id , int saldo , int numeroRetiros , int comision , int porcentaje) {
        this.dueño = dueño;
        this.id = id;
        this.numeroRetiros = numeroRetiros;
        this.saldo = saldo;
        this.comision = comision;
        this.porcentaje = porcentaje;
    }

    //Getters
    public int getComision() {
        return comision;
    }

    public Persona getDueño() {
        return dueño;
    }

    public int getporcentaje() {
        return porcentaje;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getId() {
        return id;
    }

    public boolean depositar() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el valor que desea depositar");
        int deposito = leer.nextInt();
        if (deposito > 0) {
            saldo += deposito; 
            return true;
        } else {
            return false;
        }
    }

    public boolean retirar() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el valor que desea retirar");
        int retiro = leer.nextInt();
        if (retiro <= saldo) {
            saldo -= retiro; 
            return true;
        } else {
            return false;
        }
    }

    public void consultar(){
        System.out.println("Este es su saldo" + saldo);
    }

}