package com.example.rest_demo.controller;

import com.example.rest_demo.model.Vendas;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/vendedores")
@CrossOrigin(origins = "http://localhost:3000")  // Altere a porta conforme necessário
public class VendasController {

    private List<Vendas> vendedores = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger();

    @GetMapping
    public List<Vendas> getVendedores() {
        return vendedores;  // Retorna a lista de todos os vendedores
    }

    @GetMapping("/{vendedorId}")
    public Vendas getVendedorDetalhe(@PathVariable int vendedorId) {
        return vendedores.stream()
                .filter(v -> v.getVendedorId() == vendedorId)
                .findFirst()
                .orElse(null); // Ou lançar uma exceção apropriada
    }

    @PostMapping
    public String criarVendedor(@RequestBody Vendas vendedor) {
        vendedor.setVendedorId(idCounter.incrementAndGet());
        vendedores.add(vendedor);
        return "O Vendedor foi criado com sucesso!";
    }

    @PutMapping("/{vendedorId}")
    public String atualizarVendedor(@PathVariable int vendedorId, @RequestBody Vendas vendedorAtualizado) {
        for (int i = 0; i < vendedores.size(); i++) {
            Vendas vendedor = vendedores.get(i);
            if (vendedor.getVendedorId() == vendedorId) {
                vendedorAtualizado.setVendedorId(vendedorId);  // Garantir que o ID não mude
                vendedores.set(i, vendedorAtualizado);
                return "O Vendedor foi atualizado com sucesso!";
            }
        }
        return "Vendedor não encontrado!";
    }

    @DeleteMapping("/{vendedorId}")
    public String deletarVendedor(@PathVariable int vendedorId) {
        for (int i = 0; i < vendedores.size(); i++) {
            Vendas vendedor = vendedores.get(i);
            if (vendedor.getVendedorId() == vendedorId) {
                vendedores.remove(i);
                return "O Vendedor foi deletado com sucesso!";
            }
        }
        return "Vendedor não encontrado!";
    }
}
