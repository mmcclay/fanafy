<script>
        jQuery(window).ready(function(){
            jQuery("#listEvents").click(initiate_geolocation);
        });

        function initiate_geolocation() {
            navigator.geolocation.getCurrentPosition(handle_geolocation_query);
        }

        function handle_geolocation_query(position){
            window.location.href = "listEvents/" + position.coords.latitude + "/" + position.coords.longitude + "/d";
        }
</script>


<ul data-role="listview" data-inset="true">
    <li><a id="listEvents" >Find An Upgrade!</a></li>
    <li><a href="pastPurchases.jsp">Past purchases</a></li>
    <li><a href="myAccount.jsp">My Account</a></li>
</ul>