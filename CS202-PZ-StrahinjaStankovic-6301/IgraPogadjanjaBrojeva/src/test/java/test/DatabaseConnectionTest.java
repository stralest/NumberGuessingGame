package test;

import org.example.igrapogadjanjabrojeva.database.DatabaseConnection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.SQLException;

class DatabaseConnectionTest {

    @Test
    void databaseConnectionTest(){
        try(Connection conn = DatabaseConnection.getConnection()){
            assertNotNull(conn, "Konekcija ne sme da bude null!");
            assertFalse(conn.isClosed(), "Konekcija ne sme biti zatvorena!");
        }
        catch (SQLException ex){
           fail("Greska pri konektovanjem sa bazom! " + ex.getMessage());
        }
    }
}
