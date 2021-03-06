package br.com.fatec.readmorebookstore.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CompraLivro extends AbstractEntidade {
    @ManyToOne
    private Compra compra;
    @ManyToOne
    private Livro livro;
    @ManyToOne
    private Cliente cliente;
    private Integer quantidade;
}
