package daviClimaco.gerenciamentoProdutos.controller;

import daviClimaco.gerenciamentoProdutos.entity.Produto;
import daviClimaco.gerenciamentoProdutos.services.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public void salvar(@RequestBody Produto livro){ //requestbody recebe o json e transforma em objeto
        produtoService.salvar(livro);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }

    @GetMapping
    public List<Produto> buscarTodos(){
        return produtoService.buscarTodos(); //reotrna a lista de objetos java
    }

    @GetMapping("{id}")
    public Produto buscarPorId(@PathVariable Long id){
        return produtoService.buscarProdutoPorId(id); //retorna o objeto pelo id
    }
}
