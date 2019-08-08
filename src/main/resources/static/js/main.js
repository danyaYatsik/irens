var $history = $("#history");

var onShow = function (e) {
    var $listItem = e.target.parentElement;
    var $numberId = $listItem.querySelector(".number-id").textContent;
    var $button = $listItem.querySelector("button");
    console.log($button);
    console.log($numberId);
    console.log(e);
    $.ajax({
        type : "GET",
        url : "/" + $numberId,
        success : function (d) {
            $button.remove();
            $listItem.innerText = (d.origin + "min - " + d.min + ", max - " + d.max);
        }
    });
};


$('#submit').on("click", function (e) {
    e.preventDefault();
    var $number = $("#number").val();
    var $range = $("#range").val();
    var $listItem = $("<div class='list-group-item list-group-item-light'></div>").text($number + " - please, wait for calculation");
    $history.css("display", "inline");
    $history.after($listItem);
    if (!($number === "" || $range === "")) {
        $.ajax({
            type: "POST",
            url: "/",
            data: {
                number: $number,
                range: $range
            },
            success: function (data) {
                console.log(data);
                var $button = $("<button class='btn btn-primary-dark ml-2'></button>").text("Show");
                $button.on("click", onShow);
                $listItem.text(data.origin);
                $listItem.append($("<span class='hidden number-id'></span>").text(data.id));
                $listItem.append($button);
            },
            error : function (data) {
                $listItem.remove();
                alert("looks like there is out of memory error on the server");
            }
        })
    } else {
        $listItem.remove();
        alert("Incorrect values");
    }
});


$(".list-group-item > button").on("click", onShow);
