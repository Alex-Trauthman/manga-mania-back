package mssaat.org.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import mssaat.org.DTO.MangaDTO;
import mssaat.org.DTO.MangaResponseDTO;

@ApplicationScoped
public interface MangaService {
    public MangaResponseDTO create( @Valid MangaDTO manga);
    public void update(long id, @Valid MangaDTO manga);
    public void delete(long id);
    public MangaResponseDTO findById(long id);
    public List<MangaResponseDTO> findByName(String name);
    public List<MangaResponseDTO> findByAutor(long authorId);
    public List<MangaResponseDTO> findByGenre(int genreId);
    public List<MangaResponseDTO> findAll();
}
