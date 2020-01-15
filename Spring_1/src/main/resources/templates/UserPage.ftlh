<#-- @ftlvariable name="thisUser" type="ru.itmo.wp.domain.User" -->
<#import "commons.ftlh" as c>

<@c.page>
    <#if thisUser??>
        <strong>CodeForces User:</strong>
        <ul>
            <li>Id: ${thisUser.id}</li>
            <li>Name: ${thisUser.login}</li>
            <li>Register date: ${thisUser.creationTime}</li>
        </ul>
    <#else>
        <strong>NO USER</strong>
    </#if>
</@c.page>