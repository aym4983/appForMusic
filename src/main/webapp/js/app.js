/*
 * Mettre dans app.js le javascript commun à toutes les pages
 */

$(function() {
	
	initCalendar();
	
	$( "#siderbar-toggler" ).click(function() {
		console.log("toggle menu");
		$( "#wrapper" ).toggleClass("toggled");
	});
	
	$( "#search-toggler" ).click(function() {
		console.log("toggle search");
		//$( "#wrapper" ).toggleClass("toggled");
	});
	
});

/** Méthode d'init pour Calendar Js */
function initCalendar (){
	$('#calendar').fullCalendar();
}