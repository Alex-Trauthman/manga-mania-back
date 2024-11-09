package br.unitins.tp1.faixas.repository;

import java.util.List;

import br.unitins.tp1.faixas.model.Faixa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FaixaRepository implements PanacheRepository<Faixa> {
    
    public List<Faixa> findByNome(String nome) {
        return find("SELECT f FROM Faixa f WHERE e.nome LIKE ?1", "%" + nome + "%").list();
    }
    
}
