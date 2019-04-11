# ForSuccess
Одно из тестовых заданий, выполненное на языке Kotlin по шаблону MVP с использованием библиотек Dagger, Retrofit, Moxy, rxJava и других.

Задание:
"У Apple есть такой сервис - называется Search API
https://www.apple.com/itunes/affiliates/resources/documentation/itunes-store-web-service-search-api.html позволяющий получать информацию о приложениях из AppStore в структурированном виде. Например https://itunes.apple.com/search?entity=software&term=slovoed

Требуется сделать приложение для Android, которое позволяет выполнять поиск приложений по текстовому запросу и отображает полученные результаты в виде таблицы.

В приложении нужно разместить поле ввода поискового запроса, с кнопкой “Поиск”
Результаты выводить в таблицу, каждая ячейка которой будет содержать
1. иконку приложения
2. название приложения
3. версию
4. дату последнего релиза
5. цену

Особое внимание стоит уделить переиспользованию ячеек с отображением контента по мере прокрутки таблицы.

Ячейка должна быть кликабельной, и перекидывать на веб страницу AppStore в отдельном активити , где можно купить приложение."