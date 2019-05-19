package Main;

import java.util.logging.*;

public class SetServer {
    //host local
    // http://localhost:8080/Catalogo/produtos
    public static void main(String[] args) {
        Server s = new Server();
        try {
            s.run(new String[]{ "server" });
        } catch (Exception ex) {
            Logger.getLogger(SetServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
