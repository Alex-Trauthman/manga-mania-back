package mssaat.org.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mssaat.org.model.GeneroManga;
import mssaat.org.model.Manga;

@ApplicationScoped
public class MangaRepository implements PanacheRepository<Manga> {
    public PanacheQuery<Manga> findByName(String name) {
        return find("UPPER(nome) LIKE ?1", "%"+ name.toUpperCase() + "%");
    }

    public PanacheQuery<Manga> findByAuthor(long authorId) {
        return find("autor.id = ?1", authorId);
    }

    public PanacheQuery<Manga> findByGenre(GeneroManga genre) {
        return find("genero = ?1", genre);
    }
    
}
