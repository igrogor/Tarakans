
    import java.io.DataOutputStream;
    import java.io.IOException;
    import java.net.Socket;
    
    public class Client {
        String host;
        Socket socket;
        int port;
        int idClient;
    
        Client() throws IOException {
            host = "localhost";
            port = 9999;
            socket = new Socket(host, port);
        }
    }

