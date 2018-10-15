package core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TRX_OUT_HDR database table.
 * 
 */
@Embeddable
public class TrxOutHdrPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private String noNota;
	private String kodeToko;

	public TrxOutHdrPK() {
	}

	//@Column(name="NO_NOTA")
	public String getNoNota() {
		return this.noNota;
	}
	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}

	//@Column(name="KODE_TOKO")
	public String getKodeToko() {
		return this.kodeToko;
	}
	public void setKodeToko(String kodeToko) {
		this.kodeToko = kodeToko;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TrxOutHdrPK)) {
			return false;
		}
		TrxOutHdrPK castOther = (TrxOutHdrPK)other;
		return 
			this.noNota.equals(castOther.noNota)
			&& this.kodeToko.equals(castOther.kodeToko);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.noNota.hashCode();
		hash = hash * prime + this.kodeToko.hashCode();
		
		return hash;
	}
}