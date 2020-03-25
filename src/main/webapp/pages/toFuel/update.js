const renderUpdateToFuel = (id) => {

    const handleSubmit = () => {

         $.ajax({
             method: 'POST',
             url: 'ControllerFactory',
             data: {
            	 action: ('toFuel.UpdateToFuel'),
            	 id: id,
            	 date: $('#toFuel-date').val(),
                 vehicle: $('#toFuel-vehicle').val(),
                 driver: $('#toFuel-driver').val(),
                 fuelStation: $('#toFuel-fuel-station').val(),
                 price: $('#toFuel-price').val(),
                 expirationHabilitation: $('#toFuel-km').val(),
                 liters: $('#toFuel-liters').val(),
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
        	var_text: 'Options edit To Fuel'
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-save",
            var_text: "Update To Fuel",
            var_event: "click",
            var_action: (e => {handleSubmit(); renderToFuel()}),
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-clear-form",
            var_text: "Clear form",
            var_event: "click",
            var_action: e => filedsClear([
                '#toFuel-station',
                '#toFuel-vehicle',
                '#toFuel-driver',
                '#toFuel-date',
                '#toFuel-liters',
                '#toFuel-price',
                '#toFuel-km',
            ]),
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
    		var_text: 'Edit To Fuel'
    	}) 
    );
    $.ajax({
    	method: 'POST',
        url: 'ControllerFactory',
        data: {action: ('toFuel.ReadUnitToFuel'), id:id},
        success:(data) => {

        	let toFuel = JSON.parse(data);
        	
        	var_form.append('To Fuel Station');
        	var_form.append(
                Input({
                    var_id: 'toFuel-fuel-station',
    	            var_class: 'input-field',
    	            var_date: 'toFuel-fuel-station',
    	            var_value: toFuel.fuelStation,
    	        })
                );
                var_form.append('Vehicle');
                var_form.append(
                    Input({
                        var_id: 'toFuel-vehicle',
        	            var_class: 'input-field',
        	            var_date: 'toFuel-vehicle',
        	            var_value: toFuel.vehicle,
                    })
                );
                
                var_form.append('Driver');
                var_form.append(
                    Input({
                        var_id: 'toFuel-driver',
                        var_class: 'input-field',
                        var_date: 'toFuel-driver',
                        var_value: toFuel.driver,
                    })
                );
                
                var_form.append('To Fuel Date');
                var_form.append(
                    Input({
                        var_id: 'toFuel-date',
                        var_class: 'input-field',
                        var_date: 'toFuel-date',
                        var_value: toFuel.date,
                    })
                );

        	    var_form.append('Liters');
        	    var_form.append(
        	        Input({
        	            var_id: 'toFuel-liters',
        	            var_class: 'input-field',
        	            var_date: 'toFuel-liters',
        	            var_value: toFuel.liters,
        	        })
        	    );
        	    
        	    var_form.append('Price');
        	    var_form.append(
        	        Input({
        	            var_id: 'toFuel-price',
        	            var_class: 'input-field',
        	            var_date: 'toFuel-price',
        	            var_value: toFuel.price,
        	        })
        	    );

        	    var_form.append('Vehicle KM');
        	    var_form.append(
        	        Input({
        	            var_id: 'toFuel-vehicle-km',
        	            var_class: 'input-field',
        	            var_date: 'toFuel-vehicle-km',
        	            var_value: toFuel.vehicleKm,
        	        })
        	    );


        	var_module.append(var_form);
        }
    })

    
    const filedsClear = () => {
        var_form.children().val("");
    }

}
