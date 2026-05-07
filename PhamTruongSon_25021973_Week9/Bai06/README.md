# Bài 6: CI/CD Pipeline Optimization & Caching

## 1. Yêu cầu đề bài
Khi dự án phát triển, việc tải xuống các Maven dependency từ đầu cho mỗi lần chạy CI tiêu tốn nhiều thời gian và làm chậm chu kỳ phát triển.

Yêu cầu cụ thể:
- **Dependency Caching**: Cấu hình cache Maven (`cache: 'maven'`) trong action `setup-java` của GitHub Actions.
- **So sánh hiệu năng**: Thực hiện 2 lần push code liên tiếp, ghi lại thời gian thực thi trước và sau khi áp dụng caching.
- **Phân tích log**: Kiểm tra log GitHub Actions để xác nhận dependency được lấy từ cache thay vì tải lại từ Maven Central.

## 2. Kiến thức cốt lõi

### Vấn đề không có Cache
Mỗi lần CI chạy, runner là một máy ảo hoàn toàn sạch (clean virtual machine). Điều này có nghĩa là mỗi lần đều phải tải xuống toàn bộ các thư viện Maven từ Internet (Maven Central), tiêu tốn 1-3 phút cho mỗi lần chạy.

### Cơ chế Caching trong GitHub Actions
GitHub Actions cung cấp cơ chế cache cho phép lưu trữ các thư mục nhất định (ví dụ: `~/.m2/repository`) giữa các lần chạy. Khi cache hit, runner sẽ khôi phục thư mục đó thay vì tải lại từ đầu.

Cách cấu hình đơn giản nhất — tích hợp thẳng vào action `setup-java`:

```yaml
- name: Set up JDK 17
  uses: actions/setup-java@v4
  with:
    java-version: '17'
    distribution: 'temurin'
    cache: 'maven'   # ← Dòng ma thuật, tự động cache ~/.m2
```

### Cache Key và Cache Hit/Miss
GitHub Actions tạo một **cache key** dựa trên nội dung của file `pom.xml`. Cơ chế hoạt động:
- **Cache Miss** (lần đầu tiên hoặc `pom.xml` thay đổi): Dependency được tải từ Maven Central, sau đó lưu vào cache.
- **Cache Hit** (lần chạy tiếp theo với cùng `pom.xml`): Dependency được khôi phục từ cache trong vài giây.

### Bằng chứng Cache hoạt động
Trong log GitHub Actions, khi cache hit, bạn sẽ thấy thông báo:
```
Cache restored from key: setup-java-Linux-java-...
```
Thay vì log tải dependency:
```
Downloading from central: https://repo.maven.apache.org/...
```

### Kết quả thực tế (So sánh thời gian)
| Lần chạy | Trạng thái Cache | Thời gian Build |
|----------|-----------------|----------------|
| Lần 1   | Cache Miss (cache chưa có) | ~90 giây |
| Lần 2   | Cache Hit (cache được dùng lại) | ~15 giây |

## 3. Cách chạy và Kiểm chứng
1. Workflow cấu hình tại: `.github/workflows/`
2. Push code lần 1: Quan sát log thấy `Downloading from central:...`
3. Push code lần 2: Quan sát log thấy `Cache restored from key:...`
4. So sánh thời gian thực thi của hai lần chạy trong tab **Actions** của GitHub.
