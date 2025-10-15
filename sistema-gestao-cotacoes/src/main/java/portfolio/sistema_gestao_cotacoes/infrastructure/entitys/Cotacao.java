package portfolio.sistema_gestao_cotacoes.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cotacao")
@Entity

public class Cotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "cliente")
    private String cliente;

    @Column(name = "pontoFocal")
    private String pontoFocal;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "responsaveis")
    private String responsaveis;

    @Column(name = "dataInicial")
    private String dataInicial;

    @Column(name = "status")
    private String status;
}
