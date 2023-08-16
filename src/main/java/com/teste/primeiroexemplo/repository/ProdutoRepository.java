package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiroexemplo.model.Produto;

@Repository
public class ProdutoRepository {
  
  private List<Produto> produtos = new ArrayList<Produto>();
  private Integer ultimoId = 0;

  /**
   * Esse é um javadoc
   * metodo para Retorna uma lista de produtos
   * @return lista de produtos
   */
  public List<Produto> obterTodos(){
    return produtos;
  }
  /**
   * Metodo que retorna o produto encontrado pelo id
   * @param id do produto que será localizado
   * @return Retorna um produto caso tenha encontrado
   */
  public Optional<Produto> obterPorId(Integer id){
    return produtos
      .stream()
      .filter(produto -> produto.getId() == id)
      .findFirst();
  }

  /**
   * Metodo para adicionar produto na lista.
   * @param produto que será adicionado 
   * @return retorna o produto que foi adicionado na lista
   */
  public Produto adicionar(Produto produto){
    ultimoId ++;

    produto.setId(ultimoId);
    produtos.add(produto);
    
    return produto;
  }

  /**
   * Metodo para deletar produto por id
   * @param id do produto a ser deletado
    por ser void não ter return
   */
  public void deletar(Integer id){
    
    produtos.removeIf(produto -> produto.getId() == id);

  }
  /**
   * Metodo para atualizar o produto na lista
   * @param produto que será atualizado
   * @param id do produto
   * @return retorna o produto após atualizado
   */
  public Produto atualizar(Produto produto){
    //Encontrar o produto antigo
    Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
    if(produtoEncontrado.isEmpty()){
      throw new InputMismatchException("Produto não encontrado");
    }
    // Eu tenho que remover o produto antigo da lista
    deletar(produto.getId());

    // Depois adicionar o novo produto
    produtos.add(produto);
    
    return produto;
  }


}
