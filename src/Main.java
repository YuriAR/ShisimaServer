import java.rmi.Naming;

public class Main {

    public static void main(String[] args) {
        try{
            Server server = new Server();
            Naming.rebind("//localhost/MessagingInterface", server);
            System.out.println("Servidor Registrado!");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }
    }
}
