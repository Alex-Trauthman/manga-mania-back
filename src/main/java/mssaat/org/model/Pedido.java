package mssaat.org.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pedido extends DefaultEntity {
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_itens")
    private List<ItemPedido> itens;
    @Column(length = 20, nullable = true)
    private String tipoCartao;
    @Column(length = 20, nullable = true)
    private String nomeCartao;
    @Column(length = 20, nullable = true)
    private String numeroCartao;
    @Column(length = 120, nullable = true)
    private String pixChave;

    private Double preco;

  

    private Endereco endereco;

    public Pedido() {
    }

    public Pedido(Usuario usuario, Endereco endereco, List<ItemPedido> itens, String tipoCartao, String nomeCartao,
            String numeroCartao, String pixChave) {
        this.usuario = usuario;
        this.endereco = endereco;
        this.itens = itens;
        this.tipoCartao = tipoCartao;
        this.nomeCartao = nomeCartao;
        this.numeroCartao = numeroCartao;
        this.pixChave = pixChave;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getPixChave() {
        return pixChave;
    }

    public void setPixChave(String pixChave) {
        this.pixChave = pixChave;
    }
}