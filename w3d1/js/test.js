
describe("Check account number", function () {
    it("calls the account number getter",
        function () {
            const account = new Account(1234);
            assert.equal(1234, account.getNumber());
        });
});


describe("Check account initial Balance", function () {
    it("calls the account Balance getter",
        function () {
            const account = new Account(1234);
            assert.equal(0.0, account.getBalance());
        });
});


describe("Check account deposit", function () {
    it("deposits 100$",
        function () {
            const account = new Account(1234);
        	account.deposit(100);
            assert.equal(100, account.getBalance());
            account.withdraw(100);
        });
});


describe("Check account withdraw", function () {
    it("withdraw 100$",
        function () {
            const account = new Account(1234);
        	account.deposit(100);            
            account.withdraw(100);
            assert.equal(0, account.getBalance());
        });
});

describe("Check toString on Account", function () {
    it("returns  Account   number : balance   balance;",
        function () {
            const account = new Account(1234);
            account.deposit(100);     
            assert.equal("Account " + 1234 + ": balance " + 100, account.toString());
        });
});

describe("Check SavingsAccount addInterest", function () {
    it("addInterest on 100$",
        function () {
            const account = new SavingsAccount(1234, 25);
            account.deposit(100);            
            account.addInterest();
            assert.equal(125, account.getBalance());
        });
});

describe("Check toString on SavingsAccount", function () {
    it("returns  Account  number : balance  balance  : Interest interest",
        function () {
            const account = new SavingsAccount(1234, 25);
            account.deposit(100);  
            account.addInterest();   
            assert.equal("Account " + 1234 + ": balance " + 125 + ": Interest "+ 25, account.toString());
        });
});


describe("Check endOfMonth on SavingsAccount", function () {
    it("returns  Interest added SavingsAccount number: balance: balance interest: (interest/100)",
        function () {
            const account = new SavingsAccount(1234, 25);
            account.deposit(100);  
            account.addInterest();   
            assert.equal("Interest added SavingsAccount "+1234+": balance: "+125+" interest: "+0.25, account.endOfMonth());
        });
});


describe("Check SavingsAccount addInterest", function () {
    it("addInterest on 100$",
        function () {
            const account = new SavingsAccount(1234, 25);
            account.deposit(100);            
            account.addInterest();
            assert.equal(125, account.getBalance());
        });
});

describe("Check toString on SavingsAccount", function () {
    it("returns  Account  number : balance  balance  : Interest interest",
        function () {
            const account = new SavingsAccount(1234, 25);
            account.deposit(100);  
            account.addInterest();   
            assert.equal("Account " + 1234 + ": balance " + 125 + ": Interest "+ 25, account.toString());
        });
});


describe("Check setOverdraft on CheckingAccount", function () {
    it("returns  sets setOverdraft for Checking account",
        function () {
            const account = new CheckingAccount(1234, 500);               
            assert.equal(500, account.getOverdraft());
        });
});


describe("Check withdraw on CheckingAccount", function () {
    it("returns  checks if the withdraw ammount is getter than the overdraft limit and allows or denies transaction",
        function () {
            const account = new CheckingAccount(1234, 500);
            account.deposit(100);
            account.withdraw(100);              
            assert.equal(0, account.getBalance());
            account.withdraw(100);              
            assert.equal(-100, account.getBalance());
        });
});


describe("Check toString on CheckingAccount", function () {
    it("Account  number : balance balance : Interest interest",
        function () {
            const account = new CheckingAccount(1234, 500);
            account.deposit(100);    
            assert.equal("Account " + 1234+ ": balance " + 100+ ": overdraft "+ 500, account.toString());
        });
});


describe("Check nextNumber on Bank", function () {
    it("checks the next account number",
        function () {
            const bank = new Bank();
            bank.addSavingsAccount(25);
            bank.addCheckingAccount(500);
            bank.addAccount();      
            assert.equal(3, Bank.getNextNumber());
        });
});


describe("Check accountReport on Bank", function () {
    it("checks the accountReport of the bank",
        function () {
            const bank = new Bank();
            Bank.nextNumber = 0;
            bank.addSavingsAccount(25);
            bank.addCheckingAccount(500);
            bank.addAccount();  
            let result = "Account " + 0 + ": balance " + 0 + ": Interest "+25+"\n"+
                        "Account " + 1 + ": balance " + 0 + ": overdraft "+ 500 + "\n"+
                        "Account " + 2 + ": balance " + 0 + "\n";   
            assert.equal(result, bank.accountReport());
        });
});



describe("Check endOfMonth on Bank", function () {
    it("checks the endOfMonth of the bank",
        function () {
            const bank = new Bank();
            Bank.nextNumber = 0;
            bank.addSavingsAccount(25);
            bank.addCheckingAccount(500);
            bank.addAccount();  
            let result = "Interest added SavingsAccount "+ 0 +": balance: "+0+" interest: "+0.25;   
            assert.equal(result, bank.endOfMonth());
        });
});


describe("Check closeAccount on Bank", function () {
    it("checks the closeAccount of the bank",
        function () {
            const bank = new Bank();
            Bank.nextNumber = 0;
            bank.addSavingsAccount(25);
            bank.addCheckingAccount(500);
            bank.addAccount(); 
            bank.closeAccount(1) 
            assert.equal(2, bank.getNumberOfAccounts());
        });
});