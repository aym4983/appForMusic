var action={
	place_add:function(){
		$('.placelist #place-add').addClass('hidden');
		$('#createPlace').removeClass('hidden');
	},
	place_reset:function(){
		$('#createPlace').addClass('hidden');
		$('.placelist #place-add').removeClass('hidden');
	}
};

function bindActions(){
	$('#place-add').click(action.place_add);
	$('#place-reset').click(action.place_reset);
}

$(bindActions);

