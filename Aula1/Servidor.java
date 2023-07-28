import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws InterruptedException {
        if(args.length < 1) return;
        
        int port = Integer.parseInt(args[0]);
        //Cria o soquete de servidor na porta 6868
        try (ServerSocket serverSocket = new ServerSocket(port);){
            for (int index = 0; index <= 100; index++) {
                //Começa a ouvir as solicitações de entrada do cliente
                Socket socket = serverSocket.accept();
                //Cria uma nova thread para o servidor  
                Thread threadCliente = new Thread(new ConexaoClienteThread(socket));
                threadCliente.start();
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar o socket na porta 6868, " + e.getMessage());
            e.printStackTrace();
        }

    }

    static class ConexaoClienteThread implements Runnable{
        private Socket socket;

        public ConexaoClienteThread(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try{
                System.out.println("Cliente conectado!");

                //Ler dados do cliente
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String msg = reader.readLine();
                System.out.println(msg);

                Thread.sleep(1000);

                //Enviar dados para o Cliente
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                //enviar mensagem
                printWriter.println("Oi!");
                System.out.println("Mensagem 'Oi!' enviada ao cliente!");

                socket.close();        
            }catch(IOException | InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}