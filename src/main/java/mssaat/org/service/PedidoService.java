package mssaat.org.service;

import java.util.List;

import mssaat.org.DTO.PedidoDTO;
import mssaat.org.DTO.PedidoResponseDTO;
import jakarta.validation.Valid;

public interface PedidoService {
    public PedidoResponseDTO create(@Valid PedidoDTO pedidoDto);
    public void update(Long id, PedidoDTO dto);
    public void deleteById(Long id);
    public long count();
    public PedidoResponseDTO findById(Long id);
    public List<PedidoResponseDTO> findAll();
    public List<PedidoResponseDTO> findByEndereco(String endereco);
    public List<PedidoResponseDTO> findComprasByUser(Long userId);
    public List<PedidoResponseDTO> findMyCompras();
}