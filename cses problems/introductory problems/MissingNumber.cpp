#include <iostream>

using namespace std;

int main() {
    long long n, sum = 0;
    cin >> n;
    for(int i=1; i<n; i++) {
        unsigned int a;
        cin >> a;
        sum += a;
    }

    cout << ((n*(n+1))/2) - sum;
}