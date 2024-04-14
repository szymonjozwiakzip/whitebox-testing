# whitebox-testing

Przykładowe wykorzystanie mavena, pitest i jacoco do testowania. Aby być w stanie odpalić aplikację potrzebujesz mieć zainstalowanego mavena oraz Javę.

Aby stworzyć whitebox testy, będąc w folderze whitebox wpisz:
mvn clean install

Następnie wejdź w /target/site/jacoco/index.html

Aby stworzyć testy mutacyjne korzystając z pitest wpisz:
mvn test-compile org.pitest:pitest-maven:mutationCoverage

A następnie wejdź w pit-reports oraz odpowiedni folder i odpal index.html

___

Example of using maven, pitest and jacoco for testing. To be able to fire up the application you need to have maven and Java installed.

To create whitebox testing, while in the whitebox folder type:
mvn clean install

Then go to /target/site/jacoco/index.html

To create mutation tests using pitest type:
mvn test-compile org.pitest:pitest-maven:mutationCoverage

And then go into pit-reports and the appropriate folder and fire up index.html
