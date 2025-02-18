package artboxproject.artboxproject.models;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class HistoricoCompras {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Id da compra


    @ManyToOne
    @JoinColumn(name= "cliente_id", nullable = false) //Foreign Key que estabelece conexão com a classe Cliente.
    private Cliente cliente;


    @Column(nullable = false)
    private LocalDateTime dataCompra; //Data e horário da compra.


    @Column(nullable = false)
    private String descricao; //Descrição completa da compra.


    @Column(nullable = false)
    private BigDecimal valor; //Valor da compra em BigDecimal.


    //Construtor:
    public HistoricoCompras() {}

    public HistoricoCompras(Cliente cliente, LocalDateTime dataCompra, String descricao, BigDecimal valor) {
        this.cliente = cliente;
        this.dataCompra = dataCompra;
        this.descricao = descricao;
        this.valor = valor;
    }

    //Getter e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
