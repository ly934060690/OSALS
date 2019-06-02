function createTableHead() {
    $("#my-head").html("");
    $("#my-head").append(
        "<tr><th>学号</th><th>姓名</th><th>性别</th><th>专业</th><th>年级</th><th>班级</th><th></th></tr>");
}

function getData() {
    $.ajax({
        url: '/osals/stu/allToString',
        type: 'GET',
        data: {

        },
        async:false,
        contentType:"application/json;charset=utf-8",
        success:function (data) {
            if(data != null){
                fillTable(data);
            }
        },
        error: function () {
            alert('亲，学生数据获取失败啦！')
        }

    })
}

function fillTable(data) {
    var studentList = data.list;
    var studentSize = data.size;
    $("#my-tbody").html("");
    for (var i = 0; i < studentSize; i++) {
        $("#my-tbody").append(
            "<tr><th scope='row' id='" + studentList[i].id + "'>" + studentList[i].sno + "</th><th>"
            + studentList[i].name + "</th><th>"
            + studentList[i].sex + "</th><th>" + studentList[i].major + "</th><th>"
            + studentList[i].grade + "</th><th>" + studentList[i].sclass + "</th><th>"
            + "<button class='btn btn-primary btn-sm stu-update' data-toggle='modal' data-target='#myModal'> 编辑 " +
            "<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button>"
            + " " + "<button class='btn btn-danger btn-sm stu-delete'><span class='glyphicon glyphicon-trash'" +
            " aria-hidden='true'></span>删除</button></th></tr>"
        );
    }
}

function addListener() {

    $(document).on("click", "#add-stu", function () {
        clearModal();
        var properties = $("#myModalBody").children("div").find("input");
        $("#myModalLabel").append("添加学生");
        $("#modal-submit").append("提交添加");
        $("#modal-submit").attr("onclick", "addStudent()");
    });

    $(document).on("click", ".stu-delete", function () {
        var id = $(this).parents("tr").find("th").eq(0).attr("id");
        $.ajax({
            url: '/osals/stu/deleteById',
            type: 'DELETE',
            data: JSON.stringify({
                "id":id
            }),
            async: false,
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                if(data === true) {
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

    $(document).on("click", ".stu-update", function () {
        clearModal();
        var data = $(this).parents("tr").find("th");
        var properties = $("#myModalBody").children("div").find("input");
        for (var i = 0, j = 0; i < 6; i++, j++) {
            properties.eq(i).val(data.eq(j).text());
        }
        // $("#myModalBody").attr("id", data.eq(0).attr("id"));
        $("#myModalLabel").append("基本信息修改");
        $("#modal-submit").append("确认修改");
        $("#modal-submit").attr("onclick", "updateStudent()");

    });

}

function addStudent() {
    var properties = $("#myModalBody").children("div").find("input");
    var student = {};
    student.sno = properties.eq(0).val();
    student.name = properties.eq(1).val();
    student.sex = properties.eq(2).val();
    student.major = properties.eq(3).val();
    student.grade = properties.eq(4).val();
    student.sclass = properties.eq(5).val();
    $.ajax({
        url: '/osals/stu/save',
        type: 'POST',
        data: JSON.stringify(student),
        async: false,
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            if(data == true) {
                alert("添加成功！");
                clearModal();
                location.reload();
            } else {
                alert("添加失败！")
            }
        },
        error: function () {
            console.log("异常！");
        }
    });
}
function updateStudent() {
    var properties = $("#myModalBody").children("div").find("input");
    var student = {};
    // student.id = $("#myModalBody").attr("id");
    // alert(student.id);
    student.sno = properties.eq(0).val();
    student.name = properties.eq(1).val();
    student.sex = properties.eq(2).val();
    student.major = properties.eq(3).val();
    student.grade = properties.eq(4).val();
    student.sclass = properties.eq(5).val();
    $.ajax({
        url: '/osals/stu/update',
        type: 'POST',
        data: JSON.stringify(student),
        async: false,
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            if(data == true) {
                alert("修改成功！");
                clearModal();
                location.reload();
            } else {
                alert("修改失败！")
            }
        },
        error: function () {
            console.log("异常！");
        }
    });
}
function clearModal() {
    var properties = $("#myModalBody").children("div").find("input");
    for(var i = 0; i < 6; i++) {
        properties.eq(i).val("");
    }
    // $("#myModalBody").removeAttr("id");
    $("#modal-submit").html("");
    $("#myModalLabel").html("");
}