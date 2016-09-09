var app = app || {};

app.calendar = {
		
		/**
		 * Méthode d'init à appeler dans tiles.xml
		 */
		init : function(){
			console.log("init calendar");
			app.calendar.initCalendar();
			app.calendar.initUpdateCalendar();
			app.calendar.initClockPicker();
			//app.calendar.initDatePicker();
		},
		
		initCalendar : function(){
			$('#calendar').fullCalendar({
				 header: {
		             left: 'prev,next today',
		             center: 'title',
		             right: 'month,agendaWeek'
		         },
				lang: 'fr',
				selectable: true,
				editable: true,
				// Permet de passer de la vue mois à la vue semaine
				dayClick: function(date, jsEvent, view) {
					if(view.name != 'month'){
					    return;
					} else {
						$('#calendar').fullCalendar('changeView', 'agendaWeek');
						$('#calendar').fullCalendar('gotoDate', date); 
						$('#calendar').fullCalendar( 'renderEvent', jsEvent);
					}		  
				},

				// Ajout d'un evenement dans le calendar
		        selectHelper: true,
				select: function(start, end) {
					 var hiddenStart=start.format();
					 var hiddenEnd=end.format();
					 var day=moment(start).format('LL');
					 start=moment(start).format('HH:mm'); 
					 end=moment(end).format('HH:mm'); 
					 
					 d = document.getElementById("FormEvent");
					 d.elements["inputDayEvent"].value = day;
					 
					 s = document.getElementById("FormEvent");
					 s.elements["inputStartEvent"].value = start;
					 
					 e = document.getElementById("FormEvent");
					 e.elements["inputEndEvent"].value = end;
					 
					 hs = document.getElementById("FormEvent");
					 hs.elements["hiddenStartEvent"].value = hiddenStart;
					 
					 he = document.getElementById("FormEvent");
					 he.elements["hiddenEndEvent"].value = hiddenEnd;		 
					 		     
				     $('#myModalHorizontal').modal('show');
				},
				events: [
					{
						title: 'test Event',
						start: '2016-09-08',
						end: '2016-09-08'
					}
				]
				
			});
		},
		
		/** récupère ts les events de la bdd et les affiche */
		initUpdateCalendar : function(){
			$("#FormEvent").submit(function(event){
				event.preventDefault();
				
				$.ajax({
					url: contextPath + "calendar",
					method : 'POST',
					data : $(this).serialize(),
					success: function(data){
						console.log(data);
						if(data.succeeded){
							for(var i=0; i<data.content.length; i ++){
								$("#calendar").fullCalendar('renderEvent', {
									start : data.content[i].startevent,
									end : data.content[i].endevent,
									title : data.content[i].titleevent
								});
							}
						}
					},
					error:function(xhr, resp, status){
						console.log(resp);
						console.log(xhr);
						console.log(status);
						
					}
				})
				
				$("#myModalHorizontal").modal('hide');
				
			});
		},

		/** timepicker pour formulaire */
		initClockPicker : function(){
			var inputStart = $('#inputStartEvent').clockpicker({
			    placement: 'bottom',
			    align: 'left',
			    autoclose: true
			});
			
			var inputEnd = $('#inputEndEvent').clockpicker({
			    placement: 'bottom',
			    align: 'left',
			    autoclose: true
			});
		},
		
		/** datepicker pour formulaire */
		initDatePicker : function (){
			var inputDay = $('#inputDayEvent').datepicker({
			    placement: 'bottom',
			    align: 'left',
			    autoclose: true
			});
		}
		
}