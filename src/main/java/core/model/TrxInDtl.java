package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;

/**
 * The persistent class for the TRX_IN_DTL database table.
 * 
 */
@Entity
@Table(name = "TRX_IN_DTL")
@NamedQuery(name = "TrxInDtl.findAll", query = "SELECT t FROM TrxInDtl t")
@IdClass(value=TrxInDtlPK.class)
public class TrxInDtl implements Serializable {
	private static final long serialVersionUID = 1L;
	// private TrxInDtlPK id;
	private String kodeDetailMasuk;
	private String noInvoice;
	private String kodeBarang;
	private BigDecimal qtyMasuk;
	private BigDecimal subtotalHargaMasuk;

	public TrxInDtl() {
	}

	/*@EmbeddedId
	public TrxInDtlPK getId() {
		return this.id;
	}

	public void setId(TrxInDtlPK id) {
		this.id = id;
	}*/

	@Id
	@Column(name="KODE_DETAIL_MASUK")
	public String getKodeDetailMasuk() {
		return this.kodeDetailMasuk;
	}

	public void setKodeDetailMasuk(String kodeDetailMasuk) {
		this.kodeDetailMasuk = kodeDetailMasuk;
	}

	@Id
	@Column(name="NO_INVOICE")
	public String getNoInvoice() {
		return this.noInvoice;
	}

	public void setNoInvoice(String noInvoice) {
		this.noInvoice = noInvoice;
	}
	
	@Id
	@Column(name="KODE_BARANG")
	public String getKodeBarang() {
		return this.kodeBarang;
	}

	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}

	@Column(name = "QTY_MASUK")
	public BigDecimal getQtyMasuk() {
		return this.qtyMasuk;
	}

	public void setQtyMasuk(BigDecimal qtyMasuk) {
		this.qtyMasuk = qtyMasuk;
	}

	@Column(name = "SUBTOTAL_HARGA_MASUK")
	public BigDecimal getSubtotalHargaMasuk() {
		return this.subtotalHargaMasuk;
	}

	public void setSubtotalHargaMasuk(BigDecimal subtotalHargaMasuk) {
		this.subtotalHargaMasuk = subtotalHargaMasuk;
	}

}