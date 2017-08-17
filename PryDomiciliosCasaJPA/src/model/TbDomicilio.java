package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_DOMICILIO database table.
 * 
 */
@Entity
@Table(name="TB_DOMICILIO")
@NamedQuery(name="TbDomicilio.findAll", query="SELECT t FROM TbDomicilio t")
public class TbDomicilio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_DOMICILIO_CODDOMICILIO_GENERATOR", sequenceName = "sec_id_domicilio" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_DOMICILIO_CODDOMICILIO_GENERATOR")
	@Column(name="COD_DOMICILIO")
	private long codDomicilio;

	@Column(name="CANTIDAD_ALMUERZOS")
	private BigDecimal cantidadAlmuerzos;

	@Column(name="DIRECCION_ENVIO")
	private String direccionEnvio;

	//bi-directional many-to-one association to TbDireccionEnvio
	@ManyToOne
	@JoinColumn(name="FK_COD_DIR_ENVIO")
	private TbDireccionEnvio tbDireccionEnvio;

	public TbDomicilio() {
	}

	public long getCodDomicilio() {
		return this.codDomicilio;
	}

	public void setCodDomicilio(long codDomicilio) {
		this.codDomicilio = codDomicilio;
	}

	public BigDecimal getCantidadAlmuerzos() {
		return this.cantidadAlmuerzos;
	}

	public void setCantidadAlmuerzos(BigDecimal cantidadAlmuerzos) {
		this.cantidadAlmuerzos = cantidadAlmuerzos;
	}

	public String getDireccionEnvio() {
		return this.direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public TbDireccionEnvio getTbDireccionEnvio() {
		return this.tbDireccionEnvio;
	}

	public void setTbDireccionEnvio(TbDireccionEnvio tbDireccionEnvio) {
		this.tbDireccionEnvio = tbDireccionEnvio;
	}

}