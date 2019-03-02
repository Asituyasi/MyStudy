namespace java thrift.demo

typedef i16 short
typedef i32 int
typedef i64 long
typedef string String

struct Person {
    1: optional string name,
    2: optional int age
}

exception DataException {
    1: optional int code,
    2: optional String message
}

service PersonService {
    Person getPersonByName(1:required String name) throws (1:required DataException dataException),
    
    void removePerson(1:required String name) throws (1: required DataException dateException);
}