import os

def create_assignment_structure():
    # Nhap thong tin co ban
    ho_ten = "PhamTruongSon"
    mssv = "25021973"
    week = input("Nhap so tuan (VD: 1, 2...): ")
    
    try:
        num_bai = int(input("Nhap so luong bai tap (VD: 10): "))
    except ValueError:
        print("So luong bai tap phai la so nguyen. Mac dinh tao 10 bai.")
        num_bai = 10

    # Tao ten thu muc goc
    root_folder = f"{ho_ten}_{mssv}_Week{week}"
    
    # Tao thu muc goc neu chua co
    if not os.path.exists(root_folder):
        os.makedirs(root_folder)
        print(f"Da tao thu muc goc: {root_folder}")
    else:
        print(f"Thu muc goc {root_folder} da ton tai.")

    # Noi dung cua file run.sh theo tai lieu mau
    run_sh_content = """ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"
mkdir -p "$BUILD_DIR"
javac -d "$BUILD_DIR" "$SRC_DIR"/*.java
java -cp "$BUILD_DIR" Main
"""

    # Noi dung cua file README.md theo khuyen nghi
    readme_content = """# Mo ta loi giai

## Tom tat y tuong chinh cua loi giai
(Dien y tuong cua ban tai day)

## Ly do lua chon huong tiep can nay? Uu diem so voi cac cach khac
(Dien ly do cua ban tai day)

## Cach chay
Chay lenh: ./run.sh
"""

    # Tao cac thu muc con cho tung bai
    for i in range(1, num_bai + 1):
        # Format ten bai co 2 chu so (Bai01, Bai02...)
        folder_name = f"Bai{i:02d}"
        bai_path = os.path.join(root_folder, folder_name)
        
        # Tao thu muc BaiXX
        os.makedirs(bai_path, exist_ok=True)
        
        # Tao thu muc src/ ben trong BaiXX
        src_path = os.path.join(bai_path, "src")
        os.makedirs(src_path, exist_ok=True)
        
        # Tao thu muc lib/ ben trong BaiXX (tuy chon)
        lib_path = os.path.join(bai_path, "lib")
        os.makedirs(lib_path, exist_ok=True)

        # Tao file run.sh
        run_sh_path = os.path.join(bai_path, "run.sh")
        with open(run_sh_path, "w", encoding="utf-8", newline='\n') as f:
            f.write(run_sh_content)
        
        # Cap quyen thuc thi cho file run.sh (hoat dong tren Linux/macOS)
        try:
            os.chmod(run_sh_path, 0o755)
        except Exception:
            pass

        # Tao file README.md
        readme_path = os.path.join(bai_path, "README.md")
        with open(readme_path, "w", encoding="utf-8") as f:
            f.write(readme_content)

    print(f"Hoan thanh viec tao {num_bai} bai tap trong thu muc {root_folder}.")

if __name__ == "__main__":
    create_assignment_structure()