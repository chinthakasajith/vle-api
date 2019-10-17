package com.tuto.vle.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tuto.vle.domain.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

  @Query("SELECT m FROM com.tuto.vle.domain.UserResourceMemberships urm left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.userResourceMembershipsId = uums.userResourceMembershipsId left join Module m on urm.resourceId=m.moduleId where urm.resourceTypeId = ?2 and urm.userId = ?1 and uums.resourceTypeId = 2 and uums.context = 'mobile' and uums.scope = 'read'")
  List<Module> findByUserID(Integer userId, Integer membershipTypeId);

  @Query("SELECT m FROM com.tuto.vle.domain.UserResourceMemberships urm left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.userResourceMembershipsId = uums.userResourceMembershipsId left join Module m on urm.resourceId=m.moduleId where urm.resourceTypeId = ?2 and urm.userId = ?1 and uums.resourceTypeId = 2 and uums.context = 'mobile' and uums.scope = 'read' and m.moduleId=?3")
  Module findByUserIDANDModuleId(Integer userId, Integer membershipTypeId, Integer moduleId);

  @Query("SELECT m FROM com.tuto.vle.domain.UserResourceMemberships urm left join com.tuto.vle.domain.UserUniversityMembershipsScopes uums on urm.userResourceMembershipsId = uums.userResourceMembershipsId left join com.tuto.vle.domain.ModuleOwners mo on uums.resourceTypeId = mo.ownerResourceTypeId left join Module m on mo.moduleId=m.id left join com.tuto.vle.domain.UserResourceMemberships rurm on m.id = rurm.resourceId and rurm.resourceTypeId = 2 where urm.resourceTypeId = 3 and urm.userId = ?1 and urm.resourceId = ?2 and uums.resourceTypeId = 3 and uums.context = 'mobile' and uums.scope = 'read'")
  List<Module> findModulesByUserIDANDCourseId(Integer userId, Integer courseId);

}
