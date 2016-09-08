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
				alert(resp);
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
				alert("Suppression réussie!");
				window.location.href = contextPath + "/search"
			}
		});
	}
};

function bindActions(){
	$('#placeinfo-delete').click(action.place_delete);
	$('#image_form').change(action.image_upload);
}

$(bindActions);