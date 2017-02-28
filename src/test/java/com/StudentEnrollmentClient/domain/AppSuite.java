package com.StudentEnrollmentClient.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestAddress.class,
        TestCourse.class,
        TestDepartment.class,
        TestLecturer.class,
        TestStudent.class,
        TestSubject.class
})
public class AppSuite {

}
