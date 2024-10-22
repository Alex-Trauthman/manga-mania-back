package mssaat.org.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mssaat.org.model.Administrador;

@ApplicationScoped
public class AdministradorRepository implements PanacheRepository<Administrador> {
    public Administrador findNomeEqual(String nome) {
        return find("nome = ?1", nome).firstResult();
    }

    public PanacheQuery<Administrador> findByNome(String nome) {
        return find("nome LIKE ?1", "%" + nome + "%");
    }

    public PanacheQuery<Administrador> findByEmail(String email) {
        return find("email LIKE ?1", "%" + email + "%");
    }

    public PanacheQuery<Administrador> findByCpf(String cpf) {
        return find("cpf LIKE ?1", "%" + cpf + "%");
    }

    public Administrador findByNomeAndSenha(String nome, String senha) {
        return find("nome = ?1 AND senha = ?2", nome, senha).firstResult();
    }
}