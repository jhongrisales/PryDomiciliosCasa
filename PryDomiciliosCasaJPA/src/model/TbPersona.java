package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TB_PERSONA database table.
 * 
 */
@Entity
@Table(name="TB_PERSONA")
@NamedQuery(name="TbPersona.findAll", query="SELECT t FROM TbPersona t")
public class TbPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_PERSONA_CODPERSONA_GENERATOR", sequenceName = "sec_id_persona" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_PERSONA_CODPERSONA_GENERATOR")
	@Column(name="COD_PERSONA")
	private long codPersona;

	private String apellido;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to TbDireccionEnvio
	@ManyToOne
	@JoinColumn(name="FK_COD_DIR_ENVIO")
	private TbDireccionEnvio tbDireccionEnvio;

	public TbPersona() {
	}

	public long getCodPersona() {
		return this.codPersona;
	}

	public void setCodPersona(long codPersona) {
		this.codPersona = codPersona;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TbDireccionEnvio getTbDireccionEnvio() {
		return this.tbDireccionEnvio;
	}

	public void setTbDireccionEnvio(TbDireccionEnvio tbDireccionEnvio) {
		this.tbDireccionEnvio = tbDireccionEnvio;
	}

}