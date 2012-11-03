<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <title>My Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://192.168.1.123:8080/css/jquery.mobile-1.1.0.css" />
        <script src="http://192.168.1.123:8080/js/jquery.js"></script>
        <script src="http://192.168.1.123:8080/js/jquery.mobile.overrides.js"></script>
        <script src="http://192.168.1.123:8080/js/jquery.mobile-1.1.0.js"></script>
    </head>
    <body>

    <div data-role="page">

        <div data-role="header" data-theme="e">
            <tiles:insertAttribute name="header" />
        </div><!-- /header -->

        <div data-role="content" data-theme="d">
            <tiles:insertAttribute name="content" />
        </div><!-- /content -->

        <div data-role="footer" data-theme="f">
            <tiles:insertAttribute name="footer" />
        </div>
    </div><!-- /page -->

    </body>
</html>
