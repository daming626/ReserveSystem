function check() {
    var roomId = document.getElementById('roomId').value;
    var message = document.getElementById('message');
    var img = document.getElementById('img1')

xmlHttp = new XMLHttpRequest();//创建request对象
xmlHttp.onreadystatechange = checkReserve;  // 服务器响应后，谁负责处理服务器响应的数据
xmlHttp.open("GET", "getRoomById.do?roomId=" + roomId);  // 開啟連結
xmlHttp.send(null);  // 傳送請求

function checkReserve() {
    if (xmlHttp.readyState == 4) {
        if (xmlHttp.status == 200) {
            rel = JSON.parse(xmlHttp.responseText);
            if (rel.result == "roomToYes") {
                img.src = '/img/y.png'
            } else if (rel.result == "roomToNo") {
                img.src = '/img/n.png'
            }
        }
    }
}
}