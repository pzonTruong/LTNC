# Hướng dẫn thực hiện Bài 5: Truy vấn nâng cao với Sakila

## Tóm tắt ý tưởng chính
Dự án này tập trung vào việc áp dụng các kỹ thuật SQL nâng cao như JOIN phức tạp, hàm tổng hợp (Aggregate functions), mệnh đề HAVING, truy vấn con (Subqueries), và các hàm cửa sổ (Window Functions) để phân tích dữ liệu từ cơ sở dữ liệu mẫu Sakila.

## Hướng dẫn thực hiện
Để chạy các câu truy vấn này, bạn cần cài đặt MySQL Server trên máy tính của mình.

### 1. Thiết lập cơ sở dữ liệu
Mở terminal hoặc MySQL Command Line Client và thực hiện các lệnh sau:

```sql
-- Đăng nhập vào MySQL (thay root bằng username của bạn)
mysql -u root -p

-- Tạo và nhập cấu trúc bảng
SOURCE src/sakila-schema.sql;

-- Nhập dữ liệu mẫu
SOURCE src/sakila-data.sql;
```

### 2. Chạy các câu truy vấn nâng cao
Sau khi đã thiết lập xong cơ sở dữ liệu, bạn có thể chạy tệp truy vấn:

```sql
-- Chọn cơ sở dữ liệu
USE sakila;

-- Chạy các truy vấn trong bài tập
SOURCE src/queries.sql;
```

Hoặc bạn có thể sao chép từng câu truy vấn trong tệp `src/queries.sql` và dán vào trình quản lý cơ sở dữ liệu (như MySQL Workbench) để xem kết quả.
