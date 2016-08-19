/*
 * Mettre dans app.js le javascript commun à toutes les pages
 */

$(function() {
	
	initCalendar();
	
	$("#siderbar-toggler").click(function() {
		console.log("toggle menu");
		$("#wrapper").toggleClass("toggled");
	});
	
	$("#main-search").keyup(function(event) {
		var $input = $(this);
		var $form = $(this).closest("form");
		var key = event.keyCode || event.which;
		
		if ($input.val().length >= 3) {
			console.log("search for: '" + $(this).val() + "'");
			
			$("#search-results").addClass("toggled");
			
			switch (key) {
				//Si la flèche du haut est pressée
				case 38:
					$("#result-set-users li:last-child a").focus();
					break;
				//Si la flèche du bas est pressée
				case 40:
					$("#result-set-users li:first-child a").focus();
					break;
				default:
					$.ajax({
						url: $form.attr("action"),
						data: {search: $input.val()},
						dataType: "json",
						success: function(data, textStatus, jqXHR) {
							if (data.succeeded) {
								var templateUsers = $("#mustache-tmpl-users").html();
								var templatePlaces = $("#mustache-tmpl-places").html();
								var htmlUsers = Mustache.render(templateUsers, data);
								var htmlPlaces = Mustache.render(templatePlaces, data);
		
								$("#result-set-users ul").html(htmlUsers);
								$("#result-set-places ul").html(htmlPlaces);
							}
						},
						error: function(jqXHR, textStatus, errorThrown) {
							console.log(jqXHR)
						}
					});
					break;
			}
			
		} else $("#search-results").removeClass("toggled");
	});

	$("#result-set-users").on("keyup", "a:focus", (function(event) {
		var key = event.keyCode || event.which;
		switch (key) {
			//flèche de gauche
			case 37:
				if ($(this).closest("section").is(":last-child"))
					$("li:first-child a", $(this).closest(".result-set").prev()).focus();
				else $("li:first-child a", $(this).closest(".result-set").next()).focus();
				break;
			//flèche du haut
			case 38:
				if ($(this).parent().is(":first-child"))
					$("#main-search").focus();
				else $("a", $(this).parent().prev()).focus();
				break;
			//flèche de droite
			case 39:
				if ($(this).closest("section").is(":first-child"))
					$("li:first-child a", $(this).closest(".result-set").next()).focus();
				else $("li:first-child a", $(this).closest(".result-set").prev()).focus();
				break;
			//flèche du bas
			case 40:
				if ($(this).parent().is(":last-child"))
					$("#main-search").focus();
				else $("a", $(this).parent().next()).focus();
				break;
				default:
					break;
		}
	}));
	
});

/** Méthode d'init pour Calendar Js */
function initCalendar (){
	$('#calendar').fullCalendar();
}