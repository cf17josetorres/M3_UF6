package Fut;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex1 {
	public static void main(String[] args) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String ruta ="/home/cf17jose.torres/Baixades/futbol.mdb";
			String conex ="jdbc:ucanaccess://" + ruta;
			Connection con=DriverManager.getConnection(conex,"","");

			DatabaseMetaData pepe=con.getMetaData();
			Statement s=con.createStatement();
			String seltable="select Equipo ,Ciudad "+"from equipos";
			s.execute(seltable);
			ResultSet rs=s.getResultSet();

			while ((rs!=null) && (rs.next())) {
				System.out.println(rs.getString(1) + " : " + rs.getString(2));
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
