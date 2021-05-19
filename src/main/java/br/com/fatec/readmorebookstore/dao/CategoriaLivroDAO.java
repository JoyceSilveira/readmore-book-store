package br.com.fatec.readmorebookstore.dao;

import br.com.fatec.readmorebookstore.dominio.CategoriaLivro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaLivroDAO extends CrudRepository<CategoriaLivro, Integer>{
}
