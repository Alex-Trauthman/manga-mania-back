package mssaat.org.DTO;

import mssaat.org.model.AutorManga;
import mssaat.org.model.GeneroManga;
import mssaat.org.model.Manga;

public record MangaResponseDTO(
    Long id,
    String nome,
    String sinopse,
    GeneroManga genero,
    AutorMangaResponseDTO idAutor,
    int lancamento,
    boolean colorido,
    Double preco,
    int estoque,
    int paginas
) {
    
    public static MangaResponseDTO valueOf(Manga manga){
        return new MangaResponseDTO(
            manga.getId(),
            manga.getNome(),
            manga.getSinopse(),
            manga.getGeneroManga(),
            AutorMangaResponseDTO.valueOf(manga.getAutor()),
            manga.getAnoPublicacao(),
            manga.isColorido(),
            manga.getPreco(),
            manga.getEstoque(),
            manga.getPaginas()
        );
    
}
}