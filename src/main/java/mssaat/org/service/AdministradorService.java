package mssaat.org.service;

import java.util.List;

import jakarta.validation.Valid;
import mssaat.org.DTO.AdministradorDTO;
import mssaat.org.DTO.AdministradorResponseDTO;

public interface AdministradorService {
    public AdministradorResponseDTO create(@Valid AdministradorDTO adminDto);
    public AdministradorResponseDTO login(String username, String senha);
    public AdministradorResponseDTO findById(Long id);
    public List<AdministradorResponseDTO> findAll(int page, int pageSize);
    public List<AdministradorResponseDTO> findByNome(String nome);
    public List<AdministradorResponseDTO> findByEmail(String email);
    public List<AdministradorResponseDTO> findByCpf(String cpf);
    public void update(Long id, AdministradorDTO dto);
    public void deleteById(Long id);
}