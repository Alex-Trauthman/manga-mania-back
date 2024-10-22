package mssaat.org.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mssaat.org.model.GeneroManga;
import mssaat.org.model.Manga;

@ApplicationScoped
public class MangaRepository implements PanacheRepository<Manga> {
    public List<Manga> findByName(String name) {
        return find("UPPER(nome) LIKE ?1", "%"+ name.toUpperCase() + "%").list();
    }

    public List<Manga> findByAuthor(long authorId) {
        return find("autor_id = 1", authorId).list();
    }

    public List<Manga> findByGenre(GeneroManga genre) {
        return find("genero = 1", genre).list();
    }
    
}
