package com.tuto.vle.repositories;

import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.Division;
import com.tuto.vle.domain.University;
import com.tuto.vle.domain.UserResourceMemberships;

@Repository
@ConditionalOnExpression("${my.repository.enabled:false}")
public interface UserResourceMembershipsRepository
    extends JpaRepository<UserResourceMemberships, Long> {

  @Query("SELECT u FROM com.tuto.vle.domain.UserResourceMemberships a join University u on a.resourceId=u.universityId WHERE a.userId = ?1 AND a.membershipTypeId = ?2")
  List<University> findByUserID(Integer userId, Integer membershipTypeId);

  @Query("SELECT u FROM com.tuto.vle.domain.UserResourceMemberships a join University u on a.resourceId=u.universityId WHERE a.userId = ?1 AND a.membershipTypeId = ?2 AND u.universityId=?3")
  List<University> findByUserIDANDUniversityId(Integer userId, Integer membershipTypeId,
      Integer universityId);

  @Query("SELECT d FROM com.tuto.vle.domain.UserResourceMemberships a join University u on a.resourceId=u.universityId join Division d on d.universityId=u.universityId WHERE a.userId = ?1 AND a.membershipTypeId = ?2 AND u.universityId=?3")
  List<Division> findDivisionsByUserIDANDUniversityId(Integer userId, Integer membershipTypeId,
      Integer universityId);

}
