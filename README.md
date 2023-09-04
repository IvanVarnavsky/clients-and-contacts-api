# API клиентов и их контактов
Пример restful-сервиса клиентов и контактов с использованием таких технологий как `Spring Data JPA` и `Java`.

В проекте имеются следующие эндпоинты:

**GET** [/clients](/clients)
Возвращает список всех клиентов и связанные с ними контакты при наличии.

**GET** [/clients/{id}](/clients/{id})
Возвращает информацию о клиенте по его id.

**POST** [/clients](/clients)
Создает нового клиента.

**PUT** [/clients/{id}](/clients/{id})
Изменяет информацию о клиенте по его id.

**DELETE** [/clients/{id}](/clients/{id})
Удаляет клиента по id.

**GET** [/clients/{id}/phones](/clients/{id}/phones)
Возвращает список всех номеров телефонов у конкретного клиента по его id.

**POST** [/clients/{id}/phones](/clients/{id}/phones)
Добавляет номер телефона у конкретного клиента по его id.

**GET** [/clients/{id}/emails](/clients/{id}/emails)
Возвращает список всех адресов электронной почты у конкретного клиента по его id.

**POST** [/clients/{id}/emails](/clients/{id}/emails)
Добавляет адрес электронной почты у конкретного клиента по его id.

**GET** [/clients/{id}/contacts](/clients/{id}/contacts)
Возвращает список всех контактов у конкретного клиента по его id.

В проекте уже присутствует готовая БД H2 с небольшим набором данных, а для самостоятельного создания БД, приведены скрипты ниже.

Таблица клиентов:

```sql
create table client
(
    id         serial constraint client_pk primary key,
    name       varchar not null
);
```

Таблица телефонов, связанных с клиентами:

```sql
create table phone
(
    id         serial constraint phone_pk primary key,
    client_id integer not null
    constraint phone_client_fk references client,
    number       varchar not null
);
```

Таблица адресов электронной почты, связанных с клиентами:

```sql
create table email
(
    id         serial constraint email_pk primary key,
    client_id integer not null
    constraint email_client_fk references client,
    address      varchar not null
);
```