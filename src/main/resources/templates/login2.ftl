<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <title>Hello World!</title>
    </head>
    <body>
        <br>
        <br>
        Welcome ${username}!
        <br>
        <br>
        <br>
        <br>
        <br>
        <form method="POST" action="/login2">
            <label>Username</label><input type="input" name="username" />
            <label>Password</label><input type="password" name="password" />

            <button type="submit">提交</button>
        </form>
    <#list list as user>
        ${user.id}-${user.name}-${user.password}-${user_index}

        <#if user_has_next = true>
            有下一个<br>
        </#if>
    </#list>

    </body>
</html>