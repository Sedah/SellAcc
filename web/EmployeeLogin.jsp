
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html lang="en-US" dir="ltr">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--  
        Document Title
        =============================================
        -->
        <title>Sehda | Multipurpose HTML5 Template</title>
        <!--  
        Favicons
        =============================================
        -->
        <link rel="apple-touch-icon" sizes="57x57" href="assets/images/favicons/apple-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="assets/images/favicons/apple-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="assets/images/favicons/apple-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/images/favicons/apple-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="assets/images/favicons/apple-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="assets/images/favicons/apple-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="assets/images/favicons/apple-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="assets/images/favicons/apple-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="assets/images/favicons/apple-icon-180x180.png">
        <link rel="icon" type="image/png" sizes="192x192" href="assets/images/favicons/android-icon-192x192.png">
        <link rel="icon" type="image/png" sizes="32x32" href="assets/images/favicons/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="assets/images/favicons/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicons/favicon-16x16.png">
        <link rel="manifest" href="/manifest.json">
        <meta name="msapplication-TileColor" content="#ffffff">
        <meta name="msapplication-TileImage" content="assets/images/favicons/ms-icon-144x144.png">
        <meta name="theme-color" content="#ffffff">
        <!--  
        Stylesheets
        =============================================
        
        -->
        <!-- Default stylesheets-->
        <link href="assets/lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Template specific stylesheets-->
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Volkhov:400i" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
        <link href="assets/lib/animate.css/animate.css" rel="stylesheet">
        <link href="assets/lib/components-font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="assets/lib/et-line-font/et-line-font.css" rel="stylesheet">
        <link href="assets/lib/flexslider/flexslider.css" rel="stylesheet">
        <link href="assets/lib/owl.carousel/dist/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="assets/lib/owl.carousel/dist/assets/owl.theme.default.min.css" rel="stylesheet">
        <link href="assets/lib/magnific-popup/dist/magnific-popup.css" rel="stylesheet">
        <link href="assets/lib/simple-text-rotator/simpletextrotator.css" rel="stylesheet">
        <!-- Main stylesheet and color file-->
        <link href="assets/css/style.css" rel="stylesheet">
        <link id="color-scheme" href="assets/css/colors/default.css" rel="stylesheet">
    </head>
    <body data-spy="scroll" data-target=".onpage-navigation" data-offset="60">
        <main>
            <div class="page-loader">
                <div class="loader">Loading...</div>
            </div>


            <div class="main">
                <section class="module bg-dark-30" data-background="assets/images/section-4.jpg">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-sm-offset-3">
                                <h1 class="module-title font-alt mb-0">Login Employees</h1>
                            </div>
                        </div>
                    </div>
                </section>
                <section class="module">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-5 col-sm-offset-1 mb-sm-40">
                                <h4 class="font-alt">Login</h4>
                                <hr class="divider-w mb-10">
                                <form class="form" action="EmLoginServlet" method="POST">
                                    <div class="form-group">
                                        <input class="form-control" id="username" type="text" name="username" placeholder="Username"/>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" id="password" type="password" name="password" placeholder="Password"/>
                                    </div>
                                    <div class="form-group">
                                        <button class="btn btn-round btn-b">Login</button> 
                                    </div>

                                </form>
                                <c:if test="${loginflagem == false}">
                                    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
                                    <script>swal("Username or Password Incorrect");</script>  
                                </c:if>
                            </div>

                            <div class="col-sm-5">

                                <h4 class="font-alt">This is login page for employees</h4>
                                <hr class="divider-w mb-10">


                            </div>
                        </div>
                    </div>
                </section>
                <div class="module-small bg-dark">
                    <div class="container">
                        <div class="row">

                            <div class="col-sm-6">
                                <div class="widget">
                                    <h5 class="widget-title font-alt">Menu</h5>
                                    <ul class="icon-list">
                                        <li><a href="index.html">Home</a></li>
                                        <li><a href="AccSerlvet">Accessory Store</a></li>
                                        <li><a href="payment.jsp">Payment</a></li>

                                        <li><a href="viewCart.jsp">Cart</a></li>

                                    </ul>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="widget">
                                    <h5 class="widget-title font-alt">About Sehda</h5>
                                    <p>Accessory website Store that you can select form</p>
                                    <p>Phone: +66 968 673 088  </p>
                                    <p>Email: inbox@sehda.com</a></p>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
                <hr class="divider-d">
                <footer class="footer bg-dark">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-12">
                                <p class="copyright font-alt">&copy; 2017&nbsp;<a href="index.html">Sehda</a>, All Rights Reserved</p>
                            </div>

                        </div>
                    </div>
                </footer>
            </div>
            <div class="scroll-up"><a href="#totop"><i class="fa fa-angle-double-up"></i></a></div>
        </div>
        <div class="scroll-up"><a href="#totop"><i class="fa fa-angle-double-up"></i></a></div>
    </main>
    <!--  
    JavaScripts
    =============================================
    -->
    <script src="assets/lib/jquery/dist/jquery.js"></script>
    <script src="assets/lib/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="assets/lib/wow/dist/wow.js"></script>
    <script src="assets/lib/jquery.mb.ytplayer/dist/jquery.mb.YTPlayer.js"></script>
    <script src="assets/lib/isotope/dist/isotope.pkgd.js"></script>
    <script src="assets/lib/imagesloaded/imagesloaded.pkgd.js"></script>
    <script src="assets/lib/flexslider/jquery.flexslider.js"></script>
    <script src="assets/lib/owl.carousel/dist/owl.carousel.min.js"></script>
    <script src="assets/lib/smoothscroll.js"></script>
    <script src="assets/lib/magnific-popup/dist/jquery.magnific-popup.js"></script>
    <script src="assets/lib/simple-text-rotator/jquery.simple-text-rotator.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>
</body>
</html>