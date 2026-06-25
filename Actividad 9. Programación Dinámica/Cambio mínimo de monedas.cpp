#include <iostream>
using namespace std;

int main() {

    int monedas[] = {1, 2, 5};
    int n = 3;
    int monto;
    cout << "ingresa el monto: ";
    cin >> monto;

    // si el usuario ingresa un monto invalido, avisamos y salimos
    if (monto <= 0) {
        cout << "el monto debe ser mayor a 0." << endl;
        return 1;
    }
    //aca va la tabla DP 
    int dp[100];
    int desde[100];
    dp[0] = 0;
    desde[0] = -1;
    for (int i = 1; i <= monto; i++) {
        dp[i]    = 9999;
        desde[i] = -1;
    }
    // relacion de recurrencia 
    for (int i = 1; i <= monto; i++) {
        for (int j = 0; j < n; j++) {
            if (monedas[j] <= i) {
                int opcion = dp[i - monedas[j]] + 1;
                if (opcion < dp[i]) {
                    dp[i]    = opcion;
                    desde[i] = monedas[j];
                }
            }
        }
    }
    cout << "\ntabla DP: [";
    for (int i = 0; i <= monto; i++) {
        cout << dp[i];
        if (i < monto) cout << ",";
    }
    cout << "]" << endl;

    if (dp[monto] == 9999) {
        cout << "no hay solucion con las monedas disponibles." << endl;
    } else {
        cout << "cantidad minima de monedas: " << dp[monto] << endl;

        cout << "combinacion: ";
        int actual   = monto;
        bool primero = true;
        while (actual > 0) {
            if (!primero) cout << " + ";
            cout << desde[actual];
            actual  = actual - desde[actual];
            primero = false;
        }
        cout << endl;
    }

    return 0;
}
