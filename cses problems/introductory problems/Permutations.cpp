#include <iostream>

using namespace std;

int main() {
    long long n;
    
    cin >> n;

    if(n == 1) {
        cout << 1;
    } else if(n==2 || n==3) {
        cout << "NO SOLUTION";
    } else {
        long long even = 2;
        long long odd = 1;
        while(even <= n) {
            cout <<  even << " ";
            even += 2;
        }
        while(odd <= n) {
            cout <<  odd << " ";
            odd += 2;
        }
    }

    
}