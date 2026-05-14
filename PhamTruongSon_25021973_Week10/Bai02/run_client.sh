#!/bin/bash
ROOT_DIR=$(pwd)
BUILD_DIR="$ROOT_DIR/build"
java -cp "$BUILD_DIR" MultiThreadedClient
