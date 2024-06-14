package com.example.rest_demo.model;

public class Vendas {
    private int vendedorId;
    private String vendedorNome;
    private String vendedorEndereco;
    private String vendedorTelefone;

    // Getters e setters
    public int getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(int vendedorId) {
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
}
