package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pelicula")
@NamedQuery(name = "findxNpeli", query = "SELECT p FROM Pelicula p where p.nompeli =:xnomp")
public class Pelicula {
	@Id
	@Column(name = "cod_pel")
	private int codigo;
	
	@Column(name = "nom_pel")
	private String nompeli;
	
	@Column(name = "gen_pel")
	private String genero;
	
	@Column(name = "fes_pel")
	private String festreno;
	
	@Column(name = "sin_pel")
	private String sinopsis;
	
	@Column(name = "act_pel")
	private String actores;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNompeli() {
		return nompeli;
	}
	public void setNompeli(String nompeli) {
		this.nompeli = nompeli;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getFestreno() {
		return festreno;
	}
	public void setFestreno(String festreno) {
		this.festreno = festreno;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getActores() {
		return actores;
	}
	public void setActores(String actores) {
		this.actores = actores;
	}
	
	@Override
	public String toString() {
		return "Pelicula [actores=" + actores + "]";
	}
	
}
