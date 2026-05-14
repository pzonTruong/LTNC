-- 4. Viết một câu truy vấn sử dụng Window Functions để gán Thứ hạng (Rank) 
-- cho các bộ phim trong từng thể loại cụ thể dựa trên thời lượng (length) của chúng, 
-- hiển thị Tên phim, Thể loại, Thời lượng và Thứ hạng tương ứng.
SELECT 
    f.title, 
    c.name AS category, 
    f.length,
    RANK() OVER (PARTITION BY c.category_id ORDER BY f.length DESC) AS `film_rank`
FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
ORDER BY category, film_rank;