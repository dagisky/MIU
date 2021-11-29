const express = require('express');
const path = require('path');

const app = express();
app.use(express.json());
app.use(express.urlencoded({extend:false}));
app.use('/css', express.static(path.join(__dirname, 'public', 'css')));
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));


app.get('/', (req, res)=>{
	const date = new Date();
	let style = 'css/day.css';
	if(date.getHours() <= 6 || date.getHours() >= 18)
		style = 'css/night.css';
	res.render("index", {
		css: style,
	});
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
