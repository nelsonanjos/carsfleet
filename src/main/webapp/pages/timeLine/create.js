const renderCreateTimeline = () => {

    const handleSubmit = () => {

         $.ajax({
             method: 'POST',
             url: 'TimeLineController',
             data: {
            	 date: $('#timeline-date').val(),
                 startKm: $('#timeline-start-km').val(),
                 vehicle: $('#timeline-vehicle').val(),
                 driver: $('#timeline-driver').val(),
                 finishKm: $('#timeline-finish-km').val(),
                 fail: $('#timeline-fail').val(),
                 date: $('#timeline-maintenance').val(),
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
        	var_text: 'Options add new Timeline'
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-save",
            var_text: "Save new Timeline",
            var_event: "click",
            var_action: (e => handleSubmit()),
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-clear-form",
            var_text: "Clear form",
            var_event: "click",
            var_action: e => filedsClear([
                '#timeline-date',
                '#timeline-start-km',
                '#timeline-finish-km',
                '#timeline-fail',
                '#timeline-maintenance',
            ])
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
    		var_text: 'New Timeline'
    	}) 
    );

    var_form.append('Timeline Date');
    var_form.append(
        Input({
            var_id: 'timeline-date',
            var_class: 'input-field',
            var_name: 'timeline-date',
            var_placeholder: 'Enter timeline date',
        })
    );
    
    var_form.append('Vehicle');
    var_form.append(
    		Input({
    			var_id: 'timeline-vehicle',
    			var_class: 'input-field',
    			var_name: 'timeline-vehicle',
    			var_placeholder: 'Enter timeline vehicle',
    		})
    );
    var_form.append('Driver');
    var_form.append(
    		Input({
    			var_id: 'timeline-driver',
    			var_class: 'input-field',
    			var_name: 'timeline-driver',
    			var_placeholder: 'Enter timeline driver',
    		})
    );

    var_form.append('Start Km');
    var_form.append(
        Input({
            var_id: 'timeline-start-km',
            var_class: 'input-field',
            var_name: 'timeline-start-km',
            var_placeholder: 'Enter timeline start km',
        })
    );

    var_form.append('Finish Km');
    var_form.append(
        Input({
            var_id: 'timeline-finish-km',
            var_class: 'input-field',
            var_name: 'timeline-finish-km',
            var_placeholder: 'Enter timeline finish km',
        })
    );
    
    var_form.append('Fail');
    var_form.append(
        Input({
            var_id: 'timeline-fail',
            var_class: 'input-field',
            var_name: 'timeline-fail',
            var_placeholder: 'Enter timeline fail',
        })
    );

    var_form.append('Maintenance');
    var_form.append(
        Input({
            var_id: 'timeline-maintenance',
            var_class: 'input-field',
            var_name: 'timeline-maintenance',
            var_placeholder: 'Enter timeline maintenance',
        })
    );

    var_module.append(var_form);

    const filedsClear = () => {
        var_form.children().val("");
    }

}
