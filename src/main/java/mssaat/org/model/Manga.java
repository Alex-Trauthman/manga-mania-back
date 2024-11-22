package mssaat.org.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Manga extends Livro {
    @Column
    private String colorido;
    @ManyToOne
    private AutorManga autorManga;
    @Column(length = 60, nullable = false)
    private GeneroManga generoManga;

    public String getColor() {
        return colorido;
    }

    public void setColor(String colorido) {
        this.colorido = colorido;
    }

    public GeneroManga getGeneroManga() {
        return generoManga;
    }

    public void setGeneroManga(GeneroManga generoManga) {
        this.generoManga = generoManga;
    }

    public AutorManga getAutor() {
        return autorManga;
    }

    public void setAutor(AutorManga autorManga) {
        this.autorManga = autorManga;
    }
}