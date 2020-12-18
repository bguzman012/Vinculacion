package astronet.ec.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Telefono")

public class Telefono implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tel_id")
	@GeneratedValue(generator = "secuenciaTel")
	@SequenceGenerator(name = "secuenciaTel", initialValue = 14)
	@NotNull
	private int id;
	

	@Column(name = "tel_tipo")
	private String tipoTelefono;
	
	@Column(name = "tel_numero")
	private String telNumero;
	
	/*
	 * Relacion Telefono con Cliente
	 */
	@OneToOne
	@JoinColumn(name="cliTel_fk")
	@JsonIgnore
	private Cliente cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	public String getTelNumero() {
		return telNumero;
	}

	public void setTelNumero(String telNumero) {
		this.telNumero = telNumero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Telefono [id=" + id + ", tipoTelefono=" + tipoTelefono + ", telNumero=" + telNumero + ", cliente="
				+ cliente + "]";
	}

}
