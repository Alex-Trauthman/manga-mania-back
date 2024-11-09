package br.unitins.tp1.faixas.service;

import java.util.List;

import br.unitins.tp1.faixas.dto.LoteRequestDTO;
import br.unitins.tp1.faixas.model.Lote;


public interface LoteService {

    Lote findById(Long id);

    Lote findByCodigo(String codigo);

    Lote findByIdFaixa(Long idFaixa);

    List<Lote> findAll();

    Lote create(LoteRequestDTO dto);

    Lote update(Long id, LoteRequestDTO dto);

    void delete(Long id); 
    
}
