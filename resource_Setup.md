--------------------------------------- JAVAFX AND MYSQL CONNECTOR SETUP ---------------------------------------

1. To setup JavaFx and mysql connector inside the project, right click the project folder and select Properties
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/b024d662-92c8-41b6-9a14-640b33ed4a14)



2. Then go to 'Java Build Path > Libraries'.   Then click 'ClassPath',   And Click 'Add Library...'
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/75db7e4b-05cc-4d44-a4f4-3697ba6395d9)



3. Then select 'User Library' and click Next
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/ec96d44b-75f8-48ff-8d25-fb67133a5160)



4. Then click User Libraries...
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/f52ee6a6-ecf6-4f7c-bd6c-068cec7bff7f)



5. click 'New', then Input the library name, to be uniformed, just input 'javafx' then click ok
      ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/81c9f67c-9e05-4637-aaad-458b10bffe54)



6. Then Select the created library named 'javafx' and click 'Add External JARs...'
      ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/e53bbb5c-9e5c-43c2-b932-799712d894b0)



7. Then locate where you extracted your JavaFX Folder then proceed to ( javafx-sdk-22 > lib ) and higlight all the Jar files and open
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/90083195-a8d3-42d6-b9c8-54099fd4629b)



8. Then click 'Apply and Close'
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/f02c6854-3d83-433a-b2c9-17ae062becff)



9. Then to add the mysql connector, select again the 'classpath' and select 'Add External JARs...'
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/6b15f357-03c2-4d50-9ad9-790f1354b0ca)



10. Then locate your mysql connector the same way you did with javafx, and select the jar file and click 'Open'
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/77a1ddde-9b4c-4ee8-80a3-9e8babc4cc6f)



11. It should be look like this, then click 'Apply'  and 'Apply and Close'
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/fcb5a92d-f180-4c1b-9cd6-a73b7c6e8105)



12. Then run your project, Go to Run > Run
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/e68759b5-504f-46e3-8f81-49f914e1b8b8)



13. Then select 'Main - Application' as your Java Application and click Ok (Disregard this if it doesn't happen on your part)
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/35141176-78df-4e53-9139-fa877911aabd)



14. If you received this error, we should edit your 'Run Configurations'
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/7bba365b-aa01-40e5-b83f-67a419afbe7a)



15. Now, you will need to setup your 'Run Configurations'. Go to Run > Run Configurations
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/9b282873-d396-4d12-957f-af1e3c950d01)



16. Inside the Run Configurations, Click the Java Application > Main. Then Click the 'Argument' Tab on the Right side.
    Then Proceed to VM Arguments and Put these text:

    --module-path "C:\Users\Christopher\Desktop\PROGRAM Applications\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml

    "C:\Users\Christopher\Desktop\PROGRAM Applications\javafx-sdk-21.0.2\lib" - Change this path by reading number 7 then Click 'Apply' and 'Run'
    
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/a6245d5a-52e9-4be8-9f0f-542945207828)



17. Replace the path inside the VM Arguments with your own path by locating the folder of the javafx library files and copy its directory address

    
     ![image](https://github.com/christopherjonota/CC103-PROJECT-FINALS/assets/70148137/37db34b8-1087-4a32-99ab-3b7a224fa313)
