package com.tuto.vle.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.Lesson;
import com.tuto.vle.dto.LatestLessonDTO;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

  @Query(value = "select ol.id as id,ol.lesson_name as name, olo.owner_id as moduleId\n"
      + "from lesson_owners olo\n" + "        left join lesson ol on olo.lesson_id = ol.id\n"
      + "        inner join(select max(l.created_dt) as max_date, lo.owner_id as max_owner_id\n"
      + "                   from lesson_owners lo\n"
      + "                            left join lesson l on lo.lesson_id = l.id\n"
      + "                            left join module m on lo.owner_id = m.id\n"
      + "                            left join user_resource_memberships urm on urm.resource_id = m.id\n"
      + "                            left join user_university_memberships_scopes uums\n"
      + "                                      on urm.id = uums.user_resource_memberships_id\n"
      + "                   where lo.owner_resource_type_id = 2\n"
      + "                     and urm.user_id = ?1 \n"
      + "                     and urm.resource_type_id = ?2\n"
      + "                     and uums.resource_type_id = 1\n"
      + "                     and uums.context = 'mobile'\n"
      + "                     and uums.scope = 'read'\n"
      + "                   group by lo.owner_id\n"
      + ") as max_content on olo.owner_id = max_content.max_owner_id and ol.created_dt = max_content.max_date",
      nativeQuery = true)
  List<LatestLessonDTO> findByUserID(Integer userId, Integer membershipTypeId);

  @Query("select l from com.tuto.vle.domain.LessonOwners lo left join Lesson l on lo.lessonId=l.id left join com.tuto.vle.domain.UserResourceMemberships urm on urm.resourceId=lo.ownerId left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.id = uums.userResourceMembershipsId where lo.ownerResourceTypeId=2 and urm.userId = ?1 and l.id=?3 and urm.resourceTypeId = ?2 and uums.resourceTypeId = 1 and uums.context = 'mobile' and uums.scope = 'read'")
  Lesson findByUserIDANDLessonId(Integer userId, Integer membershipTypeId, Integer lessonId);

  @Query("select l from com.tuto.vle.domain.LessonOwners lo left join Lesson l on lo.lessonId=l.id left join com.tuto.vle.domain.UserResourceMemberships urm on urm.resourceId=lo.ownerId left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.id = uums.userResourceMembershipsId where lo.ownerResourceTypeId=2 and urm.userId = ?1 and lo.ownerId=?2 and urm.resourceTypeId = 2 and uums.resourceTypeId = 1 and uums.context = 'mobile' and uums.scope = 'read'")
  List<Lesson> findLessonsByUserIDANDModuleId(Integer userId, Integer moduleId);

}
