
<c:if test="${error != null}">
    ${error}
</c:if>

<form class="login_form" action="/spring/loginInPath/${eventId}/${upgradeId}" method="POST" data-ajax="false">
    <ul data-role="listview" data-inset="true">
        <li data-role="fieldcontain">
            <label for="email">Email:</label>
            <input type="text" name="email" id="email" value="${email}"  />
        </li>
        <li data-role="fieldcontain">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" autocomplete="off"  />
        </li>
        <li>
            <input class="button" type="submit" data-theme="b" value="Submit" />
        </li>
    </ul>
    <input type="hidden" name="eventId" value="${eventId}" />
    <input type="hidden" name="upgradeId" value="${upgradeId}" />
</form>






