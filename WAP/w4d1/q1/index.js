const express = require('express');
const cookieParser = require('cookie-parser');
const path = require('path');

const app = express();
app.use(express.json());
app.use(express.urlencoded({extend:false}));
app.use(cookieParser());

app.use('/css', express.static(path.join(__dirname, 'public', 'css')));

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));
let cookies = {};

app.get('/', (req, res)=>{
	let style = '/css/style.css';		
	res.render("index", {
		css: style,
		cookies: cookies
	});
});

app.post('/add', (req, res)=>{
	let style = '/css/style.css';	
	if(req.body.key){
		cookies[req.body.key] = req.body.value;			
	}
	res.redirect(303, '/');	
});

app.listen(3000, function(){console.log("server listening at port 3000");})