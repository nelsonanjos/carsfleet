const logo = $(".logo");
const menuSide = $("#menu-side");
const btnMenuFlex = $("#btn-menu-flex");

btnMenuFlex.click(() => {
	(menuSide.hasClass("menu-side-close"))
	? menuSide.removeClass("menu-side-close")
	: menuSide.addClass("menu-side-close");
	
	(logo.hasClass("logo-close"))
	? logo.removeClass("logo-close")
	: logo.addClass("logo-close");
});
