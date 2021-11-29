const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
});

readline.question("What is your name? ", name => {
    console.log(`Welcome ${name}`);    
    readline.question("How old are you? ", age => {
        if(parseInt(age) >= 16){
             console.log("you are allowed to get drivers licence in Iowa");
        }else{
             console.log("You are not allowed to drive in Iowa");
        }
        readline.close();
    });    
});

