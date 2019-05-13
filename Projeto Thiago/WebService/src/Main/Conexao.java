package Main;

import java.sql.*;

public class Conexao {

    public Connection GetConnection(String user, String password, String url) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Classe conectada");
            Connection cn = DriverManager.getConnection(user, password, url);
            System.out.println("Conexão ao banco de dados efetuada");
            return cn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
