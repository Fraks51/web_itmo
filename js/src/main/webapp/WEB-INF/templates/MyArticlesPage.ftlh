<#-- @ftlvariable name="articles" type="ru.itmo.wp.model.domain.Article[]" -->
<#import "commons.ftlh" as c>

<@c.page>
    <div class="datatable">
        <div class="caption">Posts</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Hide</th>
            </tr>
            </thead>
            <tbody>
            <#list articles as article>
                <tr>
                    <td class="id">${article.id}</td>
                    <td class="title">${article.title}</td>
                    <td>
                        <div class="button-field" >
                            <label class="button-field-label" value=${article.id}>
                                <input class="id" hidden = "hidden" value=${article.id}>
                            <#if article.hidden>
                                <input class="button-submit" id=${article.id} type="submit" value="NO">
                            <#else>
                                <input class="button-submit" id=${article.id} type="submit" value="YES">
                            </#if>
                            </label>
                        </div>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

    <script>
        $(function () {
            $('.button-field-label').on('click', function() {
                var $submit = $(this).find("input[type='submit']");
                var hide = $submit.val() === "YES";
                var id = $(this).find("input[class='id']").val();
                alert()
                    ajax({
                            action: "change",
                            id: id,
                            hidden: hide
                        },
                        function (response) {
                            if ($submit.val() === "NO") {
                                $submit.val("YES");
                            } else {
                                $submit.val("NO");
                            }
                        })
                return false;
            });
        })
    </script>
</@c.page>