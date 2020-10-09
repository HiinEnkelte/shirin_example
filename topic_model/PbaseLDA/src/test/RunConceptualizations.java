package test;
import conceptualization.Conceptualization;
import util.Probase;
import java.sql.Connection;
public class RunConceptualizations {

		public static void main(String[] args) throws Exception {

					Connection conn = Probase.getConnectionMySql();
							Conceptualization.conceptualizations(conn);
								}
}

