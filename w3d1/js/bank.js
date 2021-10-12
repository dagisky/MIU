class Bank{
	static nextNumber = 0;
	constructor(){
		this._accounts = [];
	}

	addAccount(){
		let account = new Account(Bank.nextNumber);
		Bank.nextNumber += 1;
		return this._accounts.push(account);
	}

	addSavingsAccount(interest){ 
		let account = new SavingsAccount(Bank.nextNumber, interest);
		Bank.nextNumber += 1;
		return this._accounts.push(account);
	}

	addCheckingAccount(overdraft){
		let account = new CheckingAccount(Bank.nextNumber, overdraft);
		Bank.nextNumber += 1;
		return this._accounts.push(account);
	}

	closeAccount(number){
		this._accounts.splice(number,1);
	}

	static getNextNumber(){
		return Bank.nextNumber;
	}

	getNumberOfAccounts(){
		return this._accounts.length;
	}

	accountReport(){
		let report = "";
		for(let i = 0; i < this._accounts.length; i++){
			report += this._accounts[i].toString() + "\n";
		}
		return report;
	}

	endOfMonth(){
		let report = "";
		for(let i = 0; i < this._accounts.length; i++){
			report += this._accounts[i].endOfMonth();
		}
		return report;
	}


}