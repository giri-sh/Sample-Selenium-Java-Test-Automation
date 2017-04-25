set ploc=C:\Users\I335799\Desktop\Test_Automation
cd %ploc%
set classpath=%ploc%\bin;
java org.testng.TestNG %ploc%\testng.xml
pause