const Table = (props) => {
    const {
        var_id,
        var_class = "table-app",
        var_head,
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