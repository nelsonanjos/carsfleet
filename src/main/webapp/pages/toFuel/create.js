const renderCreateToFuel = () => {

    const handleSubmit = () => {

         $.ajax({
             method: 'POST',
             url: 'ToFuelController',
             data: {
            	 fuelStation: $('#toFuel-station').val(),
            	 vehicle: $('#toFuel-vehicle').val(),
            	 driver: $('#toFuel-driver').val(),
                 date: $('#toFuel-date').val(),
                 price: $('#toFuel-price').val(),
                 km: $('#toFuel-km').val(),
             },
         })
    }

    const var_menu_module = $("#menu-module");
    const var_module = $("#module");
    const var_form = $('<form></form>');
    var_form.attr('id', 'form-toFuel');


    var_menu_module.text('');
    var_module.text('');


    /*********************** Menu Module */
    var_menu_module.append(
        Title({
        	var_text: 'Options add new To Fuel'
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-save",
            var_text: "Save new To Fuel",
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
                '#toFuel-station',
                '#toFuel-date',
                '#toFuel-price',
                '#toFuel-km',
            ])
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-back-consult",
            var_text: "Back to Consult To Fuel",
            var_event: "click",
            var_action: (e => renderToFuel())
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
    		var_text: 'New To Fuel Register'
    	}) 
    );

    var_form.append('Fuel Station');
    var_form.append(
        Input({
            var_id: 'toFuel-station',
            var_class: 'input-field',
            var_name: 'toFuel-station',
            var_placeholder: 'Enter to fuel station',
        })
    );
    
    var_form.append('Vehicle');
    var_form.append(
    		Input({
    			var_id: 'toFuel-vehicle',
    			var_class: 'input-field',
    			var_name: 'toFuel-vehicle',
    			var_placeholder: 'Enter to fuel vehicle',
    		})
    );

    var_form.append('Driver');
    var_form.append(
    		Input({
    			var_id: 'toFuel-driver',
    			var_class: 'input-field',
    			var_name: 'toFuel-driver',
    			var_placeholder: 'Enter to fuel driver',
    		})
    );

    var_form.append('Date');
    var_form.append(
        Input({
            var_id: 'toFuel-date',
            var_class: 'input-field',
            var_name: 'toFuel-date',
            var_placeholder: 'Enter to fuel date',
        })
    );

    var_form.append('Liters');
    var_form.append(
    		Input({
    			var_id: 'toFuel-liters',
    			var_class: 'input-field',
    			var_name: 'toFuel-liters',
    			var_placeholder: 'Enter to fuel liters',
    		})
    );

    var_form.append('Price');
    var_form.append(
        Input({
            var_id: 'toFuel-price',
            var_class: 'input-field',
            var_name: 'toFuel-price',
            var_placeholder: 'Enter to fuel price',
        })
    );
    
    var_form.append('Vehicle Km');
    var_form.append(
        Input({
            var_id: 'toFuel-km',
            var_class: 'input-field',
            var_name: 'toFuel-km',
            var_placeholder: 'Enter to fuel vehicle km',
        })
    );

    var_module.append(var_form);

    const filedsClear = () => {
        var_form.children().val("");
    }

}
