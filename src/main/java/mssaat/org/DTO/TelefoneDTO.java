package mssaat.org.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TelefoneDTO(
        @NotBlank(message = "Código de área não pode estar vazio") @Size(min = 2, max = 2, message = "Código de área grande demais.") String codigoArea,
        @NotBlank(message = "Número de telefone não pode estar vazio") @Size(min = 8, max = 12, message = "Número de telefone grande demais.") String numero) {
}