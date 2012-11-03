<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul data-role="listview" data-theme="d" data-divider-theme="b">
    <li data-role="list-divider">
        Current Ticket Information
            <span class="ui-li-count">Trade-in value:
                <c:if test="${hasTicketInformation}">$75</c:if><c:if test="${!hasTicketInformation}">N/A</c:if></span>
    </li>
    <c:choose>
        <c:when test="${hasTicketInformation}">
            <li>
                <a style="padding-top: 0px" href="/spring/currentTicketEntry/${eventId}">
                    <h3>${ticketInformation.eventName}</h3>

                    <p style="margin-left: 20px" class="ui-li-desc">Section: ${ticketInformation.section}</p>

                    <p style="margin-left: 20px">Row: ${ticketInformation.row}</p>

                    <p style="margin-left: 20px">Section: ${ticketInformation.seats}</p>
                </a>
            </li>
        </c:when>
        <c:otherwise>
            <li><a href="/spring/currentTicketEntry/${eventId}">Not yet entered.  Click here.</a>
            </li>
        </c:otherwise>
    </c:choose>
    <c:if test="${upgradeOptions != null}">
        <li data-role="list-divider">
            Upgrade Options
        </li>
        <c:forEach var="upgradeTicketInformation" items="${upgradeOptions}">
            <li>
                <a style="padding-top: 0px" href="/spring/order/${eventId}/${upgradeTicketInformation.id}">
                    <h3>${upgradeTicketInformation.eventName}</h3>

                    <p style="margin-left: 20px" class="ui-li-desc">Section: ${upgradeTicketInformation.section}</p>

                    <p style="margin-left: 20px">Row: ${upgradeTicketInformation.row}</p>

                    <p style="margin-left: 20px">Section: ${upgradeTicketInformation.seats}</p>
                </a>
                <span class="ui-li-count">Upgrade for $${upgradeTicketInformation.value}</span>
            </li>
            </c:forEach>
    </c:if>
</ul>


