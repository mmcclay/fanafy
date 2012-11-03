<ul data-role="listview" data-theme="d" data-divider-theme="b">
    <li data-role="list-divider">
        Order Confirmation <span class="ui-li-count">Price: $${upgradeTicketInformation.value}0</span>
    </li>
    <li>
        <h3>${originalTicketInformation.eventName}</h3>

        <p style="margin-left: 20px" class="ui-li-desc">Section: ${upgradeTicketInformation.section}</p>

        <p style="margin-left: 20px">Row: ${upgradeTicketInformation.row}</p>

        <p style="margin-left: 20px">Section: ${upgradeTicketInformation.seats}</p>
    </li>
    <li data-role="list-divider">
        Show this page to the ticket taker
    </li>
</ul>