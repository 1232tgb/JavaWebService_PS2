package Main;

import java.sql.*;
import java.util.*;

public class DataBaseConnection {

    Connection cn;
    PreparedStatement stmtC, stmtR, stmtU, stmtD, stmtRU;

    public DataBaseConnection(Connection cn) {
        try {
            this.cn = cn;
            stmtC = cn.prepareStatement("Insert into Produtos(descrição, marca, preço) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmtR = cn.prepareStatement("Select * from Produtos");
            stmtU = cn.prepareStatement("Update Produtos SET Descrição=?, Marca=?, Preço=? WHERE Id=?");
            stmtD = cn.prepareStatement("Delete from Produtos WHERE id=?");
            stmtRU = cn.prepareStatement("Select * FROM Produtos WHERE id=?");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ocorreu um erro: " + e.getMessage());
        }

    }

    public Produto Create(Produto p) {

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
            e.printStackTrace();
            System.out.println("Ocorreu um erro " + e.getMessage());
            return null;
        }
    }

    public List<Produto> Read() {
        List<Produto> produtos = new ArrayList<>();
        try {
            ResultSet rs = stmtR.executeQuery();

            while (rs.next()) {
                Produto p = new Produto(rs.getString("Descrição"), rs.getString("Marca"), rs.getDouble("Preço"));
                p.SetId(rs.getLong("Id"));
                produtos.add(p);
            }

            return produtos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Produto Update(Produto p) {
        try {
            stmtU.setString(1, p.GetDescricao());
            stmtU.setString(2, p.GetMarca());
            stmtU.setDouble(3, p.GetPreco());
            stmtU.setLong(4, p.GetId());

            stmtU.executeUpdate();
            return p;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean Delete(long id) {

        try {
            stmtD.setLong(1, id);
            return stmtD.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Produto readSingle(long id) {
        try {
            stmtRU.setLong(1, id);
            ResultSet rs = stmtRU.executeQuery();
            if (rs.next()) {
                Produto p = new Produto();
                p.SetId(rs.getLong("Id"));
                p.SetDescricao(rs.getString("Descrição"));
                p.SetMarca(rs.getString("Marca"));
                p.SetPreco(rs.getDouble("Preço"));
                return p;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
