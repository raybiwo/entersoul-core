package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TRX_PENJUALAN_DTL database table.
 * 
 */
@Embeddable
public class TrxPenjualanDtlPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String idDetail;
	private String kodeBarang;
	private String notaPenjualan;

	public TrxPenjualanDtlPK() {
	}

	//@Column(name="ID_DETAIL")
	public String getIdDetail() {
		return this.idDetail;
	}
	public void setIdDetail(String idDetail) {
		this.idDetail = idDetail;
	}

	//@Column(name="KODE_BARANG")
	public String getKodeBarang() {
		return this.kodeBarang;
	}
	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}

	//@Column(name="NOTA_PENJUALAN")
	public String getNotaPenjualan() {
		return this.notaPenjualan;
	}
	public void setNotaPenjualan(String notaPenjualan) {
		this.notaPenjualan = notaPenjualan;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TrxPenjualanDtlPK)) {
			return false;
		}
		TrxPenjualanDtlPK castOther = (TrxPenjualanDtlPK)other;
		return 
			this.idDetail.equals(castOther.idDetail)
			&& this.kodeBarang.equals(castOther.kodeBarang)
			&& this.notaPenjualan.equals(castOther.notaPenjualan);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idDetail.hashCode();
		hash = hash * prime + this.kodeBarang.hashCode();
		hash = hash * prime + this.notaPenjualan.hashCode();
		
		return hash;
	}
}