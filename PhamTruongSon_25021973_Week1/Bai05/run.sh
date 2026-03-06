#!/bin/bash
ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"

# Tạo thư mục build
mkdir -p "$BUILD_DIR"

# Biên dịch mã nguồn từ thư mục src
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java

# Chạy class Main từ thư mục build
java -cp "$BUILD_DIR" Main