package daviClimaco.gerenciamentoProdutos.entity;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "Produto")
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "qtdEstoque")
    private Integer estoque;


}
