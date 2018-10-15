package core.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the TRX_PENJUALAN_DTL database table.
 * 
 */
@Entity
@Table(name="TRX_PENJUALAN_DTL")
@NamedQuery(name="TrxPenjualanDtl.findAll", query="SELECT t FROM TrxPenjualanDtl t")
@IdClass(value=TrxPenjualanDtlPK.class)
public class TrxPenjualanDtl implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idDetail;
	private String kodeBarang;
	private String notaPenjualan;
	//private TrxPenjualanDtlPK id;
	private BigDecimal diskon;
	private BigDecimal harga;
	private BigDecimal jumlah;
	private BigDecimal quantity;

	public TrxPenjualanDtl() {
	}


	/*@EmbeddedId
	public TrxPenjualanDtlPK getId() {
		return this.id;
	}

	public void setId(TrxPenjualanDtlPK id) {
		this.id = id;
	}*/
	
	@Id
	@Column(name="ID_DETAIL")
	public String getIdDetail() {
		return this.idDetail;
	}
	public void setIdDetail(String idDetail) {
		this.idDetail = idDetail;
	}

	@Id
	@Column(name="KODE_BARANG")
	public String getKodeBarang() {
		return this.kodeBarang;
	}
	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}

	@Id
	@Column(name="NOTA_PENJUALAN")
	public String getNotaPenjualan() {
		return this.notaPenjualan;
	}
	public void setNotaPenjualan(String notaPenjualan) {
		this.notaPenjualan = notaPenjualan;
	}


	public BigDecimal getDiskon() {
		return this.diskon;
	}

	public void setDiskon(BigDecimal diskon) {
		this.diskon = diskon;
	}


	public BigDecimal getHarga() {
		return this.harga;
	}

	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}


	public BigDecimal getJumlah() {
		return this.jumlah;
	}

	public void setJumlah(BigDecimal jumlah) {
		this.jumlah = jumlah;
	}


	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}