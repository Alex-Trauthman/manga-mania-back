package mssaat.org.DTO;

import mssaat.org.model.ItemPedido;
import mssaat.org.model.Manga;

public record ItemPedidoResponseDTO(Long id,String nome, Long manga, Double preco, Double desconto, Integer quantidade) {
    public static ItemPedidoResponseDTO valueOf(ItemPedido item) {
        return new ItemPedidoResponseDTO(item.getId(),item.getManga().getNome(), item.getManga().getId(), item.getPreco(), item.getDesconto(), item.getQuantidade());
    }
}