const renderHome = () => {
    const var_menu_module = $("#menu-module");
    const var_module = $("#module");

    var_menu_module.text('');
    var_module.text('');

    var_menu_module.append(
        Title({
            var_text:"Welcome, user",
        })
    );
    var_menu_module.append(
        Text({
            var_text:"This is software, was develope for control of cars fleet.",
        })
    );
    var_menu_module.append(
        Text({
            var_text:"Select a options in side rigth or on the menu in side left!",
        })
    );

    var_module.append(
        Title({
            var_text: 'Welcome'
        })
    )


    var_module.append(
        Button({
            var_class: "fleet-item-menu button-home-module",
            var_text: "Fleet",
            var_event: "click",
            var_action: (e => renderFleet())
        })
    );

    var_module.append(
        Button({
            var_class: "driver-item-menu button-home-module",
            var_text: "Driver",
            var_event: "click",
            var_action: (e => renderDriver())
        })
    );

    var_module.append(
        Button({
            var_class: "tofuel-item-menu button-home-module",
            var_text: "To Fuel",
            var_event: "click",
            var_action: (e => renderToFuel())
        })
    );

    var_module.append(
        Button({
            var_class: "timeline-item-menu button-home-module",
            var_text: "Timeline",
            var_event: "click",
            var_action: (e => renderTimeline())
        })
    );

    var_module.append(
        Button({
            var_class: "submenu-people button-home-module",
            var_text: "Peoples",
            var_event: "click",
            var_action: (e => renderPeoples())
        })
    );

}