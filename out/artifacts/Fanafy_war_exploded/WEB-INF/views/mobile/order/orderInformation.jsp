<ul data-role="listview" data-theme="d" data-divider-theme="b">
    <li data-role="list-divider">
        Current Ticket Information
            <span class="ui-li-count">Trade-in value: ${ticketInformation.value}</span>
    </li>
    <li>
            <h3>${ticketInformation.eventName}</h3>

            <p style="margin-left: 20px" class="ui-li-desc">Section: ${ticketInformation.section}</p>

            <p style="margin-left: 20px">Row: ${ticketInformation.row}</p>

            <p style="margin-left: 20px">Section: ${ticketInformation.seats}</p>
    </li>

    <li data-role="list-divider">
        New Ticket Information <span class="ui-li-count">Upgrade price: ${upgradeTicketInformation.value}</span>
    </li>
    <li>
            <h3>${ticketInformation.eventName}</h3>

            <p style="margin-left: 20px" class="ui-li-desc">Section: ${upgradeTicketInformation.section}</p>

            <p style="margin-left: 20px">Row: ${upgradeTicketInformation.row}</p>

            <p style="margin-left: 20px">Section: ${upgradeTicketInformation.seats}</p>
    </li>
    <a href="/spring/order/confirmDialog/${eventId}/${upgradeId}" data-transition="pop" data-role="button" data-theme="b" data-rel="dialog">Upgrade Me</a>
</ul>