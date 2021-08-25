/*var totalPage = 10; //一共多少页
var currentPage = 1;//当前页码
var information_lenght = []*/
$(function () {
    //根据窗口调整表格高度
    $(window).resize(function () {
        $('#mytab').bootstrapTable('resetView', {
            height: tableHeight()
        })
    })
    //bootstrapTable组件


})

function tableHeight() {
    return $(window).height() - 140;
}

//列表行‘操作’按钮
function AddFunctionAlty(value, row, index) {
    return '<button id="TableView" type="button" class="btn btn-default">查看</button>'

}

//请求服务数据时所传查询参数
function queryParams(params) {
    return {
        pageSize: params.limit,
        pageNum: params.pageNumber,
        name: $('#searchName').val()
    }
}

//点击新增按钮事件
window.operateEvents = {
    "click #TableView": function (e, value, row, index) {
        window.location.href = "/getOneCadreInfo/" + row.id;//跳转新增页面
    }
}


//查询按钮事件
$('#search_btn').click(function () {
    $('#mytab').bootstrapTable('refresh', {url: '/getOneCadreInfo/list'});//url为后台action
})

function showdiv(id) {
    document.getElementById(id).style.display = "inline";
}
function showTotalJobs(id) {
    document.getElementById(id).style.display = "inline";
    $('#'+id+'').modal("show");
}

function hidediv(id) {
    document.getElementById(id).style.display = "none";
}
function showXml(obj) {
    var jobName = obj.firstChild.textContent.toString();
    var filesNamesList =  document.getElementById("filesNames").value;
    var filesNames = filesNamesList.substring(1,filesNamesList.length-1);
    var strs = filesNames.split(",");
    for (var i=0;i<strs.length;i++ )// /demo/jobs/Copy employees to customer table.analysis.xml
    {
        var indexN1 = strs[i].lastIndexOf("/");
        var indexN2 = strs[i].indexOf(".");
        var filename = strs[i].substring(indexN1+1,indexN2);
        if (strs[i].endsWith(".analysis.xml") && filename === jobName){
            var usertenant = document.getElementById("usertenant").value;
            var path = "repository/"+usertenant+"/jobs/"+strs[i].substring(indexN1+1);
            obj.target= "_blank";
            obj.href=path;
        }
    }
}


/*
//前端获取后台数据并呈现方法
function information_display() {
    var data = [
        {"title": "第一页-今日日志"},
        {"title": "第一页-今日日志"},
    ];
    $(".ui-tab").empty()
    $.each(data, function (index, n) {
        var infor_title = "<table  class=\"title\">"
            + "<tr >"
            + "<td>" + data[index].title + "</td>"
            + "</tr>"
            + "</table>";
        $(".ui-tab").append(infor_title)
    })
}

//为测试分页功能代码
function information_display2() {
    var data = [
        {"title": "第二页-今日日志反反复复付付付"}
    ];
    $(".ui-tab").empty()
    $.each(data, function (index, n) {
        var infor_title = "<table  class=\"title\">"
            + "<tr >"
            + "<td>" + data[index].title + "</td>"
            + "</tr>"
            + "</table>";
        $(".ui-tab").append(infor_title)
    })
}

//初始化加载，分页首页数据，输入：每页多少条数据，当前页（默认为1）；输出：当前页数据和总页数
window.onload = function () {
    $(".totalPage").attr("value", totalPage)
    information_display()
}

//上一页、下一页，首页和尾页的单击触发事件
function page_click(item) {
    console.log(item)
    //首页
    if ($(item).attr("class") == "firstPage") {
        console.log("firstPage")
        pageNumber = parseInt($(".currentPage").attr("value"));
        $(".currentPage").attr("value", 1)
    }
    //上一页
    else if ($(item).attr("class") == "beforePage") {
        console.log("beforePage")
        pageNumber = parseInt($(".currentPage").attr("value"));
        if (pageNumber > 1) {
            $(".currentPage").attr("value", pageNumber - 1)
            information_display()
        } else {
            $(".beforePage").attr("disabled", false)
        }
    }
    //下一页
    else if ($(item).attr("class") == "nextPage") {
        console.log("nextPage")
        pageNumber = parseInt($(".currentPage").attr("value"));
        if (pageNumber < totalPage) {
            $(".currentPage").attr("value", pageNumber + 1)
            information_display2()
        } else {
            $(".nextPage").attr("disabled", false)
        }
    }
    //尾页
    else {
        console.log("lastPage")
        pageNumber = parseInt($(".currentPage").attr("value"));
        $(".currentPage").attr("value", totalPage)
    }
}*/
