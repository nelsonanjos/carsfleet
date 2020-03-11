const Title = (props) => {
    const {
        var_h = "h1",
        var_text,
    } = props;

    const title = document.createElement(var_h);
    title.appendChild(document.createTextNode(var_text));
    return title;
}