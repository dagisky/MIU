const express = require('express');
const session = require('express-session');
const path = require('path');


const app = express();

app.use(session({
	resave:false,
	saveUninitialized: false,
	secret:"this is the secret"
}));


app.use(express.json());
app.use(express.urlencoded({extend:false}));
app.use('/css', express.static(path.join(__dirname, 'public', 'css')));
app.use('/js', express.static(path.join(__dirname, 'public', 'js')));

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

let p1 = {id:1, name:"Cheese Cake", price: 23.0, description:"Cheese cake made by MIU"};
let p2 = {id:2, name:"Sports shoe", price: 24.0, description:""};
let p3 = {id:3, name:"Car", price: 25.0, description:""};
let p4 = {id:4, name:"Soda Pack", price: 26.0, description:""};
let p5 = {id:5, name:"Bike", price: 27.0, description:""};
let p6 = {id:6, name:"Chicken", price: 28.0, description:""};

let prds = [p1, p2, p3, p4, p5, p6];
const users = [{username:"dag", password:"123"}, {username:"lolo", password:"1q2w3e"}];


app.get('/', (req, res)=>{
	const style = "/css/style.css";
	if(req.session.logged){
		res.redirect('/products');
	}else{
		res.redirect('/login');
	}
});


app.get('/login', (req, res)=>{
	const style = "/css/style.css";
	if(req.session.logged){
		res.redirect('/products');
	}else{
		res.render('login', {css:style, error:req.query.error});
	}
});

app.post('/login', (req, res)=>{
	const style = "css/style.css";
	if(req.body.username){
		for(user of users){
			if(user.username == req.body.username && user.password == req.body.password){
				req.session.username = req.body.username;
				req.session.logged = true;
				req.session.cart = [];
				res.redirect('/products')
			}
		}
		if(!req.session.logged){
			res.redirect("/login?error=Incorrect credentials");
		}
	}else{
		res.redirect("/login?error=Username missing");
	}
});

app.get('/products', (req, res)=>{
	const style = "css/style.css";
	const js = "js/script.js";
	if(req.session.logged){
		res.render('products', {products:prds, cart:req.session.cart, css:style, js:js});
	}else{
		res.redirect('/login')
	}
});

app.get('/product', (req, res)=>{
	const style = "css/style.css";
	let product = {id:null, name:"Not Found", price: 0.0, description:""};
	for(p of prds){
		if(p.id === parseInt(req.query.id))
			product = p;
	}
	
	res.render("product", {
		css: style,
		product: product
	});
});

app.post('/addToCart', (req, res)=>{
	let item = {};

	for(p of prds){
		if(p.id == parseInt(req.body.id)){
			item.id = p.id;
			item.name = p.name;
			item.quantity = 1;
		}
	}
	
	console.log(item.name + item.id +" Posted");	
	for(i in req.session.cart){
		if(req.session.cart[i].id == item.id){
			req.session.cart[i].quantity += 1;
			item.id += 1;
			res.status(200).send(JSON.stringify(req.session.cart));
		}
	}
	req.session.cart.push(item);

	res.status(200).send(JSON.stringify(req.session.cart));
});

app.listen(3000, function(){
	console.log("app listening at port: 3000");
})