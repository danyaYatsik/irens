var onShow = function (e) {
    var $listItem = $(e.target.parentElement);
    var $numberId = $listItem.find(".number-id").text();
    var $button = $listItem.find("button");
    $.ajax({
        type: "GET",
        url: "/" + $numberId,
        success: function (d) {
            $button.remove();
            $listItem.append($("<p></p>").text("min - " + d.min));
            $listItem.append($("<p></p>").text("max - " + d.max));
        }
    });
};


$('#submit').on("click", function (e) {
    e.preventDefault();
    var $number = $("#number").val();
    var $range = $("#range").val();
    var $history = $("#history");
    var $listItem = $("<div class='list-group-item list-group-item-light'></div>");
    var $wait = $("<p></p>").text("Please, wait for calculation");
    $listItem.append($("<p></p>").text($number));
    $listItem.append($("<hr/>"));
    $listItem.append($wait);
    $history.css("display", "inline");
    $history.after($listItem);
    if (/^[1-9]\d*$/.test($number) && parseInt($range) < 2147483648 && parseInt($range) > 0) {
        $.ajax({
            type: "POST",
            url: "/",
            data: {
                number: $number,
                range: $range
            },
            success: function (data) {
                var $button = $("<button class='btn btn-primary-dark ml-2'></button>").text("Result");
                $button.on("click", onShow);
                $wait.remove();
                $listItem.append($("<span class='hidden number-id'></span>").text(data.id));
                $listItem.append($button);
            },
            error: function (data) {
                if (!isHistoryPresented()) {
                    $history.css("display", "none");
                }
                $listItem.remove();
                alert("looks like there is an error on the server");
            }
        })
    } else {
        if (!isHistoryPresented()) {
            $history.css("display", "none");
        }
        $listItem.remove();
        alert("Incorrect values");
    }
});

function isHistoryPresented() {
    var $h = $(".list-group-item > button").length;
    console.log($h);
    return $h;
}


$(".list-group-item > button").on("click", onShow);
