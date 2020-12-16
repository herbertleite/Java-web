package br.senac.pi3.brawan.model;

import java.io.Serializable;

//classe com atributos do funcionario com getter e setter
public class Funcionario extends Pessoa implements Serializable {

    private int id;
    private String cargo;
    private String login;
    private int idEmpresa;
    private String empresa;
    private String senha;

    public Funcionario() {

    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String usuario) {
        this.login = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

}
