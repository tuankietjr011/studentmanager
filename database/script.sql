-- 1. Tạo Database
CREATE DATABASE DemoDB;
GO

USE DemoDB;
GO

-- 2. Tạo bảng SinhVien
CREATE TABLE SinhVien (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255),
    age INT
);
GO

-- 3. Dữ liệu mẫu
INSERT INTO SinhVien (name, age) VALUES (N'Nguyễn Văn A', 20);
INSERT INTO SinhVien (name, age) VALUES (N'Lê Tuấn Kiệt', 22);
GO