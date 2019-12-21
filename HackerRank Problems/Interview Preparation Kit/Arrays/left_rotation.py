# https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

n, d = map(int, input().split())
nums_list = list(map(int, input().split()))

temp_list = nums_list[0: d]
rest_list = nums_list[d: ]


nums_list = rest_list + temp_list
for  i in nums_list:
    print(i, end=' ')
