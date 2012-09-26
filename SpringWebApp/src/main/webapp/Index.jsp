<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

    <html>
        <head>
            <title>Home</title>
        </head>
        <body>
            <h1>Home</h1>

            <div>
                <security:authorize ifAllGranted="ROLE_ADMIN">
                    <h2>Hello Admin</h2>
                </security:authorize>
                <security:authorize ifAllGranted="ROLE_ANONYMOUS">
                    <a href="spring_security_login">Login</a>
                </security:authorize>
            </div>

        </body>
    </html>
