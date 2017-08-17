package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_DIRECCION_ENVIO database table.
 * 
 */
@Entity
@Table(name="TB_DIRECCION_ENVIO")
@NamedQuery(name="TbDireccionEnvio.findAll", query="SELECT t FROM TbDireccionEnvio t")
public class TbDireccionEnvio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_DIRECCION_ENVIO_CODDIRECCIONENVIO_GENERATOR", sequenceName = "sec_id_dir_envio" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_DIRECCION_ENVIO_CODDIRECCIONENVIO_GENERATOR")
	@Column(name="COD_DIRECCION_ENVIO")
	private long codDireccionEnvio;

	private String barrio;

	private String direccion;

	//bi-directional many-to-one association to TbCiudad
	@ManyToOne
	@JoinColumn(name="FK_COD_CIUDAD")
	private TbCiudad tbCiudad;

	//bi-directional many-to-one association to TbDomicilio
	@OneToMany(mappedBy="tbDireccionEnvio")
	private List<TbDomicilio> tbDomicilios;

	//bi-directional many-to-one association to TbPersona
	@OneToMany(mappedBy="tbDireccionEnvio")
	private List<TbPersona> tbPersonas;

	public TbDireccionEnvio() {
	}

	public long getCodDireccionEnvio() {
		return this.codDireccionEnvio;
	}

	public void setCodDireccionEnvio(long codDireccionEnvio) {
		this.codDireccionEnvio = codDireccionEnvio;
	}

	public String getBarrio() {
		return this.barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public TbCiudad getTbCiudad() {
		return this.tbCiudad;
	}

	public void setTbCiudad(TbCiudad tbCiudad) {
		this.tbCiudad = tbCiudad;
	}

	public List<TbDomicilio> getTbDomicilios() {
		return this.tbDomicilios;
	}

	public void setTbDomicilios(List<TbDomicilio> tbDomicilios) {
		this.tbDomicilios = tbDomicilios;
	}

	public TbDomicilio addTbDomicilio(TbDomicilio tbDomicilio) {
		getTbDomicilios().add(tbDomicilio);
		tbDomicilio.setTbDireccionEnvio(this);

		return tbDomicilio;
	}

	public TbDomicilio removeTbDomicilio(TbDomicilio tbDomicilio) {
		getTbDomicilios().remove(tbDomicilio);
		tbDomicilio.setTbDireccionEnvio(null);

		return tbDomicilio;
	}

	public List<TbPersona> getTbPersonas() {
		return this.tbPersonas;
	}

	public void setTbPersonas(List<TbPersona> tbPersonas) {
		this.tbPersonas = tbPersonas;
	}

	public TbPersona addTbPersona(TbPersona tbPersona) {
		getTbPersonas().add(tbPersona);
		tbPersona.setTbDireccionEnvio(this);

		return tbPersona;
	}

	public TbPersona removeTbPersona(TbPersona tbPersona) {
		getTbPersonas().remove(tbPersona);
		tbPersona.setTbDireccionEnvio(null);

		return tbPersona;
	}

}