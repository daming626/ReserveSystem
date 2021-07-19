function showMenu(ele) {
    var currentStatus = ele.nextSibling.nextSibling.style.display;
    if (currentStatus == "block") {
        ele.nextSibling.nextSibling.style.display = "none";
        ele.children[0].src="/static/img/open.png";
    }
    else {
        ele.nextSibling.nextSibling.style.display = "block";
        ele.children[0].src="close.png";
    }
}
