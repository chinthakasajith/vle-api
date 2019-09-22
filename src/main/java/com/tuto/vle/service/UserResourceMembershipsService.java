package com.tuto.vle.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnExpression("${my.service.enabled:false}")
public class UserResourceMembershipsService {

}
