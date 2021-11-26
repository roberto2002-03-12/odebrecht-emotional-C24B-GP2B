package odebrecht.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@Table(name="consultas")
public class Consulta implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@NotNull
	private Long usuario_id;
	@NotNull
	private String resultado;
	@NotNull
	private Long medico_id;
	@PrePersist
	public void prePersist() {
		fecha = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Long getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public Long getMedico_id() {
		return medico_id;
	}
	public void setMedico_id(Long medico_id) {
		this.medico_id = medico_id;
	}
	@Override
	public String toString() {
		return "Consulta [id=" + id + ", fecha=" + fecha + ", usuario_id=" + usuario_id + ", resultado=" + resultado
				+ ", medico_id=" + medico_id + "]";
	}
}
