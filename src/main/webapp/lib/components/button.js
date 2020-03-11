const Button = (props) => {

    const {
        var_id=null,
        var_class = "btn",
        var_text = "Button Undefined",
        var_type = "button",
        var_action,
    } = props;

    var button = $('<button></button>');
    var span = $('<i></i>');
    button.attr('type', var_type);
    if(var_id != null)
        button.attr('id', var_id);
        
    button.attr('class', var_class);
    span.text(var_text);
    button.append(span);
    button.click(var_action);
    return button;
}