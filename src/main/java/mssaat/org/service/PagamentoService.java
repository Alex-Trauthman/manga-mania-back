package mssaat.org.service;

import java.util.List;

import mssaat.org.DTO.PagamentoDTO;
import mssaat.org.DTO.PagamentoResponseDTO;
import jakarta.validation.Valid;

public interface PagamentoService {
    public PagamentoResponseDTO create(@Valid PagamentoDTO pedidoDto);
    public void update(Long id, PagamentoDTO dto);
    public void deleteById(Long id);
    public long count();
    public List<PagamentoResponseDTO> findAll();
    public PagamentoResponseDTO findById(Long id);
}