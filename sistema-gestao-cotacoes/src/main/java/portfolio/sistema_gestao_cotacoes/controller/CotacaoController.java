package portfolio.sistema_gestao_cotacoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio.sistema_gestao_cotacoes.business.CotacaoService;
import portfolio.sistema_gestao_cotacoes.infrastructure.entitys.Cotacao;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<Cotacao> consultarCotacaoPorId(@PathVariable Integer id) {
        cotacaoService.consultarCotacaoPorId(id);
        return ResponseEntity.ok(cotacaoService.consultarCotacaoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCotacaoPorId(@PathVariable Integer id) {
        cotacaoService.deletarCotacaoPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCotacaoPorId(@PathVariable Integer id, @RequestBody Cotacao cotacao) {
        cotacaoService.atualizarCotacaoPorId(id, cotacao);
        return ResponseEntity.ok().build();
    }
}

