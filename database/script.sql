-- 1. Tạo Database (Giữ nguyên)
CREATE DATABASE DemoDB;
GO

USE DemoDB;
GO

-- 2. Tạo bảng SinhVien với UUID
CREATE TABLE SinhVien (
    -- Dùng UNIQUEIDENTIFIER thay cho INT
    -- NEWSEQUENTIALID() giúp tạo UUID có thứ tự, tốt cho hiệu năng (Index-friendly)
    id UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID() PRIMARY KEY,
    name NVARCHAR(255),
    age INT
);
GO

-- 3. Dữ liệu mẫu
-- Khi dùng DEFAULT NEWSEQUENTIALID(), bạn không cần chèn cột id thủ công
INSERT INTO SinhVien (name, age) VALUES (N'Nguyễn Văn A', 20);
INSERT INTO SinhVien (name, age) VALUES (N'Lê Tuấn Kiệt', 22);
GO

-- Xem kết quả
SELECT * FROM SinhVien;