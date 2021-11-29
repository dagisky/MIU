$(document).ready(function(){
	$('#main ul li span').click(function(ele){
		let id = parseInt($(ele.target).attr('data'));
		$.post("/addToCart", {id:id}, function( data ) {
		  console.log(data);
		  let products = JSON.parse(data);
		  let response = "";
		  for(let p of products){
		  	response += `<li><a href="/product?id=<%= item.id %>">${p.name}</a> : <span> ${p.quantity} </span></li>`;
		  }
		  $("#cartItems").html(response);
		});
	})
});