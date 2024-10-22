package mssaat.org.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mssaat.org.model.Usuario;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {
    public Usuario findNomeEqual(String nome) {
        return find("nome = ?1", nome).firstResult();
    }

    public PanacheQuery<Usuario> findByNome(String nome) {
        return find("nome LIKE ?1", "%" + nome + "%");
    }

    public PanacheQuery<Usuario> findByEmail(String email) {
        return find("email LIKE ?1", "%" + email + "%");
    }

    public PanacheQuery<Usuario> findByCpf(String cpf) {
        return find("cpf LIKE ?1", "%" + cpf + "%");
    }

    public PanacheQuery<Usuario> findByEndereco(String endereco) {
        return find("endereco LIKE ?1", "%" + endereco + "%");
    }

    public Usuario findByNomeAndSenha(String nome, String senha) {
        return find("nome = ?1 AND senha = ?2", nome, senha).firstResult();
    }
}