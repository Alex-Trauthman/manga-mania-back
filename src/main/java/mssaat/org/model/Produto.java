package mssaat.org.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Produto extends DefaultEntity {

    @Column(length = 60, nullable = false)
    private String nome;

    private String nomeImagem;

    @Column(nullable = false)
    private int paginas;

    @Column(length = 10, nullable = false)
    private Double preco;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String sinopse;
    
    
    @Column(nullable = false)
    private int anoPublicacao;

    @Column(nullable = false)
    private int estoque;
    
    public int getEstoque() {
        return estoque;
    }
    
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    public String getNomeImagem() {
        return nomeImagem;
    }
    
    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }
    public String getSinopse() {
        return sinopse;
    }
    
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    
    
    public Double getPreco() {
        return preco;
    }
    
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    
    public void setAnoPublicacao(int ano) {
        this.anoPublicacao = ano;
    }
    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
}
