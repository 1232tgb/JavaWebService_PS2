
package Main;


public class dataBaseTeste {
  
    public static void main(String[] args) {
        Conexao cn = new Conexao();
        DataBaseConnection db = new DataBaseConnection(cn.GetConnection("jdbc:derby://localhost:1527/Produto"));
        
        
       Produto p = db.Create(new Produto("Descrição teste","Marca teste",50.00));
        System.out.println(p.ToString());
    }
    
}
