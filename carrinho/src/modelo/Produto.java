package modelo;

public class Produto {
    
    private int id;
    private String descricao;
    private double preco;
    private String imagem;
    private Especificacao especificacao;

    public Produto() {
    }

    public Produto(String vazio) {
        this.descricao = "";
        this.especificacao = new Especificacao();
        this.especificacao.setCor("");
        this.especificacao.setMarca("");
        this.especificacao.setModelo("");
    }

    public Produto(int id) {
        this.id = id;
    }

    public Produto(int id, String descricao, double preco, String imagem) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Especificacao getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(Especificacao especificacao) {
        this.especificacao = especificacao;
    }

    @Override
    public boolean equals(Object o) {
        try {
            Produto outro = (Produto) o;
            return outro.getId() == this.id;
        } catch (Exception e) {
            return false;
        }
    }

}
