-- 2. Viết một câu truy vấn sử dụng Lọc phức tạp (mệnh đề HAVING) để lấy danh sách 
-- các khách hàng đã thuê nhiều hơn 30 bộ phim, hiển thị Tên, Email và Tổng số lượt thuê của họ, 
-- sắp xếp theo số lượng thuê giảm dần.
SELECT 
    c.first_name, 
    c.last_name, 
    c.email, 
    COUNT(r.rental_id) AS total_rentals
FROM customer c
JOIN rental r ON c.customer_id = r.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name, c.email
HAVING total_rentals > 30
ORDER BY total_rentals DESC;
