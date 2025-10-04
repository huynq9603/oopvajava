#include<bits/stdc++.h>
using namespace std;
struct Cinema {
    string name;
    string address;
    int soPhong;
    int soChoNgoi;
};
void input(Cinema &c) {
    cout << "Nhap ten rap: ";
    getline(cin, c.name);
    cout << "Nhap dia chi: ";
    getline(cin, c.address);
    cout << "Nhap so phong chieu: ";
    cin >> c.soPhong;
    cout << "Nhap so ghe toi da moi phong: ";
    cin >> c.soChoNgoi;
    cin.ignore(); 
}
void show(const Cinema &c) {
    cout << "Ten rap: " << c.name << endl;
    cout << "Dia chi: " << c.address << endl;
    cout << "So phong chieu: " << c.soPhong << endl;
    cout << "So ghe toi da moi phong: " << c.soChoNgoi << endl;
    cout << "-----------------------------" << endl;
}
int main() {
    int n;
    cout << "Nhap so luong rap: ";
    cin >> n;
    cin.ignore(); 
    Cinema cinemas[100];
    for (int i = 0; i < n; ++i) {
        cout << "Nhap thong tin rap thu " << i + 1 << ":\n";
        input(cinemas[i]);
    }
    cout << "\n=== DANH SACH RAP ===\n";
    for (int i = 0; i < n; ++i) {
        show(cinemas[i]);
    }
}
