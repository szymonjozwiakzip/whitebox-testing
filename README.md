# whitebox-testing

Przykładowe wykorzystanie mavena, pitest i jacoco do testowania. Aby być w stanie odpalić aplikację potrzebujesz mieć zainstalowanego mavena oraz Javę.

Aby stworzyć whitebox testy, będąc w folderze whitebox wpisz:
mvn clean install

Następnie wejdź w /target/site/jacoco/index.html

Aby stworzyć testy mutacyjne korzystając z pitest wpisz:
mvn test-compile org.pitest:pitest-maven:mutationCoverage

A następnie wejdź w pit-reports oraz odpowiedni folder i odpal index.html
