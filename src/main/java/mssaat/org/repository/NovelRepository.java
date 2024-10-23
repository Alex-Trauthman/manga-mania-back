package mssaat.org.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mssaat.org.model.GeneroNovel;
import mssaat.org.model.Novel;

@ApplicationScoped
public class NovelRepository implements PanacheRepository<Novel> {
    public List<Novel> findByName(String name) {
        return find("UPPER(nome) LIKE ?1", "%"+ name.toUpperCase() + "%").list();
    }

    public List<Novel> findByAuthor(long authorId) {
        return find("autor.id = 1", authorId).list();
    }

    public List<Novel> findByGenre(GeneroNovel genre) {
        return find("genero = ?1", genre).list();
    }
}