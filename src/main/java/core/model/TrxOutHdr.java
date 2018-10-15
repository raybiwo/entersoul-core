package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the TRX_OUT_HDR database table.
 * 
 */
@Entity
@Table(name="TRX_OUT_HDR")
@NamedQuery(name="TrxOutHdr.findAll", query="SELECT t FROM TrxOutHdr t")
@IdClass(value=TrxOutHdrPK.class)
public class TrxOutHdr implements Serializable {
	private static final long serialVersionUID = 1L;
	//private TrxOutHdrPK id;
	private String noNota;
	private String kodeToko;
	private Date tglKeluar;

	public TrxOutHdr() {
	}


	/*@EmbeddedId
	public TrxOutHdrPK getId() {
		return this.id;
	}

	public void setId(TrxOutHdrPK id) {
		this.id = id;
	}*/
	
	@Id
	@Column(name="NO_NOTA")
	public String getNoNota() {
		return this.noNota;
	}
	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}

	@Id
	@Column(name="KODE_TOKO")
	public String getKodeToko() {
		return this.kodeToko;
	}
	public void setKodeToko(String kodeToko) {
		this.kodeToko = kodeToko;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="TGL_KELUAR")
	public Date getTglKeluar() {
		return this.tglKeluar;
	}

	public void setTglKeluar(Date tglKeluar) {
		this.tglKeluar = tglKeluar;
	}

}