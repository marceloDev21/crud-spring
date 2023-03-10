package com.loja.produto.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.loja.produto.model.Produto;
import com.loja.produto.service.ProdutoService;

//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

//	@ApiOperation("Endpoint responsável por buscar todos os produtos")
//	@ApiResponses(value= {
//			@ApiResponse(code=200, message = "Consulta feita com sucesso"),
//			@ApiResponse(code=500, message = "Foi gerado um erro ao consultar os produtos"),
//			@ApiResponse(code=404, message = "URL pesquisada não corresponde "),
//			@ApiResponse(code=403, message = "Você não tem permissão")
//})

	@CrossOrigin(origins = "*")
	@GetMapping
	public List<Produto> obterTodos() {
		return produtoService.obterTodos();
	}


//	@ApiOperation("Endpoint responsável por buscar um unico produto")
//	@ApiResponses(value= {
//			@ApiResponse(code=200, message = "Consulta feita com sucesso"),
//			@ApiResponse(code=500, message = "Foi gerado um erro ao consultar o produto"),
//			@ApiResponse(code=404, message = "URL pesquisada não corresponde "),
//			@ApiResponse(code=403, message = "Você não tem permissão")
//})
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public Optional<Produto> obterporId(@PathVariable Long id) {
		return produtoService.obterPorId(id);
	}

//	@ApiOperation("Endpoint responsável por adicionar um produto")
//	@ApiResponses(value= {
//				@ApiResponse(code=200, message = "Criou um produto"),
//				@ApiResponse(code=500, message = "Foi gerado um erro ao criar o produto"),
//				@ApiResponse(code=404, message = "URL pesquisada não corresponde "),
//				@ApiResponse(code=403, message = "Você não tem permissão")
//	})
	@CrossOrigin(origins = "*")
	@PostMapping
	public Produto adicionar(@RequestBody @Valid Produto produto) {
		return produtoService.adicionar(produto);

	}

//	@ApiOperation("Endpoint responsável por deletar um produto")
//	@ApiResponses(value= {
//			@ApiResponse(code=200, message = "Produto deletado com sucesso"),
//			@ApiResponse(code=500, message = "Foi gerado um erro ao deletar o produto"),
//			@ApiResponse(code=404, message = "URL pesquisada não corresponde "),
//			@ApiResponse(code=403, message = "Você não tem permissão")
//})
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		produtoService.deletar(id);
	}

//	@ApiOperation("Endpoint responsável para atualizar um produto")
//	@ApiResponses(value= {
//			@ApiResponse(code=200, message = "Produto atualizado com sucesso"),
//			@ApiResponse(code=500, message = "Foi gerado um erro ao atualizar o produto"),
//			@ApiResponse(code=404, message = "URL pesquisada não corresponde "),
//			@ApiResponse(code=403, message = "Você não tem permissão")
//})
	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public Produto atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		return produtoService.atualizar(id, produto);

	}
	
	@GetMapping("/codigo/{codigo}")
	public List<Produto> findByCodigo(String codigo){
		return produtoService.findByCodigo(codigo);
	}

//	@ApiResponses(value= {
//			@ApiResponse(code=200, message = "Produto encontrado com sucesso"),
//			@ApiResponse(code=500, message = "Foi gerado um erro ao tentar encontrar o produto pelo codigo"),
//			@ApiResponse(code=404, message = "URL pesquisada não corresponde "),
//			@ApiResponse(code=403, message = "Você não tem permissão")
//})
//	@ApiOperation("Endpoint responsável por filtrar um produto pelo codigo")
//	@CrossOrigin(origins = "*")
//	@GetMapping("/codigo/{codigo}")
//	public Optional<Produto>obterPorCodigo(@PathVariable String codigo) {
//		return produtoService.obterPorCodigo(codigo);
//	}

}
