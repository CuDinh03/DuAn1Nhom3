create database DuAn1
go
use DuAn1

create table vaiTro(
   id uniqueidentifier PRIMARY KEY ,
   ma varchar(20),
   ngayTao Date,
   ngaySua Date,
   trangThai int,

)
INSERT INTO vaiTro (id, ma, ngayTao, ngaySua, trangThai)
VALUES
   ('7E90870D-89E3-4AEB-9130-176566081D76', 'VT001', '2023-07-12', '2023-07-12', 1),
   ('8A2F1EBD-C1AA-46C4-A7E3-35A1337A60E4', 'VT002', '2023-07-12', '2023-07-12', 1),
   ('FF9F0D7B-41EF-482A-9E84-2B81E7AA6E29', 'VT003', '2023-07-12', '2023-07-12', 1),
   ('A8E62E50-9CEA-4B0C-A3C3-91C3B5C3A35D', 'VT004', '2023-07-12', '2023-07-12', 1),
   ('B387B2D6-3E7F-4F7A-B7DF-32D21A47C3E9', 'VT005', '2023-07-12', '2023-07-12', 1);
create table taiKhoanVaiTro(
    idVaiTro  uniqueidentifier ,
	idTaiKhoan uniqueidentifier,
	FOREIGN KEY (idVaiTro) REFERENCES vaiTro(id),
	FOREIGN KEY (idTaiKhoan) REFERENCES taiKhoan(id),
)
INSERT INTO taiKhoan (id, ma, ngayTao, ngaySua, taiKhoan, matKhau, trangThai)
VALUES
   ('7E90870D-89E3-4AEB-9130-176566081D76', 'TK001', '2023-07-12', '2023-07-12', 'tai_khoan_1', 'mat_khau_1', 1),
   ('8A2F1EBD-C1AA-46C4-A7E3-35A1337A60E4', 'TK002', '2023-07-12', '2023-07-12', 'tai_khoan_2', 'mat_khau_2', 1),
   ('FF9F0D7B-41EF-482A-9E84-2B81E7AA6E29', 'TK003', '2023-07-12', '2023-07-12', 'tai_khoan_3', 'mat_khau_3', 1),
   ('A8E62E50-9CEA-4B0C-A3C3-91C3B5C3A35D', 'TK004', '2023-07-12', '2023-07-12', 'tai_khoan_4', 'mat_khau_4', 1),
   ('B387B2D6-3E7F-4F7A-B7DF-32D21A47C3E9', 'TK005', '2023-07-12', '2023-07-12', 'tai_khoan_5', 'mat_khau_5', 1);
create table taiKhoan(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 ngayTao Date,
 ngaySua date,
 taiKhoan varchar(30),
 matKhau varchar(30),
 trangThai int,
)
INSERT INTO taiKhoanVaiTro (idVaiTro, idTaiKhoan)
VALUES
   ('7E90870D-89E3-4AEB-9130-176566081D76', '7E90870D-89E3-4AEB-9130-176566081D76'),
   ('8A2F1EBD-C1AA-46C4-A7E3-35A1337A60E4', '8A2F1EBD-C1AA-46C4-A7E3-35A1337A60E4'),
   ('FF9F0D7B-41EF-482A-9E84-2B81E7AA6E29', 'FF9F0D7B-41EF-482A-9E84-2B81E7AA6E29'),
   ('A8E62E50-9CEA-4B0C-A3C3-91C3B5C3A35D', 'A8E62E50-9CEA-4B0C-A3C3-91C3B5C3A35D'),
   ('B387B2D6-3E7F-4F7A-B7DF-32D21A47C3E9', 'B387B2D6-3E7F-4F7A-B7DF-32D21A47C3E9');
create table NhanVien(
 id uniqueidentifier PRIMARY KEY ,
 maNV varchar(20),
 tenNV varchar(20),
 tuoi int,
 diaChi varchar(30),
 email varchar(30),
 gioiTinh int,
 soDienThoai varchar(11),
 ngayTao date,
 ngaySua date,
 trangThai int,
 idKho uniqueidentifier,
 FOREIGN KEY (idKho) REFERENCES kho(id),
  FOREIGN KEY (id) REFERENCES taiKhoan(id),
)

create table baoCao(
 id uniqueidentifier PRIMARY KEY ,
 maBC varchar(20),
 noiDung varchar(20),
 ten varchar(20),
 ngayTao date,
 ngaySua date,
 doanhThu decimal(20,5),
 trangThai int,
 idNV uniqueidentifier,
 idCuaHang uniqueidentifier,
 FOREIGN KEY (idNV) REFERENCES NhanVien(id),
  FOREIGN KEY (idCuaHang) REFERENCES CuaHang(id),

)


create table kho(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 tenKho varchar(20),
 ngayTao date,
 ngaySua date,
 diaChi varchar(30),
 trangThai int,
 idPhieuNhap uniqueidentifier,
)
ALTER TABLE dbo.kho ADD FOREIGN KEY(idPhieuNhap) REFERENCES dbo.phieuNhap(id)

create table phieuXuat(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 ngayTao date,
 ngaySua date,
 DonViTinh varchar(30),
 trangThai int,
 idKho uniqueidentifier,
 FOREIGN KEY (idKho) REFERENCES kho(id),
)
create table phieuXuatChiTiet(
 idPhieuXuat uniqueidentifier ,
 idSanPham uniqueidentifier ,
 FOREIGN KEY (idPhieuXuat) REFERENCES phieuXuat(id),
 FOREIGN KEY (idSanPham) REFERENCES sanPham(id),

)
create table phieuNhap(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 ngayTao date,
 ngaySua date,
 DonViTinh varchar(30),
 giaNhap decimal(20,5),
 trangThai int,
)
create table phieuNhapChiTiet(
 idPhieuNhap uniqueidentifier,
 idSanPham uniqueidentifier ,
  FOREIGN KEY (idPhieuNhap) REFERENCES phieuNhap(id),
)
 ALTER TABLE dbo.phieuNhapChiTiet ADD FOREIGN KEY (idSanPham) REFERENCES sanPham(id)
create table khachHang(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 tenKH varchar(30),
 soDienThoai varchar(11),
 ngayTao date,
 ngaySua date,
 trangThai int,
)
create table gioHang(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 idNV uniqueidentifier,
 idKH uniqueidentifier,
 idCH uniqueidentifier,
 ngayTao date,
 ngaySua date,
 trangThai int,
)
create table gioHangChiTiet(
 id uniqueidentifier PRIMARY KEY,
 idgioHang uniqueidentifier ,
 idSP uniqueidentifier,
 idHoaDon uniqueidentifier,
 soLuong int,
 giaBan  decimal(20,5),
)
create table hoaDon(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 ten varchar(20),
 ngayTao date,
 ngaySua date,
 idKh uniqueidentifier,
 idCH uniqueidentifier,
 trangThai int,
)
create table hoaDonChiTiet(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 idHD uniqueidentifier,
 ngayTao date,
 ngaySua date,
 tongTien decimal(20,5),
 trangThai int,
)
create table cuaHang(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 ten varchar(30),
 ngayTao date,
 ngaySua date,
 diaChi varchar(30),
 idPhieuNhanHang uniqueidentifier,
 trangThai int,
  FOREIGN KEY (idPhieuNhanHang) REFERENCES phieuNhanHang(id),
)

create table doanhThu(
 idCH uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 ngayTao date,
 ngaySua date,
doanhThu decimal(20,5),
FOREIGN KEY (idCH) REFERENCES CuaHang(id),
)
create table phieuNhanHang(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 ngayTao date,
 ngaySua date,
 donViTinh varchar(30),
 trangThai int,
)
create table nhanHangChitiet(
 idPhieuNhan uniqueidentifier,
 idSanPham  uniqueidentifier,
  FOREIGN KEY (idPhieuNhan) REFERENCES phieuNhanHang(id),
   FOREIGN KEY (idSanPham) REFERENCES sanPham(id),
)
create table sanPham(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 ten varchar(30),
 ngayTao date,
 ngaySua date,
 nguonGoc varchar(30),
 giaGoc decimal(20,5),
 ngaySX date,
 hanSD date,
 idDanhMuc uniqueidentifier,
 trangThai int,
)
ALTER TABLE dbo.sanPham ADD FOREIGN KEY(idDanhMuc) REFERENCES dbo.danhMuc(id)
create table tonKho(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 idSP uniqueidentifier,
 ngayTao date,
 ngaySua date,
 trangThai int,
 FOREIGN KEY (idSP) REFERENCES sanPham(id),
)
create table danhMuc(
  id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 ten varchar(30),
 ngayTao date,
 ngaySua date,
 trangThai int,
)
create table khachHang(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 tenKh varchar(20),
 ngayTao date,
 ngaySua date,
 soDienThoai varchar(11),
 trangThai int,
)
create table gioHang(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 ngayTao date,
 ngaySua date,
 idNV uniqueidentifier,
 idKH uniqueidentifier,
 idCH uniqueidentifier,
 trangThai int,
  FOREIGN KEY (idNV) REFERENCES NhanVien(id),
  FOREIGN KEY (idKH) REFERENCES khachHang(id),
   FOREIGN KEY (idCH) REFERENCES CuaHang(id),
)
create table gioHangChiTiet(
 id uniqueidentifier PRIMARY KEY ,
 idGH uniqueidentifier,
 idSP uniqueidentifier,
 idHD uniqueidentifier,
 soLuong int,
 giaBan decimal(20,5),
 trangThai int,
  FOREIGN KEY (idGH) REFERENCES gioHang(id),
  FOREIGN KEY (idSP) REFERENCES sanPham(id),
   FOREIGN KEY (idHD) REFERENCES hoaDon(id),
)
create table HoaDon(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 ngayTao date,
 ngaySua date,
 trangThai int,
)
create table HoaDonChiTiet(
 id uniqueidentifier PRIMARY KEY ,
 ma varchar(20),
 idHoaDon uniqueidentifier,
 ngayTao date,
 ngaySua date,
 tongTien decimal(20,5),
 trangThai int,
   FOREIGN KEY (idHoaDon) REFERENCES hoaDon(id),
)