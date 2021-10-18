const express = require('express');
const path = require('path');

const app = express();
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
let cart = [];

app.get('/', (req, res)=>{
	const date = new Date();
	let style = '/css/day.css';
	if(date.getHours() <= 6 || date.getHours() >= 18)
		style = '/css/night.css';
	res.render("index", {
		css: style,
		products: prds,
		cart:cart
	});
});

app.get('/product', (req, res)=>{
	let product = {id:null, name:"Not Found", price: 0.0, description:""};
	for(p of prds){
		if(p.id === parseInt(req.query.id))
			product = p;
	}
	const date = new Date();
	let style = '/css/day.css';
	if(date.getHours() <= 6 || date.getHours() >= 18)
		style = '/css/night.css';
	res.render("product", {
		css: style,
		product: product
	});
});


app.post('/addToCart', (req, res)=>{
	let item = {};
	for(p of prds){
		if(p.id === parseInt(req.body.id)){
			item.id = p.id;
			item.name = p.name;
			cart.push(item);
		}	
	}
	res.redirect(303, '/')
});


app.listen(3000, ()=>{
	console.log("your server is running on port 3000");
});
