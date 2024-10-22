package mssaat.org.service;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import mssaat.org.DTO.AdministradorDTO;
import mssaat.org.DTO.AdministradorResponseDTO;
import mssaat.org.model.Administrador;
import mssaat.org.repository.AdministradorRepository;
import mssaat.org.validation.ValidationException;

@ApplicationScoped
public class AdministradorServiceImpl implements AdministradorService {
    @Inject
    public AdministradorRepository administradorRepository;
    @Inject
    public HashService hashService;

    @Override
    @Transactional
    @RolesAllowed("Administrador")
    public AdministradorResponseDTO create(@Valid AdministradorDTO adminDto) {
        Administrador userBanco = new Administrador();
        userBanco.setUsername(adminDto.username());
        userBanco.setEmail(adminDto.email());
        userBanco.setSenha(hashService.getHashSenha(adminDto.senha()));
        userBanco.setCpf(adminDto.cpf());
        administradorRepository.persist(userBanco);
        return AdministradorResponseDTO.valueOf(userBanco);
    }

    @Override
    @Transactional
    @RolesAllowed("Administrador")
    public void update(Long id, AdministradorDTO adminDto) {
        Administrador userBanco = administradorRepository.findById(id);
        if (userBanco == null) {
            throw new ValidationException("id", "Administrador não existe.");
        }
        userBanco.setUsername(adminDto.username());
        userBanco.setEmail(adminDto.email());
        userBanco.setSenha(hashService.getHashSenha(adminDto.senha()));
        userBanco.setCpf(adminDto.cpf());
    }

    @Override
    @Transactional
    @RolesAllowed("Administrador")
    public void deleteById(Long id) {
        Administrador userBanco = administradorRepository.findById(id);
        if (userBanco == null) {
            throw new ValidationException("id", "Administrador não existe.");
        }
        administradorRepository.deleteById(id);
    }

    @Override
    @RolesAllowed("Administrador")
    public List<AdministradorResponseDTO> findAll(int page, int pageSize) {
        return administradorRepository.findAll().page(page, pageSize).stream().map(e -> AdministradorResponseDTO.valueOf(e)).toList();
    }

    @Override
    @RolesAllowed("Administrador")
    public AdministradorResponseDTO findById(@PathParam("id") Long id) {
        Administrador admin = administradorRepository.findById(id);
        if (admin == null)
            return null;
        return AdministradorResponseDTO.valueOf(admin);
    }

    @Override
    @Path("/search/username/{nome}")
    @RolesAllowed("Administrador")
    public List<AdministradorResponseDTO> findByUsername(@PathParam("nome") String username) {
        return administradorRepository.findByUsername(username).stream().map(e -> AdministradorResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Path("/search/email/{email}")
    @RolesAllowed("Administrador")
    public List<AdministradorResponseDTO> findByEmail(@PathParam("email") String email) {
        return administradorRepository.findByEmail(email).stream().map(e -> AdministradorResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    @Path("/search/cpf/{cpf}")
    @RolesAllowed("Administrador")
    public List<AdministradorResponseDTO> findByCpf(@PathParam("cpf") String cpf) {
        return administradorRepository.findByCpf(cpf).stream().map(e -> AdministradorResponseDTO.valueOf(e)).toList();
    }

    public AdministradorResponseDTO login(String username, String senha) {
        Administrador administrador = administradorRepository.findByUsernameAndSenha(username, senha);
        return AdministradorResponseDTO.valueOf(administrador);
    }
}