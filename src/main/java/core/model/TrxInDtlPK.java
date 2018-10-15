package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TRX_IN_DTL database table.
 * 
 */
@Embeddable
public class TrxInDtlPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String kodeDetailMasuk;
	private String noInvoice;
	private String kodeBarang;

	public TrxInDtlPK() {
	}

	//@Column(name="KODE_DETAIL_MASUK")
	public String getKodeDetailMasuk() {
		return this.kodeDetailMasuk;
	}
	public void setKodeDetailMasuk(String kodeDetailMasuk) {
		this.kodeDetailMasuk = kodeDetailMasuk;
	}

	//@Column(name="NO_INVOICE")
	public String getNoInvoice() {
		return this.noInvoice;
	}
	public void setNoInvoice(String noInvoice) {
		this.noInvoice = noInvoice;
	}

	//@Column(name="KODE_BARANG")
	public String getKodeBarang() {
		return this.kodeBarang;
	}
	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TrxInDtlPK)) {
			return false;
		}
		TrxInDtlPK castOther = (TrxInDtlPK)other;
		return 
			this.kodeDetailMasuk.equals(castOther.kodeDetailMasuk)
			&& this.noInvoice.equals(castOther.noInvoice)
			&& this.kodeBarang.equals(castOther.kodeBarang);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.kodeDetailMasuk.hashCode();
		hash = hash * prime + this.noInvoice.hashCode();
		hash = hash * prime + this.kodeBarang.hashCode();
		
		return hash;
	}
}