const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
});

let sum = 0;
function addNum(){    
    readline.question("Please enter a number or (stop: to end the program): ", num => {        
        if(num === "stop"){
            console.log("The total ammount is: "+sum);
            readline.close();
        }else{
            let n = (parseInt(num) == NaN)? 0 : parseInt(num);
            sum +=  n;
            addNum();
        } 
    });
    
}

addNum();