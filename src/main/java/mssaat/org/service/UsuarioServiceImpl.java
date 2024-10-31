package mssaat.org.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mssaat.org.DTO.TelefoneResponseDTO;
import mssaat.org.DTO.UsuarioDTO;
import mssaat.org.DTO.UsuarioResponseDTO;
import mssaat.org.model.Sexo;
import mssaat.org.model.Telefone;
import mssaat.org.model.Usuario;
import mssaat.org.repository.UsuarioRepository;
import mssaat.org.validation.ValidationException;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {
    @Inject
    public UsuarioRepository usuarioRepository;
    @Inject
    public HashService hashService;

    @Override
    @Transactional
    public UsuarioResponseDTO create(@Valid UsuarioDTO userDto) {
        Usuario userBanco = new Usuario();
        userBanco.setUsername(userDto.username());
        userBanco.setEmail(userDto.email());
        userBanco.setSenha(hashService.getHashSenha(userDto.senha()));
        userBanco.setCpf(userDto.cpf());
        userBanco.setEndereco(userDto.endereco());
        userBanco.setListaTelefone(new ArrayList<Telefone>());
        userBanco.setSexo(Sexo.valueOf(userDto.sexo()));

        for (TelefoneResponseDTO tel : userDto.telefones()) {
            Telefone telefone = new Telefone(tel.codigoArea(), tel.numero());
            userBanco.getListaTelefone().add(telefone);
        }

        usuarioRepository.persist(userBanco);
        return UsuarioResponseDTO.valueOf(userBanco);
    }

    @Override
    @Transactional
    public void update(Long id, UsuarioDTO userDto) {
        Usuario userBanco = usuarioRepository.findById(id);
        if (userBanco == null) {
            throw new ValidationException("id", "Usuário não existe.");
        }
        userBanco.setUsername(userDto.username());
        userBanco.setEmail(userDto.email());
        userBanco.setSenha(hashService.getHashSenha(userDto.senha()));
        userBanco.setCpf(userDto.cpf());
        userBanco.setEndereco(userDto.endereco());
        userBanco.setListaTelefone(new ArrayList<Telefone>());
        userBanco.setSexo(Sexo.valueOf(userDto.sexo()));

        for (TelefoneResponseDTO tel : userDto.telefones()) {
            Telefone telefone = new Telefone(tel.codigoArea(), tel.numero());
            userBanco.getListaTelefone().add(telefone);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public long count() {
        return usuarioRepository.count();
    }

    @Override
    public List<UsuarioResponseDTO> findAll(int page, int pageSize) {
        List<Usuario> usuarios = usuarioRepository.findAll().page(page, pageSize).list();
        return usuarios.stream().map(UsuarioResponseDTO::valueOf).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        Usuario user = usuarioRepository.findById(id);
        if (user == null) {
            return null;
        }
        return UsuarioResponseDTO.valueOf(user);
    }

    @Override
    public List<UsuarioResponseDTO> findByUsername(String content, int page, int pageSize) {
        List<Usuario> usuarios = usuarioRepository.findByUsername(content).page(page, pageSize).list();
        return usuarios.stream().map(UsuarioResponseDTO::valueOf).collect(Collectors.toList());
    }

    @Override
    public List<UsuarioResponseDTO> findByEmail(String email, int page, int pageSize) {
        List<Usuario> usuarios = usuarioRepository.findByEmail(email).page(page, pageSize).list();
        return usuarios.stream().map(UsuarioResponseDTO::valueOf).collect(Collectors.toList());
    }

    @Override
    public List<UsuarioResponseDTO> findByCpf(String cpf, int page, int pageSize) {
        List<Usuario> usuarios = usuarioRepository.findByCpf(cpf).page(page, pageSize).list();
        return usuarios.stream().map(UsuarioResponseDTO::valueOf).collect(Collectors.toList());
    }

    @Override
    public List<UsuarioResponseDTO> findByEndereco(String content, int page, int pageSize) {
        List<Usuario> usuarios = usuarioRepository.findByEndereco(content).page(page, pageSize).list();
        return usuarios.stream().map(UsuarioResponseDTO::valueOf).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        Usuario usuario = usuarioRepository.findByUsernameAndSenha(username, senha);
        return UsuarioResponseDTO.valueOf(usuario);
    }
}