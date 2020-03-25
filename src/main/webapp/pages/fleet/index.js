const renderFleet = () => {
    const var_menu_module = $("#menu-module");
    const var_module = $("#module");
    
    var_menu_module.text('');
    var_module.text('');

    var_menu_module.append(
        Title({
            var_text:"Options of Fleet",
        })
    );

    var_menu_module.append(
        Button({
            var_class:"btn-add-new",
            var_text:"Add new Vehicle",
            var_event: "click",
            var_action: (e => renderCreateVehicle()),
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
			var_text: "Fleet of Vehicles"
		})
	);
    
    var vehicles = null;
        	
	var table = $('<table></table>');
	table.attr('id', 'table-fleet');
	table.attr('class', 'table-app');
	var thead = $('<thead></thead>');
    var tbody;
    var tr = $('<tr></tr>');;
    var td;
    
    var head = [
        'Vehicle Type',
        'Plate',
        'Color',
        'Licensing Expiration',
        'Actions'];
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
				action: ('vehicle.DeleteVehicle'),
				id: id,
			},
		});
		$('#tbody-fleet').remove();
		readDatasForTable();
	}
	//============================readDatasForTable
	const readDatasForTable = () => {
		tbody = $('<tbody></tbody>');
		tbody.attr('id', 'tbody-fleet');
		$.ajax({
	        method: 'POST',
	        url: 'ControllerFactory',
	        data: {
	       	 action: ('vehicle.ReadVehicle'),
	        },
	        success: (data) => {
	        	vehicles = JSON.parse(data).vehicles;
	        	if(vehicles !== null && vehicles !== undefined && vehicles.length > 0){
		        	vehicles.map(vehicle => {
		        		tr = $('<tr></tr>');
		        		td = $('<td></td>').text(vehicle.type); tr.append(td);
		        		td = $('<td></td>').text(vehicle.plate); tr.append(td);
		        		td = $('<td></td>').text(vehicle.color); tr.append(td);
		        		td = $('<td></td>').text(vehicle.licensingExpiration); tr.append(td);
		        		//Button change
		        		td = $('<td></td>');
		        		var btn = $('<button></button>');
		        		btn = Button({
		                    var_class: "btn-table-change",
		                    var_text: "",
		                    var_event: "click",
		                    var_action: (e => renderUpdateVehicle(vehicle.id)),
		                })
		        		td.append(btn);
		        		tr.append(td);
		        		//Button Remove
		        		td = $('<td></td>'); 
		        		btn = Button({
		                    var_class: "btn-table-remove",
		                     var_text: "",
		                    var_event: "click",
		                    var_action: (e => removeDataTable(vehicle.id)),
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