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
		var id = $(this).parent().data('id');
		$.ajax({
			url : contextPath + 'placedelete',
			method : 'POST',
			data : {
				id: id
			},
			dataType : 'json',
			success: function(response){
				$('.placelist div[data-id='+id+']').remove();
			}
		});
	}
};

function bindActions(){
	$('#place-delete').click(action.place_delete);
	$('#image_form').change(action.image_upload);
}

$(bindActions);