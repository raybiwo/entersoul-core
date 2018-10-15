package core;

//import java.math.BigDecimal;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpMethod;

import response.RestResponse;
import core.dto.MstBarangDto;
import core.dto.TrxPenjualanDtlDto;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
		Date tanggal = new Date();
		String result = formatter.format(tanggal);
		
		System.out.println("tanggal : " + result);
		
		
		/*BigDecimal x = new BigDecimal(001);
		System.out.println(x);*/
		
		
		/*NumberFormat formatter = new DecimalFormat("0000000");
		String number = formatter.format(2500);
		System.out.println(number);*/
		
		
		//System.out.println(x);
		//int x=0;
		/*List<String> a1 = new ArrayList<String>(); 
		a1.add("d");
		a1.add("b"); 
		a1.add("c");
		a1.add("a");
		a1.add("e");
		a1.add("f");
		a1.add("g");
	
		
		for (int i = 0; i < a1.size(); i++) {
			NumberFormat formatter = new DecimalFormat("0000000");
			String number = "ID" + formatter.format(i);
			System.out.println(number);
		}
		System.out.println("record  : "+a1.size());
		String kode = "ID" + (a1.size()+001);
		System.out.println(kode);
		
		//a1.remove(1);
		
		System.out.println(" ArrayList Elements"); 
		System.out.println(a1); 
		
		for (String s : a1) 
			System.out.println(a1.indexOf(s) + s);
			System.out.println("");*/
			
		/*for (int i = 0; i < a1.size(); i++) 
			if(a1.get(i)=="a"){
				x=i;
				System.out.println(x);
			}
			a1.set(x, "z");
			System.out.println("");
			System.out.println(a1);*/ 
			
			/*a1.get(i);
			System.out.println(a1.get(i));*/
			
			/*List<MstBarangDto> listbarang = new ArrayList<>();
			String WS_URL = "http://localhost:8080/boot-core";
			String uriBarang = WS_URL + "/barang/allLengkap";
			
			RestResponse restResponse = new RestResponse();
			try {
				restResponse = bs.callWs(uriDetail, null, HttpMethod.GET);
				listDetail = JsonUtil.mapJsonToListObject(
						restResponse.getContents(), TrxPenjualanDtlDto.class);

				restResponse = bs.callWs(uriBarang, null, HttpMethod.GET);
				listBarang = JsonUtil.mapJsonToListObject(
						restResponse.getContents(), MstBarangDto.class);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			for (MstBarangDto mstBarang : listbarang) {
				System.out.println("Kode Barang : "+mstBarang.getKodeBarang());
				System.out.println("Nama Barang : "+mstBarang.getNamaBarang());
				System.out.println("Kode Jenis Barang : "+mstBarang.getKodeJenisBarang());
				System.out.println("Nama Jenis Barang : "+mstBarang.getNamaJenisBarang());
				System.out.println("Kode Supplier : "+mstBarang.getKodeSupplier());
				System.out.println("Nama Supplier : "+mstBarang.getNamaSupplier());
				System.out.println("Kode Merk : "+mstBarang.getKodeMerk());
				System.out.println("Nama Merk : "+mstBarang.getNamaMerk());
			}*/
	}

}
