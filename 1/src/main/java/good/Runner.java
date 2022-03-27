package good;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*Делаем в maven покрываем unit test-ами

Создайте класс Person, с полями name, surname, age. Сгенерируйте группу из 100 человек в возрасте от 15 до 30.
1) выберете объекты, возраст которых меньше 21;
2) распечатать их на экран;
 3) сортируем по фамилии, а потом по имени (использовать thenComparing у объекта Comparator);
 4) убираем дубли (если name, surname, age одинаковые)
 5) сохраняем в файл, как объект, каждый экземпляр класса Person
6) читаем из файла
7) создаем при помощи stream новую коллекцию (List<String>) только из Фамилии и Имени для прочтенных из фалов объектов
8) выводим на экран

Создать базу  данных People
создать в этой базе таблицу Person с полями:
   -id -  Целые числа (индентификатор)
   -age -  Целые числа
   -salary - Десятичные дробные числа
   -passport  - Строки с фиксированной длиной (10 символов)
   -address -  Строки с переменной длиной (до 200 символов)
   -dateOfBirthday - Дата
   -dateTimeCreate- Дата и время
   -timeToLunch -  Время
   - letter- Текст большого объёма

Добавить 5 произвольных Person
Выбрать из этой таблици всех  Person у котороых age > 21, и отсортировать эту выборку по полю  dateTimeCreate.

Скрипты, которые все это делают залить в гит и создать PullRequest.*/

public class Runner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String[] names = {"Igor", "Vasya", "Olya", "Dasha"};
        String[] surnames = {"VAsiliev", "Kozlov", "Korolev", "Ivanov", "PEtrov"};
        int[] ages = {16, 21, 15, 29, 35};
        List<Person> personList = new ArrayList<>();

        Collection<Person> personSet = Stream.generate(() -> makePerson(names, surnames, ages))
                .limit(100)
                .filter(person -> person.getAge() < 21)
                .peek(System.out::println)
                .sorted(Comparator.comparing(Person::getSurname).thenComparing(Person::getName))
                .distinct()
                .collect(Collectors.toList());

        //5.Сохраняем в файл, как объект, каждый экземпляр класса Person
        System.out.println("5.Cохраняем в файл, как объект, каждый экземпляр класса Person");
        File file = new File("Persons.txt");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Persons.txt"))) {
            file.createNewFile();
            for (Person p : personSet) {
                oos.writeObject(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //6.Читаем из файла и создаем коллекицю из имени и фамилии
        System.out.println("6.Читаем из файла и создаем коллекицю из имени и фамилии");
        List<String> NameSurnameList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Persons.txt"))) {
            for (Person p : personSet) {
                ois.readObject();
                NameSurnameList.add(p.getName());
                NameSurnameList.add(p.getSurname());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //8.Печатаем коллекцию из имени и фамилии на экран
        System.out.println("8.Печатаем коллекцию из имени и фамилии на экран");
        for (String list : NameSurnameList) {
            System.out.println(list);
        }
    }

    public static Person makePerson(String[] names, String[] surnames, int[] ages) {
        int nameCount = new Random().nextInt(names.length);
        int surnameCount = new Random().nextInt(surnames.length);
        int agecount = new Random().nextInt(5);
        return new Person.PersonBuilder().name(names[nameCount]).surname(surnames[surnameCount]).age(ages[agecount]).build();
    }

}
