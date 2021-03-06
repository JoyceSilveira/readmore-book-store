package br.com.fatec.readmorebookstore.dominio;

import lombok.Getter;

@Getter
public enum TipoEnderecoEnum {
    ENTREGA("Entrega"),
    COBRANCA("Cobrança");

    private String descricao;

    TipoEnderecoEnum(String descricao) {
        this.descricao = descricao;
    }
}
