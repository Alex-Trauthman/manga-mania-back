package mssaat.org.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mssaat.org.DTO.MangaDTO;
import mssaat.org.DTO.MangaResponseDTO;
import mssaat.org.model.AutorManga;
import mssaat.org.model.GeneroManga;
import mssaat.org.model.Manga;
import mssaat.org.repository.AutorMangaRepository;
import mssaat.org.repository.MangaRepository;

@ApplicationScoped
public class MangaServiceImpl implements MangaService {

    @Inject
    private MangaRepository mangaRepository;

    @Inject
    private AutorMangaRepository autorMangaRepository;

    @Override
    @Transactional
    public MangaResponseDTO create(@Valid MangaDTO manga) {
        Manga mangaEntity = new Manga();
        mangaEntity.setNome(manga.nome());
        mangaEntity.setAnoPublicacao(manga.lancamento());
        mangaEntity.setAutor(autorMangaRepository.findById(manga.idAutor()));
        mangaEntity.setGeneroManga(GeneroManga.value(manga.genero()));
        mangaEntity.setColor(manga.color());
        mangaEntity.setEstoque(manga.estoque());
        mangaEntity.setPreco(manga.preco());
        mangaEntity.setSinopse(manga.sinopse());
        mangaEntity.setPaginas(manga.paginas());
        AutorManga autor = autorMangaRepository.findById(manga.idAutor());
        autor.getMangas().add(mangaEntity);

        mangaRepository.persist(mangaEntity);
        return MangaResponseDTO.valueOf(mangaEntity);

    }

    @Override
    @Transactional
    public void update(long id, MangaDTO manga) {
        Manga mangaEntity = mangaRepository.findById(id);
        mangaEntity.setNome(manga.nome());
        mangaEntity.setAnoPublicacao(manga.lancamento());
        mangaEntity.setAutor(autorMangaRepository.findById(manga.idAutor()));
        mangaEntity.setGeneroManga(GeneroManga.value(manga.genero()));
        mangaEntity.setColor(manga.color());
        mangaEntity.setEstoque(manga.estoque());
        mangaEntity.setPreco(manga.preco());
        mangaEntity.setSinopse(manga.sinopse());
        mangaEntity.setPaginas(manga.paginas());
    }

    @Override
    @Transactional
    public void delete(long id) {
        mangaRepository.deleteById(id);
    }

    @Override
    public long count() {
        return mangaRepository.count();
    }

    @Override
    public MangaResponseDTO findById(long id) {
        Manga mangaEntity = mangaRepository.findById(id);
        return MangaResponseDTO.valueOf(mangaEntity);
    }

    @Override
    public List<MangaResponseDTO> findByName(String name) {
        return mangaRepository.findByName(name).stream().map(MangaResponseDTO::valueOf).toList();
    }

    @Override
    public List<MangaResponseDTO> findByAutor(long authorId) {
        return mangaRepository.findByAuthor(authorId).stream().map(MangaResponseDTO::valueOf).toList();
    }

    @Override
    public List<MangaResponseDTO> findByGenre(int genreId) {
        return mangaRepository.findByGenre(GeneroManga.value(genreId)).stream().map(MangaResponseDTO::valueOf)
                .toList();
    }

    @Override
    public List<MangaResponseDTO> findAll(int page, int pageSize) {
        return mangaRepository.findAll().page(page, pageSize).stream().map(MangaResponseDTO::valueOf).toList();
    }

}
