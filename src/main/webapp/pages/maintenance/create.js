const renderCreateMaintenance = () => {

    const handleSubmit = () => {

         $.ajax({
             method: 'POST',
             url: 'MaintenanceController',
             data: {
            	 description: $('#maintenance-description').val(),
                 type: $('#maintenance-type').val(),
                 price: $('#maintenance-price').val(),
                 date: $('#maintenance-date').val(),
             },
         })
    }

    const var_menu_module = $("#menu-module");
    const var_module = $("#module");
    const var_form = $('<form></form>');
    var_form.attr('id', 'form-maintenance');


    var_menu_module.text('');
    var_module.text('');


    /*********************** Menu Module */
    var_menu_module.append(
        Title({
        	var_text: 'Options add new Maintenance'
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-save",
            var_text: "Save new Maintenance",
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
                '#maintenance-description',
                '#maintenance-type',
                '#maintenance-price',
                '#maintenance-date',
            ])
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-back-consult",
            var_text: "Back to Consult Maintenance",
            var_event: "click",
            var_action: (e => renderMaintenance())
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
    		var_text: 'New Maintenance'
    	}) 
    );

    var_form.append('Maintenance Description');
    var_form.append(
        Input({
            var_id: 'maintenance-description',
            var_class: 'input-field',
            var_name: 'maintenance-description',
            var_placeholder: 'Enter maintenance description',
        })
    );

    var_form.append('Type');
    var_form.append(
        Input({
            var_id: 'maintenance-type',
            var_class: 'input-field',
            var_name: 'maintenance-type',
            var_placeholder: 'Enter maintenance type',
        })
    );

    var_form.append('Price');
    var_form.append(
        Input({
            var_id: 'maintenance-price',
            var_class: 'input-field',
            var_name: 'maintenance-price',
            var_placeholder: 'Enter maintenance price',
        })
    );
    
    var_form.append('Date');
    var_form.append(
        Input({
            var_id: 'maintenance-date',
            var_class: 'input-field',
            var_name: 'maintenance-date',
            var_placeholder: 'Enter maintenance date',
        })
    );

    var_module.append(var_form);

    const filedsClear = () => {
        var_form.children().val("");
    }

}
