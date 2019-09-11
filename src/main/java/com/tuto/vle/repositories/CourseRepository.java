package com.tuto.vle.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

  @Query("SELECT c FROM com.tuto.vle.domain.UserResourceMemberships a join Course c on a.resourceId=c.courseId WHERE a.userId = ?1 AND a.membershipTypeId = ?2")
  List<Course> findByUserID(Integer userId, Integer membershipTypeId);

  @Query("SELECT c FROM com.tuto.vle.domain.UserResourceMemberships a join Course c on a.resourceId=c.courseId WHERE a.userId = ?1 AND a.membershipTypeId = ?2 AND c.courseId=?3")
  List<Course> findByUserIDANDCourseId(Integer userId, Integer membershipTypeId, Integer courseId);

}
