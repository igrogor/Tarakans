package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ServerConnectionProcessor extends Thread{
    // private Socket sock;
    HostInf idClient;
    Server Lada_jiguli_VAZ_2105;

    public ServerConnectionProcessor( Server Lada_jiguli_VAZ_2105, HostInf idHost) {
        this.Lada_jiguli_VAZ_2105 = Lada_jiguli_VAZ_2105;
        idClient = idHost;
    }

    @Override
    public void run() {
        try {
            System.out.println("The Host PC" + idClient.getId() + "крч готов");
            DataOutputStream outStream = new DataOutputStream(idClient.getSocket().getOutputStream());
            DataInputStream inputStream = new DataInputStream(idClient.getSocket().getInputStream());

            outStream.writeInt(idClient.getId());

            while (true) {
                
                outStream.writeInt(Lada_jiguli_VAZ_2105.SList.size());
                for (int i = 0; i < Lada_jiguli_VAZ_2105.SList.size(); i++) {
                    outStream.writeInt(Lada_jiguli_VAZ_2105.SList.get(i).getId());
                }
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println("Client " + idClient.getId() + " disconnected");
            for (int i = 0; i < Lada_jiguli_VAZ_2105.SList.size(); i++) {
                if (Lada_jiguli_VAZ_2105.SList.get(i).getId() == idClient.getId()) Lada_jiguli_VAZ_2105.SList.remove(i);
            }
        }
    }

}
