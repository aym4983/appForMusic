action={
	image_upload:function(){
		var data = new FormData();
		$.each($('#image_form')[0].files, function(i, file) {
		    data.append('image_upload', file);
		});
		$.ajax({
			url: contextPath + 'uploadimage',
			method:'POST',
			data : data,
			dataType : 'json',
			contentType : false,
			processData : false,
			success : function(response){
				$('#image').attr('src',response.path);
					
			},
			error:function(xhr, resp, status){
				console.log(resp);
			}
		});
	},
	place_add:function(){
		$('.placelist #place-add').addClass('hidden');
		$('#createPlace').removeClass('hidden');
	},
	place_delete:function(){
		var form = $(this).closest("form");
		$.ajax({
			url : contextPath + 'api/places/placedelete',
			method : 'POST',
			data : form.serialize(),
			dataType : 'json',
			success: function(data, textStatus,jqXHR ){
				console.log(data);
				$('#deleteModal').modal('hide');
				window.location.href = contextPath + "places";
				 $("#snoAlertBox").fadeIn();
				   closeSnoAlertBox();
			}
		});
	},
	place_localisation:function(){
		
		var codepostal = document.getElementById('place-zipcode').value;
	    var ville =  document.getElementById('place-city').value;
	    var rue =  document.getElementById('place-street').value;
	    
	    if(codepostal!=="" && ville!=="" && rue!=="")
	    {
		    address = rue + " " + codepostal + " "+ ville; 
		    
		    console.log(address);
		    
		    var geocoder = new google.maps.Geocoder();
		   
		    geocoder.geocode({'address': address}, function(results, status) {
		        if (status === google.maps.GeocoderStatus.OK) {
		        	document.getElementById('latitude').value = results[0].geometry.location.lat();
		        	document.getElementById('longitude').value = results[0].geometry.location.lng();
		        	//alert( "latitude : " + results[0].geometry.location.lat() );
		          	//alert( "longitude : " + results[0].geometry.location.lng() );
		        } else {
		          //alert('Geocode was not successful for the following reason: ' + status);
		        }
		      });   
	    }
	}
};

function closeSnoAlertBox(){
	window.setTimeout(function () {
	  $("#snoAlertBox").fadeOut(300)
	}, 3000);
} 

function showInfo(container, message) {
    container.append(
    $('<div>', {
        class: 'alert alert-info',
        html: message
    }).append(
    $('<button>', {
        type: 'button',
        class: 'close',
        html: '&times',
        click: function () {
            $(this).parent().remove();
        }
    })));
}

function bindActions(){
	$('#placeinfo-delete').click(action.place_delete);
	$('#image_form').change(action.image_upload);
	//$('#modifier').click(action.place_localisation);
	$('#place-street').click(action.place_localisation);
	$('#place-zipcode').click(action.place_localisation);
	$('#place-city').click(action.place_localisation);
	$('#place-publiclabel').click(action.place_localisation);
	$('#place-privatelabel').click(action.place_localisation);
	$('#description').click(action.place_localisation);
	$('#place-image').click(action.place_localisation);
	$('#ajouter').click(action.place_localisation);
}



$(bindActions);