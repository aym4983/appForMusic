var action={
	place_add:function(){
		/*** Cacher le bouton ajouter ***/ 
		$('#placelist .place-add').addClass('hidden');
	}
};

function bindActions(){
	$('#place-add').click(action.place_add);
}

$(bindActions);

