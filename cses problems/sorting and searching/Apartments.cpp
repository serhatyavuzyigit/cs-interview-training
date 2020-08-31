#include <cstdlib>
#include <iostream>
#include <algorithm>
using namespace std;

#define ll long long
#define ui unsigned int

int main() {

    ui n, m;
    ll k;

    cin >> n >> m >> k;

    ll applicants[n];
    ll apartments[m];

    ui i;
    ll j;
    for(i=0; i<n; i++) 
    {    
        cin >> j;
        applicants[i] = j;
    }

    for(i=0; i<m; i++) 
    {    
        cin >> j;
        apartments[i] = j;
    }
    
    sort(applicants, applicants+n); 
    sort(apartments, apartments+m); 
    
    ui counter = 0;
    ui p1 = 0;
    ui p2 = 0;

    while(p1<n && p2<m) 
    {
        ll applc = applicants[p1];
        ll apart = apartments[p2];

        ll diff = applc - apart;

        if((-1*k)<=diff && diff<=k) 
        {
            p1++;
            p2++;
            counter++;
        }
        else 
        {
            if(apart > applc)
            {
                p1++;
            }
            else
            {
                p2++;
            }
        }
    }

    cout << counter << endl;
    
}