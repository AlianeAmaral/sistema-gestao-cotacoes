package portfolio.sistema_gestao_cotacoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.sistema_gestao_cotacoes.business.CotacaoService;
import portfolio.sistema_gestao_cotacoes.infrastructure.entitys.Cotacao;

@RestController
@RequestMapping("/cotacoes")
@RequiredArgsConstructor

public class CotacaoController {

    private final CotacaoService cotacaoService;

    @PostMapping
    public ResponseEntity<Void> criarCotacao(@RequestBody Cotacao cotacao) {
        cotacaoService.criarCotacao(cotacao);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Cotacao> consultarCotacaoPorId(@RequestParam Integer id) {
        cotacaoService.consultarCotacaoPorId(id);
        return ResponseEntity.ok(cotacaoService.consultarCotacaoPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarCotacaoPorId(@RequestParam Integer id) {
        cotacaoService.deletarCotacaoPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarCotacaoPorId(@RequestParam Integer id, @RequestBody Cotacao cotacao) {
        cotacaoService.atualizarCotacaoPorId(id, cotacao);
        return ResponseEntity.ok().build();
    }
}

