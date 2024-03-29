package com.tuto.vle.repositories;

import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.Division;

@Repository
@ConditionalOnExpression("${my.repository.enabled:false}")
public interface DivisionRepository extends JpaRepository<Division, Long> {

  @Query("SELECT d FROM com.tuto.vle.domain.UserResourceMemberships a join Division d on a.resourceId=d.divisionId WHERE a.userId = ?1 AND a.membershipTypeId = ?2")
  List<Division> findByUserID(Integer userId, Integer membershipTypeId);

  @Query("SELECT d FROM com.tuto.vle.domain.UserResourceMemberships a join Division d on a.resourceId=d.divisionId WHERE a.userId = ?1 AND a.membershipTypeId = ?2 AND d.divisionId=?3")
  List<Division> findByUserIDANDDivisionId(Integer userId, Integer membershipTypeId,
      Integer universityId);

}
