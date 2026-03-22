package daviClimaco.gerenciamentoProdutos.services;

import daviClimaco.gerenciamentoProdutos.entity.Produto;
import daviClimaco.gerenciamentoProdutos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void salvar(Produto produto){
        produtoRepository.save(produto);
    }

    public void deletar(Long id){//deleta pelo id comoparametro
        produtoRepository.deleteById(id);
    }

    public Produto buscarProdutoPorId(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

}
