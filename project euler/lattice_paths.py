def calculate_lattice_paths(m, n, memo):
    key = str(m) + ',' + str(n)
    if key in memo:
        return memo[key]

    if m == 1 and n == 1:
        return 2

    if m == 0 or n == 0:
        return 1

    memo[key] = calculate_lattice_paths(m-1, n, memo) + calculate_lattice_paths(m, n-1, memo)
    return memo[key] 


memo = {}
m = 20
n = 20

print(calculate_lattice_paths(m, n, memo))

