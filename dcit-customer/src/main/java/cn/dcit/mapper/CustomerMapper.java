package cn.dcit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.dcit.common.mapper.SysMapper;

import cn.dcit.pojo.Customer;


public interface CustomerMapper extends SysMapper<Customer>{
	
	//List<User> findAll();

	//void updateState(@Param("userIds")String[] userIds, @Param("state")int state);

	//void deleteUsers(String userId);

	//void saveUser(User user);

	@Select("select * from customer where id=#{customerid}")
	Customer findCustomerByID(@Param("customerid")String customerid);
	
	
	Customer findUserById(String customerId);

	//void updateUser(User user);

	//@Insert("insert into role_user_p(role_id,user_id) values(#{roleId},#{userId})")
	//void saveUserRole(@Param("userId")String userId,@Param("roleId") String roleId);

	//void deleteRoleUsers(String userId);

	//List<String> finduRoleList(String userId);

//	User findUserByU_P(@Param("username")String username, @Param("password")String password);
//
//	User findUserByUserName(String username);
//
//	List<String> findPrivilegeInfoList(String userId);


}
