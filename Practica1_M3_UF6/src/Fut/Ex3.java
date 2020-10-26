package Fut;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex3 {//postgress

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.postgresql.Driver");
			//String ruta ="/home/cf17jose.torres/Baixades/futbol.mdb";
			String conex = "jdbc:postgresql://localhost:5432/bdroot";
			Connection conn=DriverManager.getConnection(conex,"root","root");

			DatabaseMetaData pepe=conn.getMetaData();
			Statement s = conn.createStatement();
			String selTable = "select * from departamentos";

			s.execute(selTable);
			ResultSet rs = s.getResultSet();
			while((rs!=null) && (rs.next()))
				System.out.println(rs.getString(1) + " : " + rs.getString(2) +
						" : " + rs.getString(3) + " : " + rs.getString(7));
		}
		catch(Exception ex)
		{
			System.out.print(ex.getMessage());
		}
	}
}