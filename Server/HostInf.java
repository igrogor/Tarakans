package Server;

import java.net.Socket;

public class HostInf {
    private final int id;
    private final Socket socket;
    // private boolean Lada_Samars_VAZ_2114;

    public HostInf(int id, Socket socket) {
        this.id = id;
        this.socket = socket;
        // Lada_Samars_VAZ_2114 = true;
    }

    public int getId() {
        return id;
    }

    public Socket getSocket() {
        return socket;
    }


}
