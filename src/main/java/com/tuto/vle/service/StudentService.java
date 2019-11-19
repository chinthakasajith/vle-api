package com.tuto.vle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuto.vle.domain.Student;
import com.tuto.vle.domain.StudentCode;
import com.tuto.vle.repositories.StudentCodeRepository;
import com.tuto.vle.repositories.StudentRepository;
import com.tuto.vle.util.TimeUtil;
import com.tuto.vle.util.TokenGenerator;

@Service
public class StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  StudentCodeRepository studentCodeRepository;

  @Autowired
  TimeUtil timeUtil;

  @Autowired
  TokenGenerator tokenGenerator;

  public Student getStudentByStudentID(String studentId) {
    return studentRepository.getStudentByStudentID(studentId);
  }

  public Student persistStudent(Student student) {
    return studentRepository.save(student);
  }

  public StudentCode persistStudentCode(Integer studentId, Integer userId) {
    StudentCode studentCode = new StudentCode();
    studentCode.setId(studentId);
    studentCode.setUserId(userId);
    studentCode.setCreateDt(timeUtil.addHoursToDate(0));
    studentCode.setExpireDt(timeUtil.addHoursToDate(1));
    studentCode.setAuthCode(tokenGenerator.getAlphaNumericString(8));

    return studentCodeRepository.save(studentCode);
  }
}
