
const elUsersMenu = $(".users-item-menu");
const elItemUsers = $(".users-subitens-menu");


function openModule(module) {
	switch(module){
		case 'users':
			addOrRemoveClass('users-subitens-menu-open');
			break;
		default:
			console.log("404 T_T");
			break;
	}
}

function addOrRemoveClass(nameClass){
	let hasClass 
		= (elItemUsers.hasClass(nameClass))
		? elItemUsers.removeClass("users-subitens-menu-open")
		: elItemUsers.addClass("users-subitens-menu-open")
	;
}






