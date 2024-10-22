package mssaat.org.DTO;

import mssaat.org.model.Telefone;

public record TelefoneResponseDTO(String codigoArea, String numero) {
    public static TelefoneResponseDTO valueOf(Telefone telefone) {
        if(telefone == null) return null;
        return new TelefoneResponseDTO(telefone.getCodigoArea(), telefone.getNumero());
    }
}