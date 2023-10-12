<html>
<head>
    <title>Jooby</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<style>
    body {
        background-image: url("internship01.jpg");
        background-size: cover;

    }
</style>
</body>

<form action="userlogin.jsp">
    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card bg-dark text-white" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">
                            <div class="mb-md-5 mt-md-4 pb-5">
                                <h2 class="fw-bold mb-2 text-uppercase">Welcome to</h2>
                                <h2 class="fw-bold mb-2 text-uppercase">~Jooby~</h2>
                                <br>
                                <br>
                                <div class="form-outline form-white mb-4">
                                    <input type="text" name="userName" id="userName" onclick="this.value=''"
                                           required="true" class="form-control form-control-lg"/>
                                    <label class="form-label" for="userName">User</label>
                                </div>
                                <div class="form-outline form-white mb-4">
                                    <input type="password" name="password" id="typePasswordX" onclick="this.value=''"
                                           required="true" class="form-control form-control-lg"/>
                                    <label class="form-label" for="typePasswordX">Password</label>
                                </div>
                                <div class="form-outline form-white mb-4">
                                    <input type="password" name="userType" id="userType" onclick="this.value=''"
                                           required="true" class="form-control form-control-lg"/>
                                    <label class="form-label" for="userType">User type</label>
                                </div>
                                <div align="CENTER" class="form-outline mb-4">
                                    <input class="btn btn-primary" type="submit" value="Login">
                                </div>

                                <div>
                                    <p class="mb-0">Don't have an account? <a href="useraddhtml.jsp"
                                                                              class="text-white-50 fw-bold">Sign
                                        Up</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</form>

</body>
</html>
