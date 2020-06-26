#include <iostream>

using namespace std;

int main() {
    long long n, _max=0, answer=0;
    cin >> n;
    for(int i=0; i<n; i++) {
        long long a;
        cin >> a;
        _max = max(a, _max);
        answer += _max - a;
    }

    cout << answer;
}