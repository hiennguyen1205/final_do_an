package com.dooan.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THIETBI1")
public class ThietBi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = 0;

	@Column(name = "STT")
	private Integer stt;

	@Column(name = "TENTHIETBI")
	private String ten;

	@Column(name = "MODEL")
	private String model;

	@Column(name = "SERIAL")
	private String serial;

	@Column(name = "HANGSX")
	private String hangsx;

	@Column(name = "NUOCSX")
	private String nuocsx;

	@Column(name = "NAMSX")
	private String namsx;

	@Column(name = "DONVI")
	private String donVi;

	@Column(name = "SOLUONG")
	private Integer soLuong;

	@Column(name = "DONGIAVND")
	private Double dongiaVND;

	@Column(name = "DONGIAUSD")
	private Double dongiaUSD;

	@Column(name = "THANHTIEN")
	private Double thanhTien;

	@Column(name = "KHOA")
	private String khoa;

	@Column(name = "NGAYBANGIAO")
	private String ngayBanGiao;

	@Column(name = "GIAYTO")
	private String giayTo;

	@Column(name = "NGUON")
	private String nguon;

	@Column(name = "GHICHU")
	private String ghiChu;

	public ThietBi() {
		super();
	}

	public ThietBi(Integer id, Integer stt, String ten, String model, String serial, String hangsx, String nuocsx,
			String namsx, String donVi, Integer soLuong, Double dongiaVND, Double dongiaUSD, Double thanhTien,
			String khoa, String ngayBanGiao, String giayTo, String nguon, String ghiChu) {
		super();
		this.id = id;
		this.stt = stt;
		this.ten = ten;
		this.model = model;
		this.serial = serial;
		this.hangsx = hangsx;
		this.nuocsx = nuocsx;
		this.namsx = namsx;
		this.donVi = donVi;
		this.soLuong = soLuong;
		this.dongiaVND = dongiaVND;
		this.dongiaUSD = dongiaUSD;
		this.thanhTien = thanhTien;
		this.khoa = khoa;
		this.ngayBanGiao = ngayBanGiao;
		this.giayTo = giayTo;
		this.nguon = nguon;
		this.ghiChu = ghiChu;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(Double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public Integer getStt() {
		return stt;
	}

	public void setStt(Integer stt) {
		this.stt = stt;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getHangsx() {
		return hangsx;
	}

	public void setHangsx(String hangsx) {
		this.hangsx = hangsx;
	}

	public String getNuocsx() {
		return nuocsx;
	}

	public void setNuocsx(String nuocsx) {
		this.nuocsx = nuocsx;
	}

	public String getNamsx() {
		return namsx;
	}

	public void setNamsx(String namsx) {
		this.namsx = namsx;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Double getDongiaVND() {
		return dongiaVND;
	}

	public void setDongiaVND(Double dongiaVND) {
		this.dongiaVND = dongiaVND;
	}

	public Double getDongiaUSD() {
		return dongiaUSD;
	}

	public void setDongiaUSD(Double dongiaUSD) {
		this.dongiaUSD = dongiaUSD;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		khoa = khoa;
	}

	public String getNgayBanGiao() {
		return ngayBanGiao;
	}

	public void setNgayBanGiao(String ngayBanGiao) {
		this.ngayBanGiao = ngayBanGiao;
	}

	public String getGiayTo() {
		return giayTo;
	}

	public void setGiayTo(String giayTo) {
		this.giayTo = giayTo;
	}

	public String getNguon() {
		return nguon;
	}

	public void setNguon(String nguon) {
		this.nguon = nguon;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return this.getStt() + "\n" + this.getTen() + "\n" + this.getModel() + "\n" + this.getSerial() + "\n"
				+ this.getHangsx() + "\n" + this.getNuocsx() + "\n" + this.getNamsx() + "\n" + this.getDonVi() + "\n"
				+ this.getSoLuong() + "\n" + this.getDongiaVND() + "\n" + this.getDongiaUSD() + "\n"
				+ this.getThanhTien() + "\n" + this.getKhoa() + "\n" + this.getNgayBanGiao() + "\n" + this.getGiayTo()
				+ "\n" + this.getNguon() + "\n" + this.getGhiChu();
	}

	public void setByKey(String key, String s) {
		if (s != null && s != "")
			switch (key) {
			case "stt":
				this.stt = Integer.parseInt(s);
				break;
			case "ten":
				this.ten = s;
				break;
			case "model":
				this.model = s;
				break;
			case "serial":
				this.serial = s;
				break;
			case "hangsx":
				this.hangsx = s;
				break;
			case "nuocsx":
				this.nuocsx = s;
				break;
			case "namsx":
				this.namsx = s;
				break;
			case "donvi":
				this.donVi = s;
				break;
			case "soluong":
				this.soLuong = Integer.valueOf(s);
				break;
			case "dongiavnd":
				this.dongiaVND = Double.valueOf(s);
				break;
			case "dongiausd":
				this.dongiaUSD = Double.valueOf(s);
				break;
			case "thanhtien":
				this.thanhTien = Double.valueOf(s);
				break;
			case "khoa":
				this.khoa = s;
				break;
			case "ngaybangiao":
				this.ngayBanGiao = s;
				break;
			case "giayto":
				this.giayTo = s;
				break;
			case "nguon":
				this.nguon = s;
				break;
			case "ghichu":
				this.ghiChu = s;
				break;
			default:
				break;
			}
	}

}
