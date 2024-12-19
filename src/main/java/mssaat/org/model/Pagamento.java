package mssaat.org.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pagamento extends DefaultEntity {
    private PagamentoTipo tipo;
    private PagamentoEstado estado;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(PagamentoTipo tipo, PagamentoEstado estado, Pedido pedido) {
        this.tipo = tipo;
        this.estado = estado;
        this.pedido = pedido;
    }

    public PagamentoTipo getTipo() {
        return tipo;
    }

    public void setTipo(PagamentoTipo tipo) {
        this.tipo = tipo;
    }

    public PagamentoEstado getEstado() {
        return estado;
    }

    public void setEstado(PagamentoEstado estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}