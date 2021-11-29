const express = require("express");
const path = require('path');

const app = express();
app.use(express.json());
app.use(express.urlencoded({extend:false}));

app.use('/css', express.static(path.join(__dirname, 'css')));
app.use('/img', express.static(path.join(__dirname, 'imgs')));


app.use('/register', (req, res, next) => {
	console.log("In the middleware");
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
	});

app.use('/result', (req, res, next)=>{
	
	res.send(req.body);
});

app.listen(3000, ()=>{
	console.log("your server is running on port 3000");
});


