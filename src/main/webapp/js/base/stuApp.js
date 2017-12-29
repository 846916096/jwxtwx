$(document).ready(function () {

    /**考试安排*/
    $("#exam").click(function(){
        $("#examContent").popup();
    });
    $("#examClose").click(function(){
        $.closePopup();
    });


});

