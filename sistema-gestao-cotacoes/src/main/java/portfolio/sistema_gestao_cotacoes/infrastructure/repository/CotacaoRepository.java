package portfolio.sistema_gestao_cotacoes.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.sistema_gestao_cotacoes.infrastructure.entitys.Cotacao;

import java.util.Optional;

public interface CotacaoRepository extends JpaRepository<Cotacao, Integer> {
    Optional<Cotacao> findById(Integer id);
}
