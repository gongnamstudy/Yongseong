package springbook.user.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.domain.User;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserDaoTest {
    @Test
    public void addAndGet() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        User user = new User("gyumee", "박성철", "springno1");

        dao.add(user);
        assertThat(dao.getCount(), is(1));

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());

        assertThat(user2.getName(), is(user.getName()));
        assertThat(user2.getPassword(), is(user.getPassword()));
    }

    @Test
    public void count() throws SQLException {
        ApplicationContext context = new GenericXmlApplicationContext("applicationConfig.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);
        User user1 = new User("gyumee", "박성철", "springno1");
        User user2 = new User("leegw700", "이길원", "springno2");
        User user3 = new User("bumjin", "박범진", "springno3");

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        assertThat(dao.getCount(), is(1));

        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        dao.add(user3);
        assertThat(dao.getCount(), is(3));
    }

//    public static void main(String[] args) {
//        JUnitCore.main("springbook.user.dao.UserDaoTest");
//    }
}
