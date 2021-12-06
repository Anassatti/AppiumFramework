package FirstFramework.AppiumFramework1;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name="InputData")
public Object[][] getDataForEditField()
{
Object[][] data= new Object[][]
		
{
	{"hello"}//, {"$$##%"}
};
return data;
}
}
