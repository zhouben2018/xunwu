package com.zben.service.user;

import com.zben.dto.UserDTO;
import com.zben.entity.User;
import com.zben.repository.RoleRepository;
import com.zben.repository.UserRepository;
import com.zben.entity.Role;
import com.zben.service.ServiceResult;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zben
 * @Date: 2018/4/22/022 10:49
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User findUserByName(String userName) {
        User user = userRepository.findByName(userName);
        if (user == null) {
            return null;
        }
        List<Role> roleList = roleRepository.findRolesByUserId(user.getId());
        if (CollectionUtils.isEmpty(roleList)) {
            throw new DisabledException("权限非法");
        }
        List<GrantedAuthority> authorityList = new ArrayList<>();
        roleList.forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));

        user.setAuthorityList(authorityList);
        return user;
    }

    @Override
    public ServiceResult<UserDTO> findById(Long userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            return ServiceResult.notFound();
        }
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return ServiceResult.of(userDTO);
    }
}
