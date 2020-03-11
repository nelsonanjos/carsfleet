const renderDriver = () => {
    const var_menu_module = $("#menu-module");
    const var_module = $("#module");

    var_menu_module.text('');
    var_module.text('');

    var_menu_module.append(
        Title({
            var_text:"Options of Driver",
        })
    );

    var_menu_module.append(
        Button({
            var_class:"btn-add-new",
            var_text:"Add new Driver",
            var_event: "click",
            var_action: (e => renderCreateDriver()),
        })
    );

    var_menu_module.append(
        Button({
            var_class:"btn-back-home",
            var_text:"Back to Home",
            var_event: "click",
            var_action: (e => renderHome())
        })
    );
    
    var_module.append(
    		Title({
    			var_text: "Drivers"
    		})
    	);
    
    var_module.append(
        Table({
            var_id: "table-driver",
            var_head: [
                'Name',
                'Phone',
                'Habilitation',
                'Habilitation Expiration'
            ],
        })
    );
}