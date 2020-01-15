<#-- @ftlvariable name="users" type="ru.itmo.wp.domain.User[]" -->
<#-- @ftlvariable name="disableForm" type="ru.itmo.wp.form.DisableForm" -->
<#import "commons.ftlh" as c>

<@c.page>
    <div class="users datatable">
        <div class="caption">User</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Login</th>
                <th>Created</th>
                <th>Disabled</th>
            </tr>
            </thead>
            <tbody>
            <#if users?size==0>
                <tr class="noData">
                    <td colspan="3">
                        No data
                    </td>
                </tr>
            <#else>
                <#list users as user>
                <tr>
                    <td class="id">${user.id}</td>
                    <td class="login">${user.login}</td>
                    <td class="creationTime">${user.creationTime}</td>
                    <td class="disable">
                        <form method="post" action="">
                            <input type="hidden" name="id" value="${user.id}"/>
                            <#if user.disabled>
                                <input type="hidden" name="disable" value="false"/>
                                <div class="button-field">
                                    <input type="submit" value="Enable">
                                </div>
                            <#else >
                                <input type="hidden" name="disable" value="true"/>
                                <div class="button-field">
                                    <input type="submit" value="Disable">
                                </div>
                            </#if>
                        </form>
                    </td>
                </tr>
                </#list>
            </#if>
            </tbody>
        </table>
    </div>
</@c.page>
