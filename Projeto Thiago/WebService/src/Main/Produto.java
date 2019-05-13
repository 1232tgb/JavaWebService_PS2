package Main;

class Produto {

    long id;
    String descricao, marca;
    double preco;

    public Produto(){}
    
    public Produto(String descricao, String marca, double preco) {
        this.descricao = descricao;
        this.marca = marca;
        this.preco = preco;
    }

    public void SetDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void SetMarca(String marca) {
        this.marca = marca;
    }

    public void SetPreco(double preco) {
        this.preco = preco;
    }

    public String GetDescricao() {
        return descricao;
    }

    public String GetMarca() {
        return marca;
    }

    public double GetPreco() {
        return preco;
    }

    public void SetId(long id){
        this.id = id;
    }
    
    public long GetId(){
        return id;
    }
     public String ToString() {
        return "Produto - ID:"+ id +", Descrição:" + descricao+", Marca: "+ marca+", Preço: "+ preco+".";
    }
    
}
