const renderToFuel = () => {
    const var_menu_module = $("#menu-module");
    const var_module = $("#module");

    var_menu_module.text('');
    var_module.text('');

    var_menu_module.append(
        Title({
            var_text:"Options of To Fuel",
        })
    );

    var_menu_module.append(
        Button({
            var_class:"btn-add-new",
            var_text:"Add new To Fuel Register",
            var_event: "click",
            var_action: (e => renderCreateToFuel()),
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
    			var_text: "List To Fuel"
    		})
    	);
    
    var toFuels = null;

    var table = $('<table></table>');
    table.attr('id', 'table-toFuel');
    table.attr('class', 'table-app');
    var thead = $('<thead></thead>');
    var tbody;
    var tr = $('<tr></tr>');;
    var td;
    
    var head = [
    	'Date',
        'Vehicle',
        'Driver',
        'Liters',
        'Price',
        'Actions',
        
    ];
    for(let i = 0; i < head.length; i++){
        td = $('<td></td>');
        td.text(head[i]);
        tr.append(td);
    };
    thead.append(tr);
    table.append(thead);
    
    var_module.append(table);
    //============================removeDataTable
    const removeDataTable = (id) => {
        $.ajax({
            method: 'POST',
            url: 'ControllerFactory',
            data: {
                action: ('toFuel.DeleteToFuel'),
                id: id,
            },
        });
        $('#tbody-toFuel').remove();
        readDatasForTable();
    }
    //============================readDatasForTable
    const readDatasForTable = () => {
        tbody = $('<tbody></tbody>');
        tbody.attr('id', 'tbody-toFuel');
        $.ajax({
            method: 'POST',
            url: 'ControllerFactory',
            data: {
                action: ('toFuel.ReadToFuel'),
            },
            success: (data) => {
                toFuels = JSON.parse(data).toFuels;
                if(toFuels !== null && toFuels !== undefined && toFuels.length > 0){
                    toFuels.map(toFuel => {
                        tr = $('<tr></tr>');
                        td = $('<td></td>').text(toFuel.date); tr.append(td);
                        td = $('<td></td>').text(toFuel.vehicle); tr.append(td);
                        td = $('<td></td>').text(toFuel.driver); tr.append(td);
                        td = $('<td></td>').text(toFuel.liters); tr.append(td);
                        td = $('<td></td>').text(toFuel.price); tr.append(td);
                        //Button change
                        td = $('<td></td>');
                        var btn = $('<button></button>');
                        btn = Button({
                            var_class: "btn-table-change",
                            var_value: "",
                            var_event: "click",
                            var_action: (e => renderUpdateToFuel(toFuel.id)),
                        })
                        td.append(btn);
                        tr.append(td);
                        //Button Remove
                        td = $('<td></td>'); 
                        btn = Button({
                            var_class: "btn-table-remove",
                            var_value: "",
                            var_event: "click",
                            var_action: (e => removeDataTable(toFuel.id)),
                        })
                        td.append(btn);
                        tr.append(td);
    
                        tbody.append(tr);
                    })
                } else {
                    tr = $('<tr></tr>');
                    td = $('<td></td>');
                    td.append(
                        Title({
                            var_h: 'h2',
                            var_text: 'Not found registers!',
                        })
                    );
                    tr.append(td);
                    tbody.append(tr);
                }
                }
        });
        table.append(tbody);
            
    }
    
    window.onload = readDatasForTable();
}