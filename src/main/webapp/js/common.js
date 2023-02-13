(function(){

    (function () {
        var path =location.pathname.substr(1);
        var search = location.search;
        if(search!=''){
            path += decodeURIComponent(search);
        }
        if(path == '')
        {
            $('#navbar-str li:eq(0)').addClass('active');
        }else{
            $('#navbar-str li').each(function () {
                var href = $(this).find('>a').attr('href');
                if(href == path)
                {
                    $(this).addClass('active');
                }
                if($(this).hasClass('dropdown'))
                {
                    var that = this;
                    $(this).find('li').each(function () {
                        var href = $(this).find('>a').attr('href');
                        if(href == path)
                        {
                            $(this).addClass('active');
                            $(that).addClass('active');
                        }
                    })
                }
            })
        }
        console.log(path)
    })();

})();