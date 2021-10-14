$(document).ready(function(){
	let maze = $("#maze");
	let boundery = $("div.boundary");
	let end = $("div#end");
	let start = $("div#start");
	let status = $("#status");
	let container = $("#container");
	start.click(function(){
		boundery.removeClass("youlose");
		boundery.mouseenter(loose);
		end.mouseenter(win);
		maze.mouseleave(loose);
		status.text("Click the \"S\" to begin.");
	})
	function win(ele){
		status.text("Congrats You Won The Game!");
		boundery.unbind("mouseenter");
		end.unbind("mouseenter");
	}

	function loose (ele){
		boundery.addClass("youlose");
		boundery.unbind("mouseenter");
		status.text("Sorry You Lost The Game!");
	}
});