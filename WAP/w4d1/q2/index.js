const express = require('express');
const path = require('path');
const session = require('express-session');

const app = express();
app.use(session({
	resave:false,
	saveUninitialized: false,
	secret:"salt for cookie saving"
}));

app.use(express.json());
app.use(express.urlencoded({extend:false}));

app.use('/css', express.static(path.join(__dirname, 'public', 'css')));

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

const style = '/css/style.css';

app.get('/', (req, res)=>{
	if(req.session.name){

	}
	res.render('index', {
		css:style,
		person: {name:req.session.name, age:req.session.age}
	})
});

app.post('/add', (req, res)=>{
	if(req.body.name && req.body.age){
		req.session.name = req.body.name;
		req.session.age = req.body.age;
	}
	res.redirect(303, '/');
});

app.listen(3000, function(){console.log("app listening through port 3000");});