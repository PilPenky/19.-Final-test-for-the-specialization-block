Итоговая контрольная работа.  
Пилипенко Артур, номер группы — 4595.
--------------------------------------------------------------------

## Программа-реестр домашних животных.

### *Навигация по меню:*

Навигация по меню осуществляется через реализованный консольный пользовательский интерфейс. Интерфейс понятный и простой в использовании, включает в себя 6 основных команд.
***

### *Основные команды:*

***1 - Показать полный список животных***  
Данная команда предоставляет пользователю на выбор два варианта:  
- Просмотреть список животных в обычном порядке (по их добавлению);  
- Просмотреть список животных, отсортированный по дате рождения животного.
***

***2 - Показать количество животных***  
Данная команда предоставляет пользователю на выбор также два варианта:
- Узнать общее количество всех животных;
- Узнать общее количество животных заданного вида пользователем;
***

***3 - Добавить животное***  
Команда добавляет в общий список животное по введенным характеристикам от пользователя.  
Включает в себя 5 основных запрашиваемых характеристик:
- На выбор тип животного (собака, кошка, хомяк, попугай);
- Имя животного;
- Породу животного;
- Дату рождения животного (вводится по отдельности: год, месяц, дата);
- Команды животного.
***

***4 - Показать список команд животного***  
Показывает список команд животного, выбранного по id пользователем.
***

***5 - Обучить новой команде животное***  
Действие добавляет в список команд животного, выбранного по id пользователем, ту команду, которую введет пользователь с консоли.
***

***0. Закрыть программу***  
Осуществляется закрытие программы при указании в меню цифры 0.
***



### *Реализация в коде.*

Код написан на языке программирования Java при соблюдении принципов объектно-ориентированного программирования, SOLID, с классом в виде конструктора, с обработкой возможных ошибок. Программа запускается и работает корректно, ошибок при выполнении программы нет.  
Ошибки на не правильное введенное число, а также на ввод не числа обработаны при использовании операторов сравнения if, метода isDigit класса CheckForNumber, совместно с циклом while. За вывод текста сообщения с ошибкой отвечает класс MyIsException. 

***
***