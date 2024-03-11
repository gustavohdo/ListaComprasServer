package com.compras.compras.Repositories;

import com.compras.compras.Models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepositoryInterface extends CrudRepository<Produto, Long> {
}
