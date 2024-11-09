package br.unitins.tp1.faixas.dto;

import br.unitins.tp1.faixas.model.Faixa;

public record FaixaResponseDTO(Long id, String nome, Double preco) {

    public static FaixaResponseDTO valueOf(Faixa faixa) {
        return new FaixaResponseDTO (
            faixa.getId(), 
            faixa.getNome(), 
            faixa.getPreco()
        );
    }
    
}
