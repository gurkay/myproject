const myDropdownMenu = document.getElementById("myDropdownMenu")
const dropdownMenuItemCreate = document.getElementById("dropdownMenuItemCreate");
const dropdownMenuItemView = document.getElementById("dropdownMenuItemView");

myDropdownMenu.addEventListener('show.bs.dropdown', event => {
    console.log('myDropdownMenu ::: opening...');
});

dropdownMenuItemCreate.addEventListener("click", event => {
    console.log("dropdownMenuItemCreate ::: click");
});

dropdownMenuItemView.addEventListener("click", event => {
    console.log("dropdownMenuItemView ::: click");
});

myDropdownMenu.addEventListener('hide.bs.dropdown', event => {
    console.log('myDropdownMenu ::: closing...');
});