const Label = (props) => {
    const {
        var_text,
    } = props;

    const label = $('<label></label>');
    label.text(var_text);
    return label;
}