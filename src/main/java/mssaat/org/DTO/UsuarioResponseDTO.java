package mssaat.org.DTO;

import java.util.List;

import mssaat.org.model.Sexo;
import mssaat.org.model.Usuario;

public record UsuarioResponseDTO(Long id, String username, String email, String senha, String cpf, String endereco, List<TelefoneResponseDTO> telefones, Sexo sexo) {
    public static UsuarioResponseDTO valueOf(Usuario user) {
        if(user == null) return null;
        List<TelefoneResponseDTO> telefones = user.getListaTelefone().stream().map(TelefoneResponseDTO::valueOf).toList();
        return new UsuarioResponseDTO(user.getId(), user.getUsername(), user.getEmail(), user.getSenha(), user.getCpf(), user.getEndereco(), telefones, user.getSexo());
    }
}