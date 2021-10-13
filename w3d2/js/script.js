$('document').ready(function(){
	function randomIntFromInterval(min, max) { // min and max included
		return Math.floor(Math.random() * (max - min + 1) + min)
	}
	let rate = 250;
	let colors = ["#c2a042", "#73c242", "#42c2be", "#4282c2", "#a242c2", "#c242a4", "#21101d", "#d4175f", "#ebff36", "#36ffe4"]


	$("#form-control button").click(function(){

		let count = parseInt($('#form-control [name="numCircles"]').val());	
		let growthAmm = parseInt($('#form-control [name="growthAmm"]').val());	
		let growthRate = parseInt($('#form-control [name="growthRate"]').val());	
		let width = parseInt($('#form-control [name="width"]').val());

		count = (!count)? 10 : count;
		growthAmm = (!growthAmm)? 10 : growthAmm;
		growthRate = (!growthRate)? 250 : growthRate;
		width = (!width)? 10 : width;


		for(let i = 0; i < count; i++)
			$("#main").prepend($("<div>", {
				"addClass": "circle",
				"css":{
					"background-color":colors[randomIntFromInterval(0,8)],
					"top": "500px",
					"width": width+"px",
					"height":width+"px",
					"left":randomIntFromInterval(100,500)+"px",
					"border":"1px solid #9e9e9e",
					"z-index": i
				},
				"click": function(){
					$(this).hide();
				}
			}));
		let interval = setInterval(function(){
			$(".circle").css("min-width", function(idx, old){
				return parseInt(old)+growthAmm+"px";
			});
			$(".circle").css("min-height", function(idx, old){
				return parseInt(old)+growthAmm+"px";
			});

		}, growthRate);
	})
	
	
	
});