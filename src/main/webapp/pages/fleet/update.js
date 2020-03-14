const renderUpdateVehicle = (id) => {

    const handleSubmit = () => {

         $.ajax({
             method: 'POST',
             url: 'VehicleController',
             data: {
            	 action: ('update'),
            	 id: id,
            	 type: $('#vehicle-type').val(),
                 plate: $('#vehicle-plate').val(),
                 brand: $('#vehicle-brand').val(),
                 price: $('#vehicle-price').val(),
                 state: $('#vehicle-state').val(),
                 color: $('#vehicle-color').val(),
                 year: $('#vehicle-year').val(),
                 licensingExpiration: $('#vehicle-licensing-expiration').val(),
             },
         })
    }

    const var_menu_module = $("#menu-module");
    const var_module = $("#module");
    const var_form = $('<form></form>');
    var_form.attr('id', 'form-vehicle');


    var_menu_module.text('');
    var_module.text('');


    /*********************** Menu Module */
    var_menu_module.append(
        Title({
        	var_text: 'Options edit Vehicle'
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-save",
            var_text: "Update Vehicle",
            var_event: "click",
            var_action: (e => {handleSubmit(); renderFleet()}),
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-clear-form",
            var_text: "Clear form",
            var_event: "click",
            var_action: e => filedsClear([
                '#vehicle-type',
                '#vehicle-plate',
                '#vehicle-brand',
                '#vehicle-price',
                '#vehicle-state',
                '#vehicle-color',
                '#vehicle-year',
            ]),
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-back-consult",
            var_text: "Back to Consult Fleet",
            var_event: "click",
            var_action: (e => renderFleet())
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
    		var_text: 'Edit Vehicle'
    	}) 
    );
    $.ajax({
    	method: 'POST',
        url: 'VehicleController',
        data: {action: ('readUnit'), id:id},
        success:(data) => {
        	let vehicle = JSON.parse(data);
        	
        	var_form.append('Vehicle Type');
        	var_form.append(
    	        Input({
    	            var_id: 'vehicle-type',
    	            var_class: 'input-field',
    	            var_name: 'vehicle-type',
    	            var_value: vehicle.type,
    	        })
    	    );
        	var_form.append('Plate');
        	var_form.append(
        	        Input({
        	            var_id: 'vehicle-plate',
        	            var_class: 'input-field',
        	            var_name: 'vehicle-plate',
        	            var_value: vehicle.plate,
        	        })
        	    );

        	    var_form.append('Brand');
        	    var_form.append(
        	        Input({
        	            var_id: 'vehicle-brand',
        	            var_class: 'input-field',
        	            var_name: 'vehicle-brand',
        	            var_value: vehicle.brand,
        	        })
        	    );

        	    var_form.append('Price');
        	    var_form.append(
        	        Input({
        	            var_id: 'vehicle-price',
        	            var_class: 'input-field',
        	            var_name: 'vehicle-price',
        	            var_value: vehicle.price,
        	        })
        	    );
        	    
        	    var_form.append('State');
        	    var_form.append(
        	        Input({
        	            var_id: 'vehicle-state',
        	            var_class: 'input-field',
        	            var_name: 'vehicle-state',
        	            var_value: vehicle.state,
        	        })
        	    );

        	    var_form.append('Color');
        	    var_form.append(
        	        Input({
        	            var_id: 'vehicle-color',
        	            var_class: 'input-field',
        	            var_name: 'vehicle-color',
        	            var_value: vehicle.color,
        	        })
        	    );

        	    var_form.append('Year');
        	    var_form.append(
        	        Input({
        	            var_id: 'vehicle-year',
        	            var_class: 'input-field',
        	            var_name: 'vehicle-year',
        	            var_value: vehicle.year,
        	        })
        	    );

        	    var_form.append('Licensing Expiration');
        	    var_form.append(
        	        Input({
        	            var_id: 'vehicle-licensing-expiration',
        	            var_class: 'input-field',
        	            var_name: 'vehicle-licensing-expiration',
        	            var_value: vehicle.licensingExpiration,
        	        })
        	    );

        	    var_module.append(var_form);
        }
    })

    
    const filedsClear = () => {
        var_form.children().val("");
    }

}
