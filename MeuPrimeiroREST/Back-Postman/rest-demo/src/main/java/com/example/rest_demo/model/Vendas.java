package com.example.rest_demo.model;

public class Vendas {
    private String vendedorId;
    private String vendedorNome;
    private String vendedorEndereco;
    private String vendedorTelefone;
    private String salario;

    public Vendas() {
    }

    public Vendas(String vendedorId, String vendedorNome, String vendedorEndereco, String vendedorTelefone, String salario) {
        this.vendedorId = vendedorId;
        this.vendedorNome = vendedorNome;
        this.vendedorEndereco = vendedorEndereco;
        this.vendedorTelefone = vendedorTelefone;
        this.salario = salario;
    }

    public String getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(String vendedorId) {
        this.vendedorId = vendedorId;
    }

    public String getVendedorNome() {
        return vendedorNome;
    }

    public void setVendedorNome(String vendedorNome) {
        this.vendedorNome = vendedorNome;
    }

    public String getVendedorEndereco() {
        return vendedorEndereco;
    }

    public void setVendedorEndereco(String vendedorEndereco) {
        this.vendedorEndereco = vendedorEndereco;
    }

    public String getVendedorTelefone() {
        return vendedorTelefone;
    }

    public void setVendedorTelefone(String vendedorTelefone) {
        this.vendedorTelefone = vendedorTelefone;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
}
