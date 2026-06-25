#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "entrada: ";
    cin >> n;
    // solo guardamos los dos valores anteriores, no toda la tabla
    int anterior2 = 1;  // es dp[i-2]
    int anterior1 = 1;  // es dp[i-1]
    int actual;

    cout << "tabla DP: [1, 1";

    for (int i = 2; i <= n; i++) {
        actual    = anterior1 + anterior2;
        anterior2 = anterior1;
        anterior1 = actual;
        cout << ", " << actual;
    }
    cout << "]" << endl;

    cout << "formas posibles: " << actual << endl;
    return 0;
}
