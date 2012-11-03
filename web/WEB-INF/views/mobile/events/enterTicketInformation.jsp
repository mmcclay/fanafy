
<form class="enterTicketInformation" name="ticketInformation" action="/spring/submitCurrentTicketInfo" method="post" data-ajax="false">
    <div data-role="fieldcontain">
        <label for="name">Section: </label>
        <input type="text" name="section" id="section" value=""  />
    </div>

    <div data-role="fieldcontain">
        <label for="name">Row: </label>
        <input type="text" name="row" id="row" value=""  />
    </div>

    <div data-role="fieldcontain">
        <label for="name">Seat(s): </label>
        <input type="text" name="seats" id="name" value=""  />
    </div>
    <input type="hidden" name="eventId" value="${eventId}" />
    <input class="button" type="submit" value="Submit" data-theme="b" />
</form>


