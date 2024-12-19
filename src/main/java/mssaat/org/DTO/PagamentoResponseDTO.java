package mssaat.org.DTO;

import mssaat.org.model.Pagamento;
import mssaat.org.model.PagamentoEstado;
import mssaat.org.model.PagamentoTipo;

public record PagamentoResponseDTO(Long id, PagamentoTipo tipo, PagamentoEstado estado, PedidoResponseDTO pedido) {
    public static PagamentoResponseDTO valueOf(Pagamento pagamento) {
        if(pagamento == null) return null;
        return new PagamentoResponseDTO(pagamento.getId(), pagamento.getTipo(), pagamento.getEstado(), PedidoResponseDTO.valueOf(pagamento.getPedido()));
    }
}