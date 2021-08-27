// 弹出窗口(遮罩层)
function shield(reservingDate, roomId, seatNumber) {
    var s = document.getElementById("test");
    s.style.display = "block";

    var l = document.getElementById("log_window");
    l.style.display = "block";

    // 根据点击图标自动获取对应座位号并放入预约中
    var seatNum = document.getElementById("seatNum");
    seatNum.value = seatNumber;
    seatNum.placeholder = seatNumber;

    // var url = '/reserving/viewAllReservedBySome.do?date='+a+'&roomId='+b+'&seatNumber='+c;
    // $("#kkkkk").loal(url);

    // ajax获取某座位的当天预约信息
    var xmlhttp = new XMLHttpRequest();
    // var seraddrs = 'http://localhost:9090/reserving/viewAllReservedBySome.do?date=' + reservingDate + '&roomId=' + roomId + '&seatNumber=' + seatNumber;
    // var seraddrs = '/reserving/viewAllReservedBySome.do?date=' + reservingDate + '&roomId=' + roomId + '&seatNumber=' + seatNumber;
    var seraddrs = 'viewAllReservedBySome.do?date=' + reservingDate + '&roomId=' + roomId + '&seatNumber=' + seatNumber;
    xmlhttp.open("GET", seraddrs);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.onreadystatechange = function (ev) {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var items = document.getElementById("items");
            if (items == null) {
                console.log("格式错误");
                // window.open('http://localhost:9090/reserving/viewAllReservedBySome.do?date=' + reservingDate + '&roomId=' + roomId + '&seatNumber=' + seatNumber);
            } else {
                items.innerHTML = xmlhttp.response;
            }
        }
    };
    xmlhttp.send(null);
}

// 关闭遮罩层
function cancel_shield() {
    var s = document.getElementById("test");
    s.style.display = "none";

    var l = document.getElementById("log_window");
    l.style.display = "none";

    //关闭遮罩层后将所有内容清空
    var startTime = document.getElementById("startTime");
    startTime.value = '';
    startTime.placeholder = '';
    var overTime = document.getElementById("overTime");
    overTime.value = '';
    overTime.placeholder = '';
    var displayImg1 = document.getElementById("displayImg1");
    displayImg1.src = '';
    displayImg1.text = '';
    var displayImg2 = document.getElementById("displayImg2");
    displayImg2.src = '';
    displayImg2.text = '';
    var message = document.getElementById("message");
    message.innerText = '';
}

// 检测输入的开始预约时间是否合格
function displayImgOne(reservingDate, roomId) {
    var img1 = document.getElementById("displayImg1");
    var seatNum = document.getElementById("seatNum").value;
    var start = document.getElementById("startTime").value;

    //判断输入的开始预约时间是否为空，是则给其赋值'null'
    if (start == '') {
        start = 'null'
    }
//我需要参考的数据
    xmlHttp = new XMLHttpRequest();//创建request对象
    xmlHttp.onreadystatechange = checkReserve;  // 服务器响应后，谁负责处理服务器响应的数据
    xmlHttp.open("GET", "getSomeoneStart.do?reservingDate=" + reservingDate + "&roomId=" + roomId + "&seatNumber=" + seatNum + "&startTime=" + start);  // 開啟連結
    xmlHttp.send(null);  // 傳送請求

    function checkReserve() {
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
                // console.log(typeof xmlHttp.responseText);//服务器响应的原始数据
                // console.log(typeof eval('('+xmlHttp.responseText+')'));//不推荐使用
                // console.log(typeof JSON.parse(xmlHttp.responseText));
                rel = JSON.parse(xmlHttp.responseText);
                if (rel.result == "reserveToYes") {
                    img1.src = "/img/y.png";
                    img1.text = '正确'//此处赋值用来设置判断是否可以预约成功（数据是否可以插入数据库）
                } else if (rel.result == "reserveToNo") {
                    img1.src = "/img/n.png";
                    img1.text = '错误'
                }
            }
        }
    }
}

// 检测输入的结束预约时间是否合格
function displayImgTwo(reservingDate, roomId) {
    var img2 = document.getElementById("displayImg2");
    var seatNum = document.getElementById("seatNum").value;
    var start = document.getElementById("startTime").value;
    var over = document.getElementById("overTime").value;

    //判断输入的开始预约时间是否为空，是则给其赋值'null'
    if (start == '') {
        start = 'null'
    }
    //判断输入的结束预约时间是否为空，是则给其赋值'null'
    if (over == '') {
        over = 'null'
    }

    xmlHttp = new XMLHttpRequest();//创建request对象
    xmlHttp.onreadystatechange = checkReserve;  // 服务器响应后，谁负责处理服务器响应的数据
    xmlHttp.open("GET", "getSomeoneOver.do?reservingDate=" + reservingDate + "&roomId=" + roomId + "&seatNumber=" + seatNum + "&startTime=" + start + "&overTime=" + over);  // 開啟連結
    xmlHttp.send(null);  // 傳送請求

    function checkReserve() {
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
                // console.log(typeof xmlHttp.responseText);//服务器响应的原始数据
                // console.log(typeof eval('('+xmlHttp.responseText+')'));//不推荐使用
                // console.log(typeof JSON.parse(xmlHttp.responseText));
                rel = JSON.parse(xmlHttp.responseText);
                if (rel.result == "reserveToYes") {
                    img2.src = "/img/y.png";
                    img2.text = '正确'
                } else if (rel.result == "reserveToNo") {
                    img2.src = "/img/n.png";
                    img2.text = '错误'
                }
            }
        }
    }
}

//申请预约往数据库存入数据
function conservation() {
    var message = document.getElementById("message");

    var reservingDate = document.getElementById("reservingDate").value;
    var roomId = document.getElementById("roomId").value;
    var seatNum = document.getElementById("seatNum").value;
    var startTime = document.getElementById("startTime").value;
    var overTime = document.getElementById("overTime").value;

    //时间为空，提示错误信息，不再继续执行
    if (startTime == '' || overTime == '') {
        message.innerText = '请选择时间'
    }else{
        //根据图片提示的信息判断是否能成功预约，若图片为叉，给图片赋值‘错误’，
        // 在此处判断图片的值，若为‘错误’，则提示错误信息
        var img1 = document.getElementById("displayImg1").text;
        var img2 = document.getElementById("displayImg2").text;
        if (img1 == '错误' || img2 == '错误') {
            message.innerText = '请重新选择时间'
        }else{
            xmlHttp = new XMLHttpRequest();//创建request对象
            xmlHttp.onreadystatechange = checkReserve;  // 服务器响应后，谁负责处理服务器响应的数据
            xmlHttp.open("POST", "insertReservate.do?reservingDate=" + reservingDate + "&roomId=" + roomId + "&seatNumber=" + seatNum + "&startTime=" + startTime + "&overTime=" + overTime);  // 開啟連結
            xmlHttp.send(null);  // 傳送請求

            function checkReserve() {
                if (xmlHttp.readyState == 4) {
                    if (xmlHttp.status == 200) {
                        // console.log(typeof xmlHttp.responseText);//服务器响应的原始数据
                        // console.log(typeof eval('('+xmlHttp.responseText+')'));//不推荐使用
                        // console.log(typeof JSON.parse(xmlHttp.responseText));
                        rel = JSON.parse(xmlHttp.responseText);
                        if (rel.result == "reservingToYes") {
                            message.innerText = '预约成功'
                        } else if (rel.result == "reservingToNo") {
                            message.innerText = '预约失败'
                        }
                    }
                }
            }
        }
    }
}