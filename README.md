# FrameworkSample
Some feature in framework
1. Extent Report
2. Write Log to file
3. Read data from Excel File
4. Main Keyword: ValidateHelpers (call common function)
5. Sample test

How to use

1. Run test case in XML (src/test/java/saucedemo/testcase/runTestNG.xml)
2. Pom.xml:
        Used to add the necessary dependencies used in the framework such as: TestNG, Selenium
3. Main Keyword: ValidateHelpers
![ảnh](https://user-images.githubusercontent.com/73646046/210928191-9daa40a4-fd3b-4466-bdfa-0803e20f5bf5.png)


        ValidateHelpers class is main keyword in Framework. It contains common functions.
    
        How to use: ValidateHelpers.function_name.
    
        Example: ValidateHelpers.setText(By element, String value),...

4. Read data test in Excel file
![ảnh](https://user-images.githubusercontent.com/73646046/210927218-c796dd17-7e64-49a2-9a58-9b0f4f3c03b2.png)

5. Resource folder : src/core/resources:
        Contains necessary resources such as drivers for chrome, firefox, and excel file
