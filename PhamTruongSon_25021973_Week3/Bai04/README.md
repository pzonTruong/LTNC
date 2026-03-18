# Mo ta loi giai

## Tom tat y tuong chinh cua loi giai
(Dien y tuong cua ban tai day)

Thực hành:
Biên dịch chương trình (javac). Có lỗi không? (Mong đợi: Không lỗi biên dịch).
// javac: Không lỗi
        
Chạy chương trình (java). Có lỗi không? Ghi lại tên lỗi (Exception) xuất hiện.
// Exception in thread "main" java.lang.ClassCastException: class Dog cannot be cast to class Cat (Dog and Cat are in unnamed module of loader 'app')
// at Main.main(Main.java:7)

Sửa lỗi:
Sử dụng cấu trúc if và toán tử instanceof để kiểm tra biến a có đúng là Cat hay không trước khi ép kiểu.
In ra thông báo: "Đây không phải là Mèo!" nếu ép kiểu không hợp lệ.


## Ly do lua chon huong tiep can nay? Uu diem so voi cac cach khac
(Dien ly do cua ban tai day)

## Cach chay
Chay lenh: ./run.sh
