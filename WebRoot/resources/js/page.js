var isClick = false;//用来判断按钮是否是第一次点击，默认为false是第一次点击
var trades;//用来保存data的json
var num = 5;//每页显示的条数
var totalPage;//总页数
function tbodyCon(i){//从json中取出数据插入到表格中
    item = "<tr><td>"+trades[i].time+"</td><td>"+trades[i].symbol+"</td><td>"+trades[i].sellbuy+"</td><td>"+trades[i].price+"</td><td>"+trades[i].volume+"</td></tr>";
    $("#report tbody").append(item);
}
function backTestReport(){
    var strategyname = $("ol").children().last().text().trim();
    if(isClick==false){//若是第一次点击按钮
        $.ajax({
            async:true,
            type:'POST',
            data:{"strategyname":strategyname},
            dataType:'json',
            url:'/trades/',
            success:function(data){
                if(data.length>0){//判断json文件中是否有数据
                    trades = data;
                    var item;
                    console.log(data);
                    if(data.length<num){//若json中的数据条数小于每页显示的条数，则让每页显示的条数等于总条数
                        num = data.length;
                    }
                    totalPage = Math.ceil(data.length/num);
                    $("#report").css("display","block");
                    $("#totalPage").text(totalPage);
                    for(var i=0;i<num;i++){
                        tbodyCon(i);
                    }
                    isClick = true;
                }
            }
        });
    }else{
        var state = $("#report").css("display");
        if(state=='none'){
            $("#report").css("display","block");
        }else{
            $("#report").css("display","none");
        }
    }
}
function paging(obj){
    var currentPage = parseInt($("#currentPage").text());
    // console.log(currentPage,totalPage,obj);
    $("#page ul li").removeClass("active");
    $("#report tbody").children('tr').remove();
    if(obj=="fast"){//首页
        for(var i=0;i<num;i++){
            tbodyCon(i);
        }
        $("#fast").addClass("active");
        $("#currentPage").text('1');
    }else if(obj=="prev"){//上一页
        if(currentPage != 1){
            for(var i=num*(currentPage-2);i<num*(currentPage-1);i++){
                tbodyCon(i);
            }
            $("#prev").addClass("active");
            $("#currentPage").text(currentPage-1);
        }else{
            for(var i=0;i<num;i++){
                tbodyCon(i);
            }
            $("#fast").addClass("active");
            $("#currentPage").text('1');
        }
    }else if(obj=="next"){//下一页
        if(currentPage != totalPage){
            for(var i=num*currentPage;i<num*(currentPage+1);i++){
                tbodyCon(i);
            }
            $("#next").addClass("active");
            $("#currentPage").text(currentPage+1);
        }else{
            for(var i=num*(totalPage-1);i<trades.length;i++){
                tbodyCon(i);
            }
            $("#last").addClass("active");
            $("#currentPage").text(totalPage);
        }
    }else if(obj=="last"){//尾页
        for(var i=num*(totalPage-1);i<trades.length;i++){
            tbodyCon(i);
        }
        $("#last").addClass("active");
        $("#currentPage").text(totalPage);
    }else if(obj=="jump"){//尾页
        var jumpage = parseInt($("#jumpage").val());
        if(jumpage!=""&&jumpage!=null&&!(isNaN(jumpage))&&0<jumpage<=totalPage){//jumpage必须是非空格，非null，!isNaNaN是一个数字，并且范围在0到总页数之间
            for(var i=num*(jumpage-1);i<num*jumpage;i++){
                tbodyCon(i);
            }
            $("#currentPage").text(jumpage);
        }else{//若不满足条件则按首页处理
            for(var i=0;i<num;i++){
                tbodyCon(i);
            }
            $("#fast").addClass("active");
            $("#currentPage").text('1');
        }
        
    }
}