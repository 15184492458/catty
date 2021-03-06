/*
 * Copyright 2020 The Catty Project
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pink.catty.test.spring;

import java.util.UUID;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pink.catty.test.service.AService;
import pink.catty.test.service.BService;

public class SpringCapabilityTest {

  private static ApplicationContext consumer;

  @BeforeClass
  public static void init() {
    new ClassPathXmlApplicationContext("provider_test_a.xml");
    new ClassPathXmlApplicationContext("provider_test_b.xml");
    consumer = new ClassPathXmlApplicationContext("consumer_test.xml");
  }

  @Test
  public void test() {
    AService aService = consumer.getBean(AService.class);
    String uuid = UUID.randomUUID().toString();
    String result = aService.echo(uuid);
    Assert.assertEquals(uuid, result);

    BService bService = consumer.getBean(BService.class);
    uuid = UUID.randomUUID().toString();
    result = bService.echo(uuid);
    Assert.assertEquals(uuid, result);
  }

}
