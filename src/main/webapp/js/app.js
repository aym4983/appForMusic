/*
 * Mettre dans app.js le javascript commun à toutes les pages
 */
var homeMap = {};

$(function(){
	
	initHomePlacesList();
	
	$("#main-menu-toggler").on("click", function() {
		$("#main-wrapper").toggleClass("navigable");
	});
	
	$("#places-list-toggler").on("click", function() {
		$("#places-list").toggleClass("toggled");
	});
	
});

<<<<<<< Upstream, based on origin/master
/** insert l'evenement */
//function doSubmit() {
//	$("#myModalHorizontal").modal('hide');
//	$("#calendar").fullCalendar('renderEvent', {
//	    title: $('#inputTitleEvent').val(),
//	    start: new Date($('#hiddenStartEvent').val()),
//	    end: new Date($('#hiddenEndEvent').val()),
//	}, true);
//	return true;  
//}

=======
/** récupère ts les events de la bdd et les affiche */

function initUpdateCalendar() {
	$("#FormEvent").submit(function(event){
		event.preventDefault();
		
		$.ajax({
			url: contextPath + "/calendar",
			method : 'POST',
			data : $(this).serialize(),
			dataType : 'json',
			success: function(data){
				console.log(data);
				for(var i=0; i<data.length; i ++){
					$("#calendar").fullCalendar('renderEvent', {
						start : data[i].startevent,
						end : data[i].endevent,
						title : data[i].titleevent
					});
				}
			}
		})
		
		$("#myModalHorizontal").modal('hide');
		
	});
}
>>>>>>> f8aaad5 modif calendar

function initHomeMap() {
	homeMap.map = new google.maps.Map(document.getElementById("places-map"), {
		center: {lat: 47.4698, lng: -0.5593},
		zoom: 12
	});
	
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			var pos = {
				lat: position.coords.latitude, 
				lng: position.coords.longitude
			}
			
			reloadHomePlaces(pos);
			
			new google.maps.InfoWindow({
				map: homeMap.map, 
				position: pos,
				content: "Vous êtes ici."
			});
			
			homeMap.map.panTo(pos);
		});
	}
	
	homeMap.markers = {};
	resetHomeMarkers(homeMap.map, homeMap.markers);
}

function initHomePlacesList() {
	$("#places-list").on("mouseover", ".place-item", function() {
		homeMap.map.panTo({lat: Number.parseFloat($(this).data("place-lat")), lng: Number.parseFloat($(this).data("place-lng"))});
		homeMap.markers[$(this).data("place-id")].setAnimation(google.maps.Animation.BOUNCE);
	});
	
	$("#places-list").on("mouseout", ".place-item", function() {
		homeMap.markers[$(this).data("place-id")].setAnimation(null);
	});
}

function reloadHomePlaces(position) {
	$.ajax({
		url: $("#places-list").data("url-places-near"),
		data: {
			lat: position.lat, 
			lng: position.lng,
			offset: 0,
			limit: 50
		},
		success: function(resp) {
			if (resp.succeeded) {
				for (var i = 0; i < resp.content.length ; i++) {
					resp.content[i].distance = $.get({
						url: "https://maps.googleapis.com/maps/api/distancematrix/json",
						data: {
							key: "AIzaSyBH8dHLUHMkDTWfuiLOxhySJpQtXTp7mFU", 
							origins: (position.lat).toString() + "," + (position.lng).toString(),
							destinations: (resp.content[i].latitude).toString() + "," + (resp.content[i].longitude).toString()
						},
						success: function(d) { return d.rows[0].elements[0].distance }
					});
				}
				var tmpl = $("#place-item-template").html();
				$("#places-list ul").html(Mustache.render(tmpl, resp));
			}
		}
	});
}

function resetHomeMarkers(map, markers) {
	for (marker in markers) {
		marker.setMap(null);
	}
	$("#places-list li").each(function() {
		markers[$(this).data("place-id")] = new google.maps.Marker({
			position: {
				lat: Number.parseFloat($(this).data("place-lat")), 
				lng: Number.parseFloat($(this).data("place-lng"))
			},
			map: map,
			title: $(this).data("place-label")
		});
	});
}

/** Validating Empty Field */
//function check_empty() {
//	if (document.getElementById('inputStartEvent').value == "" || document.getElementById('inputEndEvent').value == "" || document.getElementById('inputTitleEvent').value == "") {
//		alert("Il manque des informations !");
//	} else {
//		document.getElementById('form-event').submit();
//		alert("Evenement créé...");
//	}
//}

/** Méthode pour ajout d'un évènement */
//function addCalanderEvent(id, startdate, enddate, title){
//    var eventObject = {
//	    title: title,
//	    start: startdate,
//	    end: enddate,
//	    id: id,
//    };
//
//    $('#calendar').fullCalendar('renderEvent', eventObject, true);
//    return eventObject;
//}


/** Méthode pour modifier un évènement */
//function updateCalanderEvent(id, start, end, title, colour){
//    var eventObject = $('#calendar').fullCalendar( 'clientEvents', id )
//
//    if (eventObject != null){
//        eventObject.title = title;
//        eventObject.start = start;
//        eventObject.end = end;
//
//        $('#calendar').fullCalendar( 'updateEvent', eventObject );
//    }
//    return eventObject;
//}







