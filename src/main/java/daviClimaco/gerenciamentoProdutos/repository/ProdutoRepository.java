package daviClimaco.gerenciamentoProdutos.repository;

import daviClimaco.gerenciamentoProdutos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> { //long por que e o tipo do id
}
