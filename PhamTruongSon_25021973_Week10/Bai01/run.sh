ROOT_DIR=$(pwd)
SRC_DIR="src"
BUILD_DIR="build"

mkdir -p "$BUILD_DIR"
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java

echo "Starting Server in background..."
# Run server in background and pipe output to server.log
java -cp build Main server > server.log 2>&1 &
SERVER_PID=$!

# Wait 3 seconds for server to start
sleep 3

echo "Starting Client..."
java -cp build Main client

# Terminate server when client exits
kill $SERVER_PID
echo "Server terminated."
