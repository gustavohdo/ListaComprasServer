package com.compras.compras.Controllers;

import com.compras.compras.Models.Produto;
import com.compras.compras.Repositories.ProdutoRepositoryInterface;
import com.compras.compras.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepositoryInterface produtoRepositoryInterface;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public List<Produto> listar() {
      return (List<Produto>) produtoRepositoryInterface.findAll();
    }

    @GetMapping("/consultar/{id}")
    public Optional<Produto> consultar(@PathVariable("id") long id) {
        return produtoRepositoryInterface.findById(id);
    }

    @PostMapping("/inserir")
    public Produto inserir(@RequestBody Produto produto) {
        produtoRepositoryInterface.save(produto);
        return produto;
    }

    @PutMapping("editar/{id}")
    public Produto editar(@PathVariable("id") long id, @RequestBody Produto produto) {
        Optional<Produto> updateProduto = produtoRepositoryInterface.findById(id);
        if(updateProduto.isPresent()){
            Produto produtoAtual = updateProduto.get();
            produtoAtual.setNome(produto.getNome());
            produtoAtual.setDescricao(produto.getDescricao());
            produtoAtual.setQuantidade(produto.getQuantidade());
            produtoAtual.setPreco(produto.getPreco());
            produtoRepositoryInterface.save(produtoAtual);
        }
        return updateProduto.get();
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") long id) {
        produtoRepositoryInterface.deleteById(id);
        return "Produto deletado com sucesso";
    }

    @GetMapping("/total")
    public double total(){
        return produtoService.calcularTotal();
    }
}
