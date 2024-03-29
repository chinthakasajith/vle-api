package com.tuto.vle.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	@Query("SELECT c FROM com.tuto.vle.domain.UserResourceMemberships urm left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.userResourceMembershipsId = uums.userResourceMembershipsId left join Course c on urm.resourceId = c.courseId WHERE uums.context = 'mobile' and urm.userId = ?1 and uums.scope = 'read' and urm.resourceTypeId=3 and uums.resourceTypeId = 3")
	List<Course> findByUserID(Integer userId, Integer membershipTypeId);

	@Query("SELECT c FROM com.tuto.vle.domain.UserResourceMemberships urm left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.userResourceMembershipsId = uums.userResourceMembershipsId left join com.tuto.vle.domain.CourseOwners co on uums.resourceTypeId = co.ownerResourceTypeId left join Course c on co.courseId = c.courseId WHERE uums.context = 'mobile' and urm.userId = ?1 and uums.scope = 'public-read' and urm.resourceTypeId=5 and co.ownerResourceTypeId >=3 and urm.resourceId = 1 and c.isNew=1")
	List<Course> findNewByUserID(Integer userId, Integer membershipTypeId);

	@Query("SELECT c FROM com.tuto.vle.domain.UserResourceMemberships urm left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.userResourceMembershipsId = uums.userResourceMembershipsId left join com.tuto.vle.domain.CourseOwners co on uums.resourceTypeId = co.ownerResourceTypeId left join Course c on co.courseId = c.courseId left join com.tuto.vle.domain.CourseCategory cc on c.courseId=cc.courseId WHERE uums.context = 'mobile' and urm.userId = ?1 and uums.scope = 'public-read' and urm.resourceTypeId=5 and co.ownerResourceTypeId >=3 and urm.resourceId = 1 and cc.contentCategoryId IN (select contentCategoryId from com.tuto.vle.domain.UserCategoryInterests where userId=?1)")
	List<Course> findInterestByUserID(Integer userId, Integer membershipTypeId);

//	@Query("SELECT c FROM com.tuto.vle.domain.UserResourceMemberships urm left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.userResourceMembershipsId = uums.userResourceMembershipsId left join com.tuto.vle.domain.CourseOwners co on uums.resourceTypeId = co.ownerResourceTypeId left join Course c on co.courseId = c.courseId WHERE uums.context = 'mobile' and urm.userId = ?1 and uums.scope = 'public-read' and urm.resourceTypeId=?2 and urm.resourceId=?3 and co.ownerResourceTypeId >=3")
//	List<Course> findByUserIDANDCourseId(Integer userId, Integer membershipTypeId, Integer courseId);
	
	@Query("SELECT c FROM com.tuto.vle.domain.UserResourceMemberships urm left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.userResourceMembershipsId = uums.userResourceMembershipsId left join com.tuto.vle.domain.CourseOwners co on uums.resourceTypeId = co.ownerResourceTypeId left join Course c on co.courseId = c.courseId WHERE uums.context = 'mobile' and urm.userId = ?1 and uums.scope = 'public-read' and urm.resourceTypeId=?2 and c.courseId=?3 and co.ownerResourceTypeId >=3")
	List<Course> findByUserIDANDCourseId(Integer userId, Integer membershipTypeId, Integer courseId);

	@Query("SELECT c FROM com.tuto.vle.domain.UserResourceMemberships urm left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.userResourceMembershipsId = uums.userResourceMembershipsId left join com.tuto.vle.domain.CourseOwners co on uums.resourceTypeId = co.ownerResourceTypeId left join Course c on co.courseId = c.courseId WHERE uums.context = 'mobile' and urm.userId = ?1 and uums.scope = 'public-read' and urm.resourceTypeId=5 and co.ownerResourceTypeId >=3 and urm.resourceId = 1")
	List<Course> findSubscriptionByUserID(Integer userId, Integer membershipTypeId);

}
