package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TRX_OUT_DTL database table.
 * 
 */
@Embeddable
public class TrxOutDtlPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String kodeDetail;
	private String noNota;
	private String kodeBarang;

	public TrxOutDtlPK() {
	}

	//@Column(name="KODE_DETAIL")
	public String getKodeDetail() {
		return this.kodeDetail;
	}
	public void setKodeDetail(String kodeDetail) {
		this.kodeDetail = kodeDetail;
	}

	//@Column(name="NO_NOTA")
	public String getNoNota() {
		return this.noNota;
	}
	public void setNoNota(String noNota) {
		this.noNota = noNota;
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
		if (!(other instanceof TrxOutDtlPK)) {
			return false;
		}
		TrxOutDtlPK castOther = (TrxOutDtlPK)other;
		return 
			this.kodeDetail.equals(castOther.kodeDetail)
			&& this.noNota.equals(castOther.noNota)
			&& this.kodeBarang.equals(castOther.kodeBarang);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.kodeDetail.hashCode();
		hash = hash * prime + this.noNota.hashCode();
		hash = hash * prime + this.kodeBarang.hashCode();
		
		return hash;
	}
}