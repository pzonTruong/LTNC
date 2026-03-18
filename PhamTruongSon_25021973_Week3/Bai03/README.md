# Mo ta loi giai
```
Quan sát kết quả dòng (A). Nó ra 10 hay 20? Tại sao?
```
Ans: Từ lúc biên dịch, trình biên dịch sẽ kiểm tra rằng MathUtils có hàm sum() không. Vì có nên nó chạy. Nhưng tại thời điểm **thực thi** thì Jva sẽ nhìn vào đối tượng thực tế trong bộ nhớ là thằng *Advanced Math* nên sẽ ghi đè và trả ra a + b + 10 -> 20

```
Bỏ comment dòng (B). Trình biên dịch có báo lỗi không? Tại sao đối tượng là AdvancedMath (có hàm sum double) mà biến m lại không gọi được? 
```
Ans: (B) sẽ xảy ra lỗi. Do m là kiểu MathUtils mà MathUtils lại không có kiểu double trong nó nên chương trình sẽ trả ra lỗi.

## Tom tat y tuong chinh cua loi giai
(Dien y tuong cua ban tai day)

## Ly do lua chon huong tiep can nay? Uu diem so voi cac cach khac
(Dien ly do cua ban tai day)

## Cach chay
Chay lenh: ./run.sh
