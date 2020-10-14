#include <cstdlib>
#include <bits/stdc++.h>
#include <iostream>
#include <algorithm>
using namespace std;

#define ll long long
#define ui unsigned int
int main() {

    ui n;
    ll x;

    cin >> n >> x;

    ll childrenWeights[n];

    ui i;
    ll j;
    for(i=0; i<n; i++) 
    {    
        cin >> j;
        childrenWeights[i] = j;
    }

    
    sort(childrenWeights, childrenWeights+n); 
    /*
    for(i=0; i<n; i++) 
    {    
        cout << childrenWeights[i];
    }
    cout << "\n";
    */
    ui counter = 0;
    ui p = 0;
    ll sum = 0;
    while(p < n) 
    {
        ui k = p;
        while(true)
        {
            sum += childrenWeights[k];
            if(sum > x)
                break;
            k++;
            if(k >= n)
                break;
        }
        cout << sum << endl;
        cout << k << endl;
        sum = 0;
        p = k;
        counter++;

    }

    cout << counter << endl;


    
    
}