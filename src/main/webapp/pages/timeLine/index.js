const renderTimeline = () => {
    const var_menu_module = $("#menu-module");
    const var_module = $("#module");

    var_menu_module.text('');
    var_module.text('');

    var_menu_module.append(
        Title({
            var_text:"Options of Timeline ",
        })
    );

    var_menu_module.append(
        Button({
            var_class:"btn-add-new",
            var_text:"Add new Timeline",
            var_event: "click",
            var_action: (e => renderCreateTimeline()),
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
    			var_text: "List Fleet Timeline"
    		})
    	);
    
    var timelines = null;

    var table = $('<table></table>');
    table.attr('id', 'table-timeline');
    table.attr('class', 'table-app');
    var thead = $('<thead></thead>');
    var tbody;
    var tr = $('<tr></tr>');;
    var td;
    
    var head = [
        'Date',
        'Vehicle',
        'Driver',
        'Fail',
        'Maintenance',
        'KM',
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
                action: ('timeline.DeleteTimeline'),
                id: id,
            },
        });
        $('#tbody-timeline').remove();
        readDatasForTable();
    }
    //============================readDatasForTable
    const readDatasForTable = () => {
        tbody = $('<tbody></tbody>');
        tbody.attr('id', 'tbody-timeline');
        $.ajax({
            method: 'POST',
            url: 'ControllerFactory',
            data: {
                action: ('timeline.ReadTimeline'),
            },
            success: (data) => {
                timelines = JSON.parse(data).timelines;
                if(timelines !== null && timelines !== undefined && timelines.length > 0){
                    timelines.map(timeline => {
                        tr = $('<tr></tr>');
                        td = $('<td></td>').text(timeline.date); tr.append(td);
                        td = $('<td></td>').text(timeline.vehicle); tr.append(td);
                        td = $('<td></td>').text(timeline.driver); tr.append(td);
                        td = $('<td></td>').text(timeline.fail); tr.append(td);
                        td = $('<td></td>').text(timeline.maintenance); tr.append(td);
                        td = $('<td></td>').text(timeline.finishKm); tr.append(td);
                        //Button change
                        td = $('<td></td>');
                        var btn = $('<button></button>');
                        btn = Button({
                            var_class: "btn-table-change",
                            var_event: "click",
                            var_action: (e => renderUpdateTimeline(timeline.id)),
                        })
                        td.append(btn);
                        tr.append(td);
                        //Button Remove
                        td = $('<td></td>'); 
                        btn = Button({
                            var_class: "btn-table-remove",
                            var_event: "click",
                            var_action: (e => removeDataTable(timeline.id)),
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