function shield2(){
    var s = document.getElementById("test2");
    s.style.display = "block";

    var l = document.getElementById("log_window2");
    l.style.display = "block";
}

function cancel_shield2(){
    console.log("kkkkk");
    var s = document.getElementById("test2");
    s.style.display = "none";

    var l = document.getElementById("log_window2");
    l.style.display = "none";
}


/*手动上传ajax异常*/
function check() {
    var userid = document.getElementById('userid2').value;
    var message = document.getElementById('message');

    xmlHttp = new XMLHttpRequest();//创建request对象
    xmlHttp.onreadystatechange = checkReserve;  // 服务器响应后，谁负责处理服务器响应的数据
    xmlHttp.open("GET", "getStudentbyId?userid=" + userid);  // 開啟連結
    xmlHttp.send(null);  // 傳送請求

    function checkReserve() {
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
                // console.log(typeof xmlHttp.responseText);//服务器响应的原始数据
                // console.log(typeof eval('('+xmlHttp.responseText+')'));//不推荐使用
                // console.log(typeof JSON.parse(xmlHttp.responseText));
                rel = JSON.parse(xmlHttp.responseText);
                if (rel.result == "studentToYes") {
                    console.log("yes");
                    message.innerHTML='✔用户ID验证通过'
                } else if (rel.result == "studentToNo") {
                    console.log("no");
                    message.innerHTML='❌用户ID已经存在'
                }
            }
        }
    }
}