function getData(pageNum, pageSize, navigatePages) {
    $.ajax({
        url: '/logistics/car/getInfo.action',
        type: 'GET',
        data: {
            "pageNum": pageNum,
            "pageSize": pageSize,
            "navigatePages": navigatePages
        },
        async: false,
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            if (data != null) {
                fillTable(data);
            }
        },
        error: function () {
            alert('学生数据获取失败');
        }
    });
}

function createTableHead() {
    $("#my-head").html("");
    $("#my-head").append(
        "<tr><th>#</th><th>车辆编号</th><th>车辆最大载重量</th><th></th></tr>");
}

function fillTable(data) {
    var carList = data.list;
    var size = data.size;
    //当前列表起始值
    var indexId = (data.pageNum - 1) * data.pageSize + 1;
    $("#my-tbody").html("");
    for (var i = 0; i < size; i++) {
        $("#my-tbody").append(
            "<tr><th scope='row' carid='" + carList[i].id + "'>" + indexId++ + "</th><th>" + carList[i].carNum + "</th><th>" + carList[i].carLoad + "</th>" +
            "<th><button class='btn btn-primary btn-sm car-edit' data-toggle='modal' data-target='#myModal'> 编辑 <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button>" +
            " " + "<button class='btn btn-danger btn-sm car-delete'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span>删除</button></th></tr>");
    }
    $("#page-info").html("");
    $("#page-info").append(
        "当前为第 " + data.pageNum + " 页 , 总共 " + data.pages + " 页，包含 " + data.total + " 条记录"
    );

    $("#adjust-ul").html("");


    $("#adjust-ul").append(
        "<li><a class='page-first' onclick='getData(1," + data.pageSize + "," + data.navigatePages + ")'>首页</a></li>"
    );
    $("#adjust-ul").append(
        "<li><a class='page-first' onclick='getData(" + data.prePage + "," + data.pageSize + "," + data.navigatePages + ")' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span> </a> </li>"
    );

    if (data.isFirstPage) {
        $(".page-first").removeAttr("onclick");
    }

    var navigatePageNums = data.navigatepageNums;
    for (var i = 0; i < data.navigatePages; i++) {

        if (navigatePageNums[i] === data.pageNum) {
            str = "<li class= 'active'>";
        } else {
            str = "<li>";
        }

        $("#adjust-ul").append(
            str + "<a onclick='getData(" + navigatePageNums[i] + "," + data.pageSize + "," + data.navigatePages + ")'>" + navigatePageNums[i] + "<span class='sr-only'>(current)</span> </a> </li>"
        );
    }

    $("#adjust-ul").append(
        "<li><a class='page-last' onclick='getData(" + data.nextPage + "," + data.pageSize + "," + data.navigatePages + ")' aria-label='Next'> <span aria-hidden='true'>&raquo;</span> </a> </li>"
    );
    $("#adjust-ul").append(
        "<li><a class='page-last' onclick='getData(" + data.pages + "," + data.pageSize + "," + data.navigatePages + ")'>尾页</a></li>"
    );

    if (data.isLastPage) {
        $(".page-last").removeAttr("onclick");
    }
}

function addListener() {

    $(document).on("click", ".car-edit", function () {
        clearModal();
        var data = $(this).parents("tr").find("th");
        var properties = $("#myModalBody").children("div").find("input");
        for (var i = 0, j = 1; i < 2; i++, j++) {
            properties.eq(i).val(data.eq(j).text());
        }
        $("#myModalBody").attr("carid",data.eq(0).attr("carid"));
        $("#myModalLabel").append("基本信息修改");
        $("#modal-submit").append("确认修改");
        $("#modal-submit").attr("onclick","updateCar()");

    });

    $(document).on("click", "#add-car", function () {
        clearModal();
        $("#myModalLabel").append("新车辆添加");

        $("#modal-submit").append("提交添加");

        $("#modal-submit").attr("onclick","addCar()");
    });

    $(document).on("click", ".car-delete", function () {
        var id = $(this).parents("tr").find("th").eq(0).attr("carid");
        $.ajax({
            url: '/logistics/car/deleteOne.action',
            type: 'DELETE',
            data: JSON.stringify({
              "id":id
            }),
            async: false,
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                if (data === 1) {
                    alert("删除成功！");
                    location.reload();
                } else {
                    alert("删除失败！");
                }
            },
            error: function () {
                alert('异常');
            }
        });
    });
}

function addCar() {
    var properties = $("#myModalBody").children("div").find("input");
    var car = {};
    car.id = $("#myModalBody").attr("carid");
    car.carNum = properties.eq(0).val();
    car.carLoad = properties.eq(1).val();

    $.ajax({
        url: '/logistics/car/saveOne.action',
        type: 'POST',
        data: JSON.stringify(car),
        async: false,
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            if (data == 1) {
                alert("添加成功");
                clearModal();
                location.reload();
            } else {
                alert("添加失败");
            }
        },
        error: function () {
            console.log("错误");
        }
    });
}

function updateCar() {
    var properties = $("#myModalBody").children("div").find("input");
    var car = {};
    car.id = $("#myModalBody").attr("carid");
    car.carNum = properties.eq(0).val();
    car.carLoad = properties.eq(1).val();


    $.ajax({
        url: '/logistics/car/updateOne.action',
        type: 'POST',
        async: false,
        data: JSON.stringify(car),
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            if (data === 1) {
                alert("修改成功！");
                clearModal();
                location.reload();
            } else {
                alert("修改失败！");
            }
        },
        error: function () {
            alert('异常');
        }
    });
}

function clearModal() {
    var properties = $("#myModalBody").children("div").find("input");
    for (var i = 0; i < 2; i++) {
        properties.eq(i).val("");
    }
    $("#myModalBody").removeAttr("carid");
    $("#modal-submit").html("");
    $("#myModalLabel").html("");

}

