const Input = (props) => {
    const {
        var_type = 'text',
        var_id = null,
        var_class,
        var_name,
        var_placeholder,
        var_value = '',
        var_readOnly = false,
        var_action = null,
    } = props;

    var input = $('<input></input>');
    input.attr('type', var_type);
    if(var_id != null)
        input.attr('id', var_id);
        
    input.attr('class', var_class);
    input.attr('name', var_name);
    input.attr('placeholder', var_placeholder);
    input.attr('value', var_value);
    input.attr('readonly', var_readOnly);
    input.click(var_action);
    return input;
}