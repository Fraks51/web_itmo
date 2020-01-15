<#-- @ftlvariable name="thisPost" type="ru.itmo.wp.domain.Post" -->
<#-- @ftlvariable name="comment" type="ru.itmo.wp.domain.Comment" -->
<#import "commons.ftlh" as c>

<@c.page>
    <#if thisPost??>
    <@c.post thisPost/>
    <#if user??>
        <form method="post" action="">
            <div class="comment">
                <div class="header">
                    <label for="text">Comment</label>
                </div>
                <div class="value">
                    <textarea id="text" name="text" cols="20" rows="1">${comment.text!}</textarea>
                </div>
                <@c.error "comment.text"/>
                <div class="button-field">
                    <input type="submit" value="write">
                </div>
            </div>
        </form>
    </#if>
    <#list thisPost.comments as comment>
        <div class="com">
            <div class="user">
                ${comment.user.login!}
            </div>
            <div class="text">
                ${comment.text!}
            </div>
        </div>
    </#list>
    <#else>
        NOT FOUND
    </#if>
</@c.page>
