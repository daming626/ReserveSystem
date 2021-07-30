function shield(a,b,c,d,e,f,g,h){
    var userid1 = document.getElementById("userid1")
    userid1.value=a;
    var username1 = document.getElementById("username1")
    username1.value=b;
    var password1 = document.getElementById("password1")
    password1.value=c;
    var realname1 = document.getElementById("realname1")
    realname1.value=d;
    var sex1 = document.getElementById("sex1")
    sex1.value=e;
    var tclass1 = document.getElementById("tclass1")
    tclass1.value=f;
    var grade1 = document.getElementById("grade1")
    grade1.value=g;
    var contacts1 = document.getElementById("contacts1")
    contacts1.value=h;



    var s = document.getElementById("test");
    s.style.display = "block";

    var l = document.getElementById("log_window");
    l.style.display = "block";

    // 根据点击修改自习室信息自动获取对应座位号并放入对应的框中
    // var roomId = document.getElementById("RoomId").innerText;
    // console.log(roomId)
    //
    //
    // xmlHttp = new XMLHttpRequest();//创建request对象
    // xmlHttp.onreadystatechange = checkReserve;  // 服务器响应后，谁负责处理服务器响应的数据
    // xmlHttp.open("GET", "getRoomById.do?roomId=" + roomId);  // 開啟連結
    // xmlHttp.send(null);  // 傳送請求

}

function cancel_shield(){
    var s = document.getElementById("test");
    s.style.display = "none";

    var l = document.getElementById("log_window");
    l.style.display = "none";
}