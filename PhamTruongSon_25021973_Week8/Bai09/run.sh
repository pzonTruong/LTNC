#!/bin/bash

# 1. Tạo thư mục bin để chứa file sau khi biên dịch
mkdir -p bin

# 2. Biên dịch code chính (GradeClassifier)
javac -d bin src/main/*.java

# 3. Biên dịch code test (GradeClassifierTest) 
# Phải kèm theo file jar trong classpath (-cp)
javac -d bin -cp "lib/junit-platform-console-standalone-1.10.2.jar:bin" src/test/*.java

# 4. Chạy các bài kiểm thử
java -jar lib/junit-platform-console-standalone-1.10.2.jar \
     --class-path bin \
     --scan-class-path