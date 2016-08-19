/*
 * Mettre dans app.js le javascript commun à toutes les pages
 */

$(function() {
	
	initCalendar();
	
	$("#siderbar-toggler").click(function() {
		console.log("toggle menu");
		$("#wrapper").toggleClass("toggled");
	});
	
	$("#main-search").keyup(function() {
		var $input = $(this);
		var $form = $(this).closest("form");
		
		if ($input.val().length >= 3) {
			console.log("search for: '" + $(this).val() + "'");
			
			$("#search-results").addClass("toggled");
			
			$.ajax({
				url: $form.attr("action"),
				data: {search: $input.val()},
				dataType: "json",
				success: function(data, textStatus, jqXHR) {
					if (data.succeeded) {
						
					}
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.log(jqXHR)
				}
			});
		}
	});
	
});

/** Méthode d'init pour Calendar Js */
function initCalendar (){
	$('#calendar').fullCalendar();
}