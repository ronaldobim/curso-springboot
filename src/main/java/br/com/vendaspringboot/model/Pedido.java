package br.com.vendaspringboot.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.vendaspringboot.enums.StatusPedido;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@Column(name = "data_pedido")
	private LocalDate dataPedido;
	@Column(name = "total", precision = 20, scale = 2)
	private BigDecimal total;
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens;
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private StatusPedido status;
	
	
	public String toString() {
		return "IdPedido =  "+this.id + " Total = "+this.total;
		
	}
	
}