echo "HRM automation suite exceution"
cd C:\SeleniumDefault\HRM_FinalFramework
 
mvn clean test -DsuiteXmlFile=suite.xml
pause