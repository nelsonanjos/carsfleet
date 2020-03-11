const renderCreateDriver = () => {

    const handleSubmit = () => {

         $.ajax({
             method: 'POST',
             url: 'DriverController',
             data: {
                 name: $('#driver-name').val(),
                 location: $('#driver-location').val(),
                 phone: $('#driver-phone').val(),
                 cpf: $('#driver-cpf').val(),
                 habilitation: $('#driver-habilitation').val(),
                 expirationHabilitation: $('#driver-expirationHabilitation').val(),
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
        	var_text: 'Options add new Driver'
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-save",
            var_text: "Save new Driver",
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
                '#driver-name',
                 '#driver-location',
                 '#driver-phone',
                 '#driver-cpf',
                 '#driver-habilitation',
                 '#driver-expiration-habilitation',
            ]),
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-back-consult",
            var_text: "Back to Consult Drivers",
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
    		var_text: 'New Driver'
    	}) 
    );

    var_form.append('Name');
    var_form.append(
        Input({
            var_id: 'driver-name',
            var_class: 'input-field',
            var_name: 'driver-name',
            var_placeholder: 'Enter a name for driver',
        })
    );

    var_form.append('Location');
    var_form.append(
        Input({
            var_id: 'driver-location',
            var_class: 'input-field',
            var_name: 'driver-location',
            var_placeholder: 'Enter driver location',
        })
    );

    var_form.append('Phone');
    var_form.append(
        Input({
            var_id: 'driver-phone',
            var_class: 'input-field',
            var_name: 'driver-phone',
            var_placeholder: 'Enter driver phone',
        })
    );

    var_form.append('CPF');
    var_form.append(
        Input({
            var_id: 'driver-cpf',
            var_class: 'input-field',
            var_name: 'driver-cpf',
            var_placeholder: 'Enter driver CPF',
        })
    );
    
    var_form.append('Habilitation');
    var_form.append(
        Input({
            var_id: 'driver-habilitation',
            var_class: 'input-field',
            var_name: 'driver-habilitation',
            var_placeholder: 'Enter driver habilitation',
        })
    );

    var_form.append('Expiration Habilitation');
    var_form.append(
        Input({
            var_id: 'driver-expiration-habilitation',
            var_class: 'input-field',
            var_name: 'driver-expiration-habilitation',
            var_placeholder: 'Enter driver expiration habilitation',
        })
    );


    var_module.append(var_form);

    const filedsClear = () => {
        var_form.children().val("");
    }

}
