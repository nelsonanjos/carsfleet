const Title = (props) => {
    const {
        var_h = "h1",
        var_text,
    } = props;

    var title = $('<'+var_h+'>','</'+var_h+'>');
    title.text(var_text);
    return title;
}