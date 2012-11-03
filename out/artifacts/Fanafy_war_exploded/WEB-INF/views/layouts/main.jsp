<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
    <head>
        
    </head>
    <body>
        <div id="header"><tiles:insertAttribute name="header" /></div>
        <div id="content"><tiles:insertAttribute name="content" /></div>
        <div id="footer"><tiles:insertAttribute name="footer" /></div>
    </body>
</html>