package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_CIUDAD database table.
 * 
 */
@Entity
@Table(name="TB_CIUDAD")
@NamedQuery(name="TbCiudad.findAll", query="SELECT t FROM TbCiudad t")
public class TbCiudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_CIUDAD_CODCIUDAD_GENERATOR", sequenceName = "sec_id_ciudad" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_CIUDAD_CODCIUDAD_GENERATOR")
	@Column(name="COD_CIUDAD")
	private long codCiudad;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to TbDireccionEnvio
	@OneToMany(mappedBy="tbCiudad")
	private List<TbDireccionEnvio> tbDireccionEnvios;

	public TbCiudad() {
	}

	public long getCodCiudad() {
		return this.codCiudad;
	}

	public void setCodCiudad(long codCiudad) {
		this.codCiudad = codCiudad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<TbDireccionEnvio> getTbDireccionEnvios() {
		return this.tbDireccionEnvios;
	}

	public void setTbDireccionEnvios(List<TbDireccionEnvio> tbDireccionEnvios) {
		this.tbDireccionEnvios = tbDireccionEnvios;
	}

	public TbDireccionEnvio addTbDireccionEnvio(TbDireccionEnvio tbDireccionEnvio) {
		getTbDireccionEnvios().add(tbDireccionEnvio);
		tbDireccionEnvio.setTbCiudad(this);

		return tbDireccionEnvio;
	}

	public TbDireccionEnvio removeTbDireccionEnvio(TbDireccionEnvio tbDireccionEnvio) {
		getTbDireccionEnvios().remove(tbDireccionEnvio);
		tbDireccionEnvio.setTbCiudad(null);

		return tbDireccionEnvio;
	}

}