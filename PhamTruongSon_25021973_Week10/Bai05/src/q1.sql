-- 1. Viết một câu truy vấn sử dụng JOIN cơ bản và các hàm Tổng hợp (Aggregation) 
-- để tìm ra Top 5 thể loại phim (categories) tạo ra tổng doanh thu cho thuê cao nhất.
SELECT 
    c.name AS category, 
    SUM(p.amount) AS total_revenue
FROM payment p
JOIN rental r ON p.rental_id = r.rental_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film_category fc ON i.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
GROUP BY c.name
ORDER BY total_revenue DESC
LIMIT 5;
