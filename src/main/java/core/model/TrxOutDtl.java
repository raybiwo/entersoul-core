package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;

/**
 * The persistent class for the TRX_OUT_DTL database table.
 * 
 */
@Entity
@Table(name = "TRX_OUT_DTL")
@NamedQuery(name = "TrxOutDtl.findAll", query = "SELECT t FROM TrxOutDtl t")
@IdClass(value = TrxOutDtlPK.class)
public class TrxOutDtl implements Serializable {
	private static final long serialVersionUID = 1L;
	// private TrxOutDtlPK id;
	private String kodeDetail;
	private String noNota;
	private String kodeBarang;
	private BigDecimal qty;

	public TrxOutDtl() {
	}

	/*
	 * @EmbeddedId public TrxOutDtlPK getId() { return this.id; }
	 * 
	 * public void setId(TrxOutDtlPK id) { this.id = id; }
	 */
	@Id
	@Column(name="KODE_DETAIL")
	public String getKodeDetail() {
		return this.kodeDetail;
	}

	public void setKodeDetail(String kodeDetail) {
		this.kodeDetail = kodeDetail;
	}
	@Id
	@Column(name="NO_NOTA")
	public String getNoNota() {
		return this.noNota;
	}

	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}
	@Id
	@Column(name="KODE_BARANG")
	public String getKodeBarang() {
		return this.kodeBarang;
	}

	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}

	public BigDecimal getQty() {
		return this.qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

}