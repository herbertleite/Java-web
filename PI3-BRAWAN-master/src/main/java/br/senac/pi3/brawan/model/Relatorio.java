package br.senac.pi3.brawan.model;

//Classe com todos os atributos de um relatorio com getter e setter
public class Relatorio {
    
    private int codigo;
    private int qtdComprado;
    private String dataCompra;
    private float totFaturado;
    private String empresa;
    private String cliente;
    private String caixa;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtdComprado() {
        return qtdComprado;
    }

    public void setQtdComprado(int qtdComprado) {
        this.qtdComprado = qtdComprado;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public float getTotFaturado() {
        return totFaturado;
    }

    public void setTotFaturado(float totFaturado) {
        this.totFaturado = totFaturado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCaixa() {
        return caixa;
    }

    public void setCaixa(String caixa) {
        this.caixa = caixa;
    }
    
}
