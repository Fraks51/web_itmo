<#-- @ftlvariable name="handle" type="java.lang.String" -->
<#-- @ftlvariable name="id" type="java.lang.Long" -->
<#import "common.ftl" as c/>

<@c.page>
    <#list 0..users?size-1 as i>
        <#if users[i].handle == handle>
            <#assign prevUser=users[i - 1]!/>
            <#assign viewedUser=users[i]!/>
            <#assign nextUser=users[i + 1]!/>
        </#if>
    </#list>
    <#if viewedUser.id??>
        <div class="user-table">
            <dif class="text">
                <div class="name-ref">
                    <@c.userlink user=viewedUser/>
                </div>
                <li>id: ${viewedUser.id}</li>
                <li>handle: ${viewedUser.handle}</li>
                <li>name: ${viewedUser.name}</li>
            </dif>
            <dif class="picture">
                <a href="#"><img src="/img/user.jpg" alt="User" title="User"/></a>
            </dif>
        </div>
        <div class="arrows">
            <#if prevUser?has_content>
                <a href="/user?handle=${prevUser.handle}">←</a>
            <#else>
                ←
            </#if>
            <#if nextUser?has_content>
                <a href="/user?handle=${nextUser.handle}">→</a>
            <#else>
                →
            </#if>
        </div>
    <#else>
        <h1>No such user</h1>
    </#if>
</@c.page>
