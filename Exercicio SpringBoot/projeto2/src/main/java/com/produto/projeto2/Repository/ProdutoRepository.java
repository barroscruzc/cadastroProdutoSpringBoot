package com.produto.projeto2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.produto.projeto2.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
