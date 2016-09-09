var app = app || {};

/** Espace de nom pour le code propre à la barre de recherche */
app.search = {
		
		/**
		 * fonction d'init à appeler dans tiles.xml
		 */
		init : function(){
			app.search.initSearch();
			app.search.initSearchNav();
		},
		
		initSearch : function() {
			$("#main-search-field").on("click", function(event) {
				event.stopPropagation();
			});
			
			$("#main-search-field").on("focus", function() {
				$("#main-search-results").addClass("toggled");
			});
			
			$("#main-search-field").keyup(function(event) {
				var $input = $(this);
				var $form = $(this).closest("form");
				var key = event.keyCode || event.which;
				
				// Si le bouton Echap est pressé
				if (key === 27) closeMainSearch();
				
				if ($input.val().length >= 3) {
					switch (key) {
						//Si la flèche du haut est pressée
						case 38:
							$("a", $(".result-item").last()).focus();
							break;
						//Si la flèche du bas est pressée
						case 40:
							$("a", $(".result-item").first()).focus();
							break;
						default:
							$.ajax({
								url: $form.data("json-action"),
								data: {search: $input.val()},
								dataType: "json",
								success: function(data, textStatus, jqXHR) {
									if (data.succeeded) {
										var htmlUsers = Mustache.render($("#mustache-tmpl-users").html(), data.content);
										var htmlPlaces = Mustache.render($("#mustache-tmpl-places").html(), data.content);
										
										htmlUsers += (data.content.users.length) ? Mustache.render($("#mustache-tmpl-more-users").html(), {query: $input.val()}) : '';
										htmlPlaces += (data.content.places.length) ? Mustache.render($("#mustache-tmpl-more-places").html(), {query: $input.val()}) : '';
										
										$("#main-search-users").html(htmlUsers);
										$("#main-search-places").html(htmlPlaces);
									}
								},
								error: function(jqXHR, textStatus, errorThrown) {
									console.log(jqXHR)
								}
							});
							break;
					}
					
				} else {
					$("#main-search-users").html("");
					$("#main-search-places").html("");
				}
			});
		},
		
		initSearchNav : function() {
			$(".result-set").on("keyup", "a:focus", (function(event) {
				var key = event.keyCode || event.which;
				switch (key) {
					//échap
					case 27:
						closeMainSearch();
						break;
					//flèche de gauche
					case 37:
						break;
					//flèche du haut
					case 38:
						// Si l'élément focus est le premier parmi toutes les listes
						if ($(this).is($("a", $(".result-set")).first()))
							// Focus sur le champ de recherche
							$("#main-search-field").focus();
						// Sinon, s'il est le premier du result-set
						else if ($(this).is($("a", $(this).parents(".result-set")).first()))
							// Focus sur le dernier élément du précédent result-set
							$("a", $(".result-item", $(this).parents(".result-set").prevAll()).last()).focus();
						// Sinon focus sur le précédent élément
						else $("a", $(this).parents(".result-item").prev()).focus();
						break;
					//flèche de droite
					case 39:
						break;
					//flèche du bas
					case 40:
						// Si l'élément focus est le dernier parmi toutes les listes
						if ($(this).is($("a", $(".result-set")).last()))
							// Focus sur le champ de recherche
							$("#main-search-field").focus();
						// Sinon, s'il est le dernier du result-set
						else if ($(this).is($("a", $(this).parents(".result-set")).last()))
							// Focus sur le premier élément du result-set suivant
							$("a", $(".result-item", $(this).parents(".result-set").nextAll()).first()).focus();
						// Sinon focus sur l'élément suivant
						else $("a", $(this).parents(".result-item").next()).focus();
						break;
						default:
							break;
				}
			}))
		},
		
}

function closeMainSearch() {
	console.log("bind");
	$("#main-search-results").removeClass("toggled");
	$("#main-search-field").blur();
}
$(window).click(closeMainSearch());