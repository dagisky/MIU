const express = require("express");
const path = require('path');

const app = express();
app.use(express.json());
app.use(express.urlencoded({extend:false}));

app.use('/css', express.static(path.join(__dirname, 'css')));
app.use('/img', express.static(path.join(__dirname, 'imgs')));


app.use('/register', (req, res, next) => {
	const date = new Date();
	let style = 'css/day.css';
	if(date.getHours() <= 6 || date.getHours() >= 18)
		style = 'css/night.css';
	res.send(`<!DOCTYPE html>
				<html>
				<head>
					<meta charset="utf-8">
					<link rel="stylesheet" type="text/css" href="${style}">
					<title></title>
				</head>
				<body>
					<div class="container">
						<div id="side">					
						</div>
						<div id="main">
							<form id="form_action" action="/result" method="post">
								Name<input type="text" name="name">
								Age<input type="text" name="age">
								<button type="submit">Submit Query</button>
							</form>
						</div>
					</div>

				</body>
				</html>`);
	next();
	});

app.post('/result', (req, res)=>{	
	res.redirect(303, "/profile?name="+req.body.name+"&age="+req.body.age);
});

app.get('/profile', (req, res)=>{
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


