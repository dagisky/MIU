const express = require('express');
const path = require('path');

const app = express();
app.use(express.json());
app.use(express.urlencoded({extend:false}));
app.use('/css', express.static(path.join(__dirname, 'public', 'css')))
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

app.get('/', (req, res)=>{
	const date = new Date();
	let style = 'css/day.css';
	if(date.getHours() <= 6 || date.getHours() >= 18)
		style = 'css/night.css';
	res.render("index", {
		time: date.toTimeString(),
		css: style
	});
});

app.listen(3000);