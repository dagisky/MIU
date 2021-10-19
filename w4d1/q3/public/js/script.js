$(document).ready(function(){
	$('#main ul li span').click(function(ele){
		let id = parseInt($(ele.target).attr('data'));
		$.post("/addToCart", {id:id}, function( data ) {
		  window.location = "/";
		});
	})
});