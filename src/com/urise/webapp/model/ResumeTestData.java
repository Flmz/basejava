package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.urise.webapp.model.ContactType.*;
import static com.urise.webapp.model.SectionType.*;
import static java.time.LocalDate.ofYearDay;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Denis", "uuid1");
        String textAchievement1 = "Организация команды и успешная реализация Java проектов для" +
                " сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, " +
                "система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на " +
                "Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет";

        String textAchievement2 = "С 2013 года: разработка проектов " +
                "\"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный " +
                "maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP)." +
                " Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение " +
                "проектов. Более 3500 выпускников.\n";

        String textAchievement3 = "Реализация двухфакторной аутентификации для " +
                "онлайн платформы управления проектами Wrike. Интеграция с Twilio, " +
                "DuoSecurity, Google Authenticator, Jira, Zendesk.";

        String textQualifications1 = "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2\n";

        String textQualifications2 = "Version control: Subversion, Git, Mercury, ClearCase, Perforce\n";

        String textQualifications3 = "DB: PostgreSQL(наследование, pgplsql, PL/Python)," +
                " Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB\n";

        String textQualifications4 = "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy\n";

        List<String> listAchievements = new LinkedList<>();
        listAchievements.add(textAchievement1);
        listAchievements.add(textAchievement2);
        listAchievements.add(textAchievement3);

        List<String> listQualifications = new LinkedList<>();
        listQualifications.add(textQualifications1);
        listQualifications.add(textQualifications2);
        listQualifications.add(textQualifications3);
        listQualifications.add(textQualifications4);

        resume.getContacts().put(MOBILE_PHONE, "+7(921)855-0482");
        resume.getContacts().put(SKYPE, "skype: grigory.kislin");
        resume.getContacts().put(MAIL, "gkislin@yandex.ru");
        resume.getContacts().put(LINKEDIN, "url");
        resume.getContacts().put(GITHUB, "github.com/gkislin");
        resume.getContacts().put(STACKOVERFLOW, "stackoverflow.com/users/" +
                "548473");

        resume.getContacts().put(HOME_PAGE, "gkislin.ru");

        resume.getSections().put(OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного " +
                "обучения по Java Web и Enterprise технологиям"));

        resume.getSections().put(PERSONAL, new TextSection("Аналитический склад ума, сильная логика, " +
                "креативность, инициативность. Пурист кода и архитектуры."));
        resume.getSections().put(ACHIEVEMENT, new ListSection(listAchievements));

        resume.getSections().put(QUALIFICATIONS, new ListSection(listQualifications));

        Period first = new Period(ofYearDay(2013, 10), LocalDate.now(), "Создание, организация " +
                "и проведение Java онлайн проектов и стажировок.");
        Period second = new Period(ofYearDay(2014, 10), ofYearDay(2016, 01), "Проектирование и " +
                "разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, " +
                "Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");

        List<Period> periodsOrganizations = new LinkedList<>();
        periodsOrganizations.add(first);
        periodsOrganizations.add(second);
        Organization organizations = new Organization("Wrike", periodsOrganizations);
        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(organizations);
        OrganizationSection organizationExperience = new OrganizationSection(organizationList);

        resume.getSections().put(EXPERIENCE, organizationExperience);

        System.out.println(resume);
    }
}
