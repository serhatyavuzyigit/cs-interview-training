phone_map = {
    '2': ['a', 'b', 'c'],
    '3': ['d', 'e', 'f'],
    '4': ['g', 'h', 'i'],
    '5': ['j', 'k', 'l'],
    '6': ['m', 'n', 'o'],
    '7': ['p', 'q', 'r', 's'],
    '8': ['t', 'u', 'v'],
    '9': ['w', 'x', 'y', 'z'],
}

def appendLettersToList(out_list, num):
    new_list = []
    new_letters = phone_map[num]
    for x in out_list:
        for y in new_letters:
            new_list.append(x + y)
    return new_list

def letterCombinations(out_list, digits):
    if len(digits) == 0:
        return out_list
    
    if out_list == []:
        out_list = phone_map[digits[0]]
        digits = digits[1:]
        return letterCombinations(out_list, digits)
    else:
        out_list = appendLettersToList(out_list, digits[0])
        digits = digits[1:]
        return letterCombinations(out_list, digits)

    
