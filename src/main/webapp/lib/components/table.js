const Table = (props) => {
    const {
        var_id,
        var_class = "table-app",
        var_head,
        var_body,
    } = props;

    
    var table = $('<table></table>');
    if(var_id != null)
        table.attr('id', var_id);
        
    var thead = $('<thead></thead>');
    var tbody = $('<tbody></tbody>');
    var tr = $('<tr></tr>');
    var td;
    
    table.attr('id', var_id);
    table.attr('class', var_class);

    for(let i = 0; i < var_head.length; i++){
        td = $('<td></td>');
        td.text(var_head[i]);
        tr.append(td);
    }
    thead.append(tr);
    
    if(var_body != null || var_body != undefined){
	    for(let i = 0; i < var_body.length; i++){
	    	tr = $('<tr></tr>');
	    	for(let j = 0; j < var_body[i].length; j++){
	    		var td = $('<td></td>');
	    		td.text(var_body[i][j]);
	    		tr.append(td);
	    	}
	    	tbody.append(tr);
	    }
    } else {
    	tr = $('<tr></tr>');
    	td = $('<td></td>');
    	td.append(
    	   Title({
    		var_text: "Registers not found!",	   
    	   })
    	);
    	tr.append(td);
    	tbody.append(tr);
    }


    table.append(thead);
    table.append(tbody);
    

    return table;
}


/*
    <tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr><tr>
    	<td>Gol</td>
        <td>OKM-4564</td>
        <td>Branco</td>
        <td>10/02/2020</td>
    </tr>
    
    
    
    <tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr><tr>
    	<td>Fusca</td>
        <td>ILM-9866</td>
        <td>Preto</td>
        <td>31/05/2022</td>
    </tr>
    
    
    
    <tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr><tr>
    	<td>Celta</td>
        <td>UKJ-9552</td>
        <td>Vermelho</td>
        <td>25/12/2038</td>
    </tr> */