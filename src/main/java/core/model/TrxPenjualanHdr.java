package core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TRX_PENJUALAN_HDR database table.
 * 
 */
@Entity
@Table(name="TR_HEADER_PENJUALAN")
@NamedQuery(name="TrxPenjualanHdr.findAll", query="SELECT t FROM TrxPenjualanHdr t")
public class TrxPenjualanHdr implements Serializable {
	private static final long serialVersionUID = 1L;
	private String notaPenjualan;
	private BigDecimal hargaTotal;
	private String idKaryawan;
	private Integer globalDiskon;
	private String kodeCustomer;
	private Date tanggalTransaksi;

	public TrxPenjualanHdr() {
	}


	@Id
	@Column(name="NO_NOTA")
	public String getNotaPenjualan() {
		return this.notaPenjualan;
	}

	public void setNotaPenjualan(String notaPenjualan) {
		this.notaPenjualan = notaPenjualan;
	}


	@Column(name="HARGA_TOTAL")
	public BigDecimal getHargaTotal() {
		return this.hargaTotal;
	}

	public void setHargaTotal(BigDecimal hargaTotal) {
		this.hargaTotal = hargaTotal;
	}


	@Column(name="KODE_KARYAWAN")
	public String getIdKaryawan() {
		return this.idKaryawan;
	}

	public void setIdKaryawan(String idKaryawan) {
		this.idKaryawan = idKaryawan;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="TANGGAL_TRANSAKSI")
	public Date getTanggalTransaksi() {
		return this.tanggalTransaksi;
	}

	public void setTanggalTransaksi(Date tanggalTransaksi) {
		this.tanggalTransaksi = tanggalTransaksi;
	}
	
	@Column(name="GLOBAL_DISKON")
	public Integer getGlobalDiskon() {
		return globalDiskon;
	}


	public void setGlobalDiskon(Integer globalDiskon) {
		this.globalDiskon = globalDiskon;
	}
	
	@Column(name="KODE_CUSTOMER")
	public String getKodeCustomer() {
		return kodeCustomer;
	}


	public void setKodeCustomer(String kodeCustomer) {
		this.kodeCustomer = kodeCustomer;
	}

}