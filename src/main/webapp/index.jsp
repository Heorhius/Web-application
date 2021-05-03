<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log In</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/all.min.css">
</head>
<body>
    <div id="p_prldr"><div class="contpre"><span class="svg_anm"></span><br>Wait...<br><small>website is loading</small></div></div>
    <%@ include file="fragment/header.jsp" %>
    <div id="headerwrap">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <h1>BUS STOP</h1>
                    <h2>Travel everywhere</h2>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="fragment/footer.jsp" %>
    <script src="https://kit.fontawesome.com/fa7e5cecef.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">$(window).on('load', function () {
        var $preloader = $('#p_prldr'),
            $svg_anm   = $preloader.find('.svg_anm');
        $svg_anm.fadeOut();
        $preloader.delay(1500).fadeOut('slow');
    });
    </script>
</body>
</html>
