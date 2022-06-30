package com.produto.projeto2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.produto.projeto2.models.Produto;
import com.produto.projeto2.Repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@SuppressWarnings("unused")
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> getProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	Produto getProduto(@PathVariable Long id) {
		return produtoRepository.findById(id).get();
	}
	
	
	@PostMapping("/cadastrar")
	public Produto cadastrar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/excluir/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void excluir(@PathVariable long id) {
		produtoRepository.deleteById(id);
	}
	
	@PutMapping("/alterar/{id}")
	public Produto alterarProduto(@RequestBody Produto novoProduto, @PathVariable Long id) {
		Produto produto = produtoRepository.findById(novoProduto.getId()).get();
		if(novoProduto.getCodigo()!= 0) {
		produto.setCodigo(novoProduto.getCodigo());
		}
		if(novoProduto.getNome()!= null) {
		produto.setNome(novoProduto.getNome());
		}
		if(novoProduto.getValor() != 0) {
		produto.setValor(novoProduto.getValor());
		}
		produto.setQuantidade(novoProduto.getQuantidade());
		produto.setCategoria(novoProduto.getCategoria());
		
		return produtoRepository.save(produto);
	}
}
