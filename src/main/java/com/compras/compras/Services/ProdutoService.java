package com.compras.compras.Services;

import com.compras.compras.Models.Produto;
import com.compras.compras.Repositories.ProdutoRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepositoryInterface produtoRepositoryInterface;

    public double calcularTotal(){
        List<Produto> produtos = (List<Produto>) produtoRepositoryInterface.findAll();
        double soma = 0;
        for (Produto produto : produtos){
            soma = soma + (produto.getPreco() * produto.getQuantidade());
        }
        return soma;
    }
}
