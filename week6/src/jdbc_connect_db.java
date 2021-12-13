import java.sql.*;

public class jdbc_connect_db {
    public static void main(String[] args) throws Exception {
        Driver driver = new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(driver);
        String url = "jdbc:mysql://localhost:3306/hh";
        String user = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url,user,password);
//        System.out.println(con);
        String sql1="insert into students values ('s001','老大',20,'计算机学院'),('s002','老二',19,'计算机学院'),('s003','老三',18,'计算机学院'),('s004','老四',17,'计算机学院')";
        String sql= "SELECT * from students";
        String sql2="delete from students where SNO='s004'";
        String sql4="select * from students where SNO='s003';";
        String sql5="update students set College='通信学院'  where SNO='s001';";

//        ResultSet rs=con.createStatement().executeQuery(sql);
//        int rs1 = con.prepareStatement(sql1).executeUpdate();
//        int re2 = con.prepareStatement(sql2).executeUpdate();
//        ResultSet rs3=con.createStatement().executeQuery(sql4);
        int re4 = con.prepareStatement(sql5).executeUpdate();
//        while (rs.next())       //第一个查询的结果
//        {
//            String Sno=rs.getString(1);
//            String Name=rs.getString("Name");
//            int age=rs.getInt("Age");
//            String college=rs.getString("College");
//            System.out.println("学号="+Sno+",姓名="+Name+",年龄="+age+",学院="+college);
//        }
//        while (rs3.next())   //第二个查询的结果
//        {
//            String Sno=rs3.getString(1);
//            String Name=rs3.getString("Name");
//            int age=rs3.getInt("Age");
//            String college=rs3.getString("College");
//            System.out.println("学号="+Sno+",姓名="+Name+",年龄="+age+",学院="+college);
//        }
        con.close();
    }


}
