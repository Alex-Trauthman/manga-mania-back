package mssaat.org.DTO;

import io.smallrye.common.constraint.NotNull;
import mssaat.org.model.Pedido;

public record PagamentoDTO(
        @NotNull Integer tipo,
        @NotNull Integer estado,
        @NotNull Pedido pedido) {
}