class SavingsAccount extends Account{
	constructor(number, interest){
		super(number)
		this._interest = interest;
	}

	addInterest(){
		this._balance = this._balance + (this._interest * this._balance)/100.0;
	}

	toString(){
		return "Account " + this._number + ": balance " + this._balance + ": Interest "+this._interest;
	}

	endOfMonth(){
		return "Interest added SavingsAccount "+this._number+": balance: "+this._balance+" interest: "+(this._interest/100);
	}


}