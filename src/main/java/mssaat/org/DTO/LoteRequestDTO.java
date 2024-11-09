package br.unitins.tp1.faixas.dto;

import java.time.LocalDate;

public record LoteRequestDTO(
    Long idFaixa, 
    LocalDate data, 
    String codigo,
    Integer estoque
) {}
