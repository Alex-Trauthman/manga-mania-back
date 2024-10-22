package mssaat.org.service;

import java.util.List;

import jakarta.validation.Valid;
import mssaat.org.DTO.UsuarioDTO;
import mssaat.org.DTO.UsuarioResponseDTO;

public interface UsuarioService {
    public UsuarioResponseDTO create(@Valid UsuarioDTO usuarioDto);
    public UsuarioResponseDTO login(String username, String senha);
    public UsuarioResponseDTO findById(Long id);
    public List<UsuarioResponseDTO> findAll(int page, int pageSize);
    public List<UsuarioResponseDTO> findByUsername(String username);
    public List<UsuarioResponseDTO> findByEmail(String email);
    public List<UsuarioResponseDTO> findByCpf(String cpf);
    public List<UsuarioResponseDTO> findByEndereco(String endereco);
    public void update(Long id, @Valid UsuarioDTO dto);
    public void deleteById(Long id);
}