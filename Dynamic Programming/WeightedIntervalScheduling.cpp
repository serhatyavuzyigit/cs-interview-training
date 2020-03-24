#include <iostream>
#include <algorithm>

struct Job {
    int startTime;
    int finishTime;
    int profit;
};

bool jobSortComparator(Job j1, Job j2)
{
    return j1.finishTime < j2.finishTime;
}

int findLastNonOverlap(Job arr[], int i)
{
    for(int j=i-1; j>=0; j--)
    {
        if(arr[i].startTime > arr[j].finishTime)
        {
            return j;
        }
    }
    return -1;
}

int findMaxProfit(Job arr[], int n)
{
    std::sort(arr, arr+n, jobSortComparator);

    int* M = new int[n];

    M[0] = arr[0].profit;

    for(int i=1; i<n; i++) 
    {
        int last = findLastNonOverlap(arr, i);

        int currentProfit = arr[i].profit;

        if(last != -1)
        {
            currentProfit += M[last];
        }

        if(currentProfit > M[i-1])
        {
            M[i] = currentProfit;
        }
        else
        {
            M[i] = M[i-1];
        }
    }

    return M[n-1];
}

int main(int argc, char const *argv[])
{
    
    Job jobArray[] = {{3, 10, 20}, {1, 2, 50}, {6, 19, 100}, {2, 100, 200}};

    int n = sizeof(jobArray) / sizeof(jobArray[0]);
    int maxProfit = findMaxProfit(jobArray, n);

    std::cout << "Max Profit is: " << maxProfit << std::endl;

    return 0;
}

