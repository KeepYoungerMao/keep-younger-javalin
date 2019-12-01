/**
 * 页码加载方法
 * 点击链接url采用 urlPre + page
 * @param cur 当前page
 * @param total 总页数
 * @param urlPre 链接前缀
 * @param e 放置页码的地方 $(this)
 */
function loadPage(cur,total,urlPre,e) {
    var max = 10;   //总加载
    var half = max/2;
    if (total <= max){
        var html = '';
        var next = '';
        for (var i = 1; i <= total; i++){
            if (i === cur){
                html += '<span>'+i+'</span>';
                next += '<a id="next-page" href="'+urlPre+(cur === total ? total : cur+1)+'">下一页</a>';
            } else {
                html += '<a href="'+urlPre+i+'">'+i+'</a>';
            }
        }
        html += next;
        $(e).append(html);
    } else {
        //如total = 20, cur = 2, : 12345678910
        if (cur > half){
            if ((total - cur) < half){
                var html2 = '';
                for (var j = (total-max); j <= total; j++){
                    if (j === cur){
                        html2 += '<span>'+j+'</span>';
                    }  else {
                        html2 += '<a href="'+urlPre+j+'">'+j+'</a>';
                    }
                }
                html2 += '<a id="next-page" href="'+urlPre+(cur === total ? total : cur+1)+'">下一页</a>';
                $(e).append(html2);
            } else {
                var html3 = '';
                for (var k = (cur - half - 1); k <= (cur-1); k++){
                    html3 += '<a href="'+urlPre+k+'">'+k+'</a>';
                }
                html3 += '<span>'+cur+'</span>';
                for (var l = cur+1; l <= (cur+half); l++){
                    html3 += '<a href="'+urlPre+l+'">'+l+'</a>';
                }
                html3 += '<a id="next-page" href="'+urlPre+(cur+1)+'">下一页</a>';
                $(e).append(html3);
            }
        } else {
            var html4 = '';
            for (var m = 1; m <= max; m++){
                if (m === cur){
                    html4 += '<span>'+m+'</span>';
                } else {
                    html4 += '<a href="'+urlPre+m+'">'+m+'</a>';
                }
            }
            html4 += '<a id="next-page" href="'+urlPre+(cur+1)+'">下一页</a>';
            $(e).append(html4);
        }
    }
}