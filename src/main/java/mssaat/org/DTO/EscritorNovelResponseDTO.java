package mssaat.org.DTO;

import java.util.List;

import mssaat.org.model.EscritorNovel;
import mssaat.org.model.Novel;
import mssaat.org.model.Sexo;

public record EscritorNovelResponseDTO(
    Long id,
    String nome,
    int anoNascimento,
    String nacionalidade,
    Sexo sexo
) {
        
    public static EscritorNovelResponseDTO valueOf(EscritorNovel escritor){
        
        return new EscritorNovelResponseDTO(
            escritor.getId(),
            escritor.getNome(),
            escritor.getAnoNascimento(),
            escritor.getNacionalidade(),
            escritor.getSexo()
            
        );
    }
    
}
