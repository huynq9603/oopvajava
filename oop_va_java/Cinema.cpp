#include <iostream>
#include <vector>
using namespace std;

// --- Person and Customer ---
class Person {
public:
    string name;
    Person(string n) : name(n) {}
};

class Customer : public Person {
public:
    Customer(string n) : Person(n) {}
};

// --- Movie Class ---
class Movie {
private:
    string title;
    string time;

public:
    Movie(string t, string tm) : title(t), time(tm) {}

    string getTitle() const { return title; }
    string getTime() const { return time; }
};

// --- Seat Class ---
class Seat {
private:
    int row, col;
    bool booked;

public:
    Seat(int r = 0, int c = 0) : row(r), col(c), booked(false) {}

    bool isBooked() const { return booked; }
    void book() { booked = true; }
    void cancel() { booked = false; }

    int getRow() const { return row; }
    int getCol() const { return col; }
};

// --- Cinema Class ---
class Cinema {
private:
    Movie movie;
    int rows, cols;
    vector<vector<Seat>> seats;

public:
    Cinema(Movie m, int r, int c) : movie(m), rows(r), cols(c) {
        seats.resize(rows, vector<Seat>(cols));
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < cols; ++j)
                seats[i][j] = Seat(i, j);
    }

    bool bookSeat(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols)
            return false;
        if (seats[row][col].isBooked())
            return false;
        seats[row][col].book();
        return true;
    }

    bool cancelSeat(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols)
            return false;
        if (!seats[row][col].isBooked())
            return false;
        seats[row][col].cancel();
        return true;
    }

    void printSeats() {
        cout << "\nSo do ghe - Phim: " << movie.getTitle() << " (" << movie.getTime() << ")\n";
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j)
                cout << (seats[i][j].isBooked() ? "[X]" : "[ ]");
            cout << endl;
        }
    }

    string getMovieTitle() const { return movie.getTitle(); }
    Movie getMovie() const { return movie; }
};

// --- TicketManager Class ---
class TicketManager {
private:
    vector<Cinema> cinemas;

public:
    void addCinema(Movie m, int rows, int cols) {
        cinemas.push_back(Cinema(m, rows, cols));
        cout << "Them suat chieu thanh cong.\n";
    }

    bool bookTicket(string movieTitle, int row, int col, Customer c) {
        for (auto &cinema : cinemas) {
            if (cinema.getMovieTitle() == movieTitle) {
                if (cinema.bookSeat(row, col)) {
                    cout << "Dat ve thanh cong cho " << c.name << " tai ghe (" << row << "," << col << ") - " << movieTitle << endl;
                    return true;
                } else {
                    cout << "Ghe da duoc dat hoc khong hop le.\n";
                    return false;
                }
            }
        }
        cout << "Khong tim thay phim.\n";
        return false;
    }

    bool cancelTicket(string movieTitle, int row, int col) {
        for (auto &cinema : cinemas) {
            if (cinema.getMovieTitle() == movieTitle) {
                if (cinema.cancelSeat(row, col)) {
                    cout << "Huy ve thanh cong tai ve (" << row << "," << col << ") - " << movieTitle << endl;
                    return true;
                } else {
                    cout << "Khong the huy ve. Ghe khong ton tai hoc khong hop le\n";
                    return false;
                }
            }
        }
        cout << "Khong tim thay phim.\n";
        return false;
    }

    void showAvailableSeats(string movieTitle) {
        for (auto &cinema : cinemas) {
            if (cinema.getMovieTitle() == movieTitle) {
                cinema.printSeats();
                return;
            }
        }
        cout << "Khong tim thay phim.\n";
    }

    void listMovies() {
        cout << "Danh sach cac phim dang chieu:\n";
        for (auto &cinema : cinemas) {
            Movie m = cinema.getMovie();
            cout << "- " << m.getTitle() << " (" << m.getTime() << ")\n";
        }
    }

    bool hasMovies() const {
        return !cinemas.empty();
    }
};

// --- Main ---
int main() {
    TicketManager tm;
    int choice;

    while (true) {
        cout << "\n===== MENU =====\n";
        cout << "1. Them suat chieu\n";
        cout << "2. Xem danh sach phim\n";
        cout << "3. Dat ve\n";
        cout << "4. Huy ve\n";
        cout << "5. Xem so do ghe\n";
        cout << "0. Thoat\n";
        cout << "Chon chuc nang: ";
        cin >> choice;
        cin.ignore();

        if (choice == 0) break;

        string title, time, name;
        int row, col;

        switch (choice) {
            case 1:
                cout << "Nhap ten phim: ";
                getline(cin, title);
                cout << "Nhap thoi gian chieu: ";
                getline(cin, time);
                cout << "So hang ghe: ";
                cin >> row;
                cout << "So cot ghe: ";
                cin >> col;
                tm.addCinema(Movie(title, time), row, col);
                break;

            case 2:
                tm.listMovies();
                break;

            case 3:
                if (!tm.hasMovies()) {
                    cout << "Chua co phim nao duoc them.\n";
                    break;
                }
                cout << "Ten khach hang: ";
                getline(cin, name);
                cout << "Ten phim: ";
                getline(cin, title);
                cout << "Nhap hang ghe: ";
                cin >> row;
                cout << "Nhap cot ghe: ";
                cin >> col;
                tm.bookTicket(title, row, col, Customer(name));
                break;

            case 4:
                cout << "Ten phim: ";
                getline(cin, title);
                cout << "Nhap hang ghe: ";
                cin >> row;
                cout << "Nhap cot ghe: ";
                cin >> col;
                tm.cancelTicket(title, row, col);
                break;

            case 5:
                cout << "Nhap ten phim: ";
                getline(cin, title);
                tm.showAvailableSeats(title);
                break;

            default:
                cout << "Lua chon khong hop le.\n";
        }

        cin.ignore();
    }
}
