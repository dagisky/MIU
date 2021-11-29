class CheckingAccount extends Account{
	constructor(number, overdraft){
		super(number)
		this._overdraft = overdraft;
	}


	getOverdraft(){
		return this._overdraft;
	}

	setOverdraft(overdraft){
		this._overdraft = overdraft;
	}

	 /**
     * Method to take money out of the account
     * 
     * @param {number} amount money to be taken out of the account
     * @returns {undefined}
     * @throws {RangeError} when amount is less than or equal to zero
     * @throws {Error} when the account has insufficient funds (balance)
     */
    withdraw(amount) {
        if (amount <= 0) {
            throw new RangeError("Withdraw amount has to be greater than zero");
        }
        if (amount > this._balance + this._overdraft ) {
            throw Error("Insufficient funds");
        }
        this._balance -= amount;
    }

	toString(){
		return "Account " + this._number + ": balance " + this._balance + ": overdraft "+this._overdraft;
	}

	endOfMonth(){
		if(this._balance < 0){
			return "Warning, low balance CheckingAccount "+this._number+": balance: "+this._balance+" overdraft limit: "+this._overdraft;
		}else{
			return "";
		}
	}


}