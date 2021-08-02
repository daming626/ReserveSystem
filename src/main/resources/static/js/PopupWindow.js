var btn = document.getElementById('open_btn');
var div = document.getElementById('background');
var close = document.getElementById('close-button');

btn.onclick = function show() {
    div.style.display = "block";
}

close.onclick = function close() {
    div.style.display = "none";
}

window.onclick = function close(e) {
    if (e.target == div) {
        div.style.display = "none";
    }
}


var btn2 = document.getElementById('open_btn2');
var div2 = document.getElementById('background2');
var close2 = document.getElementById('close-button2');

btn2.onclick = function show2() {
    div2.style.display = "block";
}

close2.onclick = function close2() {
    div2.style.display = "none";
}

window.onclick = function close2(e) {
    if (e.target == div) {
        div2.style.display = "none";
    }
}