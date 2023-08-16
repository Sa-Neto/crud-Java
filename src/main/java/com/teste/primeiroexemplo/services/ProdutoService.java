package com.teste.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {
  
  @Autowired
  private ProdutoRepository produtoRepository;

  /**
   * Metodo para retorna uma lista de produtos
   * @return lista de produtos.
   */
  public List<Produto> obterTodos(){
    //Coloca regra aqui caso tenha
    return produtoRepository.obterTodos();
  }

  /**
   * Metodo que retorna o produto encontrado pelo id
   * 
   * @param id do produto que será localizado
   * @return Retorna um produto caso tenha encontrado
   */
  public Optional<Produto> obterPorId(Integer id){
    return produtoRepository.obterPorId(id);
  }

  /**
   * Metodo para adicionar produto na lista.
   * 
   * @param produto que será adicionado
   * @return retorna o produto que foi adicionado na lista
   */
  public Produto adicionar(Produto produto){
    // Poderia ter alguma regra de negocio para validar o produto
    return produtoRepository.adicionar(produto);
  
  }
  
  /**
   * Metodo para deletar produto por id
   * @param id do produto a ser deletado
   *           por ser void não ter return
   */
  public void deletar( Integer id){
    //poderia ter alguma logica de validação 
    produtoRepository.deletar(id);
  }
 
  /**
   * Metodo para atualizar o produto na lista
   * 
   * @param produto que será atualizado
   * @return retorna o produto após atualizado
   */
  public Produto atualizar(Integer id, Produto produto){
    
    //ter alguma validação no produto
    produto.setId(id);
    
    return produtoRepository.atualizar(produto);
  
  }
  

}
