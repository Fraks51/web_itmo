<#import "commons.ftlh" as c>

<@c.page>
    <div class="makeArticle">
        <div class="header">Make a article</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="article"/>
                <div class="field">
                    <div class="name">
                        <label for="title">Title</label>
                    </div>
                    <div class="value">
                        <input id="title" name="title""/>
                    </div>
                </div>
                <div class="field">
                    <div class="text">
                        <label>
                            <textarea id="text" name="text"></textarea>
                        </label>
                    </div>
                </div>
                <div class="error">
                </div>
                <div class="button-field">
                    <input type="submit" value="Create">
                </div>
            </form>
        </div>
    </div>

    <script>
        $(function () {
            $(".makeArticle form").submit(function () {
                var title = $(this).find("input[name='title']").val();
                var text = $(this).find("textarea[name='text']").val();
                var $error = $(this).find(".error");

                ajax({
                        action: "createArticle",
                        title: title,
                        text: text},
                    function (response) {
                        if (response["error"]) {$error.text(response["error"]);}
                    }
                );

                return false;
            });
        })
    </script>
</@c.page>