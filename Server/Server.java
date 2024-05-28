package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {


static ArrayList<HostInf> SList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            System.out.println("Я все еще тут!");
            int idHost = 1;
            int port = 9999;
            ServerSocket ss = new ServerSocket(port);
            while(true) {
                Socket s = ss.accept();
                HostInf idSocket = new HostInf(idHost++, s);
                SList.add(idSocket);
                ServerConnectionProcessor p = new ServerConnectionProcessor(this, idSocket);
                p.start();
            }
            
        } catch (Exception e) {
            System.out.println("GG");
        } {

        }
    }

}
