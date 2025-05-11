    package fr.cnam.pronosport.pronosport;

    import java.io.*;
    import java.sql.Connection;
    import java.sql.SQLException;

    import fr.cnam.pronosport.pronosport.main.TestMySQLConnection;
    import fr.cnam.pronosport.pronosport.utils.HibernateConnection;
    import jakarta.servlet.http.*;
    import jakarta.servlet.annotation.*;

    @WebServlet(name = "helloServlet", value = "/hello-servlet")
    public class HelloServlet extends HttpServlet {
        private String message;
        TestMySQLConnection con = new TestMySQLConnection();

        public void init() {
            message = "Hello World!";

        }

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setContentType("text/html");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            try (Connection conn = TestMySQLConnection.getConnection()) {
                //conn.prepareStatement("create table");
                //response.getWriter().println("Connexion réussie !");
            } catch (SQLException e) {
                response.getWriter().println("Erreur de connexion : " + e.getMessage());
            }
            HibernateConnection.getInstance().getSession();

        }
    } 