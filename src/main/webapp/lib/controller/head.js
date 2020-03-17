const logo = $(".logo");
const menuSide = $("#menu-side");
const btnMenuFlex = $("#btn-menu-flex");
const content = $("#content");

btnMenuFlex.click(() => {
	(menuSide.hasClass("menu-side-close"))
	? menuSide.removeClass("menu-side-close")
	: menuSide.addClass("menu-side-close");
	
	(logo.hasClass("logo-close"))
	? logo.removeClass("logo-close")
	: logo.addClass("logo-close");
	
	(content.hasClass("content-close"))
	? (content.removeClass("content-close"), content.addClass("content-open"))
	: (content.removeClass("content-open"), content.addClass("content-close"));
});
