# SeleniumTAF
To czego chce się nauczyć / Moje cele
1. Chcę stworzyć framework oparty o Java/Selenium/Maven/Junit5/PageFactory/ Allure.
2. SeleniumGrid. Wydaje mi się, że jest to dość ważne aby zrównoleglić testy, pozniej bede chciał się tego nauczyć

3. Wyobrażam  sobie, że pracuje w projekcie, który wspiera dwie przeglądarki (Chrome,Firefox).
Zastanawiam się czy jest potrzeba puszczać testy zarówno na Chrome jak i Firefox?
+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + +
Zaletą, która by przemawiała za dwoma jest sporo większa pewność, że wszystko działa zarówno na jednej jak i na drugiej
- - - - - - - - - - - - - - - - - - - - - - - - - - - - -
Wadą jest na pewno dużo więcej pracy przy utrzymywaniu.
Niestety spotkałem się z czymś takim, że Firefox w 2-3% przypadków zachowywał się trochę inaczej, co
skutkowalo ifologią w kodzie, testy stawały się mniej czytelne, pojawiała się duplikacja. Przez rok pracy w tym projekcie, testy nie wykryły żadnego buga, 
który dotyczyłby tylko jednej przeglądarki. Wszystkie wykrywane bugi zawsze dotyczyły dwóch przeglądrek.

Dlatego stawiam pytanie czy warto to robić?
Jeżeli tak, to od razu tworzymy dwa oddzielne jenkins joby, jeden z parametrem Chrome, a drugi z Firefox.
Jeżeli znowu odpowiesz, że tak to tutaj dochodzimy do moich pewnych problemów w kodzie. (Klasa FirstTest)
Na początku testu mamy
open (Constants.GOOGLE_URL), w mojej ocenie ta metoda powinna jako drugi argument przyjmować rodzaj przeglądrki.
Tylko teraz mamy problem. Bo w ciele metody open pobieramy sobie już DAWNO utworzonego Webdrivera, który jest defacto Chromedriverem.

Próbowałem w tym miejscu dać ifologię, ale to nie działa, bo leci null w BasePageObject ponieważ,
 przed initElements (BasePageObject) instancja Webdrivera powinna być juz utworzona, a tak wtedy nie jest.


4. Mamy bazową klasę BasePageObject i BaseTest, czy to powinno być jakoś połączone z BaseDriver?

5. Od zawsze robiłem tak, że miałem jeden implicit i jeszcze w niektórych miejscach dodawałem explicit.
Dowiedziałem się, że nie powinno się łączyć waitów... Z racji tego, że implicit wait działa tylko na find element(s)
w takim razie przy Page Factory zostaje nam całkowite jego odrzucenie i używanie tylko Explicit? Dobrze mówię?

6. Gdzie powinny być przechowywane Drivery? Teraz przechowuje je w projekcie - repo a z tego co czytałem,one nie powinny tam być.