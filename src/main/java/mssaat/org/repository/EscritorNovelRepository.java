package mssaat.org.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mssaat.org.model.EscritorNovel;
import mssaat.org.model.GeneroNovel;

@ApplicationScoped
public class EscritorNovelRepository implements PanacheRepository<EscritorNovel> {
    public List<EscritorNovel> findByName(String name) {
        return find("UPPER(nome) LIKE ?1", "%"+ name.toUpperCase() + "%").list();
    }

    public EscritorNovel findByNovel(long novelId) {
        return find("novel_id = 1", novelId).firstResult();
    }
    
}
