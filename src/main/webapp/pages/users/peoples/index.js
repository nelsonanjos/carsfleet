const renderPeoples = () => {
    const var_menu_module = $("#menu-module");
    const var_module = $("#module");

    var_menu_module.text('');
    var_module.text('');

    var_menu_module.append(
        Title({
            var_text:"Options of People Register",
        })
    );

    var_menu_module.append(
        Button({
            var_class:"btn-add-new",
            var_text:"Add new People Register",
            var_event: "click",
            var_action: (e => renderCreatePeople()),
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
    			var_text: "List Peoples Register"
    		})
    	);
    
    var peoples = null;

    var table = $('<table></table>');
    table.attr('id', 'table-people');
    table.attr('class', 'table-app');
    var thead = $('<thead></thead>');
    var tbody;
    var tr = $('<tr></tr>');;
    var td;
    
    var head = [
        'Name',
        'CPF',
        'User',
        'Group',
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
                action: ('people.DeletePeople'),
                id: id,
            },
        });
        $('#tbody-people').remove();
        readDatasForTable();
    }
    //============================readDatasForTable
    const readDatasForTable = () => {
        tbody = $('<tbody></tbody>');
        tbody.attr('id', 'tbody-people');
        $.ajax({
            method: 'POST',
            url: 'ControllerFactory',
            data: {
                action: ('people.ReadPeople'),
            },
            success: (data) => {
                peoples = JSON.parse(data).peoples;
                if(peoples !== null && peoples !== undefined && peoples.length > 0){
                    peoples.map(people => {
                        tr = $('<tr></tr>');
                        td = $('<td></td>').text(people.name); tr.append(td);
                        td = $('<td></td>').text(people.cpf); tr.append(td);
                        td = $('<td></td>').text(people.user); tr.append(td);
                        td = $('<td></td>').text(people.group); tr.append(td);
                        //Button change
                        td = $('<td></td>');
                        var btn = $('<button></button>');
                        btn = Button({
                            var_class: "btn-table-change",
                            var_event: "click",
                            var_text: "",
                            var_action: (e => renderUpdatePeople(people.id)),
                        })
                        td.append(btn);
                        tr.append(td);
                        //Button Remove
                        td = $('<td></td>'); 
                        btn = Button({
                            var_class: "btn-table-remove",
                            var_text: "",
                            var_event: "click",
                            var_action: (e => removeDataTable(people.id)),
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