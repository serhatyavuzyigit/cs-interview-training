// serhat yavuzyigit

const isHasMajorVowelHarmony = (word) => {
    var hardVowels = ['a', 'ı', 'o', 'u'];
    var softVowels = ['e', 'i', 'ö', 'ü'];

    var counterHard = 0;
    var counterSoft = 0;

    for (let i=0; i<word.length; i++) {
        let c = word.charAt(i);
        console.log(c);

        if (hardVowels.indexOf(c) === -1 && softVowels.indexOf(c) !== -1) {
            if (counterHard !== 0) return false;
            counterSoft++;
        } 
        if (softVowels.indexOf(c) === -1 && hardVowels.indexOf(c) !== -1) {
            if (counterSoft !== 0) return false;
            counterHard++;
        }
    }

    return true;
}


export default isHasMajorVowelHarmony;