#include <iostream>

using namespace std;

int main() {
    long long t, a, b;
    cin >> t;
    for(int i=0; i<t; i++) {
        cin >> a;
        cin >> b;
        if ((a+b)%3 != 0) {
            cout << "NO\n";
        } else if(a==0 && b==0){
            cout << "YES\n";
        } else {
            if(a==0 || b==0) {
                cout << "NO\n";
            } else {
                if(2*a>=b && 2*b>=a) {
                    cout << "YES\n";
                } else {
                    cout << "NO\n";
                }
            }
        }
    }
    
    
}