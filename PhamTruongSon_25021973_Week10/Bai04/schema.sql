-- Cơ sở dữ liệu: Hệ thống Chat
-- Phiên bản: 1.1 (Cập nhật chuẩn 3NF và chú thích Tiếng Việt)

-- 1. Tạo bảng Users (Người dùng)
-- Lưu trữ thông tin cơ bản của người dùng
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL, -- Tên đăng nhập, duy nhất
    full_name VARCHAR(100),               -- Họ tên đầy đủ
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Thời gian tạo tài khoản
);

-- 2. Tạo bảng Rooms (Phòng chat)
-- Lưu trữ thông tin về các phòng chat có sẵn
CREATE TABLE rooms (
    room_id SERIAL PRIMARY KEY,
    room_name VARCHAR(100) UNIQUE NOT NULL, -- Tên phòng, duy nhất
    description TEXT,                       -- Mô tả phòng chat
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Thời gian tạo phòng
);

-- 3. Tạo bảng RoomMembers (Thành viên phòng)
-- Giải quyết mối quan hệ Nhiều-Nhiều giữa Users và Rooms
-- Một người dùng có thể tham gia nhiều phòng, một phòng có nhiều thành viên
CREATE TABLE room_members (
    user_id INT NOT NULL,
    room_id INT NOT NULL,
    joined_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Thời gian tham gia phòng
    PRIMARY KEY (user_id, room_id),
    CONSTRAINT fk_member_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_member_room FOREIGN KEY (room_id) REFERENCES rooms(room_id) ON DELETE CASCADE
);

-- 4. Tạo bảng Messages (Tin nhắn)
-- Lưu trữ nội dung tin nhắn, liên kết với người gửi và phòng chat tương ứng
CREATE TABLE messages (
    message_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,                   -- ID người gửi
    room_id INT NOT NULL,                   -- ID phòng chat
    content TEXT NOT NULL,                  -- Nội dung tin nhắn
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Thời gian gửi (mặc định là hiện tại)
    CONSTRAINT fk_msg_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_msg_room FOREIGN KEY (room_id) REFERENCES rooms(room_id) ON DELETE CASCADE
);
