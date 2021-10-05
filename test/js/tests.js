describe("sum", function () {
    it("function sum() sums all the numbers of an array",
        function () {
            assert.equal(15, sum([1,2,3,4,5]));
        });
});

describe("multiply", function () {
    it("function multiply() multiplies all the numbers of an array",
        function () {
            assert.equal(120, multiply([1,2,3,4,5]));
        });
});


describe("reverse", function () {
    it("computes the reversal of a string ",
        function () {
            assert.equal("albalb", reverse("blabla"));
        });
});


describe("findLongestWord", function () {
    it("takes an array of words and returns the length of the longest one",
        function () {
            assert.equal(4, findLongestWord(['foo', 'lolo', 'kc']));

        });
});

describe("findLongestWords", function () {
    it("Takes an array of words and an integer i and returns the array of words that are longer than i.",
        function () {
            assert.deepEqual(['foo', 'lolo'], findLongestWords(['foo', 'lolo', 'kc'], 2));
        });
});


describe("isVawel", function () {
    it("takes a character (i.e. a string of length 1) and returns true if it is a vowel, false otherwise.",
        function () {
            assert.equal(true, isVawel('a'));
        });
});

describe("max", function () {
    it("max returns the maximum of 2 argumentsd",
        function () {
            assert.equal(5, max(2,5));
        });
});

describe("maxOfThree", function () {
    it("max3 takes 3 numbers as arguments and returns the largest",
        function () {
            assert.equal(4, maxOfThree(2,4,1));
        });
});