#!/bin/bash

# 1. Dọn dẹp và kiểm tra lỗi định dạng (Checkstyle)
echo "Checking code style..."
mvn checkstyle:check

# 2. Biên dịch và chạy thử nghiệm
if [ $? -eq 0 ]; then
    echo "Checkstyle passed! Building project..."
    mvn clean install
else
    echo "Checkstyle failed. Please fix violations before building."
    exit 1
fi