package br.com.fatec.readmorebookstore.controller;

import br.com.fatec.readmorebookstore.dominio.*;
import br.com.fatec.readmorebookstore.facade.ClienteFacade;
import br.com.fatec.readmorebookstore.facade.CompraFacade;
import br.com.fatec.readmorebookstore.facade.LivroFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Log4j2
@Controller
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private LivroFacade livroFacade;
    @Autowired
    private ClienteFacade clienteFacade;
    @Autowired
    private CompraFacade compraFacade;

    @GetMapping("/carrinho-compras/{clienteId}")
    public String carrinhoCompras(@PathVariable("clienteId") Integer clienteId, Model model, CompraLivro compraLivro){
        Cliente cliente = clienteFacade.getCliente(clienteId);
        model.addAttribute("cliente", cliente);
        return "carrinho";
    }

    @GetMapping("/cupons")
    public String listaCupom(){ return "cupom"; }

    @GetMapping("/detalhes-pedido")
    public String detalhesPedido(){ return "detalhes-pedido"; }

    @GetMapping("/detalhes-pedido-admin")
    public String detalhesPedidoAdmin(){ return "detalhes-pedido-admin"; }

    @GetMapping("/lista-compra/{clienteId}")
    public String listaCompra(@PathVariable("clienteId") Integer clienteId){
        return "lista-compra";
    }

    @GetMapping("/lista-venda")
    public String listaVenda(){ return "lista-venda"; }

    @GetMapping("/lista-troca")
    public String listaTroca(){ return "lista-troca"; }

    @GetMapping("/pedido/{clienteId}")
    public String pedido(@PathVariable("clienteId") Integer clienteId, Model model, Compra compra){
        Cliente cliente = clienteFacade.getCliente(clienteId);
        model.addAttribute("cliente", cliente);
        return "pedido";
    }

    @GetMapping("/troca")
    public String troca(){ return "troca"; }

    @GetMapping("/add-carrinho/{id}/{clienteId}")
    public String addCarrinho(CompraLivro compraLivro, @PathVariable("id") Integer id, @PathVariable("clienteId") Integer clienteId){
        try{
            Livro livro = livroFacade.getLivro(id);
            Cliente cliente = clienteFacade.getCliente(clienteId);
            compraLivro.setLivro(livro);
            compraLivro.setCliente(cliente);
            compraFacade.cadastrarItem(compraLivro);
            return "redirect:/livros/detalhes-livro/" + livro.getId() + "/" + cliente.getId() + "";
        } catch (Exception e) {
            log.error("Falha ao salvar item no carrinho.", e);
            return "Falha ao salvar item no carrinho.";
        }
    }

    @GetMapping("/editar-quantidade/{id}/{clienteId}")
    public String editarQuantidade( @PathVariable("id") Integer id, @PathVariable("clienteId") Integer clienteId, CompraLivro compraLivro){
        try{
            Livro livro = livroFacade.getLivro(id);
            Cliente cliente = clienteFacade.getCliente(clienteId);
            compraLivro.setLivro(livro);
            compraLivro.setCliente(cliente);
            compraFacade.cadastrarItem(compraLivro);
            return "redirect:/compras/carrinho-compras/" + cliente.getId() + "";
        } catch (Exception e) {
            log.error("Falha ao salvar item no carrinho.", e);
            return "Falha ao salvar item no carrinho.";
        }
    }
}
