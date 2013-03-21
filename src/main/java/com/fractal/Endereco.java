package com.fractal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Endereco {

	/** The resultado. */
	@Element
	private long resultado;

	/** The resultado_txt. */
	@Element
	private String resultado_txt;

	/** The uf. */
	@Element
	private String uf;

	/** The cidade. */
	@Element
	private String cidade;

	/** The bairro. */
	@Element
	private String bairro;

	/** The tipo_logradouro. */
	@Element
	private String tipo_logradouro;

	/** The logradouro. */
	@Element
	private String logradouro;

	public long getResultado() {
		return resultado;
	}

	public void setResultado(long resultado) {
		this.resultado = resultado;
	}

	public String getResultado_txt() {
		return resultado_txt;
	}

	public void setResultado_txt(String resultado_txt) {
		this.resultado_txt = resultado_txt;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTipo_logradouro() {
		return tipo_logradouro;
	}

	public void setTipo_logradouro(String tipo_logradouro) {
		this.tipo_logradouro = tipo_logradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}
