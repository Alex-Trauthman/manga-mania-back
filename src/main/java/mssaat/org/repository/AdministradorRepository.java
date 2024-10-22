package mssaat.org.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mssaat.org.model.Administrador;

@ApplicationScoped
public class AdministradorRepository implements PanacheRepository<Administrador> {
    public Administrador findUsernameEqual(String username) {
        return find("username = ?1", username).firstResult();
    }

    public PanacheQuery<Administrador> findByUsername(String username) {
        return find("username LIKE ?1", "%" + username + "%");
    }

    public PanacheQuery<Administrador> findByEmail(String email) {
        return find("email LIKE ?1", "%" + email + "%");
    }

    public PanacheQuery<Administrador> findByCpf(String cpf) {
        return find("cpf LIKE ?1", "%" + cpf + "%");
    }

    public Administrador findByUsernameAndSenha(String username, String senha) {
        return find("username = ?1 AND senha = ?2", username, senha).firstResult();
    }
}