# Bài 5: Test Coverage & Quality Enforcement (JaCoCo)

## 1. Yêu cầu đề bài
Chỉ viết unit test là chưa đủ; chúng ta cần đo lường mức độ bao phủ của code (Code Coverage) để đảm bảo các logic quan trọng đã được kiểm thử.

Yêu cầu cụ thể:
- **Tích hợp JaCoCo**: Sử dụng `jacoco-maven-plugin` để đo lường độ bao phủ.
- **Quality Gate (Quy tắc nghiêm ngặt)**: Tự động làm thất bại (fail) quá trình build nếu độ bao phủ code (Line Coverage) thấp hơn **80%**.
- **GitHub Actions Integration**: Thực thi bước kiểm tra này trong pipeline (thông qua lệnh `mvn verify`).
- **Artifact Storage**: Sử dụng `upload-artifact` để lưu trữ báo cáo JaCoCo (`target/site/jacoco/`) sau khi build.

## 2. Kiến thức cốt lõi

### Code Coverage là gì?
Code Coverage là một chỉ số đo lường tỷ lệ phần trăm mã nguồn được thực thi khi chạy bộ kiểm thử (unit tests). Độ bao phủ cao không đảm bảo code không có bug, nhưng độ bao phủ thấp chắc chắn cho thấy rủi ro cao vì nhiều phần mã chưa được kiểm tra.

### JaCoCo (Java Code Coverage)
JaCoCo là một thư viện mã nguồn mở phổ biến để đo lường độ bao phủ code trong Java. Nó hoạt động bằng cách chèn các "instrumentation" vào bytecode để theo dõi các dòng lệnh nào đã chạy.

Các chỉ số quan trọng:
- **Line Coverage**: Tỷ lệ các dòng code đã được thực thi.
- **Branch Coverage**: Tỷ lệ các nhánh rẽ (if/else, switch) đã được thực thi.
- **Instruction Coverage**: Tỷ lệ các lệnh bytecode đã được thực thi.

### Cấu hình Quality Gate trong Maven
Trong `pom.xml`, chúng ta sử dụng goal `check` của JaCoCo để định nghĩa các giới hạn:

```xml
<execution>
    <id>check</id>
    <goals><goal>check</goal></goals>
    <configuration>
        <rules>
            <rule>
                <element>BUNDLE</element>
                <limits>
                    <limit>
                        <counter>LINE</counter>
                        <value>COVEREDRATIO</value>
                        <minimum>0.80</minimum>
                    </limit>
                </limits>
            </rule>
        </rules>
    </configuration>
</execution>
```

### GitHub Actions Artifacts
Việc lưu trữ báo cáo dưới dạng Artifact giúp lập trình viên có thể tải về và xem chi tiết (file HTML) những phần code nào chưa được cover, ngay cả khi pipeline đã kết thúc.

```yaml
- name: Upload Coverage Report
  uses: actions/upload-artifact@v4
  with:
    name: jacoco-report
    path: target/site/jacoco/
```

## 3. Cách chạy và Kiểm chứng
1. Chạy lệnh: `mvn clean verify`
2. Nếu coverage < 80%, build sẽ báo lỗi: `[ERROR] Failed to execute goal org.jacoco:jacoco-maven-plugin:...:check (check) on project...: Coverage check failed`
3. Xem báo cáo chi tiết tại: `target/site/jacoco/index.html`
