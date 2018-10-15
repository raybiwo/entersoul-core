package core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TRX_IN_HDR database table.
 * 
 */
@Entity
@Table(name="TRX_IN_HDR")
@NamedQuery(name="TrxInHdr.findAll", query="SELECT t FROM TrxInHdr t")
public class TrxInHdr implements Serializable {
	private static final long serialVersionUID = 1L;
	private String noInvoice;
	private String kodeSupplier;
	private Date tglKeluar;
	private BigDecimal totalHargaMasuk;

	public TrxInHdr() {
	}


	@Id
	@Column(name="NO_INVOICE")
	public String getNoInvoice() {
		return this.noInvoice;
	}

	public void setNoInvoice(String noInvoice) {
		this.noInvoice = noInvoice;
	}


	@Column(name="KODE_SUPPLIER")
	public String getKodeSupplier() {
		return this.kodeSupplier;
	}

	public void setKodeSupplier(String kodeSupplier) {
		this.kodeSupplier = kodeSupplier;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="TGL_KELUAR")
	public Date getTglKeluar() {
		return this.tglKeluar;
	}

	public void setTglKeluar(Date tglKeluar) {
		this.tglKeluar = tglKeluar;
	}


	@Column(name="TOTAL_HARGA_MASUK")
	public BigDecimal getTotalHargaMasuk() {
		return this.totalHargaMasuk;
	}

	public void setTotalHargaMasuk(BigDecimal totalHargaMasuk) {
		this.totalHargaMasuk = totalHargaMasuk;
	}

}