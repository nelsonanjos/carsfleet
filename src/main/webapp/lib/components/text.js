const Text = (props) => {
    const {
        var_type = "<p></p>",
        var_text,
    } = props;

    const text = $(var_type);
    text.text(var_text);
    return text;
}