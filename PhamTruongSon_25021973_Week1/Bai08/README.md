# Kiểm tra số đối xứng (Palindrome Number)

## Mô tả
Kiểm tra một số nguyên có giữ nguyên giá trị khi đọc ngược lại hay không.

## Yêu cầu kỹ thuật
- **Phương thức:** `boolean isPalindrome(int n)`
- **Quy tắc:** Số âm không được coi là số Palindrome.

## Giải thuật
Đảo ngược số và so sánh với giá trị gốc ban đầu. Tối ưu hóa bằng cách loại trừ ngay các số âm và số kết thúc bằng 0.