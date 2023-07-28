import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    public static void main(String[] args) {
        if(args.length < 2) return;

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);
        
        try{
            for (int i = 0; i <= 100; i++) {
                //Cria uma nova thread para cada cliente
                Thread clienteThread = new Thread(new ClienteThread(hostname, port));
                clienteThread.start();
            }
        }catch(NumberFormatException e){
            System.out.println("erro ao converter porta, ex: " + e.getMessage());
            e.getStackTrace();
        }
    }

    static class ClienteThread implements Runnable{
        private String hostname;
        private int port;

        public ClienteThread(String hostname, int port){
            this.hostname = hostname;
            this.port = port;
        }

        @Override
        public void run() {
            try(Socket socket = new Socket(hostname, port)){
                //Enviar dados para o Servidor
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                //enviar mensagem
                printWriter.println("Olá!");
            }catch (UnknownHostException e){
                System.out.println("Servidor não encontrado: " + e.getMessage());
                e.printStackTrace();
            }catch (IOException e){
                System.out.println("I/O Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
