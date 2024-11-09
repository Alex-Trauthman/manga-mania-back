package br.unitins.tp1.faixas.dto;

import java.time.LocalDate;

import br.unitins.tp1.faixas.model.Lote;

public record LoteResponseDTO(
    Long id,
    LocalDate data,
    String codigo,
    Integer estoque,
    FaixaResponseDTO faixa 
) {

    public static LoteResponseDTO valueOf(Lote lote) {
        return new LoteResponseDTO(
            lote.getId(),
            lote.getData(),
            lote.getCodigo(),
            lote.getEstoque(),
            FaixaResponseDTO.valueOf(lote.getFaixa())
        );
    }
    
}
