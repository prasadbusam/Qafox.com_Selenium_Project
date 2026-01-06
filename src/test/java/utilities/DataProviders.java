package utilities;
import java.io.IOException;
import org.testng.annotations.DataProvider;


public class DataProviders {
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException {
		String path=".\\Testdata\\Qafox_Login_Data.xlsx";
		Excelutility xlutl=new Excelutility(path);
		int totalrows=xlutl.getRowCount("Sheet1");
		int totalcol=xlutl.getCellCount("Sheet1",1);
		String logindata[][]=new String[totalrows][totalcol];
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcol;j++) {
				logindata[i-1][j]=xlutl.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}
	
}
