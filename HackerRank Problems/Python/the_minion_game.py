
def minion_game(string):
    vowel_list = ['a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U']
    score_stuart = 0
    score_kevin = 0
    result = ''

    for i in range(len(string)):
        if string[i] in vowel_list:
            score_kevin += len(string) - i
        else:
            score_stuart += len(string) - i   

    if score_stuart > score_kevin:
        result = 'Stuart ' + str(score_stuart)
    elif score_kevin > score_stuart:
        result = 'Kevin ' + str(score_kevin)
    else:
        result = 'Draw'

    print(result)

string = input()
minion_game(string)