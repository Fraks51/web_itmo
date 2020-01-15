<#-- @ftlvariable name="createForm" type="ru.itmo.wp.form.NoticeForm" -->
<#import "commons.ftlh" as c>

<@c.page>
    <div class="makeNotice">
        <div class="header"><strong>Make a notice</strong></div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="article"/>
                <div class="field">
                    <div class="text">
                        <label>
                            <textarea id="content" name="content" rows="8" cols="32"></textarea>
                        </label>
                    </div>
                    <@c.error "createForm.content"/>
                </div>
                <div class="button-field">
                    <input type="submit" value="Create">
                </div>
            </form>
        </div>
    </div>
</@c.page>