package com.tuto.vle.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.University;
import com.tuto.vle.domain.UserResourceMemberships;

@Repository
public interface UserResourceMembershipsRepository extends JpaRepository<UserResourceMemberships, Long> {
  
  @Query("SELECT u FROM com.tuto.vle.domain.UserResourceMemberships a join University u on a.resourceId=u.universityId WHERE a.userId = ?1 AND a.membershipTypeId = ?2")
  List<University> findByUserID(Integer userId, int membershipTypeId);

}
