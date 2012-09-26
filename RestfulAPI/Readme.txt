
- Run using mvn jetty:run

- To issue a test request, use: http://localhost:9090/RestfulAPI/api/v1/user/john

  This should result in a json stream:

  {
    "password" : "799ef92a11af918e3fb741df42934f3b568ed2d93ac1df74f1b8d41a27932a6f",
    "username" : "john",
    "fullName" : "John Doe",
    "desc" : "Admin user"
  }

