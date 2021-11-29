const express = require("express");
const path = require('path');

const app = express();
app.use(express.json());
app.use(express.urlencoded({extend:false}));

app.use('/css', express.static(path.join(__dirname, 'css')));
app.use('/img', express.static(path.join(__dirname, 'imgs')));


app.get('/', (req, res)=>{
	let name = req.query.name;
	let age = req.query.age;
	if(!name && !age){
		name = "Person";
		age = "0";
	}
	res.send(`Welcome Mr. ${name} Seasoned ${age}`);
});

app.listen(3000, ()=>{
	console.log("your server is running on port 3000");
});