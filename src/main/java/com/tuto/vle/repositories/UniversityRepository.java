package com.tuto.vle.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.Division;
import com.tuto.vle.domain.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

  @Query("SELECT u FROM com.tuto.vle.domain.UserResourceMemberships urm left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.userResourceMembershipsId = uums.userResourceMembershipsId left join University u on urm.resourceId=u.universityId WHERE uums.context = 'mobile' and urm.userId = ?1\n"
      + "and uums.scope = 'read' and urm.resourceTypeId=?2")
  List<University> findByUserID(Integer userId, Integer membershipTypeId);

  @Query("SELECT u FROM com.tuto.vle.domain.UserResourceMemberships urm left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.userResourceMembershipsId = uums.userResourceMembershipsId left join University u on urm.resourceId=u.universityId WHERE uums.context = 'mobile' and urm.userId = ?1 and uums.scope = 'read' and urm.resourceTypeId=?2 and u.universityId=?3")
  List<University> findByUserIDANDUniversityId(Integer userId, Integer membershipTypeId,
      Integer universityId);

  @Query("SELECT d FROM com.tuto.vle.domain.UserResourceMemberships urm left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.userResourceMembershipsId = uums.userResourceMembershipsId left join com.tuto.vle.domain.DivisionOwners do on uums.resourceTypeId = do.ownerResourceTypeId left join com.tuto.vle.domain.Division d on do.divisionId = d.divisionId WHERE uums.context = 'mobile' and urm.userId = ?1 and uums.scope = 'public-read' and urm.resourceTypeId=?2 and urm.resourceId=?3 and do.ownerResourceTypeId >=4")
  List<Division> findDivisionsByUserIDANDUniversityId(Integer userId, Integer membershipTypeId,
      Integer universityId);

}
