package com.csys.template.domain;

import com.csys.template.repository.AccessControlRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(
    replace = AutoConfigureTestDatabase.Replace.ANY
)
public class AccessControlRepositoryTest {
  @Autowired
  private AccessControlRepository accesscontrolRepository;

  @Autowired
  private TestEntityManager testEntityManager;

  private AccessControl accesscontrol;

  @Before
  public void setup() {
    accesscontrol = new AccessControl();
    accesscontrol.setUserName("accesscontrol");
    accesscontrol.setDescription("accesscontrol");
    accesscontrol.setPassWord("accesscontrol");
    accesscontrol.setCodemedecininfirmier("accesscontrol");
    accesscontrol.setActif(true);
    accesscontrol.setModuleCollection(null);
    accesscontrol.setAccessFormUserCollection(null);
    accesscontrol.setDemandeCollection(null);
    accesscontrol.setGroupUser(null);
    accesscontrol.setAccessMenuUserCollection(null);
    accesscontrol.setClinique(null);
  }

  @Test
  public void test() {
  }
}

