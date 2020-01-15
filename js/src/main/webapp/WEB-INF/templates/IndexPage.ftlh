<#import "commons.ftlh" as c>

<@c.page>
    <div class="articles">
        <template>
            <article>
                <div class="title"></div>
                <div class="information"></div>
                <div class="body"></div>
                <div class="footer">
                    <div class="left">
                        <img src="img/voteup.png" title="Vote Up" alt="Vote Up"/>
                        <span class="positive-score">0</span>
                        <img src="img/votedown.png" title="Vote Down" alt="Vote Down"/>
                    </div>
                    <div class="right">
                        <img src="img/date_16x16.png" title="Publish Time" alt="Publish Time"/>
                        <div class="time"></div>
                    </div>
                </div>
            </article>
        </template>
    </div>

<script>
    $(function () {
        ajax({
                action: "findAll"
            },
            function(response) {
                response["articles"].forEach(function(article) {
                    if (article["hidden"] === false) {
                        var $div = $($(".articles template").prop("content")).clone();
                        $div.find(".title").text(article["title"]);
                        $div.find(".body").text(article["text"]);
                        $div.find(".time").text(article["creationTime"]);
                        $(".articles").append($div);
                    }
                });
            });
        return false;
    })
</script>

<script>
    $(function () {
        $("aside section").click(function () {
            $(this).css("background-color", "red");
        });
    })
</script>
</@c.page>
