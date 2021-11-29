/* runs test to see if expected argument is === to value returned by function2test argument */
function myFunctionTest(expected, found) {
  if (expected === found) {
    return "TEST SUCCEEDED";
  } else {
    return "TEST FAILED.  Expected " + expected + " found " + found;
  }
}

/* runs test to see if expected array is === to value returned by function2test argument */
function myArrayFunctionTest(expected, found) {
  if(expected.length === found.length){
      return "TEST SUCCEEDED";
  }else{
    return "TEST FAILED.  Expected size " + expected.length + " found size " + found.length;
  }

}

/* max returns the maximum of 2 arguments */
function max(a, b) {
  if (a > b) {
    return a;
  } else {
    return b;
  }
}


/* max3 takes 3 numbers as arguments and returns the largest */
function maxOfThree(a, b, c) {
return max(max(a, b), c);

}

/*   */
function isVawel(str){
  let vawel = ['a', 'e', 'i', 'o', 'u'];
  if(vawel.includes(str)){
    return true;
  }else{
    return false;
  }

}
 
/* function sum() sums all the numbers of an array*/
function sum(array){
return array.reduce(function(accumulator, elem){return accumulator + elem;}, 0); 
}

/* function multiply() multiplies all the numbers of an array*/
function multiply(array){
return array.reduce(function(accumulator, elem){return accumulator * elem;}, 1); 
}

/* computes the reversal of a string */
function reverse(str){
  return str.split("").reverse().join("");
}

/* takes an array of words and returns the length of the longest one */
function findLongestWord(words){
  return words.map(w=>w.length).reduce((a,b)=>{return a>b?a:b});
}

/* akes an array of words and an integer i and returns the array of words that are longer than i. */
function findLongestWords(words, k){  
  return words.filter(function(ele){return ele.length > k;})
}

const a = [1,3,5,3,3]; 
const b = a.map(function(elem, i, array) {
  return elem * 10;
})
document.writeln(b.toString() + "<br/>");
const c = a.filter(function(elem, i, array){return elem == 3;});
document.writeln(c.toString() + "<br/>");
const d = a.reduce(function(prevValue, elem, i, array){return prevValue * elem;});


