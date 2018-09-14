package ru.bootcamp.springboot.service;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class DBException extends RuntimeException {
    public DBException(Throwable throwable) {
        super(throwable);
    }
}
