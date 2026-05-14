-- 3. Viết một câu truy vấn sử dụng Truy vấn con (Subqueries) hoặc Biểu thức Bảng Chung (CTE) 
-- để xác định những khách hàng có tổng chi tiêu lớn hơn mức chi tiêu trung bình 
-- của toàn bộ khách hàng cộng lại.
WITH CustomerSpending AS (
    SELECT customer_id, SUM(amount) AS total_spent
    FROM payment
    GROUP BY customer_id
)
SELECT 
    c.first_name, 
    c.last_name, 
    cs.total_spent
FROM customer c
JOIN CustomerSpending cs ON c.customer_id = cs.customer_id
WHERE cs.total_spent > (SELECT AVG(total_spent) FROM CustomerSpending);