package br.unitins.tp1.faixas.service;

import java.util.List;

import br.unitins.tp1.faixas.dto.FaixaRequestDTO;
import br.unitins.tp1.faixas.model.Faixa;


public interface FaixaService {

    Faixa findById(Long id);

    List<Faixa> findByNome(String nome);

    List<Faixa> findAll();

    Faixa create(FaixaRequestDTO dto);

    Faixa update(Long id, FaixaRequestDTO dto);

    void delete(Long id); 
    
}
