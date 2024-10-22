package mssaat.org.DTO;

import mssaat.org.model.GeneroNovel;
import mssaat.org.model.Novel;

public record NovelResponseDTO(
    Long id,
    String nome,
    String sinopse,
    EscritorNovelResponseDTO idEscritor,
    int lancamento,
    Double preco,
    int estoque,
    int paginas,
    GeneroNovel genero
) {
    public static NovelResponseDTO valueOf(Novel novel){
        return new NovelResponseDTO(
            novel.getId(),
            novel.getNome(),
            novel.getSinopse(),
            EscritorNovelResponseDTO.valueOf(novel.getEscritorNovel()),
            novel.getAnoPublicacao(),
            novel.getPreco(),
            novel.getEstoque(),
            novel.getPaginas(),
            novel.getGenero()
        );
    }
}
