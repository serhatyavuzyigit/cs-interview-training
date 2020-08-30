#include <cstdlib>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {

    unsigned int n, m;
    long long k;

    cin >> n >> m >> k;

    long long applicants[n];
    long long apartments[m];

    unsigned int i;
    long long j;
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
    
    unsigned int counter = 0;
    unsigned int p1 = 0;
    unsigned int p2 = 0;

    while(p1<n && p2<m) 
    {
        long long applc = applicants[p1];
        long long apart = apartments[p2];

        long long diff = applc - apart;

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
            else if(apart < applc)
            {
                p2++;
            }
            else 
            {
                p1++;
                p2++;
            }
        }
    }

    cout << counter << endl;
    
}