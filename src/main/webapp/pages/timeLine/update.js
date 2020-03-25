const renderUpdateTimeline = (id) => {

    const handleSubmit = () => {

         $.ajax({
             method: 'POST',
             url: 'ControllerFactory',
             data: {
            	 action: ('timeline.UpdateTimeline'),
            	 id: id,
            	 date: $('#timeline-date').val(),
                 vehicle: $('#timeline-vehicle').val(),
                 driver: $('#timeline-driver').val(),
                 startKm: $('#timeline-startKm').val(),
                 finishKm: $('#timeline-finishKm').val(),
                 fail: $('#timeline-fail').val(),
                 maintenance: $('#timeline-maintenance').val(),
             },
         })
    }

    const var_menu_module = $("#menu-module");
    const var_module = $("#module");
    const var_form = $('<form></form>');
    var_form.attr('id', 'form-timeline');


    var_menu_module.text('');
    var_module.text('');


    /*********************** Menu Module */
    var_menu_module.append(
        Title({
        	var_text: 'Options Edit Timeline'
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-save",
            var_text: "Update Timeline",
            var_event: "click",
            var_action: (e => {handleSubmit(); renderTimeline()}),
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-clear-form",
            var_text: "Clear form",
            var_event: "click",
            var_action: e => filedsClear([
                '#timeline-date',
                '#timeline-vehicle',
                '#timeline-driver',
                '#timeline-startKm',
                '#timeline-finishKm',
                '#timeline-fail',
                '#timeline-maintenance',
            ]),
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-back-consult",
            var_text: "Back to Consult Timeline",
            var_event: "click",
            var_action: (e => renderTimeline())
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-back-home",
            var_text: "Back to Home",
            var_event: "click",
            var_action: (e => renderHome())
        })
    );
    /*********************** Module */
    var_module.append(
		Title({
    		var_text: 'Edit Timeline'
    	}) 
    );
    $.ajax({
    	method: 'POST',
        url: 'ControllerFactory',
        data: {action: ('timeline.ReadUnitTimeline'), id:id},
        success:(data) => {
        	console.log(data);
        	let timeline = JSON.parse(data);
        	
        	var_form.append('Timeline date');
        	var_form.append(
    	        Input({
    	            var_id: 'timeline-date',
    	            var_class: 'input-field',
    	            var_date: 'timeline-date',
    	            var_value: timeline.date,
    	        })
    	    );
        	var_form.append('Vehicle');
        	var_form.append(
                Input({
                    var_id: 'timeline-vehicle',
                    var_class: 'input-field',
                    var_date: 'timeline-vehicle',
                    var_value: timeline.vehicle,
                })
            );

            var_form.append('Driver');
            var_form.append(
                Input({
                    var_id: 'timeline-driver',
                    var_class: 'input-field',
                    var_date: 'timeline-driver',
                    var_value: timeline.driver,
                })
            );

            var_form.append('Start Km');
            var_form.append(
                Input({
                    var_id: 'timeline-startKm',
                    var_class: 'input-field',
                    var_date: 'timeline-startKm',
                    var_value: timeline.startKm,
                })
            );
            
            var_form.append('Finish Km');
            var_form.append(
                Input({
                    var_id: 'timeline-finishKm',
                    var_class: 'input-field',
                    var_date: 'timeline-finishKm',
                    var_value: timeline.finishKm,
                })
            );

            var_form.append('Fail');
            var_form.append(
                Input({
                    var_id: 'timeline-fail',
                    var_class: 'input-field',
                    var_date: 'timeline-fail',
                    var_value: timeline.fail,
                })
            );

            var_form.append('Maintenance');
            var_form.append(
                Input({
                    var_id: 'timeline-maintenance',
                    var_class: 'input-field',
                    var_date: 'timeline-maintenance',
                    var_value: timeline.maintenance,
                })
            );

            var_module.append(var_form);
        }
    })

    
    const filedsClear = () => {
        var_form.children().val("");
    }

}
