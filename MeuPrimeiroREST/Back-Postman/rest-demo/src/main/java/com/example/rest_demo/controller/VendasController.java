package com.example.rest_demo.controller;

import com.example.rest_demo.model.Vendas;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vendedores")
public class VendasController {

    private List<Vendas> vendedores = new ArrayList<>();

    @GetMapping
    public List<Vendas> getVendedores() {
        return vendedores;  // Retorna a lista de todos os vendedores
    }

    @GetMapping("/{vendedorId}")
    public Vendas getVendedorDetalhe(@PathVariable String vendedorId) {
        return vendedores.stream()
                .filter(v -> v.getVendedorId().equals(vendedorId))
                .findFirst()
                .orElse(null); // Ou lançar uma exceção apropriada
    }

    @PostMapping
    public String criarVendedor(@RequestBody Vendas vendedor) {
        vendedores.add(vendedor);
        return "O Vendedor foi criado com sucesso!";
    }

    @PutMapping("/{vendedorId}")
    public String atualizarVendedor(@PathVariable String vendedorId, @RequestBody Vendas vendedorAtualizado) {
        for (int i = 0; i < vendedores.size(); i++) {
            Vendas vendedor = vendedores.get(i);
            if (vendedor.getVendedorId().equals(vendedorId)) {
                vendedores.set(i, vendedorAtualizado);
                return "O Vendedor foi atualizado com sucesso!";
            }
        }
        return "Vendedor não encontrado!";
    }

    @DeleteMapping("/{vendedorId}")
    public String deletarVendedor(@PathVariable String vendedorId) {
        for (int i = 0; i < vendedores.size(); i++) {
            Vendas vendedor = vendedores.get(i);
            if (vendedor.getVendedorId().equals(vendedorId)) {
                vendedores.remove(i);
                return "O Vendedor foi deletado com sucesso!";
            }
        }
        return "Vendedor não encontrado!";
    }
}
