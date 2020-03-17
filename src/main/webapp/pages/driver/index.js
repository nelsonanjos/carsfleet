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
    
    var drivers = null;
	
	var table = $('<table></table>');
	table.attr('id', 'table-drivers');
	table.attr('class', 'table-app');
	var thead = $('<thead></thead>');
    var tbody;
    var tr = $('<tr></tr>');;
    var td;
    
    var head = [
    	'Name',
    	'Phone',
    	'Habilitation',
    	'Habilitation Exp.',
    	'Action',
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
			url: 'DriverController',
			data: {
				action: ('delete'),
				id: id,
			},
		});
		$('#tbody-driver').remove();
		readDatasForTable();
	}
	//============================readDatasForTable
	const readDatasForTable = () => {
		tbody = $('<tbody></tbody>');
		tbody.attr('id', 'tbody-driver');
		$.ajax({
	        method: 'POST',
	        url: 'DriverController',
	        data: {
	       	 action: ('read'),
	        },
	        success: (data) => {
	        	drivers = JSON.parse(data).drivers;
	        	if(drivers !== null && drivers !== undefined && drivers.length > 0){
		        	drivers.map(driver => {
		        		tr = $('<tr></tr>');
		        		td = $('<td></td>').text(driver.name); tr.append(td);
		        		td = $('<td></td>').text(driver.phone); tr.append(td);
		        		td = $('<td></td>').text(driver.habilitation); tr.append(td);
		        		td = $('<td></td>').text(driver.habilitationExpiration); tr.append(td);
		        		//Button change
		        		td = $('<td></td>');
		        		var btn = $('<button></button>');
		        		btn = Button({
		                    var_class: "btn-table-change",
		                    var_event: "click",
		                    var_text: "",
		                    var_action: (e => renderUpdateDriver(driver.id)),
		                })
		        		td.append(btn);
		        		tr.append(td);
		        		//Button Remove
		        		td = $('<td></td>'); 
		        		btn = Button({
		                    var_class: "btn-table-remove",
		                    var_text: "",
		                    var_event: "click",
		                    var_action: (e => removeDataTable(driver.id)),
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