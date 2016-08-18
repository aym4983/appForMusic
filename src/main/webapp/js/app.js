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
		$( "#search-container" ).toggleClass("toggled");
	});
	
	$( "#search-input" ).keyup(function() {
		if ($( this ).val().length >= 3) {
			console.log("searching for \"" + $( this ).val() + "\"");
			var $form = $( this ).closest( 'form' );
			$.ajax({
				url: $form.attr( 'action' ),
				complete: function(jqXHR, textStatus) {
					console.log( "status: " + textStatus );
					console.log( "jqXHR: " + jqXHR );
				}
			});
		}
	});
	
});

/** Méthode d'init pour Calendar Js */
function initCalendar (){
	$('#calendar').fullCalendar();
}