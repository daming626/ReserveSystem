function checkUserId() {
    var message = document.getElementById("message");

    var userId = document.getElementById("userId").value;

    if(userId != null){
        xmlHttp = new XMLHttpRequest();//创建request对象
        xmlHttp.onreadystatechange = checkId;  // 服务器响应后，谁负责处理服务器响应的数据
        xmlHttp.open("POST", "../user/checkUserId.do?&userId=" + userId );  // 開啟連結
        xmlHttp.send(null);  // 傳送請求

        function checkId() {
            if (xmlHttp.readyState == 4) {
                if (xmlHttp.status == 200) {
                    rel = JSON.parse(xmlHttp.responseText);
                    console.log(rel)
                    if (rel != "null") {
                        message.innerText = 'id已存在'
                        console.log('id已存在')
                    } else {
                        message.innerText = '合法id'
                        console.log('合法id')
                    }
                }
            }
        }
    }else{
        message.innerText = '管理员账号不能为空'
    }
}

function checkPassword() {
    var pwd = document.getElementById("password").value;

    var checkPwd = document.getElementById("checkPwd").value;

    var pwdmessage = document.getElementById("pwdmessage");

    console.log('c');
    if(pwd == checkPwd){
        pwdmessage.innerText = '√';
        console.log('a');
    }else {
        pwdmessage.innerText = '密码不一致，请重新输入';
        console.log('b');
    }

}
// window.onload=function (){
//     var kk=document.getElementById("checkPwd");
//     kk.onblur=function (){
//         console.log("LLLLLLLLLL")
//     }
// }
