const renderUpdateDriver = (id) => {

    const handleSubmit = () => {

         $.ajax({
             method: 'POST',
             url: 'ControllerFactory',
             data: {
            	 action: ('driver.UpdateDriver'),
            	 id: id,
            	 name: $('#driver-name').val(),
                 location: $('#driver-location').val(),
                 phone: $('#driver-phone').val(),
                 cpf: $('#driver-cpf').val(),
                 habilitation: $('#driver-habilitation').val(),
                 habilitationExpiration: $('#driver-habilitation-expiration').val(),
             },
         })
    }

    const var_menu_module = $("#menu-module");
    const var_module = $("#module");
    const var_form = $('<form></form>');
    var_form.attr('id', 'form-driver');


    var_menu_module.text('');
    var_module.text('');


    /*********************** Menu Module */
    var_menu_module.append(
        Title({
        	var_text: 'Options edit Driver'
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-save",
            var_text: "Update Driver",
            var_event: "click",
            var_action: (e => {handleSubmit(); renderDriver()}),
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-clear-form",
            var_text: "Clear form",
            var_event: "click",
            var_action: e => filedsClear([
                '#driver-name',
                '#driver-location',
                '#driver-phone',
                '#driver-cpf',
                '#driver-habilitation',
                '#driver-habilitation-expiration',
            ]),
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-back-consult",
            var_text: "Back to Consult Driver",
            var_event: "click",
            var_action: (e => renderDriver())
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
    		var_text: 'Edit driver'
    	}) 
    );
    $.ajax({
    	method: 'POST',
        url: 'ControllerFactory',
        data: {action: ('driver.ReadUnitDriver'), id:id},
        success:(data) => {
        	let driver = JSON.parse(data);
        	
        	var_form.append('driver name');
        	var_form.append(
    	        Input({
    	            var_id: 'driver-name',
    	            var_class: 'input-field',
    	            var_name: 'driver-name',
    	            var_value: driver.name,
    	        })
    	    );
        	var_form.append('location');
        	var_form.append(
        	        Input({
        	            var_id: 'driver-location',
        	            var_class: 'input-field',
        	            var_name: 'driver-location',
        	            var_value: driver.location,
        	        })
        	    );

        	    var_form.append('phone');
        	    var_form.append(
        	        Input({
        	            var_id: 'driver-phone',
        	            var_class: 'input-field',
        	            var_name: 'driver-phone',
        	            var_value: driver.phone,
        	        })
        	    );

        	    var_form.append('cpf');
        	    var_form.append(
        	        Input({
        	            var_id: 'driver-cpf',
        	            var_class: 'input-field',
        	            var_name: 'driver-cpf',
        	            var_value: driver.cpf,
        	        })
        	    );
        	    
        	    var_form.append('habilitation');
        	    var_form.append(
        	        Input({
        	            var_id: 'driver-habilitation',
        	            var_class: 'input-field',
        	            var_name: 'driver-habilitation',
        	            var_value: driver.habilitation,
        	        })
        	    );

        	    var_form.append('Habilitation Expiration');
        	    var_form.append(
        	        Input({
        	            var_id: 'driver-habilitation-expiration',
        	            var_class: 'input-field',
        	            var_name: 'driver-habilitation-expiration',
        	            var_value: driver.habilitationExpiration,
        	        })
        	    );

        	    var_module.append(var_form);
        }
    })

    
    const filedsClear = () => {
        var_form.children().val("");
    }

}
