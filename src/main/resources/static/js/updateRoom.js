function shield(a,b,c,d){
    var roomId1 = document.getElementById("RoomId1")
    roomId1.value=a;
    var roomName1 = document.getElementById("RoomName1")
    roomName1.value=b;
    var roomCapacity1 = document.getElementById("roomCapacity1")
    roomCapacity1.value=c;
    var roomDescribe1 = document.getElementById("roomDescribe1")
    roomDescribe1.value=d;



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