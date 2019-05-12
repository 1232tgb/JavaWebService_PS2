package Main;

import java.sql.*;

public class DataBaseConnection {

    Connection cn;
    PreparedStatement stmtC, stmtU;

    public DataBaseConnection(Connection cn) {
        try {
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//            System.out.println("Classe conectada");
//            cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Produtos");
//            System.out.println("Conexão ao banco de dados efetuada");
            this.cn = cn;

            stmtC = cn.prepareStatement("Insert into produto('descrição','marca', preço) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmtU = cn.prepareStatement("Update Produtos SET Descrição=?, Marca=?, Preco=? WHERE Id=?");

        } catch (Exception e) {
            System.out.println("ocorreu um erro " + e.getMessage());
        }

    }

    Produto Create(Produto p) {

        try {
            stmtC.setString(1, p.descricao);
            stmtC.setString(2, p.marca);
            stmtC.setDouble(3, p.preco);

            stmtC.executeUpdate();

            ResultSet rs = stmtC.getGeneratedKeys();
            rs.next();
            p.SetId(rs.getLong(1));

            return p;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro " + e.getMessage());
            return null;
        }
    }

    boolean Update(Produto p) {
        try {
            stmtU.setString(1, p.GetDescricao());
            stmtU.setString(2, p.GetMarca());
            stmtU.setDouble(3, p.GetPreco());
            stmtU.setLong(4, p.GetId());

            return stmtU.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
