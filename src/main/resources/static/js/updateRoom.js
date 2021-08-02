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

}

function cancel_shield(){
    var s = document.getElementById("test");
    s.style.display = "none";

    var l = document.getElementById("log_window");
    l.style.display = "none";
}