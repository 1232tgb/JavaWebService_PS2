package Main;

class Produto {

    String descricao, marca;
    double preco;

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

    
     public String ToString() {
        return "Produto - Descrição:" + descricao+", Marca: "+ marca+", Preço: "+ preco+".";
    }
    
}
