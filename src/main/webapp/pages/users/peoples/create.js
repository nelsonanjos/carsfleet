const renderCreatePeople = () => {

    const handleSubmit = () => {

         $.ajax({
             method: 'POST',
             url: 'PeopleController',
             data: {
            	 action: ('create'),
            	 name: $('#people-name').val(),
                 register: $('#people-register').val(),
                 cpf: $('#people-cpf').val(),
                 user: $('#people-user').val(),
                 password: $('#people-password').val(),
                 group: $('#people-group').val(),
             },
         })
    }

    const var_menu_module = $("#menu-module");
    const var_module = $("#module");
    const var_form = $('<form></form>');
    var_form.attr('id', 'form-people');


    var_menu_module.text('');
    var_module.text('');


    /*********************** Menu Module */
    var_menu_module.append(
        Title({
        	var_text: 'Options add new People Register'
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-save",
            var_text: "Save new People Register",
            var_event: "click",
            var_action: (e => {handleSubmit(); renderPeoples();}),
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-clear-form",
            var_text: "Clear form",
            var_event: "click",
            var_action: e => filedsClear([
                '#people-name',
                '#people-register',
                '#people-cpf',
                '#people-user',
                '#people-password',
                '#people-group',
            ])
        })
    );

    var_menu_module.append(
        Button({
            var_class: "btn-back-consult",
            var_text: "Back to Consult People Register",
            var_event: "click",
            var_action: (e => renderPeoples())
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
    		var_text: 'New People Register'
    	}) 
    );

    var_form.append('Name');
    var_form.append(
        Input({
            var_id: 'people-name',
            var_class: 'input-field',
            var_name: 'people-name',
            var_placeholder: 'Enter people name',
        })
    );

    var_form.append('Register');
    var_form.append(
        Input({
            var_id: 'people-register',
            var_class: 'input-field',
            var_name: 'people-register',
            var_placeholder: 'Enter people register',
        })
    );

    var_form.append('CPF');
    var_form.append(
        Input({
            var_id: 'people-cpf',
            var_class: 'input-field',
            var_name: 'people-cpf',
            var_placeholder: 'Enter people cpf',
        })
    );
    
    var_form.append('User');
    var_form.append(
        Input({
            var_id: 'people-user',
            var_class: 'input-field',
            var_name: 'people-user',
            var_placeholder: 'Enter people user',
        })
    );
    
    var_form.append('Password');
    var_form.append(
    		Input({
    			var_id: 'people-password',
    			var_class: 'input-field',
    			var_name: 'people-password',
    			var_placeholder: 'Enter people password',
    			var_type: 'password',
    		})
    );

    var_form.append('Group');
    var_form.append(
    		Input({
    			var_id: 'people-group',
    			var_class: 'input-field',
    			var_name: 'people-group',
    			var_placeholder: 'Enter people group',
    		})
    );

    var_module.append(var_form);

    const filedsClear = () => {
        var_form.children().val("");
    }

}
