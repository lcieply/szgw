1. Pobieramy i instalujemy wamp:
[Click](http://www.wampserver.com/en/)
2. Po instalacji uruchamiamy (z uprawnieniami administratora na wszelki wypadek).
3. Wchodzimy na: [localhost/phpmyadmin](http://localhost/phpmyadmin/) w przeglądarce: login root, bez hasła.
4. Konta użytkowników - tworzymy nowego, login: admin, hasło: admin, hostname: lokalny i nadajemy mu wszystkie uprawnienia - [Globalne uprawnienia Zaznacz wszystko]
5. Tworzymy nową bazę danych o nazwie: mydb

//==========================================

Teraz można się wylogować i dla pewności zalogować się na nowo stworzone konto, sprawdzić czy widzimy bazę danych mydb.

//==========================================

*6. Otwieramy projekt w intelliJ i wchodzimy do pliku persistance.xml - src/main/resources/META-INF i w dyrektywie <properties> dodajemy na dole linijkę: 
<property name="hibernate.hbm2ddl.auto" value="create" />
*7. Uruchamiamy projekt.
*8. Usuwamy linijkę z persistance którą dodaliśmy.

*Dzięki tej linijce hibernate przejdzie nam po wszystkich plikach i poszuka adnotacji @Entity - jeżeli taką napotka to z tą linijką wykona operacje create table na bazie danych. Ale powinniśmy to wykonać tylko raz - jeżeli jej nie usuniemy to tabela w bazie danych po ponownym uruchomieniu zostanie stworzona na nowo - tracimy wszystkie dane w niej zapisane!

**linijka  java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF); wyłącza nam logi z hibernate'a, śmieci to bardzo konsolę dlatego jest linijka z wyłączeniem tego, ale w trakcie pisania można sobie włączać żeby widzieć co się dzieje z bazą.