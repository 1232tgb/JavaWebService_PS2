package Main;

import java.sql.*;

public class DataBaseConnection {

    Connection cn;

    public DataBaseConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Classe conectada");
            cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Produtos");
            System.out.println("Conexão ao banco de dados efetuada");

        } catch (Exception e) {
            System.out.println("ocorreu um erro "+ e.getMessage());
        }

    }

    boolean Create(Produto p) {
        String command = "Insert into produto('descrição','marca', preço) values(?,?,?)";
        try {
            PreparedStatement stm = cn.prepareStatement(command);
            stm.setString(1, p.descricao);
            stm.setString(2, p.marca);
            stm.setDouble(3, p.preco);
            
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
             System.out.println("ocorreu um erro "+ e.getMessage());
            return false;
        }
    }

}
