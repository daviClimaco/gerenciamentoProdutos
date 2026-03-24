package daviClimaco.gerenciamentoProdutos.controller;

import daviClimaco.gerenciamentoProdutos.entity.Produto;
import daviClimaco.gerenciamentoProdutos.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto livro){ //requestbody recebe o json e transforma em objeto
        Produto requeste = produtoService.salvar(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(livro.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(){
        List<Produto> requeste = produtoService.buscarTodos(); //reotrna a lista de objetos java
        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("{id}")
    public Produto buscarPorId(@PathVariable Long id){
        return produtoService.buscarProdutoPorId(id); //retorna o objeto pelo id
    }

    @PutMapping("{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto){
        return produtoService.atualizar(id, produto);
    }
}