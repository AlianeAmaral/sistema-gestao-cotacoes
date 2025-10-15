package portfolio.sistema_gestao_cotacoes.business;

import org.springframework.stereotype.Service;
import portfolio.sistema_gestao_cotacoes.infrastructure.entitys.Cotacao;
import portfolio.sistema_gestao_cotacoes.infrastructure.repository.CotacaoRepository;

@Service

public class CotacaoService {
    private final CotacaoRepository repository;

    public CotacaoService(CotacaoRepository repository) {
        this.repository = repository;
    }

    public void criarCotacao(Cotacao cotacao) {
        repository.saveAndFlush(cotacao);
    }

    public Cotacao consultarCotacaoPorId(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Cotação Não Encontrada."));
    }

    public void deletarCotacaoPorId(Integer id) {
        repository.deleteById(id);
    }

    public void atualizarCotacaoPorId(Integer id, Cotacao cotacao) {
        Cotacao cotacaoBase = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Cotação não encontrada."));
        Cotacao cotacaoAtualizada = Cotacao.builder()
                .cliente(cotacao.getCliente() != null ? cotacao.getCliente() :
                        cotacaoBase.getCliente())
                .pontoFocal(cotacao.getPontoFocal() != null ? cotacao.getPontoFocal() :
                        cotacaoBase.getPontoFocal())
                .descricao(cotacao.getDescricao() != null ? cotacao.getDescricao() :
                        cotacaoBase.getDescricao())
                .valor(cotacao.getValor() != null ? cotacao.getValor() :
                        cotacaoBase.getValor())
                .responsaveis(cotacao.getResponsaveis() != null ? cotacao.getResponsaveis() :
                        cotacaoBase.getResponsaveis())
                .dataInicial(cotacao.getDataInicial() != null ? cotacao.getDataInicial() :
                        cotacaoBase.getDataInicial())
                .status(cotacao.getStatus() != null ? cotacao.getStatus() :
                        cotacaoBase.getStatus())
                .id(cotacaoBase.getId())
                .build();

        repository.saveAndFlush(cotacaoAtualizada);
    }
}

