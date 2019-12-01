$(function () {
    picParam.page = picParam.page/40 + 1;
    console.log(pics);
    console.log(picParam);
    loadClass(picClass);
    picActive();
    loadPic();
    loadPage(picParam.page,Math.ceil((picParam.count)/40),'/color/pic/'+picParam.pid+'/'+picParam.id+'/',$("#page-box"));
});

function loadClass(pc) {
    var main = '',sub = '';
    for (var i = 0,len = pc.length; i < len; i++){
        main += '<li class="pic-main-class"><span class="pmc" data-id="'+pc[i].id+'">'+pc[i].name+'</span></li>';
        if (pc[i].id === picParam.pid){
            var ps = pc[i].child;
            for (var j = 0,len2 = ps.length; j < len2; j++) {
                sub += '<li class="pic-sub-class"><span class="psc" data-pid="'+pc[i].id+'" data-id="'+ps[j].id+'">'+ps[j].name+'</span></li>';
            }
        }
    }
    $(".pic-class .pic-main-ul").append(main);
    $(".pic-class .pic-sub-ul").append(sub);
    classAction();
    picAction2()
}

function classAction(){
    $(".pmc").on("click",function () {
        if (!$(this).hasClass("pic-active")) {
            //移除别的active，自己增加active
            $(this).parent().siblings().find(".pmc").removeClass("pic-active");
            $(this).addClass("pic-active");
            //移除子class，添加新的
            $(".pic-sub-ul").empty();
            var id = $(this).data("id");
            for (var i = 0, len = picClass.length; i < len; i++){
                if (picClass[i].id === id){
                    var pms = picClass[i].child;
                    var sub2 = '';
                    for (var j = 0, len2 = pms.length; j < len2; j++){
                        sub2 += '<li class="pic-sub-class"><span class="psc" data-pid="'+picClass[i].id+'" data-id="'+pms[j].id+'">'+pms[j].name+'</span></li>';
                    }
                    $(".pic-sub-ul").append(sub2);
                    picAction2();
                    break;
                }
            }
        }
    });
}

function picAction2() {
    $(".psc").on("click",function () {
        if (!$(this).hasClass("pic-active")) {
            var pid = $(this).data("pid");
            var id = $(this).data("id");
            window.location.href = '/color/pic/'+pid+'/'+id+'/'+1;
        }
    });
}

function picActive() {
    $(".pmc[data-id='"+picParam.pid+"']").addClass("pic-active");
    $(".psc[data-id='"+picParam.id+"']").addClass("pic-active");
}

function loadPic() {
    for (var i = 0,len = pics.length; i < len; i++){
        var image = '/pic/'+pics[i].mid+'/'+pics[i].sid+'/'+pics[i].image;
        var img = '<div class="item"><div class="item_content content-lar">' +
            '<a title="'+pics[i].name+'" href="/color/pic/src/'+pics[i].id+'">' +
            '<img class="lazy" src="'+image+'" alt="'+pics[i].name+'" /></a>' +
            '</div></div>';
        $(".masonry").append(img);
    }
}