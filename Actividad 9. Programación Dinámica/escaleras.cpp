#include <iostream>
using namespace std;

// memo[i] guarda el resultado para no repetirlo
int memo[100];

int escaleras(int n) {
    // si ya llegamos al inicio o al escalon 1 hay  1 forma
    if (n == 0 || n == 1) return 1;
    // aca ya calculamos este escalon, devolvemos el resultado 
    if (memo[n] != -1) return memo[n];
    memo[n] = escaleras(n-1) + escaleras(n-2);
    return memo[n];
}

int main() {
    int n;
    cout << "entrada: ";
    cin >> n;
    // inicializamos toda la tabla en -1 
    for (int i = 0; i <= n; i++) memo[i] = -1;
    cout << "tabla DP: [";
    for (int i = 0; i <= n; i++) {
        cout << escaleras(i);
        if (i < n) cout << ", ";
    }
    cout << "]" << endl;
    cout << "formas posibles: " << escaleras(n) << endl;

    return 0;
}
