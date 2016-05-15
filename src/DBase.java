import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Zoli on 2016.05.12..
 */
class DBase
{
    public DBase()
    {
    }

    public Connection connect(String db_connect_str,
                              String db_userid, String db_password)
    {
        Connection conn;
        try
        {
            Class.forName(
                    "com.mysql.jdbc.Driver").newInstance();

            conn = DriverManager.getConnection(db_connect_str,
                    db_userid, db_password);

        }
        catch(Exception e)
        {
            e.printStackTrace();
            conn = null;
        }

        return conn;
    }

    public void importData(Connection conn)
    {
        Statement stmt;
        String query;
        String filename = "c:\\Users\\Zoli\\Documents\\Stock\\DailyData\\results_quandl_20160510.csv";

        try
        {
            stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            query = "LOAD DATA INFILE '"+filename+"' INTO TABLE stock  FIELDS TERMINATED BY ','";

            stmt.executeUpdate(query);

        }
        catch(Exception e)
        {
            e.printStackTrace();
            stmt = null;
        }
    }
};