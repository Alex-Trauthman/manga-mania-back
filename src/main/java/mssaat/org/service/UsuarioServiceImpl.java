package mssaat.org.service;

import java.util.ArrayList;
import java.util.List;  

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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
        userBanco.setNome(userDto.nome());
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
        userBanco.setNome(userDto.nome());
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
    public List<UsuarioResponseDTO> findAll(int page, int pageSize) {
        return usuarioRepository.findAll().page(page, pageSize).stream().map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }

    @Override
    public UsuarioResponseDTO findById(@PathParam("id") Long id) {
        Usuario user = usuarioRepository.findById(id);
        if (user == null) {
            return null;
        }
        return UsuarioResponseDTO.valueOf(user);
    }

    @Override
    @Path("/search/nome/{nome}")
    public List<UsuarioResponseDTO> findByNome(@PathParam("nome") String nome) {
        return usuarioRepository.findByNome(nome).stream().map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Path("/search/email/{email}")
    public List<UsuarioResponseDTO> findByEmail(@PathParam("email") String email) {
        return usuarioRepository.findByEmail(email).stream().map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Path("/search/cpf/{cpf}")
    public List<UsuarioResponseDTO> findByCpf(@PathParam("cpf") String cpf) {
        return usuarioRepository.findByCpf(cpf).stream().map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Path("/search/endereco/{content}")
    public List<UsuarioResponseDTO> findByEndereco(@PathParam("content") String content) {
        return usuarioRepository.findByEndereco(content).stream().map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }


    public UsuarioResponseDTO login(String username, String senha) {
        Usuario usuario = usuarioRepository.findByNomeAndSenha(username, senha);
        return UsuarioResponseDTO.valueOf(usuario);
    }
}