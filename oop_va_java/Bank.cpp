#include <bits/stdc++.h>
using namespace std;
struct Customer {
    string name;
    string id;
};
struct Transaction {
    string type; // "Deposit" or "Withdraw"
    double amount;
    string timestamp;
};
class Account {
private:
    Customer owner;
    double balance;
    vector<Transaction> history;

    string getCurrentTime() {
        time_t now = time(0);
        char buf[80];
        strftime(buf, sizeof(buf), "%Y-%m-%d %X", localtime(&now));
        return string(buf);
    }

    void logTransaction(string type, double amount) {
        history.push_back({type, amount, getCurrentTime()});
        cout << "[LOG] " << type << " $" << amount << " at " << history.back().timestamp << endl;
    }

public:
    Account(Customer c) : owner(c), balance(0.0) {}

    void deposit(double amount) {
        if (amount <= 0) {
            cout << "Số tiền nạp không hợp lệ.\n";
            return;
        }
        balance += amount;
        logTransaction("Deposit", amount);
    }

    void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            cout << "Số tiền rút không hợp lệ hoặc vượt quá số dư.\n";
            return;
        }
        balance -= amount;
        logTransaction("Withdraw", amount);
    }

    void printStatement() {
        cout << "\n--- Sao kê tài khoản: " << owner.name << " ---\n";
        cout << "ID: " << owner.id << "\n";
        cout << "Số dư: $" << balance << "\n";
        cout << "Lịch sử giao dịch:\n";
        for (auto &t : history) {
            cout << t.timestamp << " | " << t.type << " | $" << t.amount << "\n";
        }
        cout << "----------------------------\n";
    }

    string getId() const {
        return owner.id;
    }

    string getName() const {
        return owner.name;
    }
};

// --- Bank Class ---
class Bank {
private:
    vector<Account> accounts;

public:
    void addAccount(Customer c) {
        accounts.push_back(Account(c));
        cout << "Tạo tài khoản cho " << c.name << " thành công.\n";
    }

    Account* findAccount(string id) {
        for (auto &acc : accounts) {
            if (acc.getId() == id)
                return &acc;
        }
        return nullptr;
    }
};

// --- Main ---
int main() {
    Bank bank;
    int choice;
    do {
        cout << "\n=========== MENU NGÂN HÀNG ===========" << endl;
        cout << "1. Tạo tài khoản mới\n";
        cout << "2. Gửi tiền\n";
        cout << "3. Rút tiền\n";
        cout << "4. In sao kê\n";
        cout << "5. Thoát\n";
        cout << "Chọn chức năng (1-5): ";
        cin >> choice;
        cin.ignore();

        string id;
        double amount;

        switch (choice) {
            case 1: {
                Customer c;
                cout << "Nhập tên khách hàng: ";
                getline(cin, c.name);
                cout << "Nhập ID tài khoản: ";
                getline(cin, c.id);
                if (bank.findAccount(c.id)) {
                    cout << "❌ ID đã tồn tại. Vui lòng chọn ID khác.\n";
                } else {
                    bank.addAccount(c);
                }
                break;
            }
            case 2: {
                cout << "Nhập ID tài khoản: ";
                getline(cin, id);
                Account* acc = bank.findAccount(id);
                if (acc) {
                    cout << "Nhập số tiền muốn gửi: ";
                    cin >> amount;
                    acc->deposit(amount);
                } else {
                    cout << "❌ Không tìm thấy tài khoản.\n";
                }
                cin.ignore();
                break;
            }
            case 3: {
                cout << "Nhập ID tài khoản: ";
                getline(cin, id);
                Account* acc = bank.findAccount(id);
                if (acc) {
                    cout << "Nhập số tiền muốn rút: ";
                    cin >> amount;
                    acc->withdraw(amount);
                } else {
                    cout << "❌ Không tìm thấy tài khoản.\n";
                }
                cin.ignore();
                break;
            }
            case 4: {
                cout << "Nhập ID tài khoản: ";
                getline(cin, id);
                Account* acc = bank.findAccount(id);
                if (acc) {
                    acc->printStatement();
                } else {
                    cout << "❌ Không tìm thấy tài khoản.\n";
                }
                break;
            }
            case 5:
                cout << "👋 Thoát chương trình.\n";
                break;
            default:
                cout << "❌ Lựa chọn không hợp lệ.\n";
        }
    } while (choice != 5);

    return 0;
}
